pizzaShopApp.filter('priceFilter', function(){
    return function(price){
        var amt = price.toFixed(2);
        return "$" + amt;
    };
});