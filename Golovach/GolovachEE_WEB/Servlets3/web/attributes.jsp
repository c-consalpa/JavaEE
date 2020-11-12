<%--
  Created by IntelliJ IDEA.
  User: c-consalpa
  Date: 2/7/2020
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Attr demo</title>
</head>
<body>
<%--Get MockModelA's fields:--%>
<%--private Map<Integer, String> map;--%>
<%--private List<String> list;--%>
<%--    private int[] array_int;--%>
<%--    private String string;--%>
<%--    private MockModelB mockModelB;--%>
<%--    modelA--%>
    <p>modelA.map["key-0"]:     ${modelA.map["key-0"]}</p>
    <p>modelA.list[0]:          ${modelA.list[0]}</p>
    <p>modelA.array_int[0]:     ${modelA.array_int[0]}</p>
    <p>modelA.string:           ${modelA.string}</p>
    <p>modelA.mockModelB:       ${modelA.mockModelB.value}</p>

<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>
