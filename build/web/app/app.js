/**
 * Module Creation for the Pizza Shop App.
 * @type {*}
 */
var pizzaShopApp = angular.module
    ('pizzaShopApp',
        [
            'ngRoute',
            'pizzaShopControllers'
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
            })
    }
]);