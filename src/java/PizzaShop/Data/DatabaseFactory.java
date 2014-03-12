/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Database Creation Singleton. Keeps the value nice and cached.
 * @author phalpin
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
    
    /**
     * Constructor - need to get this shoehorned into a config file somehow.
     */
    public DatabaseFactory(){
        _driverType = "jdbc";
        _dbType = "mysql";
        _ipAddress = "127.0.0.1";
        _dbName = "PizzaShop";
        _port = "3306";
        _user = "root";
        _pass = "oopwinter2014";
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                String.format(
                        "{0}:{1}://{2}:{3}/{4}?user={5}&password={6}",
                        _driverType,
                        _dbType,
                        _ipAddress,
                        _dbName,
                        _port,
                        _user,
                        _pass
                ),
                null
        );
    }
}
