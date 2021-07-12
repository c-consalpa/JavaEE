<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: c-consalpa
  Date: 7/12/2021
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Tags Demo</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="usr">
        First Name:
        <form:input type="text" path="firstName"/>
        <br>
        Last Name:
        <form:input type="text" path="lastName"/>
        <br>
        Country:
        <form:select path="country">
            <form:options items="${usr.countryValues}"/>
        </form:select>
        <br>
        QA<form:radiobutton path="role" value="QA"/>
        <br>
        DEV<form:radiobutton path="role" value="DEV"/>
        <br>
        PM<form:radiobutton path="role" value="PM"/>
        <br>
        Involved into projects:
        <br>
        XES<form:checkbox path="involvedProjects" value="XES"/>
        <br>
        EAM<form:checkbox path="involvedProjects" value="EAM"/>
        <br>
        XE<form:checkbox path="involvedProjects" value="XE"/>
        <br>

        <input type="submit" value="Submit"/>
    </form:form>

</body>
</html>
