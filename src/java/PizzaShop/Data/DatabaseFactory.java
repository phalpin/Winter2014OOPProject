package PizzaShop.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Database Creation Singleton. Keeps the value nice and cached.
 */
public class DatabaseFactory {
    
    //<editor-fold desc="Singleton Methods">
    private static DatabaseFactory _instance;
    
    /**
     * Used to get an instance of the Database Factory.
     * @return An instance of the Database Factory.
     */
    public static DatabaseFactory getInstance(){
        if(_instance == null) _instance = new DatabaseFactory();
        return _instance;
    }
    
    /**
     * Initializes the Singleton.
     */
    public void Initialize(){
        
        if(_instance != null) _instance = new DatabaseFactory();
    }
    
    /**
     * Reinitializes the Singleton.
     */
    public void Reinitialize(){
        _instance = null;
        _instance = new DatabaseFactory();
    }
    //</editor-fold>
    
    private final String _driverType;
    private final String _dbType;
    private final String _ipAddress;
    private final String _dbName;
    private final String _port;
    private final String _user;
    private final String _pass;
    private Connection _con;
    
    /**
     * Constructor - need to get this shoehorned into a config file somehow.
     * @throws java.sql.SQLException
     */
    public DatabaseFactory(){
        _driverType = "jdbc";
        _dbType = "mysql";
        _ipAddress = "localhost";
        _dbName = "PizzaShop";
        _port = "3306";
        _user = "root";
        _pass = "oopwinter2014";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            _con = DriverManager.getConnection(getConnectionString(), _user, _pass);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    private String getConnectionString(){
            return MessageFormat.format(
                    "{0}:{1}://{2}:{3}/{4}",
                    _driverType,
                    _dbType,
                    _ipAddress,
                    _port,
                    _dbName
            );
        
    }
    
    /**
     * Used to obtain a mysql connection for a given service to use.
     * @return MySQL connection object
     * @throws SQLException Depending on how the MySQL driver is feeling at any given moment.
     */
    public Connection getConnection() throws SQLException {
        return _con;
    }
}
