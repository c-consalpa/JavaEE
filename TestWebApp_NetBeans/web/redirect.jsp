<%-- 
    JSP tags usage

    Document   : redirect
    Created on : Jan 14, 2020, 12:53:14 PM
    Author     : c-consalpa

--%>
<!--JSP directives:-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        
    <h1>Hello World!</h1>
        <p>sout: ${user.name}</p>
       
        <!--Conditional IF:-->
        <c:if test="${user.name == 'testName'}">
            <p>Conditional IF shown</p>
        </c:if>
            
       
        
        <!--JSP scriptlet:-->
        <%
            GregorianCalendar currentDate = new GregorianCalendar();
            int currentYear = currentDate.get(Calendar.YEAR);
        %>
        
        <!--JSP expression:-->
        
        <p>Year: <%= currentYear %></p>
    

