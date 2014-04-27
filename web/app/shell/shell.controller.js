pizzaShopControllers.controller('ShellCtrl', [
    '$scope', '$location', '$rootScope','$http','cartService',
    function($scope, $location, $rootScope, $http, cartService){

        $scope.Links = [
            {
                Name: "Home",
                Path: "#/",
                Title: "Home"
            },
            {
                Name: "Build Your Pizza",
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
        
        $scope.CartLink = {
            Name: "Cart (0)",
            Path: "#/Cart",
            Title: "View Shopping Cart"
        };
        
        $scope.init = function(){
            if($scope.checkAuthentication() === true){
                $scope.checkAccessLevel();
            }
            $scope.checkCart();
        };
        
        $scope.checkCart = function(){
            cartService.load();
        };
        
        $scope.checkAuthentication = function(){
            var auth = localStorage.getItem("Authentication");
            if(auth === "null"){
                $rootScope.Authentication = null;
                return false;
            }
            else{
                $rootScope.Authentication = auth;
                $http.defaults.headers.common.Authorization = auth;
                return true;
            }
        };
        
        $scope.checkAccessLevel = function(){
            var access = localStorage.getItem("AccessLevel");
            if(access === "null"){
                $rootScope.AccessLevel = null;
                return false;
            }
            else{
                $rootScope.AccessLevel = access;
                return true;
            }
        }

        $scope.isActive = function(path){
            var pattern = '/' + path;
            var re = new RegExp(pattern);
            return re.test($location.path());
        };
        
        $scope.$watch('CartCount', function(){
           $scope.CartLink.Name = "Cart (" + cartService.items.length + ")"; 
        });
        
        $scope.$watch('Authentication', function(){
            if($scope.Authentication !== null){
                $scope.LoginLinks = [
                    {
                        Name: "Log Out",
                        Path: "#/Logout",
                        Title: "Log Out"
                    },
                    {
                        Name: "My Account",
                        Path: "#/Account",
                        Title: "View Your Account"
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