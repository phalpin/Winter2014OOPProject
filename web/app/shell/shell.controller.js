pizzaShopControllers.controller('ShellCtrl', [
    '$scope', '$location', '$rootScope',
    function($scope, $location, $rootScope){

        $scope.Links = [
            {
                Name: "Home",
                Path: "#/",
                Title: "Home"
            },
            {
                Name: "Pizzas",
                Path: "#/Pizzas",
                Title: "Pizzas"
            }
        ];
        
        $scope.LoginLinks = [
            {
                Name: "Login",
                Path: "#/Login",
                Title: "Log In"
            },
            {
                Name: "Register",
                Path: "#/Register",
                Title: "Register"
            }
        ];
        
        $scope.checkAuthentication = function(){
            var auth = localStorage.getItem("Authentication");
            if(auth == "null"){
                $rootScope.Authentication = null;
            }
            else{
                $rootScope.Authentication = auth;
            }
        }

        $scope.isActive = function(path){
            var pattern = '/' + path;
            var re = new RegExp(pattern);
            return re.test($location.path());
        }
        
        $scope.$watch('Authentication', function(){
            if($scope.Authentication !== null){
                $scope.LoginLinks = [
                    {
                        Name: "Log Out",
                        Path: "#/Logout",
                        Title: "Log Out"
                    }
                ];
            }
            else{
                $scope.LoginLinks = [
                    {
                        Name: "Login",
                        Path: "#/Login",
                        Title: "Log In"
                    },
                    {
                        Name: "Register",
                        Path: "#/Register",
                        Title: "Register"
                    }
                ];
            }
        });
    }
]);