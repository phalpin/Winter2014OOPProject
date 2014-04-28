package PizzaShop.Models;

/**
 * The baseline of what a DB Driven entity should have.
 */
public interface IDBEntity {
    
    /**
     * Accessor for the ID of this entity.
     * @return The DB ID of this entity.
     */
    public int getId();
    
    /**
     * Setter for the ID of this entity (ONLY FROM SERVICE LAYER)
     * @param id ID to set for this entity.
     */
    public void setId(int id);
}
