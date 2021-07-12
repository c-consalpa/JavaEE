<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: c-consalpa
  Date: 7/12/2021
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>User first name (invokes usr.getFirstName() - \${model.firstName}): ${usr.firstName}</p>
<p>User last name (invokes usr.getLastName() - \${model.lastName}): ${usr.lastName}</p>
<p>User country (invokes usr.getCountry() - \${model.country}): ${usr.country}</p>
<p>User role (invokes usr.getRole() - \${model.role}): ${usr.role}</p>
<p>User projects: (\${model.involvedProjects}):

    <ul>
    <c:forEach items="${usr.involvedProjects}" var="i">
        <li>${i}</li>
    </c:forEach>

</ul>




</p>



</body>
</html>
