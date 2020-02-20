

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../styles/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>First Cart</title>
    </head>
    <body>
        <h1>Select products</h1>
            <table border="1">
        <thead>
            <tr>
                <th>Product</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>Sugar</td>
                    <td><a href="TestCart_Demo?act=add&amp;id=1">Add</a></td>
                </tr>
                 <tr>
                    <td>Bread</td>
                    <td><a href="TestCart_Demo?act=add&amp;id=2">Add</a></td>
                </tr>   
    </table>
    
    <c:import url="/includes/cart.jsp"/>
    
    </body>
</html>
