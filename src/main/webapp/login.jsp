
<%--
  Created by IntelliJ IDEA.
  User: TS
  Date: 2021/4/11
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>login</h1>
<%
    if(!(request.getAttribute("message")==null){
    //error
    out.println(request.getAttribute("message"));
}
%>
<form method="post" action="login">
    Username:<input type="text" name="username"><br/>
    Password:<input type="text" name="password"><br/>
    <input type="submit" value="login">
</form>
<%@include file="footer.jsp"%>e