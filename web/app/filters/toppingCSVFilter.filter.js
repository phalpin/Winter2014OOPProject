pizzaShopApp.filter('toppingCSVFilter', function(){
    return function(toppingsArray){
        var retVal = "";
        if(toppingsArray.length === 0){
            retVal = "No Toppings";
        }
        else{
            var iter = 0;
            angular.forEach(toppingsArray, function(value, key){
                retVal += iter === 0 ? "" : ", ";
                retVal += value;
                iter++;
            });
        }

        return retVal;
    };
});