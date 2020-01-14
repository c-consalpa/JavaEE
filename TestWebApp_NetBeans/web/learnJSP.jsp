<%-- 
    Document   : learnJSP
    Created on : Jan 14, 2020, 1:43:25 PM
    Author     : c-consalpa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>JSTL Usage</h1>
    
    <p>Simple reference from request attribute:<br> \${user.name} : ${user.name}</p>
       
        <!--Conditional IF:-->
        <c:if test="${user.name == 'sampleUserIvan'}">
            <p>Conditional IF:</p>
            <pre>
                &#x3C;c:if test=&#x22;\${user.name == &#x27;testName&#x27;}&#x22;&#x3E;
                    &#x3C;p&#x3E;Conditional IF shown&#x3C;/p&#x3E;
                &#x3C;/c:if&#x3E;
            </pre>
        </c:if>
            
        
            <p>JSP Scriplet: </p>
            <pre>
            &#x3C;%
                GregorianCalendar currentDate = new GregorianCalendar();
                int currentYear = currentDate.get(Calendar.YEAR);
            %&#x3E;
            </pre>
        <%
            GregorianCalendar currentDate = new GregorianCalendar();
            int currentYear = currentDate.get(Calendar.YEAR);
        %>
        
        <p>JSP expression:</p>
        <p>&#x3C;%= currentYear %&#x3E; : <%= currentYear %></p>
        
<!-- COMMENTS -->

<!-- HTML: Compiled, BUT NOT SHOWN in browser: -->
<!-- <p><%= new Date()%></p> -->

<!-- JSP: NEITHER compiled NOR shown in browser: -->
<%-- <p><%= new Date()%></p> --%>

<!-- NEITHER compiled NOR shown in browser: -->
<%
    String test = "abc";
    /*
        Object test = new Object();
    */
%>
    </body> 