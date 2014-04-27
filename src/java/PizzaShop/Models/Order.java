/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

import PizzaShop.Resources.GsonManager;
import java.util.ArrayList;

/**
 *
 * @author phalpin
 */
public class Order extends DBEntity implements IPriceableEntity, ISerializable{

    private ArrayList<Pizza> pizzas;
    private ArrayList<Side> sides;
    private int userId;
    
    public Order(){
        pizzas = new ArrayList<Pizza>();
        sides = new ArrayList<Side>();
    }
    
    public void addPizza(Pizza p){
        pizzas.add(p);
    }
    
    public void removePizza(Pizza p){
        pizzas.remove(p);
    }
    
    public boolean hasPizza(Pizza p){
        return pizzas.contains(p);
    }
    
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }
    
    public void addSide(Side s){
        sides.add(s);
    }
    
    public void removeSide(Side s){
        sides.remove(s);
    }
    
    public boolean hasSide(Side s){
        return sides.contains(s);
    }
    
    public ArrayList<Side> getSides(){
        return sides;
    }
    
    @Override
    public double getCost() {
        double total = 0.0;
        
        for(Pizza p : pizzas){
            total += p.getCost();
        }
        
        for(Side s : sides){
            total += s.getCost();
        }
        
        return total;
    }

    @Override
    public String toJson() {
        return GsonManager.GO.toJson(this);
    }
    
    public int getUserId(){
        return this.userId;
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }

    public static Order fromJson(String json){
        return GsonManager.GO.fromJson(json, Order.class);
    }
    
}
