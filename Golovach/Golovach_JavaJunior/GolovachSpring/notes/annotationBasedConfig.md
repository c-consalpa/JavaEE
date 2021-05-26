#DI-Related Annotations
https://www.baeldung.com/spring-core-annotations#wiring


##@Autowired
marks a dependency which Spring is going to resolve and inject:
- Constructor injection:
    ```$java
    class Car {
        Engine engine;
    
        @Autowired
        Car(Engine engine) {
            this.engine = engine;
        }
    }
    ```
    
- Setter injection:
    ```java
    class Car {
        Engine engine;
    
        @Autowired
        void setEngine(Engine engine) {
            this.engine = engine;
        }
    }
    ```
    
- Field injection:
    ```java
    class Car {
        @Autowired
        Engine engine;
    }
    ```

**@Autowired** has a boolean argument called required with a default value of true.
It tunes Spring's behavior when it doesn't find a suitable bean to wire. When true, an exception is thrown, otherwise, nothing is wired.

##@Bean
@Bean marks a factory method which instantiates a Spring bean:
```java
@Bean
Engine engine() {
    return new Engine();
}
```
Spring calls these methods when a new instance of the return type is required.