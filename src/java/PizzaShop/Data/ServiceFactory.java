package PizzaShop.Data;

import PizzaShop.Services.BeverageService;
import PizzaShop.Services.ContactService;
import PizzaShop.Services.OrderService;
import PizzaShop.Services.PizzaService;
import PizzaShop.Services.SessionService;
import PizzaShop.Services.UserService;

/**
 * Factory used to obtain services for the rest of the application.
 * Ensures that only one instance of a service is alive at any given time.
 */
public class ServiceFactory {
    
    //<editor-fold desc="Singleton Methods">
    private static ServiceFactory _instance = null;

    public static ServiceFactory Instance(){
        if(_instance == null) _instance = new ServiceFactory();
        return _instance;
    }
    //</editor-fold>
    
    private final BeverageService _bevSvc;
    private final ContactService _conSvc;
    private final OrderService _ordSvc;
    private final PizzaService _pzaSvc;
    private final SessionService _ssnSvc;
    private final UserService _usrSvc;
    
    /**
     * Initializes the Service Factory.
     */
    public ServiceFactory(){
        _bevSvc = new BeverageService();
        _conSvc = new ContactService();
        _ordSvc = new OrderService();
        _pzaSvc = new PizzaService();
        _ssnSvc = new SessionService();
        _usrSvc = new UserService();
    }

    /**
     * Returns a BeverageService worker for obtaining Beverages from the Database.
     * @return BeverageService data object.
     */
    public BeverageService getBevSvc() {
        return _bevSvc;
    }

    /**
     * Returns a ContactService worker for obtaining Contacts from the Database.
     * @return ContactService data object.
     */
    public ContactService getConSvc() {
        return _conSvc;
    }

    /**
     * Returns an OrderService worker for obtaining Orders from the Database.
     * @return OrderService data object.
     */
    public OrderService getOrdSvc() {
        return _ordSvc;
    }

    /**
     * Returns a PizzaService worker for obtaining Pizzas from the database.
     * @return PizzaService Worker.
     */
    public PizzaService getPzaSvc() {
        return _pzaSvc;
    }

    /**
     * Returns a SessionService worker for obtaining Sessions from the Database.
     * @return SessionService data object.
     */
    public SessionService getSsnSvc() {
        return _ssnSvc;
    }

    /**
     * Returns a UserService worker for obtaining Users from the Database
     * @return UserService Data Object.
     */
    public UserService getUsrSvc() {
        return _usrSvc;
    }
    
}
