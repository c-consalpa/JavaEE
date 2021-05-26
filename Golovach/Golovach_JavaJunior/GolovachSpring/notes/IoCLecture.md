#IoC Container Overview
Base interface - `org.springframework.context.ApplicationContext` with descendats:
    - ClassPathXmlApplicationContext
    - FileSystemXmlApplicationContext

### Configuration Metadata
Traditional config - via XML, however, there are as well:
    
- [Annotation-based container configuration](https://docs.spring.io/spring-framework/docs/4.3.12.RELEASE/spring-framework-reference/html/beans.html#beans-annotation-config)
- [Java-based container configuration](https://docs.spring.io/spring-framework/docs/4.3.12.RELEASE/spring-framework-reference/html/beans.html#beans-java)
    
   
### Instantiating Container
sample daos.xml:
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accountDao"
        class="org.springframework.samples.jpetstore.dao.jpa.JpaAccountDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="itemDao" class="org.springframework.samples.jpetstore.dao.jpa.JpaItemDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for data access objects go here -->

</beans>
```
    Note: XML defintion can span multiple files.
       
Somewhere in Java:
```
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance
List<String> userList = service.getUsernameList();
```

##Beans
A bean is a POJO managed by Spring container. A bean holds the following information:
- class
- name
- scope
- autowiring mode
- initialization behavior
###Bean identifiers
Each bean has:
- id: The id attribute allows you to specify exactly one id.
- name: In a bean definition itself, you can supply more than one name for the bean, by using a combination of up to one
 name specified by the id attribute, and any number of other names in the name attribute. 
 
Aliasing also supported for beans:
```
<alias name="fromName" alias="toName"/>
```
###Bean instantiation
This:
```
PetStoreService service = context.getBean("petStore", PetStoreService.class);
```
is close to :

```
Java:
PetStoreService service = new PetStoreService();
```

    Note To instantiate an inner class => context.getBean("petStore", com.Pets$PetStoreService.class);

####Constructor instantiation
See `com.consalpa.TestServlet.java` with comments.
#### Factory method instantiation
```
<bean id="clientService"
    class="examples.ClientService"
    factory-method="createInstance"/>
```
```
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService() {}

    public static ClientService createInstance() {
        return clientService;
    }
}
```

#Dependency Injection
See examples constructor-based vs setter based in `consalpa.TestServlet`.
##Constructor-based DI
The following class injected with DI:
```
public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on a MovieFinder
    private MovieFinder movieFinder;

    // a constructor so that the Spring container can inject a MovieFinder
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
```
###Constructor argument resolution
Consider class:
```
package x.y;

public class Foo {

    public Foo(Bar bar, Baz baz) {
        // ...
    }
}
```
Since it is clear to Spring that **Bar** and **Baz** are different types (no inheritance between them), the following
config works fine:
```
<beans>
    <bean id="foo" class="x.y.Foo">
        <constructor-arg ref="bar"/>
        <constructor-arg ref="baz"/>
    </bean>

    <bean id="bar" class="x.y.Bar"/>

    <bean id="baz" class="x.y.Baz"/>
</beans>
```

Passing primitives to constructor:
```
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg type="int" value="7500000"/>
    <constructor-arg type="java.lang.String" value="42"/>
</bean>
```
Using indexes:
```
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg index="0" value="7500000"/>
    <constructor-arg index="1" value="42"/>
</bean>
```
and even constructor argument names:
```
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg index="0" value="7500000"/>
    <constructor-arg index="1" value="42"/>
</bean>
```

##Setter-based DI
Setter-based DI is accomplished by the container calling setter methods on your beans after invoking a no-argument 
constructor or no-argument static factory method to instantiate your bean.

The following class is a good POJO sample for setter-based DI:
```
public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on the MovieFinder
    private MovieFinder movieFinder;

    // a setter method so that the Spring container can inject a MovieFinder
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
``` 

### Dependency resolution process
1. `ApplicationContext` object is created and initialized with configuration metadata that describes all the beans. 
Configuration metadata can be specified via XML, Java code, or annotations.
2. For each bean, its dependencies are expressed in the form of properties, constructor arguments, or arguments to the 
static-factory method if you are using that instead of a normal constructor. These dependencies are provided to the 
bean, when the bean is actually created.
3. Each property or constructor argument is an actual definition of the value to set, or a reference to another bean
 in the container.
4. Each property or constructor argument which is a value is converted from its specified format to the actual type of 
that property or constructor argument. By default Spring can convert a value supplied in string format to all built-in 
types, such as int, long, String, boolean, etc.


    Important: The Spring container validates the configuration of each bean as the container is created. However, the 
    bean properties themselves are not set until the bean is actually created.
    
    Spring is capable of detecting circular dependencies.
    
###Setter-based DI config example
```
appContext.xml
<bean id="exampleBean" class="examples.ExampleBean">
    <!-- setter injection using the nested ref element -->
    <property name="beanOne">
        <ref bean="anotherExampleBean"/>
    </property>

    <!-- setter injection using the neater ref attribute -->
    <property name="beanTwo" ref="yetAnotherBean"/>
    <property name="integerProperty" value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```
The equivalent for constructor-based DI looks as follows:
```
<bean id="exampleBean" class="examples.ExampleBean">
    <!-- constructor injection using the nested ref element -->
    <constructor-arg>
        <ref bean="anotherExampleBean"/>
    </constructor-arg>

    <!-- constructor injection using the neater ref attribute -->
    <constructor-arg ref="yetAnotherBean"/>

    <constructor-arg type="int" value="1"/>
</bean>

<bean id="anotherExampleBean" class="examples.AnotherBean"/>
<bean id="yetAnotherBean" class="examples.YetAnotherBean"/>
```

##Dependencies and configuration in detail
###Straight Values
Consider the bean config:
```
<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <!-- results in a setDriverClassName(String) call -->
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
    <property name="username" value="root"/>
    <property name="password" value="masterkaoli"/>
</bean>
```
Here, the `value` attr of `<property/>` is a `String`. It is converted to corresponding type if needed.
    
Note [p-namespace](https://docs.spring.io/spring-framework/docs/4.3.12.RELEASE/spring-framework-reference/html/beans.html#beans-p-namespace) for <property/> shortcutting. 

####idref
```
<bean id="theTargetBean" class="..."/>

<bean id="theClientBean" class="...">
    <property name="targetName">
       allows to validate at deployment time that the referenced bean exists. 
        <idref bean="theTargetBean"/>
    </property>
</bean>
```

###References to collaborators (other beans)
Use `ref` to reference other beans. The value of the bean attribute may be the same as the id attribute of the target 
bean, or as one of the values in the name attribute of the target bean:
`<ref bean="someBean"/>`

###Spring config Collections
In the `<list/>`, `<set/>`, `<map/>`, and `<props/>` elements, you set the properties and arguments of the Java Collection types
 List, Set, Map, and Properties, respectively.
 
###Nulls and Empty Strings
Spring treats empty arguments for properties and the like as empty Strings. The following XML-based configuration 
metadata snippet sets the email property to the empty String value ("").

To pass `null`:
```
<bean class="ExampleBean">
    <property name="email">
        <null/>
    </property>
</bean>
```
The above snippet is equivalent to `exampleBean.setEmail(null)`

###XML shortcut with the p-namespace
The p-namespace enables you to use the bean element’s attributes, instead of nested <property/> elements, to describe 
your property values and/or collaborating beans.

###XML shortcut with the c-namespace
Similar to the the section called “XML shortcut with the p-namespace”, the c-namespace, newly introduced in Spring 3.1, 
allows usage of inlined attributes for configuring the constructor arguments rather then nested constructor-arg elements.
Example:
```
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:c="http://www.springframework.org/schema/c"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="bar" class="x.y.Bar"/>
    <bean id="baz" class="x.y.Baz"/>

    <!-- traditional declaration -->
    <bean id="foo" class="x.y.Foo">
        <constructor-arg ref="bar"/>
        <constructor-arg ref="baz"/>
        <constructor-arg value="foo@bar.com"/>
    </bean>

    <!-- c-namespace declaration -->
    <bean id="foo" class="x.y.Foo" c:bar-ref="bar" c:baz-ref="baz" c:email="foo@bar.com"/>

</beans>
```