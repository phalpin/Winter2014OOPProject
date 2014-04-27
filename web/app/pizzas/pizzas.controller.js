pizzaShopApp.controller('PizzasCtrl', [
    '$scope','pizzaService','cartService',
    function($scope, pizzaService, cartService){

        $scope.pizza = {
            toppings:[],
            type:null,
            size:null,
            cost:0.0
        };
        
        $scope.options = {
            toppings: null,
            types: null,
            sizes: null
        };
        
        $scope.cart = cartService.items;
        
        $scope.$watchCollection('[pizza.toppings, pizza.type, pizza.size]', function(){
            $scope.calculatePrice();
        });
        
        $scope.calculatePrice = function(){
            var total = 0.0;
            angular.forEach($scope.pizza.toppings, function(value, key){
               total += value.cost; 
            });
            
            if($scope.pizza.type !== null) total += $scope.pizza.type.cost;
            if($scope.pizza.size !== null) total += $scope.pizza.size.cost;
            $scope.pizza.cost = total;
        };
        
        $scope.init = function(){
            $scope.populateOptions();
        };
        
        $scope.populateOptions = function(){
            $scope.populateToppings();
            $scope.populateSizes();
            $scope.populateTypes();
        };
        
        $scope.populateToppings = function(){
            pizzaService.getAllToppings()
                .then(function(response){
                    if(response.status === 200){

                        $scope.options.toppings = response.data;
                    }
                });            
        };
        
        $scope.populateSizes = function(){
            pizzaService.getAllSizes()
                .then(function(response){
                    if(response.status === 200){
                        //console.log(response.data);
                        $scope.options.sizes = response.data;
                    }
                });            
        };
        
        $scope.populateTypes = function(){
            pizzaService.getAllTypes()
                .then(function(response){
                    if(response.status === 200){
                        //console.log(response.data);
                        $scope.options.types = response.data;
                    }
                });            
        };
        
        $scope.canAddToCart = function(){
            return $scope.pizza.size !== null && $scope.pizza.type !== null;
        };
        
        $scope.addToCart = function(){
            var name = $scope.pizza.size.name + " " + $scope.pizza.type.name + " Pizza";
            if(cartService.add($scope.pizza, name)){
                $scope.pizza = {
                    toppings:[],
                    type:null,
                    size:null,
                    cost:0.0
                };
            }
            else{
                alert('cartService failed');
            }
        };
        
    }
]);