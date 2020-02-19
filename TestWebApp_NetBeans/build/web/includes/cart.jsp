<%-- 
    Document   : testCart
    Created on : Feb 15, 2020, 4:28:08 PM
    Author     : c-consalpa
--%>

<%@page import="c_consalpa.business.mProduct"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="c_consalpa.business.mCart" %>
<%@page import="c_consalpa.business.mProduct" %>
<div class="cart">



    <table border="1">
        <thead>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${mcart.itemsInCart}">
                <tr>
                    <td>${product.key.value}</td>
                    <td>${product.value}</td>
                    <td><a href="TestCart_Demo?act=remove&amp;id=${product.key.id}"> X </a></td>
                </tr>
            </c:forEach>
           

    </table>

    
    
    
    
</div>
