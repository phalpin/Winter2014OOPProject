/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Data.ServiceFactory;
import PizzaShop.Models.Pizza;
import PizzaShop.Models.PizzaTopping;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.IActionResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phalpin
 */
public class PizzaService implements IDataService<Pizza> {

    private Connection con = null;
    private ToppingService _toppings = ServiceFactory.Instance().getTopSvc();
    
    public PizzaService(){
        try{
            con = DatabaseFactory.getInstance().getConnection();
        }
        catch(SQLException ex){
            Logger.getLogger(PizzaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public IActionResult<Pizza> Create(Pizza obj) {
        ActionResult<Pizza> result = new ActionResult<Pizza>();
        try{
            CallableStatement pza = con.prepareCall("{call Pizza_Create(?,?,?)}");
            pza.setInt("p_pizzaSizeId", obj.getSize().getValue());
            pza.setInt("p_pizzaTypeId", obj.getType().getValue());
            
            ResultSet rs = pza.executeQuery();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
            }
            
            //Create Toppings on Pizza.
            for(PizzaTopping pt : obj.getToppings()){
                if(pt.getId() == 0){
                    _toppings.Create(pt);
                }
            }
            
            //Set the Toppings as connected on the table.
            for(PizzaTopping pt : obj.getToppings()){
                CallableStatement top = con.prepareCall("{call Pizza_AddTopping}");
                top.setInt("p_pizzaId", obj.getId());
                top.setInt("p_toppingId", pt.getId());
                top.executeQuery();
            }
        }
        catch(Exception ex){
            
        }

        return result;
    }

    @Override
    public IActionResult<Pizza> Read(int id) {
        ActionResult<Pizza> result = new ActionResult<Pizza>();
        Pizza p = new Pizza();
        try{
            CallableStatement cstmt = con.prepareCall("{Call Pizza_Read(?)}");
            cstmt.setInt("p_pizzaId", id);
            ResultSet rs = cstmt.executeQuery();
            
            if(rs.next()){
                
            }
            
            if(rs.next()){
                
            }
            
            
        }
        catch(Exception ex){
            
        }
        
        return result;
    }

    @Override
    public IActionResult<Pizza> Read(Pizza obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Pizza> Update(Pizza obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(Pizza obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<ArrayList<Pizza>> ReadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
