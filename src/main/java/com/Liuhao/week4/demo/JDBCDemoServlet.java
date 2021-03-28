package com.Liuhao.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  String url="jdbc:sqlserver://localhost:databaseName=useedb";
  String username="sa";
  String  password="123456789liuhao";

  try{
      Class.forName(driver);
      Connection con= DriverManager.getConnection(url,username,password);
      System.out.println("-->"+con);
  }catch (ClassNotFoundException | SQLException e){
      e.printStackTrace();
  }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
