pizzaShopApp.factory(
    'cartService',
    [
        'toaster','$rootScope','$filter','orderService',
        function(toaster, $rootScope, $filter, orderService){
            var cart = {
                items:[],
                
                total:0.0,
                
                //Adds an item to the cart.
                add: function(item){
                    this.items.push(item);
                    this.total += item.cost;
                    toaster.pop('success', "Added item to cart", "Added " + $filter('pizzaNameFilter')(item) + " to the cart", null, 'trustedHtml');
                    this.save();
                    return true;
                },
                
                //Removes an item from the cart.
                remove: function(item){
                    var index = this.items.indexOf(item);
                    this.items.splice(index, 1);
                    this.total -= item.cost;
                    toaster.pop('success', "Removed " + $filter('pizzaNameFilter')(item) + " from the cart", "", null, 'trustedHtml');
                    this.save();
                    return true;
                },
                
                //Saves items to the localStorage point.
                save: function(){
                    localStorage.setItem("cart", JSON.stringify(this.items));
                    $rootScope.CartCount = this.items.length;
                },
                
                //Loads items from the localStorage point.
                load: function(){
                    var saved = localStorage.getItem("cart");
                    if(saved !== null){
                        this.items = JSON.parse(saved);
                        var obj = this;
                        angular.forEach(this.items, function(value, key){
                           obj.total += value.cost; 
                        });
                        $rootScope.CartCount = this.items.length;
                    }
                },
                
                //Clears all items from the cart.
                clear: function(){
                    this.items = [];
                    this.total = 0.0;
                    this.save();
                }
            };

            return cart;
        }
]);