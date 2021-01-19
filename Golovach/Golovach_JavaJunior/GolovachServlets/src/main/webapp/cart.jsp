<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 1/18/2021
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="cart">
    <p>Cart:</p>
    <table>
        <c:forEach items="${mcart.cartItems}" var="cartItem">
        <tr>
            <td>
                ${cartItem.key.productName}
            </td>
            <td>
                ${cartItem.value}
            </td>
        </tr>
        </c:forEach>
    </table>
</div>



