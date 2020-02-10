<%-- 
    Document   : TestSessionView
    Created on : Feb 7, 2020, 7:49:32 PM
    Author     : c-consalpa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>HTTPSession ID: ${ses}</p>
        <p>count: ${cnt}</p>
        
        <h2>Cookies</h2>
        <h3>Getting via JSTL:</h3>
        <c:forEach var="c" items="${cookie}">
            <p>${c.value.name} = ${c.value.value}</p>
        </c:forEach>
            
        <h3>\${cookie.customCookie1.value}: ${cookie.customCookie1.value}</h3>
    </body>
</html>
