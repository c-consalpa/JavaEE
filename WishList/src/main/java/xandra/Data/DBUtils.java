package xandra.Data;

import java.sql.*;


public class DBUtils {
    private static final String DB_USER             = "test";
    private static final String DB_USER_PASSWORD    = "";
    private static final String DB_NAME             = "wishlist";
    private static final String DB_URL              = "jdbc:mysql://localhost:3306/" + DB_NAME;
//    private static ConnectionPool cPool              = null;


//    static {
//        try {
//            Class.forName("com.mysql.cj.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static String read(String rawSQL) throws SQLException {

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded!");
//        } catch (ClassNotFoundException e) {
//            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
//        }


        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }


        Connection con = getDBConnection();
        System.out.println(con);

//        cPool = ConnectionPool.getInstance();
//        Connection connection = cPool.getConnection();
//
//        PreparedStatement ps = connection.prepareStatement(rawSQL);
//        ResultSet rs = ps.executeQuery();
//        tableData = prepareTableData(rs);
//
//        rs.close();
//        ps.close();
//        cPool.freeConnection(connection);
//        return tableData;
        return null;
    }

    static int modifyData(String rawSQL) throws SQLException {
//        int affectedRowsCnt = 0;
//
//        cPool = ConnectionPool.getInstance();
//        Connection connection = cPool.getConnection();
//
//
//        PreparedStatement ps = connection.prepareStatement(rawSQL);
//        affectedRowsCnt = ps.executeUpdate();
//        ps.close();
//        cPool.freeConnection(connection);
//
        return 0;
    }



    private static Connection getDBConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PASSWORD);

        if (connection == null) {
            throw new SQLException("failed to create a connection");
        }
        return connection;
    }

    private static void closeConnection(Connection connection) {
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex);
//        }
    }
}