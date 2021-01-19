<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<jsp:useBean id="cart" class="Models.Cart" scope="session"></jsp:useBean>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>product</title>
</head>
<body>
<p>Product: ${product.value}</p>
<p>ID: ${product.id}</p>
<a href="products.do?id=${product.id}&amp;add">Add to Cart</a>

<hr>
<c:if test="${cart!=''}">
    <c:forEach var="i" items="${cart.itemsInCart}">
        <p>${i.key.value} : ${i.value}</p>
    </c:forEach>

</c:if>


</body>
</html>
