#Hibernate Course

##Configuration

1. Hibernate maven dependencies;
2. `hibernate.cfg.xml`:
    ```xml
    <hibernate-configuration>
        <session-factory>
            <!-- JDBC Database connection settings -->
            <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
            <property name="connection.url">jdbc:mysql://localhost:3306/derby_test?useSSL=false&amp;serverTimezone=UTC</property>
            <property name="connection.username">chad</property>
            ...
   ```
   
3. 
    ```java
    @Entity
    @Table(name = "events")
    public class Event {
        @Id
        @Column(name = "id")
        private int id;
    
        @Column(name = "event_name")
        private String eventName;
   ...
   }
    ```
4. 
    - `SessionFactory` - heavy-weight, lives all the run time asked by `Session`s;

    - `Session` - short-lived, an instance from `SessionFactory` each time when db interaction is required;
    ```java
        SessionFactory sf = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Event.class)
                        .buildSessionFactory();
        Session session = sf.getCurrentSession();

        try {
            Event testEventObj = new Event("pohod", "bakhch", 50);
            session.beginTransaction();
            session.save(testEventObj);
            session.getTransaction().commit();

        } finally {
            sf.close();
        }
    ```
5. Add Java9+ missing classes, eg:
    ```xml

   <!--    Java9+ Hibernate requirements:-->
       <dependency>
         <groupId>javax.xml.bind</groupId>
         <artifactId>jaxb-api</artifactId>
         <version>2.3.1</version>
       </dependency>
   
       <dependency>
         <groupId>com.sun.xml.bind</groupId>
         <artifactId>jaxb-impl</artifactId>
         <version>2.3.4</version>
       </dependency>
   
   
   
       <dependency>
         <groupId>com.sun.xml.bind</groupId>
         <artifactId>jaxb-impl</artifactId>
         <version>2.3.3</version>
       </dependency>
   
       <dependency>
         <groupId>com.sun.activation</groupId>
         <artifactId>javax.activation</artifactId>
         <version>1.2.0</version>
       </dependency>
    ```

##CRUD