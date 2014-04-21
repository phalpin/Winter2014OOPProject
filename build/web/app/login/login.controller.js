pizzaShopControllers.controller('LoginTest', [

    '$scope', 'userService', '$http', '$location', 'toaster', '$rootScope',
    function($scope, userService, $http, $location, toaster, $rootScope){


        //Scope Login Credentials
        $scope.credentials = {
            username: "",
            password: ""
        };

        //Attempt a login with the remote service.
        $scope.attemptLogin = function(){
            userService.attemptLogin(this.credentials.username, this.credentials.password)
                .then(function(response){
                    if(response.data.token){
                        $http.defaults.headers.common.Authorization = response.data.token;
                        localStorage.setItem('Authentication', response.data.token);
                        $rootScope.Authentication = response.data.token;
                        toaster.pop('success', "Successfully Logged In", "You're good to go! Order away!", null, 'trustedHtml');
                        $location.path('/');
                    }
                    else{
                        toaster.pop('warning', "Invalid Login", "Check your username or your password!", null, 'trustedHtml');
                    }
                });

        };
    }
]);