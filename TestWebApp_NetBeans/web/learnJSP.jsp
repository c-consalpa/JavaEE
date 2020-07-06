<%-- 
    Document   : learnJSP
    Created on : Jan 14, 2020, 1:43:25 PM
    Author     : c-consalpa
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>JSTL Usage</h1>
    
    <ul>
        <li>
            <p>
                Simple reference from request attribute:<br>
                \${user.name} : ${user.name}
            </p>
        </li>
        <li>
<!--Conditional IF:-->
        <c:if test="${user.name == 'sampleUserIvan'}">
            <p>Conditional IF:</p>
            <pre>
                &#x3C;c:if test=&#x22;\${user.name == &#x27;sampleUserIvan&#x27;}&#x22;&#x3E;
                    &#x3C;p&#x3E;Conditional IF shown&#x3C;/p&#x3E;
                &#x3C;/c:if&#x3E;
            </pre>
        </c:if>
        </li>
        <li>
<!--Scriplets-->
            <p>JSP Scriplet: </p>
            <pre>
            &#x3C;%
                GregorianCalendar currentDate = new GregorianCalendar();
                int currentYear = currentDate.get(Calendar.YEAR);
            %&#x3E;


            To make this code work, the following directive should be defined in this JSP:
            &#x3C;%@page import=&#x22;java.util.*&#x22;%&#x3E;
            </pre>
            <%
                GregorianCalendar currentDate = new GregorianCalendar();
                int currentYear = currentDate.get(Calendar.YEAR);
            %>
        </li>
        <li>
            <p>JSP expression:</p>
            <p>&#x3C;%= currentYear %&#x3E; : 
                <%= currentYear %>
            </p>
        </li>
        <li>
<!-- COMMENTS -->

<!-- HTML: Compiled, BUT NOT SHOWN in browser: -->
<!-- <p><%= new Date()%></p> -->

<!-- JSP: NEITHER compiled NOR shown in browser: -->
<%-- <p><%= new Date()%></p> --%>

<!-- NEITHER compiled NOR shown in browser: -->
<%
    String test = "abc";
    /*
        Object test = new Object();
    */
%>
        </li>
    </ul>
 
<h2>JSP & JavaBeans</h2>
<pre>
*******************************************************************************
UseBean usage:

                &#x3C;jsp:useBean id=&#x22;user&#x22; scope=&#x22;request&#x22; class=&#x22;c_consalpa.business.mUser&#x22; /&#x3E;
            &#x3C;p&#x3E;
                Email: &#x3C;jsp:getProperty name=&#x22;user&#x22; property=&#x22;email&#x22; /&#x3E;
            &#x3C;/p&#x3E;
WHERE:
id=&#x22;user&#x22; - The name of the <b>request</b> object's attr that carries the JavaBean. If none found, a new JavaBean is created;

scope: <br>
    page - the bean is stored in pageContext and availbale only to this JSP;<br>

    request - the bean is stored in HttpServletRequest and available to all JSPs 
    that have access to request object <br>

    session - stored in HttpSession object <br>
    
    application - stored in ServletContext, available for all JSPs and servlets
    that have access to this object.
</pre>
    
    <jsp:useBean id="user" scope="request" class="c_consalpa.business.mUser" />
<p class='output'>
   => Email: <jsp:getProperty name="user" property="email" />
</p>
<pre>
*******************************************************************************
    Get/Set properties via useBean: <br>

&#x3C;jsp:getProperty name=&#x22;user&#x22; property=&#x22;name&#x22;/&#x3E;
&#x3C;jsp:setProperty name=&#x22;user&#x22; property=&#x22;name&#x22; value=&#x22;set via SetProp&#x22;/&#x3E;
&#x3C;jsp:getProperty name=&#x22;user&#x22; property=&#x22;name&#x22;/&#x3E;

</pre>
<p>
=> 
<jsp:getProperty name="user" property="name"/><br>
<jsp:setProperty name="user" property="name" value="set via SetProp"/>
<jsp:getProperty name="user" property="name"/>
</p>
    </body> 