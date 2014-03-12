/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Services;

import PizzaShop.Resources.IActionResult;

/**
 * Determines the standard structure of a service.
 * @author phalpin
 * @param <T> Generic type of service.
 */
public interface IDataService<T> {
    
    /**
     * Creates a given object.
     * @param obj Object to add to database.
     * @return ActionResult of type object, check result.Result for the item if status is true.
     */
    public IActionResult<T> Create(T obj);
    
    /**
     * Reads an entity from the database.
     * @param id ID of the item in the database to read.
     * @return ActionResult of type of the object, if SUCCESS will have an object in getResult()
     */
    public IActionResult<T> Read(int id);
    
    /**
     * Reads an entity from the database from a given Model.
     * @param obj Object to read from.
     * @precondition We expect the object to have an ID filled in already.
     * @return An actionresult with the result from your query.
     */
    public IActionResult<T> Read(T obj);
    
    /**
     * Updates an entity from the database from a given object.
     * @precondition We expect the object to exist in the database (IE, has an existant ID)
     * @param obj Entity to update
     * @return  An actionresult of the object you're updating's type.
     */
    public IActionResult<T> Update(T obj);
    
    /**
     * Deletes an entity from the database. WARNING: Use with caution.
     * @precondition Expects the object to exist in the database (IE, id not null)
     * @param obj The object to delete.
     * @return ActionResult containing a boolean result.
     */
    public IActionResult<Boolean> Delete(T obj);
    
    /**
     * Deletes an entity from the database. WARNING: Use with caution.
     * @precondition Expects the object to exist in the database (IE, id not null)
     * @param id The object ID to delete.
     * @return ActionResult containing a boolean result.
     */
    public IActionResult<Boolean> Delete(int id);
}
