package com.Liuhao.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//tell tomcat this class is a listener class-how?
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context=sce.getServletContext();
        String driver=context.getInitParameter("driver");//<param-name>driver</param-name>
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        //5.Create database connection within init()
        try{
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("i am in contextInitialized()-->"+con);//when?
            System.out.println("init()-->"+con);
            context.setAttribute("con",con);//name=value
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        //end point of web app
        //this method called when tomcat stop
        System.out.println("i am in contextDestroyed()");//when this line print?
        //remove connection from context
        sce.getServletContext().removeAttribute("con");//name
    }
}