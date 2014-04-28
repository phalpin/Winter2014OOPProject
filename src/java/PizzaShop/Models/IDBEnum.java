package PizzaShop.Models;

/**
 * The baseline for what a DBEnum should have.
 */
public interface IDBEnum {
    /**
     * Returns the string-based representation of this enum.
     * @return Name of the DB Enum.
     */
    public String getName();
    
    /**
     * Returns the DB ID of this enum.
     * @return DB ID of this enum.
     */
    public int getValue();
}
