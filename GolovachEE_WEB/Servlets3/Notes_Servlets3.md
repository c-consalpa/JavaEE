# MVC, Sessions, Cookies
**Tip** REST-like urls, e.g `eshop/product.do`  such servlets can be easily mapped via `*.do`
## TEST URL
```
http://localhost:8080/Servlets3_war_exploded/product.do?id=1,data=abc
```

## DAO - data access object
In computer software, a data access object (DAO) is a pattern that provides an abstract interface to some type of 
database or other persistence mechanism.

There is an @interface that has methods to select data, e.g
```
class Product {
// e.g a JavaBean
}

interface ProductDAO {
    // Never return null!!! Throw exception instead;

    Product selectByID(int id);

    List<Product> selectAll();

    // The list of selectProductsBy{Characterirstic} can be extednded on 
    // developer's desire

}
```

DAO directory within a project:
```
-dao
| |_Exceptions
|       |__NoSuchEntityException // entry not found in db
|       |__DAOSystemException    // db access lost
|       |__DAOBusinessException  // entities IDs conflict
|
|__ @Interface ProductDao
```

## HTTPServlet's doGet()
Difference between:

```

request.getParameter("abc");
request.Attribute("xyz");
// Both return Map<>
```
####Attributes
URL queries, there is only `getPararameter(str)`, **NOT** `setParam()`;

For Servlet API URL queries are Map<String, String>;
Data that has arrived from client
####Parameters
An empty map that is populated and retrieved by servlet(programmer);

##Redirection
Base alg:
1. doLogic
2. set model as `request.setAttribute(String str)`;
3. get dispatcher for a VIEW resource: `request.getRequestDispatcher('responsePage.jsp')`;
4. `dispatcher.foward(request, responce)`;

**NOTE!!!**  _Internal_ redirect, that is URL does not change;
5. `return;` - returns from Servlet worker method;

 
**NOTE!!!** _External_ redirect:
`response.sendRedirect("error.jsp")` 
In this case: `servlet --302--> client -->error.jsp`;

---
###Explore Browser F12 Networking

**Tip** All headers & response are a stream of [ASCII] bytes  divided by `\n`.

[x] **//TODO: Reproduce servlet from the lecture;**

Developer has no control over when `Servlet`'s entities are created, so mutable entities => bad
practice. Instead, developer has access to **context**.

**IMPORTANT !** From the time when `Servlet` receives request till the moment 
when the servlet returns the response, the `HttpServletRequest` and `HttpServletResponse`
are the same entities that carry attributes. This is true for _internal_ redirect, not for
`response.sendRedirect()`


**TIP** You can change jsp while Tomcat is running;
___
### Context Hierarchy
For explanation of below stuff, see _scopes.png_.

-   Page
-   Request 
-   Session
-   ServletContext (application)

##### Implicit objects
When you use scriplets `<% String attr = request.getAttribute(str); %>` there are implicit objects on
a JSP page, such as `request`.

**Tip** Scriplets vs expression diff:

1.  Just performs java code (ends with semicolon): `<% int x = 1; %>`

2.  performs such java code that returns something (no semicolon): `<%= sin(x)%>`