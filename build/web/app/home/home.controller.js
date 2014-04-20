pizzaShopControllers.controller('HomeCtrl', ['$scope','$http',
    function($scope, $http){
        $scope.Title = "Home";

        $scope.test = function(){
            alert('test');
        }
    }
]);