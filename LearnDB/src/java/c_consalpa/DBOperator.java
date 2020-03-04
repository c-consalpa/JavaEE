package c_consalpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author c-consalpa
 */
public class DBOperator {
    
    public boolean connect(String username, String password) throws SQLException {
//        TOMCAT JDBC issue:
        String className = "com.mysql.jdbc.Driver";
        try {
            Class.forName(className);
             } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
        } 
        
        Connection connection = null;
        try {
            String dbURL = "jdbc:mysql://localhost:3306/test";
            connection = DriverManager.getConnection(dbURL, username, password);
            return (connection != null);
            
         } catch (SQLException e) {
             for (Throwable t : e) {
                 t.printStackTrace();
             }
             throw e;
         }      
}
}
