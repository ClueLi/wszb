package utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
/*
* 这个类中只有一个方法，getList
* 可以将数据库的结果集ResultSet转换为实体类list
* List<User> user = JdbcRs.getList(rs, User.class);
*
*
* */
public class JdbcRS {
	public static <T> List<T> getList(ResultSet rs, Class<T> clazz) {
		// 创建一个对象，通过内省执行方法的时候，调用该对象的方法
		T obj = null;
		// 创建一个集合，存储javaBean对象及返回数据
		List<T> list = new ArrayList<T>();
		try {
			// 获取javaBean的描述信息
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			// 获取javaBean的属性描述器
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			// 获得结果集的元数据信息(包含列的数量，列的名称)
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获得结果集中列的数量
			int columnCount = rsmd.getColumnCount();
			// 创建一个集合，存储所有的列别名
			List<String> labelList = new ArrayList<String>(columnCount);
			// 循环将列别名存入别名集合中
			for(int i=0;i<columnCount;i++) {
				labelList.add(rsmd.getColumnLabel(i+1).toUpperCase());
			}
			// 遍历查询结果集
			while(rs.next()) {
				// 创建对象
				obj = clazz.newInstance();
				// 遍历JavaBean属性描述器
				for (PropertyDescriptor pd : pds) {
					// 获取属性名
					String name = pd.getName();
					// 比对属性描述器中的属性是否在别名集合中存在
					if(labelList.contains(name.toUpperCase())) {
						// 筛选出存在的属性名，判断查询结果是否为空，避免将null值存入基本数据类型的错误
						Object value = rs.getObject(name);
						if(value!=null) {
							// 获取查询结果，调用相对应的set方法存入对象属性中
							pd.getWriteMethod().invoke(obj, value);
						}
					}
				}
				// 将对象存入集合
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
