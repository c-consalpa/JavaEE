<%-- 
    Document   : tes_JSP
    Created on : Dec 18, 2019, 4:06:23 PM
    Author     : c-consalpa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Murach's Servlets & JSP</h1>
        <a href="test?param1=value1&param1=value2&param1=value3&test=qwe">test</a><br>
        <a href="learnJSP">Learn JSP</a><br>
        <a href="TestSessionController">TestSessionController</a><br>
        <a href="Cart/TestCart_Demo.jsp">TestCart_Demo.jsp</a><br> 
        <p>Hidden fields</p>
        <form action="test?hid=abc" method="POST">
            <input type="Submit" value="Send hiddden field"/>
            <input type="hidden" value="hidValue" name="hiddenInput"/>
        </form>
    </body>
</html>
