pizzaShopControllers.controller('PizzasCtrl', ['$scope',
    function($scope){

        /**
         * Types of Pizzas Available.
         * @type {*[]}
         */
        $scope.Pizzas = [
            {
                Size: "Large",
                Style: "Chicago",
                Price: 14.99
            },
            {
                Size: "Large",
                Style: "New York",
                Price: 12.99
            },
            {
                Size: "Medium",
                Style: "California",
                Price: 10.99
            }
        ];
    }
]);