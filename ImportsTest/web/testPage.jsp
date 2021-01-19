<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 1/19/2021
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="resources/main.css">
</head>
<body>

<div class="data">
    <table>
        <c:forEach var="i" items="${data}">
            <tr>
                <td>
                    <c:out value="${i.key}"></c:out>
                </td>
                <td>
                    <c:out value="${i.value}"></c:out>
                </td>
            </tr>
        </c:forEach>
        <tr></tr>
    </table>
</div>

<%@include file="cart.jsp"%>

</body>
</html>
