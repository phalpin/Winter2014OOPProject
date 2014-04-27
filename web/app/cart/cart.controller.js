pizzaShopApp.controller('CartCtrl', [
    
    '$scope', 'cartService','$rootScope','$location','$modal','orderService','toaster',
    function($scope, cartService, $rootScope, $location, $modal, orderService, toaster){
        $scope.cart = cartService;
        
        $scope.checkOut = function(){  
            //Logged in
            if($rootScope.Authentication !== null){
                orderService.submitOrder(cartService.items)
                    .then(function(response){
                        if(response.data.id){
                            toaster.pop('Success', "Submitted your order successfully!", "", null, 'trustedHtml');
                            $location.path('/');
                            cartService.clear();
                        }
                        else{

                        }
                    });
            }
            //Not Logged in.
            else{
                var modalInstance = $modal.open({
                   templateUrl:'/PizzaShop/app/login/login.modal.html',
                   controller: 'LoginModalCtrl',
                });
                
                modalInstance.result.then(
                    function(status){
                        if(status === true) $scope.checkOut();
                    }
                );
            }
        };
    }
    
]);