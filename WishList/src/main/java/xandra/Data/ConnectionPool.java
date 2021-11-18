package xandra.Data;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool cp = null;
    private static DataSource ds = null;


    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:/comp/env/jdbc/wishlist");
        } catch (NamingException ex) {
            System.out.println(ex);
        }


    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();


    }

    public static synchronized ConnectionPool getInstance() {
        if (cp == null) {
            cp = new ConnectionPool();
        }
        return cp;
    }
}
