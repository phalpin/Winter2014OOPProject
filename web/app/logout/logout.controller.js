pizzaShopControllers.controller('LogoutCtrl',
    [   
        '$scope','$rootScope','$timeout','$location','toaster',
        function($scope, $rootScope, $timeout, $location, toaster){
            $scope.logout = function(){
                toaster.pop('info', "Successfully Logged Out", "You're all logged out. Congrats. Leave now.", null, 'trustedHtml');
                localStorage.setItem("Authentication", null);
                $rootScope.Authentication = null;
                $location.path('/');
            };
        }
    ]
    );