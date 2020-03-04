
package c_consalpa.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {


    void testConnection() {
//      Connection dbConnection = null;
//
//    try {
//      String url = "jdbc:mysql://localhost:3306/test";
//      Properties info = new Properties();
//      info.put("user", "netbeans_test_ac");
//      info.put("password", "netbeans_test_ac");
//
//      dbConnection = DriverManager.getConnection(url, info);
//
//      if (dbConnection != null) {
//        System.out.println("Successfully connected to MySQL database test");
//      }
//
//    } catch (SQLException ex) {
//      System.out.println("An error occurred while connecting MySQL databse");
//      ex.printStackTrace();
//    }
//
//  }
        
        
        
        try {
             String dbURL = "jdbc:mysql://localhost:3306/test";
             String userName = "netbeans_test_ac";
             String userPassword = "netbeans_test_ac";

              Connection connection = DriverManager.getConnection(dbURL, userName, "netbeans_test_ac");

              
         } catch (SQLException e) {
             for (Throwable t : e) {
                 t.printStackTrace();
             }
         }
    }
}

