pizzaShopApp.filter('toppingCSVFilter', function(){
    return function(toppingsArray){
        var retVal = "";
        if(toppingsArray.length === 0){
            retVal = "No Toppings";
        }
        else{
            var iter = 0;
            angular.forEach(toppingsArray, function(value, key){
                retVal += iter > 0 && iter < toppingsArray.length - 1 && toppingsArray.length !== 2 ? ", " : "";
                retVal += iter === toppingsArray.length-1 && toppingsArray.length > 1 ? " and " : "";
                if(typeof value === 'object'){
                    retVal += value.name;
                }
                else{
                    retVal += value;    
                }

                
                iter++;
            });
        }

        return retVal;
    };
});