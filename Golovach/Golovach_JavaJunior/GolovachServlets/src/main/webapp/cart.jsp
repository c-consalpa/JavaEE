<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 1/18/2021
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${mcart.getCartItems().size() == 0}">
        <div class="cart">
            <p>Your cart is empty =)</p>
        </div>
    </c:when>
    <c:when test="${empty mcart}">
        <div class="cart">
            <p>Your cart is empty =)</p>
        </div>

    </c:when>
    <c:otherwise>
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
                        <td>
                            <a href="product.do?productId=${cartItem.key.id}&action=add">+</a> /
                            <a href="product.do?productId=${cartItem.key.id}&action=delete">-</a>
<%--                            <a href="product.do?productId=${item.id}&action=add">Add to cart</a>--%>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:otherwise>
</c:choose>



