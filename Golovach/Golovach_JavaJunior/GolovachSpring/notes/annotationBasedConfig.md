#DI-Related Annotations
https://www.baeldung.com/spring-value-annotation
https://www.baeldung.com/spring-core-annotations#wiring



###@Autowired
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

###@Bean
@Bean marks a factory method which instantiates a Spring bean:
```java
@Bean
Engine engine() {
    return new Engine();
}
```
Spring calls these methods when a new instance of the return type is required.

###@Qualifier
If there are two beans that implement the same interface:
```java
class Bike implements Vehicle {}

class Car implements Vehicle {}
```

**@Qualifier** is used with **@Autowired**  to specify the bean to be used due to ambiguity:
- Constructor-based:
```java
@Autowired
Biker(@Qualifier("bike") Vehicle vehicle) {
    this.vehicle = vehicle;
}
```
- Setter-based

```java
@Autowired
void setVehicle(@Qualifier("bike") Vehicle vehicle) {
    this.vehicle = vehicle;
}
```
-or-
```java
@Autowired
@Qualifier("bike")
void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
}
```

- Field injection
```java
@Autowired
@Qualifier("bike")
Vehicle vehicle;
``` 

###@Required
on setter methods that MUST be populated via XML

###@Value
@Value for injecting property values into beans. 
It's compatible with constructor, setter, and field injection.

####Inject @Value from .properties file
```properties
test.properties:
engine.fuelType=petrol
```
Inject in code:
```java
@Value("${engine.fuelType}")
String fuelType;
```

### @DependsOn(MyClass.class)
Initialize other beans before the annotated one

###@Lazy