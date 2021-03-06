package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Models.Beverage;
import PizzaShop.Resources.IActionResult;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Beverage Data Access Layer - Unimplemented for the time being.
 */
public class BeverageService implements IDataService<Beverage>{

    private Connection con = null;
    
    public BeverageService(){
        try{
            con = DatabaseFactory.getInstance().getConnection();
        }
        catch(SQLException ex){
            Logger.getLogger(BeverageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public IActionResult<Beverage> Create(Beverage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Beverage> Read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Beverage> Read(Beverage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Beverage> Update(Beverage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(Beverage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
