pizzaShopApp.factory(
    'userService',
    [
        '$http',
        function($http){
            var baseEndpoint = "/PizzaShop/webresources/Users";

            var userService = {

                //region attemptLogin
                /**
                 * The attempt Login Function. Attempts to authenticate a user with a given username and password.
                 * @param userName Username to attempt with
                 * @param passWord Password to attempt with
                 * @returns {*} Promise object
                 */
                attemptLogin: function(userName, passWord){
                    var promise = $http({
                        method:'POST',
                        url:baseEndpoint + "/login",
                        data: {username:userName, password:passWord}
                    })
                    return promise;
                }
                //endregion

            }
            return userService;
        }
]);