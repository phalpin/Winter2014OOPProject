pizzaShopControllers.controller('ShellCtrl', ['$scope',
    function($scope){

        /**
         * Links within the Shell View.
         * @type {*[]}
         */
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
    }
]);