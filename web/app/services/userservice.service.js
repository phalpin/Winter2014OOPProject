pizzaShopApp.factory(
    'userService',
    [
        '$http',
        function($http){
            var baseEndpoint = "/PizzaShop/webresources/Users";

            var userService = {

                //Attempts a login with the remote service.
                attemptLogin: function(userName, passWord){
                    var promise = $http({
                        method:'POST',
                        url:baseEndpoint + "/login",
                        data: {username:userName, password:passWord}
                    })
                    return promise;
                },
                
                
                //Attempts to register with the remote service.
                attemptRegistration: function(user){
                    var promise = $http({
                       method:'POST',
                       url:baseEndpoint + "/register",
                       data: user
                    });
                    return promise;
                },
                
                
                //Attempts to get the access level for the user once logged in. Requires authorization header populated.
                getAccessLevel: function(){
                    var promise = $http({
                        method:'GET',
                        url:baseEndpoint + '/AccessLevel'
                    });
                    return promise;
                }
            };
            
            return userService;
        }
]);