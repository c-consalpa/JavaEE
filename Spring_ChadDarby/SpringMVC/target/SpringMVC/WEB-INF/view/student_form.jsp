<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: c-consalpa
  Date: 7/13/2021
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
    <body>
    <form:form action="processForm" modelAttribute="std">
        Username: <form:input path="name"/> <br><br>

        Password(*): <form:password path="pwd"/>
        <form:errors path="pwd" cssClass="error"/><br><br>

        Email(*): <form:input path="email"/>
        <form:errors path="email" cssClass="error"/>
        <br><br>
        
        Age: <form:input path="age"/>
        <form:errors path="age" cssClass="error"/>

        <br>
        <br>
        University: <form:input path="university"/>
        <form:errors path="university" cssClass="error"/>

        <input type="submit" value="submit">
    </form:form>
</body>
</html>
