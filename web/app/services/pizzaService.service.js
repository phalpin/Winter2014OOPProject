pizzaShopApp.factory(
    'pizzaService',
    [
        '$http',
        function($http){
            var baseEndpoint = "/PizzaShop/webresources/";

            var pizzaService = {

                //Returns all toppings for pizzas available.
                getAllToppings: function(){
                    var promise = $http({
                        method:'GET',
                        url:baseEndpoint + 'Toppings'
                    });
                    return promise;
                },
                
                //Returns all sizes of pizzas available.
                getAllSizes: function(){
                    var promise = $http({
                        method:'GET',
                        url:baseEndpoint + 'Pizzas/Sizes'
                    });
                    return promise;                    
                },
                
                //Returns all types of pizzas available.
                getAllTypes: function(){
                    var promise = $http({
                        method:'GET',
                        url:baseEndpoint + 'Pizzas/Types'
                    });
                    return promise;
                }
                
            };
            
            return pizzaService;
        }
]);