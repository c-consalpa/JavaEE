package c_consalpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author c-consalpa
 */
public class DBOperator {
    String dbUserName = "netbeans_test_ac";
    String dbUserPassword = "netbeans_test_ac";
    
    public Connection connect(String username, String password) throws SQLException {
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
            return connection;
            
         } catch (SQLException e) {
             for (Throwable t : e) {
                 t.printStackTrace();
             }
             throw e;
         }      
}
    
    public ResultSet doStatement() throws SQLException {
        Connection connection;
        connection = connect(dbUserName, dbUserPassword);
        if (connection == null) {
            throw new SQLException("cannot establish connection");
        }
        Statement statement = connection.createStatement();
        
        
////        GET DATA:
//        String SQL_SELECT = "SELECT * FROM test.xes_test;";
//        ResultSet resultSet = statement.executeQuery(SQL_SELECT_FROM_XESTEST);
//        while(resultSet.next()) {
////            get resultSet value by 0-based column index:
//            String s1 = resultSet.getString(1);
////            get value by column name:
//            String s2 = resultSet.getString("data");
//            System.out.println(s1 + " : " + s2);
//        }

//      INSERT Data
//        String SQL_UPDATE = "INSERT INTO test.xes_test (id, data) " +
//                            "VALUES ('99', 'ninety-nine');";
//        int row_count = statement.executeUpdate(SQL_UPDATE);
//        System.out.println("Inserted: " + row_count + " rows;");
        

////      UPDATE DATA  
//        String SQL_UPDATE = "UPDATE test.xes_test " + 
//                            "SET data='updated' " +
//                            "WHERE id=99";
//        int rows_updated = statement.executeUpdate(SQL_UPDATE);
//                System.out.println("Updated: " + rows_updated + " rows;");

//        DELETE ROWS
//          String SQL_DELETE = "DELETE FROM test.xes_test " +
//                              "WHERE data='first';";
//          int rows_deleted = statement.executeUpdate(SQL_DELETE);
    
          
//      PREPARED STATEMENTS:
        String preparedQuery = "INSERT INTO test.xes_test " +
                               "VALUES (?,?), " + 
                                      "(?,?);";
//        PreparedStatement ps = connection.prepareStatement(preparedQuery);
//        ps.setInt(1, 12);
//        ps.setString(2, "prepared_1");
//        ps.setInt(3, 13);
//        ps.setString(4, "prepared_2");
//        ps.executeUpdate();


          return null;
          
          
          
    }
}
