/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PizzaShop.Data;

import PizzaShop.Services.BeverageService;
import PizzaShop.Services.ContactService;
import PizzaShop.Services.OrderService;
import PizzaShop.Services.PizzaService;
import PizzaShop.Services.SessionService;
import PizzaShop.Services.ToppingService;
import PizzaShop.Services.UserService;

/**
 *
 * @author phalpin
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
    private final ToppingService _topSvc;
    private final UserService _usrSvc;
    
    public ServiceFactory(){
        _bevSvc = new BeverageService();
        _conSvc = new ContactService();
        _ordSvc = new OrderService();
        _pzaSvc = new PizzaService();
        _ssnSvc = new SessionService();
        _topSvc = new ToppingService();
        _usrSvc = new UserService();
    }

    public BeverageService getBevSvc() {
        return _bevSvc;
    }

    public ContactService getConSvc() {
        return _conSvc;
    }

    public OrderService getOrdSvc() {
        return _ordSvc;
    }

    public PizzaService getPzaSvc() {
        return _pzaSvc;
    }

    public SessionService getSsnSvc() {
        return _ssnSvc;
    }

    public ToppingService getTopSvc() {
        return _topSvc;
    }

    public UserService getUsrSvc() {
        return _usrSvc;
    }
    
}
