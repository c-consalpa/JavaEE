<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product: ${product.productName}</title>
    <link href="resources/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    Product details page.
    <p>Product Name: ${product.productName}</p>
    <p>Product ID: ${product.id}</p>
    <a href="product.do?productId=${product.id}&action=add">Add to Cart</a>
    <%@include file="cart.jsp"%>
</body>
</html>
