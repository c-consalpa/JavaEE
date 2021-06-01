###Constructor-based DI:
```xml
<bean id="car" class="xany.model.Car">
    <constructor-arg value="mark2"></constructor-arg>
    <constructor-arg ref="2jz_turbo"></constructor-arg>
</bean>
```

###Setter-based DI
```xml
<bean id="bike" class="xany.model.Bike">
    <property name="engine" ref="moto_engine"></property>
    <property name="wheelsCnt" value="3"></property>
</bean>
```

###Inject values from .properties
1. Create foo.properties
2. In appContext.xml:
    ```xml
    <context:property-placeholder location="classpath:vehicle.properties"/>
    ``` 
   
#Bean Scopes
- singleton - a single shared instance of the bean
- prototype - a new object is created for each request
- request
- session
- global-session

###Usage
```xml
<bean id="" class="" scope=""/>
```

###Bean lifecycle Methods
Custom code during bean instantiation/destruction

###Usage
```xml
<bean id="foo" class="foo.Bar" init-method="doStuff" destroy-method="doStuff1"></bean>
```

**Note**: For "prototype" scoped beans, Spring does not call the destroy method.  It 
is on you to do the cleanup.

#Java-Annotated Config
###Generic strategy:
1. Enable component scanning:

    Somewhere in `applicationContext.xml`:
    ```xml
    <context:component-scan base-package="xany.model.annotatedModels"/>
    ```
     
2. Add **@Component**
    ```java
    @Component("ant")
    public class Ant implements Creature {
    ... 
    }
   ```
3. Get instatnce of annotated class:
    Same as with XML: ctx.getBean("ID", cls.class);
 
 ### Default Bean IDs
 If Bean ID is not specified explicitly, first-letter-lowecased class name is used
 `public class Ant ...` => bean ID "ant".