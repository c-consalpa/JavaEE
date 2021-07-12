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
   
##Use @RequestParam to bind HTTPServletRequest param to a variable

```java
    @RequestMapping("/path")
    public String testDataBinding(
            @RequestParam("requestParamKey") String request_param_bound,
            Model model) {

        model.addAttribute("modelAttrKey", requestParamKey);
        return VIEW_STRING;
    }
```

#SpringMVC's Form Tags
Useful stuff for automating `request.getAttribute.otherProcessing()` when handling a request
from a form.

1. Create a POJO. SpringMVC will pass this class instance as a Model attribute:
    ```java
    public class User {
        private String firstName;
    
        public User() {
    
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public String getFirstName() {
            return firstName;
        }
    }
    ```
 
 2. In a controller, see **usr** is set as the model attribute. When the form is showm, SpringMVC 
 calls User's `get*()` methods, when submitted - `set*()` methods.
     
    ```java
        @RequestMapping("/showForm")
        public String showForm(Model model) {
            User user = new User();
            model.addAttribute("usr", user);
            return "form-tags-view";
        }
    
        @RequestMapping("/processForm")
        public String processForm(@ModelAttribute("usr") User theUser) {
            //whatever manipulations with "theUser":        
            System.out.println(theUser.getFirstName());
            return "user-confirm";
        }
    ```
 
 
 3. Create SpringMVC's `<form:form modelAttribute="foo">` in a JSP:
    ```xml
        <form:form action="processForm" modelAttribute="usr">
            <form:input type="text" path="firstName"/>
            <input type="submit" value="Submit"/>
        </form:form>
    ```
    where:
    -  `modelAttribute="usr"`: **usr** is the Model's attribute key (set in controller);
    - `<form:input type="text" path="firstName"/>`: SpringMVC's tags. **path** refers to
    `usr.firstName` field - on the form submission, `usr.setName(FormInputValue)` is invoked. 
    
### SpringMVC's Form Tags: drop-down
JSP-Hardcoded:
```xml
    <form:select path="country">
        <form:option value="RU" label="Russia"/>
        <form:option value="UA" label="Ukraine"/>
        ...
    </form:select>
```
Java-based drop-down list values:
```xml
<form:select path="country">
    <form:options items="${usr.countryValues}"/>
</form:select>
```
where `${usr.countryValues}` points to a Collection in the `usr` object:
```java
    private HashMap<String, String> countryValues;  // +getter only
```

### SpringMVC's Form Tags: radio-buttons, check-boxes, etc
Analogous (JSTL iteration for list-based Java fields)

