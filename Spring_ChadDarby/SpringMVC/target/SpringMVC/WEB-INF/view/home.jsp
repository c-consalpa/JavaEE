<%--
  Created by IntelliJ IDEA.
  User: c-consalpa
  Date: 6/29/2021
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<h1>Home Page</h1>

    <p>form data via \${param.fname}: ${param.fname}</p>
    <p>form data via \${modelAttr}: ${modelAttr}</p>
</body>
</html>
