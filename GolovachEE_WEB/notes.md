# Servlets #2 lecture
-   Tomcat supports HTTP only;
-   If Servlet's `service()` is overridden - the entire handling of all 
**GET/PUT/...** should be implemented as well;
-   **HttpServletRequest / HTTPServletResponse** request contains all the methods to operate 
with the requests/response;
___
## Use servlets to return data to client

There are 2 options to output data:

1. this: 
    ```
    Printwriter pw = HTTPServletResponse.getWriter();
    pw.write("html, headers, etc);
    ```
2. and this:
    ```
    respone.getOutputStream().write(bytes[]) - this won't work????;
   ```
   
- javax.servlet.response - has a _buffer_ - to buffer the body of the response; no manual 
    interaction is considered as good practice;
    
- `HTTPServlet`'s filters - is a good example of **chain-of-responsibility**;

### Tomcat request processing sequence

Assume Tomcat receives a request to a `.jsp`:
1. Tomcat translates `.jsp` to `.java` files;
2. Compiles these files;
3. Runs the bytecodes;   