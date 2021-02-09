#Paradigms: OOP, Relational, AOP
##OOP and Relational
OOP Key features - class is the central unit, hierarchy, inheritance, polymp, encaps.
AOP can be compared to an attempt to apply realtional SQL over Java's OOP.

##AOP
####Aspect
A class/group of classes that implement a single functional entity, e.g:

- loggers
- profilers
- exeption hanlders

####Join Point
A joint point is a situation like:

- method invocation
- exception throwing moment
- constructor call
- class field access

Spring allows only to intercept method invocation. 

####Advice
This is the additional code that you want to apply to your existing model. In our 
example, this is the logging code that we want to apply whenever the thread enters or exits a Join Point (method).


#AOP Usage [Schema approach]
web.xml:
```
<context-param>
    <param-name>ContextConfigLocation</param-name>
    <param-value>/appContext-dao-aop-schema.xml</param-value>
</context-param>
```

appContext-dao-aop-schema.xml:
```
<beans 
    ...
    xmlns:aop="http://spring aop...
/>
<!-- name 'aspect-profiler' - is a custom string for a bean -->

    <bean id="aspect-profiler" class="com.consalpa.SimpleProfiler"/>
    <bean id="aspect-logger" class=""/>
    <bean id="exception-logger" class=""/>

    <aop:config>
        <aop:aspect ref="aspect-profiler>
            <aop:pointcut id="selectByID" expression="execution(* com.consalpa.dao.ProductDAO.getProductByID)"
            <aop:around pointcut-ref="selectByID" method="profile" />
        </aop:aspect>
...
```
What this means - 
`<aop:pointcut id="selectByID" expression="execution(* com.consalpa.dao.ProductDAO.getProductByID)"` :
I want to intercept the method `selectById(int)` of the interface `ProductDAO` regardless of the scope
(`*`) 

SimpleProfiler.java:
```
see consalpa.aspects.SimpleProfiler
```