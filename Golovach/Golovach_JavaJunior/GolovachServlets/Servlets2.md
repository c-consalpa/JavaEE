#Servlets #2
###Filters in Tomcat
Interface javax.servlet.Filter - is an implementation of pattern **chain of responsibility**.

    Note //TOREAD: Гранд: Приемы ООП.
    
HTTP web sockets - imba update of HTTP;

Servlet can be instantiated at any time between the start of Tomcat and the first call to the servlet.
Servlet startup priority is defined by:
```
<servlet>..
    <servlet-name>..
    <load-on-startup>INT    <- defines the priority 
</servlet> 
```

#####ServletContextListener
```
public interface ServletContextListener extends EventListener {
    public void contextInitialized (ServletContextEvent sce);

    public void contextDestroyed (ServletContextEvent sce);
    // this is called when Tomcat is closed "gently"
}
```

    (c) Нормальные люди листенеры не используют, они - для фреймворков и системных действий.
   
#####Summary
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
   ___
      
   - javax.servlet.response - has a _buffer_ - to buffer the body of the response; no manual 
       interaction is considered as good practice;
       
   
### Tomcat's request processing sequence
   
   Assume Tomcat receives a request to a `.jsp`:
   1. Tomcat translates `.jsp` to `.java` files;
   2. Compiles these files;
   3. Runs the bytecodes;  