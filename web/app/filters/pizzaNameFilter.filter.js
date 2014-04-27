pizzaShopApp.filter('pizzaNameFilter', function(){
    return function(pizza){
        var name = pizza.size.name + " " + pizza.type.name + " Pizza";
        return name;
    };
});