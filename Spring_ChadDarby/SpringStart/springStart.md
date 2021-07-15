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
- singleton (default scope) - a single shared instance of the bean
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
 
    Note: However, for the special case of when BOTH the first and second characters of the class name are upper case, 
    then the name is NOT converted.
 
###Injection with @Autowired
- Constructor-based:
    ```java
    @Component
    class SQLDataStorage {
        @Autowired
        public SQLDataStorage(StorageConnector connector) {
            this.connector = connector;
        }
    ...
    }
    ```
  
- Setter-based
    ```java
    @Component
    class DFFDataStorage {
    private StorageConnector connector;
    
        @Autowired
        public void setConnector(StorageConnector storageConnector) {
            this.connector = storageConnector;
        }
    }
    ```

- custom method
    ```java
    @Autowired
        public SQLDataStorage(StorageConnector connector) {
            this.connector = connector;
        }
    ```
- field injection
    ```java
    @Autowired
        private StorageConnector fileStorageConnector;
    ```
###Annotated Scopes

```java
@Scope("prototype")
@Component()
public class Foo {

}
```

###PostConstruct/PreDestroy
```java
@PostConstruct
public void mInitMethod() {
    
}

@PreDestroy
public void mCleanupMethod() {

}
```
    Note Java9+ requires manual import of javax.annotations.jar for 
    these hooks;
    
#Java Code Config
See Chad Derby/SpringStart project