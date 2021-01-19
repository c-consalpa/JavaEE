<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 1/19/2021
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="cart">

    <c:if test="${cart!=''}">
        <p>Items In cart:</p>
        <table>
            <c:forEach var="i" items="${cart}">
                <tr>
                    <td>
                        <c:out value="${i.key}"></c:out>
                    </td>
                    <td>
                        <c:out value="${i.value}"></c:out>
                    </td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>
    </c:if>
</div>
