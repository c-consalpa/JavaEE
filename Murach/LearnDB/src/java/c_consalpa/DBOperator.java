package c_consalpa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author c-consalpa
 */
public class DBOperator {
    private final String DB_NAME = "murach_test";
    private final String TABLE_NAME = "car_users";
    String dbUserName = "murach";
    String dbUserPassword = "murach";
    
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
            String dbURL = "jdbc:mysql://localhost:3306/murach_test";
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
        
        
//        GET DATA:
//        String SQL_SELECT = "SELECT * FROM murach_test.car_users;";
//        ResultSet resultSet = statement.executeQuery(SQL_SELECT);
//        while(resultSet.next()) {
//            //            get resultSet value by 0-based column index:
//            String s1 = resultSet.getString(1);
//            String s2 = resultSet.getString(2);
//            String s3 = resultSet.getString(3);
//            // also it is possible to get resultSet value by column name 
//            System.out.println(s1 + " : " + s2 + " : " + s3);
//            
//        }

//      INSERT Data

//        String dateTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(System.currentTimeMillis()));
//                
//        String SQL_UPDATE = "INSERT INTO murach_test.car_users (user_name, user_age) " +
//                            "VALUES ('servletName_Insert', '" + dateTime + "');";
//        int row_count = statement.executeUpdate(SQL_UPDATE);
//        System.out.println("Inserted: " + row_count + " rows;");
        

//      UPDATE DATA  
//        String SQL_UPDATE = "UPDATE " + DB_NAME + "." + TABLE_NAME + " " + 
//                            "SET USER_NAME='NOTJohn' " +
//                            "WHERE USER_AGE='1991-12-02 14:20:00'";
//        int rows_updated = statement.executeUpdate(SQL_UPDATE);
//                System.out.println("Updated: " + rows_updated + " rows;");

//        DELETE ROWS
//          String SQL_DELETE = "DELETE FROM "+DB_NAME+"."+TABLE_NAME+" "+
//                              "WHERE user_name='Ann';";
//          int rows_deleted = statement.executeUpdate(SQL_DELETE);
    
          
//      PREPARED STATEMENTS:
        String dateTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(System.currentTimeMillis()));
        String preparedQuery = "INSERT INTO " + DB_NAME + "." + TABLE_NAME + " " +
                               "(USER_NAME, USER_AGE)" +
                               "VALUES (?,?), " + 
                                      "(?,?);";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, "preparedName");
        ps.setString(2, dateTime);
        
        ps.setString(3, "preparedName1");
        ps.setString(4, dateTime);
        ps.executeUpdate();

          return null;

    }
}
