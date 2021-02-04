##Tasks
//TODO: Implement reflexive class field parser up to the specific class

Core Terms To Explore:
-   Dependency Injection
-   Inversion Control

##Dependency Injection and Inversion Control
!!!awesome!!!
Refer for Best Explanation:
https://martinfowler.com/articles/injection.html




##Enabling Spring in Maven
1. Spring maven dependency import. Core maven dependencies: **spring-core**, **spring-beans**, 
**spring-context**, **spring-expression**(?).
2. Use XML config:
    
    appContext.xml:
     ```
     <beans>
         <bean id="MovieLister" class="spring.MovieLister">
             <property name="finder">
                 <ref local="MovieFinder"/>
             </property>
         </bean>
         <bean id="MovieFinder" class="spring.ColonMovieFinder">
             <property name="filename">
                 <value>movies1.txt</value>
             </property>
         </bean>
     </beans>
    ```
3. Somewhere in code:
    ```
    public void testWithSpring() throws Exception {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
        MovieLister lister = (MovieLister) ctx.getBean("MovieLister");
        Movie[] movies = lister.moviesDirectedBy("Sergio Leone");
        assertEquals("Once Upon a Time in the West", movies[0].getTitle());
    }
    ```
    
###Pom.xml Variables
EL-like variables reuse:
1. Declare variable:
    ```
    <properties>
        <foo>1.2</foo>
    </properties>
    ```
2. Reuse variable:
    ```
    <dependency>
        <version>${foo}</version>
    ...
   </dependency>
    ```
   
###Spring Structure
Core Container:
- core
- Beans
- context
- expression-language
    


