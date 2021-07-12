<%--
  Created by IntelliJ IDEA.
  User: c-consalpa
  Date: 7/9/2021
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Smart Home Login</title>
</head>
<body>
    <p>hi, dweller!</p>
    <form action="auth" method="POST">
        <label for="usr_nm">User name</label>
        <input type="text" name="usr_nm" placeholder="User Name" id="usr_nm">
        <br>
        <label for="usr_pwd">Password</label>
        <input type="text" name="usr_pwd" id="usr_pwd">
        <br>
        <input type="submit">

    </form>
</body>
</html>
