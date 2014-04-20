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
            'toaster'
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
            })
    }
]);