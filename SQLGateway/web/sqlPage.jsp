<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>SQL Gateway</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Oh my CRUD</h1>
        <h2>SQL Statement</h2>
        <form action="SQLExecuteServlet" method="post" id="sqlData">
            <textarea name="sqlText" cols="40" rows="10" form="sqlData">1</textarea><br/>
            <input type="submit" value="Execute">
        </form>
        <h2>SQL Result</h2>
        <p>${resultData}</p>
        
        
        
    </body>
</html>
