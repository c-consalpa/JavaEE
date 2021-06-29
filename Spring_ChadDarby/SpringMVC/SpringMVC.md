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
    
    // methods annotated with this shit must return a string that is used to pick the 
    // suitable VIEW resource
    @RequestMapping("/fooPath")
    public String showPage() {
        // InternalResourceViewResolver will add prefix/suffix:
        return "view-page-name";
    }   

}
```