
import data.ConnectionPool;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
    private static final String DB_USER             = "murach";
    private static final String DB_USER_PASSWORD    = "murach";
    private static final String DB_NAME             = "testdb";
    private static final String DB_URL              = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static ConnectionPool cPool                            = null;
    static {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static String getData(String rawSQL) throws SQLException {
        String tableData = "";
        
        cPool = ConnectionPool.getInstance();
        Connection connection = cPool.getConnection();

        PreparedStatement ps = connection.prepareStatement(rawSQL);
        ResultSet rs = ps.executeQuery();
        tableData = prepareTableData(rs);
        
        rs.close();
        ps.close();
        cPool.freeConnection(connection);
        return tableData;
    }
    
    static int modifyData(String rawSQL) throws SQLException {
        int affectedRowsCnt = 0;
        
        cPool = ConnectionPool.getInstance();
        Connection connection = cPool.getConnection();
        
        
        PreparedStatement ps = connection.prepareStatement(rawSQL);
        affectedRowsCnt = ps.executeUpdate();
        ps.close();
        cPool.freeConnection(connection);

        return affectedRowsCnt;
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
                byte[] tmp = rs.getBytes(i);
                if (tmp != null) {
                    sb.append(new String(tmp, Charset.forName("UTF-8")));    
                } else {
                    sb.append("NULL");    
                }
                sb.append("<td>");
            }
            sb.append("</tr>");
        }
       
        sb.append("</table>");
        return sb.toString();
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
}
