pizzaShopApp.filter('cartItemTotalFilter', function(){
    return function(items){
        var amt = 0.0;
        angular.forEach(items, function(value, key){
           amt += value.cost;
        });
        return amt;
    };
});