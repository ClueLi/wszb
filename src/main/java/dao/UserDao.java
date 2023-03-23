package dao;
/*
* 操作数据库的类
* 控制的是user类
*
* */



import utils.JdbcRS;
import utils.JdbcUtils;
import domain.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // 获取全部的用户数据
    public ArrayList<User> selectAll() throws SQLException {

        // 获取数据库连接池对象
        DataSource dataSource = JdbcUtils.getDataSource();

        // 从数据库连接池对象中获取数据库连接对象
        Connection connection = dataSource.getConnection();

//        // 预定义定义SQL语句
//        String sql = "INSERT INTO account (NAME, balance) VALUES (?, ?);";
//        // 获取执行预定义SQL语句对象
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        // 给?赋值
//        preparedStatement.setString(1, "WanWu");
//        preparedStatement.setInt(2, 2000);

        // 预定义定义SQL语句
        String sql = "select * from user;";
        // 获取执行预定义SQL语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 执行预编译好的SQL语句,获取放回结果ResultSet结果集
        ResultSet resultSet = preparedStatement.executeQuery();

        // 使用工具类中的JdbcRS的方法getList()
        ArrayList<User> list = (ArrayList<User>) JdbcRS.getList(resultSet, User.class);


        // 释放资源：PreparedStatement
        JdbcUtils.releaseResources(preparedStatement);

        // 归还连接
        JdbcUtils.releaseResources(connection);

        return list;
    }
}
