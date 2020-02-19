<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>product</title>
</head>
<body>
<p>Product: ${product.value}</p>
<p>ID: ${product.id}</p>
<a href="products.do?id=2&amp;add">Add to Cart</a>

<hr>

</body>
</html>
