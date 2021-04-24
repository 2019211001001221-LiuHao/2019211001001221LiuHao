<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 生活
  Date: 2021/4/2
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="/header.jsp" %>
<h1>Login</h1>
<%
    PrintWriter printWriter=response.getWriter();
    if(!(request.getAttribute("message")==null)){
        printWriter.println("<h3>"+request.getAttribute("message")+"</h3>");

    }
%>
<%
    Cookie [] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form action="/2019211001001221LiuHao_war/login" method="post">
Username: <input type="text" name="username" value="<%=username%>"><br/>
Password: <input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>/>Remember Me<br/>
    <input type="submit" value="Login">
</form>
<%@include file="/footer.jsp" %>

</body>
</html>
