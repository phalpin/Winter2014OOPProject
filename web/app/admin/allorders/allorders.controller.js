pizzaShopApp.controller('AllOrdersCtrl', [
   '$scope', 'orderService', 'userService', '$location', '$rootScope',
   function($scope, orderService, userService, $location, $rootScope){
       
       $scope.init = function(){
           if($scope.checkUserAccessLevel()){
               $scope.getUserOrders();
           }
       };
       
       $scope.checkUserAccessLevel = function(){
           var accessResult = userService.getAccessLevel().then(function(response){
              var access = response.data.replace(/"/g, '');
              if($rootScope.AccessLevel === null || $rootScope.AccessLevel !== access){
                  $rootScope.AccessLevel === access;
                  localStorage.setItem("AccessLevel", access);
                  if(access !== "Administrator"){
                      $location.path("/");
                      return false;
                  }
                  return true;
              }
              else{
                  return true;
              }
           });
           
           return accessResult;
       };
       
       $scope.getUserOrders = function(){
           orderService.getAllOrdersForAllUsers().then(function(response){
               console.log(response.data[0]);
               $scope.userOrders = response.data;
           });
       };
       
       $scope.collapse = function(user){
         var item = $.grep($scope.userOrders, function(e){
             if(e === user){
                 if(e.collapsed){
                     e.collapsed = !e.collapsed;
                 }
                 else{
                     e.collapsed = true;
                 }
             }
         });
       };
       
       
       $scope.userOrders = [];
       
       
   }
]);