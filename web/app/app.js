/**
 * Module Creation for the Pizza Shop App.
 * @type {*}
 */
var pizzaShopApp = angular.module
    ('pizzaShopApp',
        [
            'ngRoute',
            'pizzaShopControllers',
            'ngAnimate',
            'toaster',
            'ui.bootstrap',
            'slick'
        ]
   );

/**
 * Configuration for the Pizza Shop App
 */
pizzaShopApp.config(['$routeProvider',
    function($routeProvider){
        $routeProvider.
            when('/', {
                templateUrl: 'app/home/home.html',
                controller: 'HomeCtrl'
            }).
            when('/Pizzas',{
                templateUrl: 'app/pizzas/pizzas.html',
                controller: 'PizzasCtrl'
            }).
            when('/Pizzas/:id',{
                templateUrl: 'app/pizzas/pizza.html',
                controller: 'PizzaCtrl'
            }).
            when('/Login',{
                templateUrl: 'app/login/login.html',
                controller: 'LoginTest'
            }).
            when('/Register',{
                templateUrl: 'app/register/register.html',
                controller: 'RegisterCtrl'
            }).
            when('/Logout',{
                templateUrl: 'app/logout/logout.html',
                controller: 'LogoutCtrl'
            }).
            when('/Cart', {
                templateUrl: 'app/cart/cart.html',
                controller: 'CartCtrl'
            }).
            when('/Account', {
                templateUrl: 'app/account/account.html',
                controller: 'AcctCtrl'
            }).
            when('/AllOrders', {
                templateUrl: 'app/admin/allorders/allorders.html',
                controller: 'AllOrdersCtrl'
            }).
            when('/About', {
                templateUrl: 'app/about/about.html',
                controller: 'AboutCtrl'
            });
    }
]);

//Whitelist the necessary stuff for skype.
pizzaShopApp.config( [
    '$compileProvider',
    function( $compileProvider )
    {   
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|chrome-extension|skype):/);
        // Angular before v1.2 uses $compileProvider.urlSanitizationWhitelist(...)
    }
]);