pizzaShopApp.factory(
    'orderService',
    [
        'toaster','$rootScope','$http',
        function(toaster, $rootScope, $http){
            var baseEndpoint = "/PizzaShop/webresources/Orders/";
            
            function formatItems(items){
                var pizzas = [];
                
                angular.forEach(items, function(value, key){
                   var pizza = {
                     size:0,
                     type:0,
                     toppings:[]
                   };
                   
                   pizza.size = value.size.name.replace(" ","");
                   pizza.type = value.type.name.replace(" ", "");
                   
                   angular.forEach(value.toppings, function(v, k){
                      pizza.toppings.push(v.name.replace(" ", "")); 
                   });
                   
                   pizzas.push(pizza);
                });
                
                return pizzas;
            }
            
            var order = {
                
                //Submits an order to the service.
                submitOrder: function(items){
                    var promise = $http({
                        method:'POST',
                        url:baseEndpoint + 'Submit',
                        data:formatItems(items)
                    });
                    return promise;
                },
                
                getAllOrders: function(){
                    var promise = $http({
                        method:'GET',
                        url:baseEndpoint
                    });
                    return promise;
                }
                
                
            };
            
            return order;
        }
]);