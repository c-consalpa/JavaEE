#Configuration
web-xml:
1. define dispatcher servlet (org.springframework.web.servlet.DispatcherServlet)
from **spring-mvc.jar**
    with `<init-param>` pointing to an XML servlet configuration, e.g. dispatcher-servlet.xml

dispatcher-servlet.xml:

2. add support for component scanning 
3. add support for conversion, formatting, validation, etc. (`<mvc:annotation-driven/>`)
4. define MVC view resolver bean (`org.springframework.web.servlet.view.InternalResourceViewResolver`).

## Define MVC Controller Class

```java

@Controller
public class mController {
    
    // methods annotated with this shit (@RequestMapping) must return a string that is used to pick the 
    // suitable VIEW resource
    @RequestMapping("/fooPath")
    public String showPage() {
        // InternalResourceViewResolver will add prefix/suffix:
        return "view-page-name";
    }   

}
```

##Adding Data to Model
1. In the Controller class, create a method annotated with `@RequestMapping`
The method signature must use Spring's arguments:
```java
public void foo(javax.servlet.http.HTTPServletRequest r, Model m) {
    // whatever operations on r
    r.getParameter("paramKey");
    
    //put data into model:
    m.addAttribute("attributeKey", new Object());

    return "home";
}
```
2. access model's attribute in JSP just like `requst.getAttr()` - `{$attributeKey}`

All

## Use static resources - css/js/imgs
1. Add to SpringMVC config file:
    ```
        <mvc:resources mapping="/resources/**" location="/resources/"></mvc:resources>
    ```
    it uses URL mapping to get static resources.
2. put all assets under location dirs (e.g webapp/WEB-INF/resources/css)
3. reference in VIEWs like:
    ```
    <img src="${pageContext.request.contextPath}/resources/images/spring-logo.png"> 
    ```
