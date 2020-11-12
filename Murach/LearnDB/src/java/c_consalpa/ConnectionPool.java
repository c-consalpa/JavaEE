package c_consalpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
    private static ConnectionPool connectionPool = null;
    private static DataSource dataSource = null;
   
    
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/c_consalpa");
        } catch (NamingException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    public static synchronized ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }
    
    
    public Connection getConnection() {
       Connection c = null;
        try {
            c = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
       return c;
    }
    
    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
