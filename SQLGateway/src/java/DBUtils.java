
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
    private static final String DB_USER = "murach";
    private static final String DB_USER_PASSWORD = "murach";
    private static final String DB_NAME = "murach";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    static {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


        
    
    
    
    static String getData(String sql) throws SQLException {
        Connection connection = null; 
        String tableData = "";
        
            connection = getDBConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                tableData = prepareTableData(rs);
                rs.close();
            }
            ps.close();
            closeConnection(connection);
        
        return tableData;
    }

    private static String prepareTableData(ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        ResultSetMetaData meta = rs.getMetaData();
        int columnsCount = meta.getColumnCount();
        sb.append("<table style=\"border: 1px solid black\">");
        while (rs.next()) {
            sb.append("<tr>");
            for (int i = 1; i <= columnsCount; i++) {
                sb.append("<td>");
                sb.append(new String(rs.getBytes(i)));
                sb.append("<td>");
            }
            sb.append("</tr>");
        }
       
        sb.append("</table>");
        return sb.toString();
    }

    static int insertData(String sqlText) throws SQLException {
        Connection connection = null; 
        connection = getDBConnection();
        int affectedRowsCount = 0;
        PreparedStatement ps = connection.prepareStatement(sqlText);
        affectedRowsCount = ps.executeUpdate();
        ps.close();
        closeConnection(connection);

        return affectedRowsCount;
    }


    static int updateData(String sqlText) throws SQLException {
        Connection connection = null;
        int affectedRowsCount = 0;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD);
        
        PreparedStatement ps = connection.prepareStatement(sqlText);
        affectedRowsCount = ps.executeUpdate();
        ps.close();
        
        closeConnection(connection);
        return affectedRowsCount;
    }

    static int removeData(String sqlText) {
        Connection connection = null;
        int removedRowsCnt = 0;
        
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD);
            PreparedStatement ps = connection.prepareStatement(sqlText);
            removedRowsCnt = ps.executeUpdate();
            ps.close();            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(connection);
        }
        return removedRowsCnt;
    }
    
    private static Connection getDBConnection() throws SQLException {
         Connection connection = null;
         connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD);
         
         if (connection == null) {
             throw new SQLException("failed to craete a connection");
         }
         return connection;
    }
    
    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    private static void closeStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
