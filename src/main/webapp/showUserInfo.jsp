<%@ page import="com.isoft.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 23811
  Date: 2019/1/4
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="other/node_modules/bootstrap3/dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="other/node_modules/bootstrap3/dist/css/bootstrap-theme.min.css">
</head>
<body>
<%List<User> list= (List<User>)session.getAttribute("userList");%>
<table class="table table-striped ">
    <tr>
        <td>id</td>
        <td>uname</td>
        <td>upwd</td>
        <td>lastLoginTime</td>
        <td>Role</td>
    </tr>
    <%
        for (int i = 0;i<list.size();i++){
            User user=list.get(i);
            list.get(i);
    %>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getUname()%></td>
        <td><%=user.getUpwd()%></td>
        <td><%=user.getLastLoginTime()%></td>
        <td><%=user.getRole()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
