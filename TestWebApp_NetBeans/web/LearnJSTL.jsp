<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="test" uri="WEB-INF/tlds/test.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Learn JSP</title>
        
    </head>
    <body>
        <h1>LearnJSTL</h1>
        <table style="border: 1px solid red">
            <tbody>
                <tr>
                    <td style="border: 1px solid red">
                        &#x3C;c:out value=&#x22;\${cookie}&#x22;&#x3E;test&#x3C;/c:out&#x3E;<br>
&#x3C;c:out value=&#x22;\${script}&#x22;&#x3E;&#x3C;/c:out&#x3E;&#x3C;br&#x3E;<br>
&#x3C;c:out value=&#x22;&#x27;\${script}&#x27;&#x22;&#x3E;&#x3C;/c:out&#x3E;&#x3C;br&#x3E<br>
                    </td>
                    <td style="border: 1px solid red">
                <c:out value="${cookie}">test</c:out><br>
                <c:out value="${sc}"></c:out><br>
                ${sc}
                <c:out value="'${sc}'"></c:out><br>
                    </td>
                </tr>
                <tr>
                    <td style="border: 1px solid red">
&#x3C;c:forEach var=&#x22;c&#x22; items=&#x22;\${testMap}&#x22;&#x3E;<br>
    &#x3C;p&#x3E;\${c.key}&#x3C;/p&#x3E;<br>
    &#x3C;p&#x3E;\${c.value.id}&#x3C;/p&#x3E;<br>
    &#x3C;p&#x3E;\${c.value.value}&#x3C;/p&#x3E;<br>
    &#x3C;p&#x3E;\${testMap[&#x27;one&#x27;]}&#x3C;/p&#x3E;<br>
    &#x3C;hr/&#x3E;<br>
&#x3C;/c:forEach&#x3E;<br>
                    </td>
                    <td style="border: 1px solid red">
        <c:forEach var="c" items="${testMap}">
            <p>${c.key}</p>
            <p>${c.value.id}</p>
            <p>${c.value.value}</p>
            <p>${testMap['one']}</p>
            <hr/>
        </c:forEach>
                    </td>
                </tr>
                                <tr>
                    <td style="border: 1px solid red">
&#x3C;c:forTokens var=&#x22;t&#x22; items=&#x22;${tokenizedString}&#x22; delims=&#x22;|&#x22;&#x3E;
    &#x3C;b&#x3E;${t}&#x3C;/b&#x3E;
&#x3C;/c:forTokens&#x3E;
                    </td>
                    <td style="border: 1px solid red">
                    <c:forTokens var="t" items="${tokenizedString}" delims="|">
                        <b>${t}</b>
                    </c:forTokens>  
                    </td>
                </tr>
                
                <tr>
                    <td style="border: 1px solid red">

                    </td>
                    <td style="border: 1px solid red">
                        <c:forEach items="${nums}" var="num" end="3">
                            <P>${num}</P>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>Custom Tag (no body): 
                        &lt;test:currentDate&gt;</td>
                    <td><test:currentDate></test:currentDate></td>
                </tr>
                  <tr>
                    <td>
                        ifWeekday:
                    </td>
                    <td>
                    <test:ifWeekDay>today is a working day</test:ifWeekDay>
                    </td>
                    </tr>
                 <tr>
                    <td>
                        Custom tag with attribute:
                    </td>
                    <td>
                        <test:AttributeTag count=""></test:AttributeTag>
                    </td>
                </tr>
                   <tr>
                    <td>
                        Iterable body tag;
                    </td>
                 <td style="border: 1px solid red">
                    <test:mIterableTag>
                        <p>${productId}:${productValue}</p>
                        <hr>
                    </test:mIterableTag>
                    </td>
                </tr>
            </tbody>
        </table>
        

    
        
            
    </body>
</html>
