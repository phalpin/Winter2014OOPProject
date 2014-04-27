package PizzaShop.Services;

import PizzaShop.Data.DatabaseFactory;
import PizzaShop.Models.Order;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderService implements IDataService<Order> {

    private Connection con = null;
    
    public OrderService(){
        try{
            con = DatabaseFactory.getInstance().getConnection();
        }
        catch(SQLException ex){
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public IActionResult<Order> Create(Order obj) {
        ActionResult<Order> result = new ActionResult<Order>();
        try{
            CallableStatement ord = con.prepareCall("{call Order_Create(?)}");
            ord.setInt("p_userId", obj.getUserId());
            ResultSet rs = ord.executeQuery();
            if(rs.next()){
                obj.setId(rs.getInt("orderId"));
                result.setResult(obj);
                result.setStatus(ActionResultStatus.SUCCESS);
                result.setMessage("Successfully created the order in the database.");
            }
        }
        catch(Exception ex){
            result.setStatus(ActionResultStatus.FAILURE);
            result.setMessage(ex.getMessage());
        }
        
        return result;
    }

    @Override
    public IActionResult<Order> Read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Order> Read(Order obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Order> Update(Order obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(Order obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IActionResult<Boolean> Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public IActionResult<ArrayList<Order>> ReadAllForUser(int userId){
        ActionResult<ArrayList<Order>> result = new ActionResult<ArrayList<Order>>();
        
        HashMap<Integer, Order> tempOrders = new HashMap<Integer, Order>();
        HashMap<Integer, Pizza> tempPizza = new HashMap<Integer, Pizza>();
        try{
            CallableStatement ord = con.prepareCall("{Call Order_Read_For_UserId(?)}");
            ord.setInt("p_userId", userId);
            
            ResultSet rs = ord.executeQuery();
            
            while(rs.next()){
                int orderId = rs.getInt("OrderId");
                int usrId = rs.getInt("UserId");
                int pizzaId = rs.getInt("PizzaId");
                int sizeId = rs.getInt("SizeId");
                int typeId = rs.getInt("TypeId");
                Integer toppingId = (Integer)rs.getObject("ToppingId");
                
                //Populate the temporary order items.
                if(!tempOrders.containsKey(orderId)){
                    Order o = new Order();
                    o.setId(orderId);
                    o.setUserId(usrId);
                    tempOrders.put(orderId, o);
                }
                
                //Populate the temporary pizza items.
                if(!tempPizza.containsKey(pizzaId)){
                    Pizza p = new Pizza();
                    p.setOrderId(orderId);
                    p.setId(pizzaId);
                    p.setType(PizzaType.fromId(typeId));
                    p.setSize(PizzaSize.fromId(sizeId));
                    if(toppingId != null) p.addTopping(PizzaTopping.fromId(toppingId));
                    tempPizza.put(pizzaId, p);
                    tempOrders.get(orderId).addPizza(p);
                }
                else{
                    if(toppingId != null) tempPizza.get(pizzaId).addTopping(PizzaTopping.fromId(toppingId));
                }
            }
            
            ArrayList<Order> resultset = new ArrayList<Order>(tempOrders.values());
            result.setResult(resultset);
            result.setStatus(ActionResultStatus.SUCCESS);
        }
        catch(Exception ex){
            result.setMessage(ex.getMessage());
        }
        
        
        return result;
    }
    
}
