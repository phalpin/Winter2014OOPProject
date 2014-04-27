pizzaShopApp.controller('AcctCtrl', [
    '$scope','$rootScope','$location','orderService',
    function($scope, $rootScope, $location, orderService){
        $scope.orders = [];
        $scope.loading = true;
        
        $scope.init = function(){
            if($rootScope.Authentication === null){
                $location.path('/Login');
            }
            
            orderService.getAllOrders().then(function(response){
               if(response.data.length > 0){
                   $scope.orders = response.data;
               }
               $scope.loading = false;
            });
        };
    }
]);