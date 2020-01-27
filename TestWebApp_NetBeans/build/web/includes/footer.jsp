<%@page import="java.util.*" %>

<% 
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Moscow"));
        int year = calendar.get(Calendar.YEAR);
%>

<p>Copyright <%= year %></p>
</body>
</html>