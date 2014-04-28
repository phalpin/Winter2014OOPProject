package PizzaShop.Models;

/**
 * Base DB Entity Class. 
 */
public abstract class DBEntity implements IDBEntity {
    private int id;
    
    /**
     * The ID of this database based-entity
     * @return DB ID of this entity.
     */
    @Override
    public int getId() { return id; }
    
    /**
     * Set the ID of this database based-entity.
     * @param Id ID to set (ONLY FROM SERVICE LAYER)
     */
    @Override
    public void setId(int Id) { id=Id; }
    
}
