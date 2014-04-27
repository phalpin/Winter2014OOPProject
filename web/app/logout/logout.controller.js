pizzaShopControllers.controller('LogoutCtrl',
    [   
        '$scope','$rootScope','$timeout','$location','toaster','$http','$window',
        function($scope, $rootScope, $timeout, $location, toaster,$http,$window){
            $scope.logout = function(){
                if($rootScope.Authentication === null){
                    $location.path('/');
                }
                toaster.pop('info', "Successfully Logged Out", "You're all logged out. Congrats. Leave now.", null, 'trustedHtml');
                localStorage.setItem("Authentication", null);
                localStorage.setItem("AccessLevel", null);
                $rootScope.Authentication = null;
                $rootScope.AccessLevel = null;
                $http.defaults.headers.common.Authorization = null;
                $location.path('/');
            };
        }
    ]
    );