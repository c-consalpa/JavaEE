<%--
  Created by IntelliJ IDEA.
  User: Konstantin
  Date: 7/31/2021
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>

    <p>New Event:</p>
    <form action="add" method="get" id="addForm">
        <label for="evname">Event Name:</label>
        <input type="text" id="evname" name="evname"><br><br>
        
        <label for="eventAttendeesCount">Number of attendees:</label>
        <input type="text" id="eventAttendeesCount" name="evcnt"><br><br>



        <label for="eventLocation">Event Locatino:</label>
        <input type="text" id="eventLocation" name="evloc"><br><br>

        <input type="submit" value="Add Event">
        
    </form>


${evname}


    <button id="purgeEvents">Purge!</button>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>




</body>
</html>
