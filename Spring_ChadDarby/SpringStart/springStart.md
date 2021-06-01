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