package servlet;

import com.alibaba.fastjson.JSON;
import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset = utf-8");
        PrintWriter pw = resp.getWriter();
        // 测试输出
        UserDao userDao = new UserDao();
        try {
            ArrayList<User> userList = userDao.selectAll();
            for ( User t: userList) {
                pw.println(t.toString());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        //登录判断
//        try {
//            List<User> userList = userDao.selectAll();
//
//            String json = JSON.toJSONString(userList);
//            // 通过客户端上传的数据进行判断是否为正确用户
//
//
////            获取客户端发来的数据
//            BufferedReader rd = new BufferedReader(new InputStreamReader(
//                    (ServletInputStream) req.getInputStream(), "utf-8"));
//            String line = null;
//            StringBuffer buffer = new StringBuffer(2048);
//            while ((line = rd.readLine()) != null) {
//                buffer.append(line);
//
//            }
//            rd.close();
//            String message = buffer.toString();
//            System.out.println(message);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}