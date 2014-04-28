package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Models.Pizza;
import PizzaShop.Models.PizzaSize;
import PizzaShop.Models.PizzaTopping;
import PizzaShop.Models.PizzaType;
import PizzaShop.Resources.ActionResult;
import PizzaShop.Resources.ActionResultStatus;
import PizzaShop.Resources.IActionResult;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Pizza Data Access Layer.
 */
public class PizzaService implements IDataService<Pizza> {

    private Connection con = null;
    
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
            pza.setInt("p_orderId", obj.getOrderId());
            
            ResultSet rs = pza.executeQuery();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
            }
            
            //Set the Toppings as connected on the table.
            for(PizzaTopping pt : obj.getToppings()){
                CallableStatement top = con.prepareCall("{call Pizza_AddTopping(?,?)}");
                top.setInt("p_pizzaId", obj.getId());
                top.setInt("p_toppingId", pt.getValue());
                top.executeQuery();
            }
        }
        catch(Exception ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage(ex.getMessage());
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
            
            //Populate the Pizza Object.
            ResultSet rs = cstmt.getResultSet();
            if(rs.next()){
                p.setId(rs.getInt("id"));
                p.setSize(PizzaSize.values()[rs.getInt("pizzaSizeId")]);
                p.setType(PizzaType.values()[rs.getInt("pizzaTypeId")]);
            }
            
            //Get the Toppings.
            rs = cstmt.getResultSet();
            while(rs.next()){
                p.addTopping(PizzaTopping.values()[rs.getInt("id") - 1]);
            }
            
            result.setStatus(ActionResultStatus.SUCCESS);
            result.setResult(p);
        }
        catch(Exception ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage("An error occurred reading the pizza.", ex);
        }
        
        return result;
    }

    @Override
    public IActionResult<Pizza> Read(Pizza obj) {
        return Read(obj.getId());
    }

    @Override
    public IActionResult<Pizza> Update(Pizza obj) {
        return new ActionResult<Pizza>();
        //TODO: Maybe implement later. No time atm.
    }

    @Override
    public IActionResult<Boolean> Delete(Pizza obj) {
        return Delete(obj.getId());
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        ActionResult<Boolean> result = new ActionResult<Boolean>();
        
        try{
            CallableStatement cstmt = con.prepareCall("{Call Pizza_Delete(?)}");
            cstmt.setInt("p_pizzaId", id);
            cstmt.executeQuery();
            result.setStatus(ActionResultStatus.SUCCESS);
            result.setResult(true);
        }
        catch(Exception ex){
            result.setMessage("Failed to delete the pizza.", ex);
            result.setStatus(ActionResultStatus.FAILURE);
        }
        
        return result;
    }
    
}
