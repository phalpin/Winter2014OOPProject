/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Models;

/**
 * Base DB Entity Class. 
 * @author phalpin
 */
public abstract class DBEntity implements IDBEntity {
    private int id;
    
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int Id) { id=Id; }
    
}
