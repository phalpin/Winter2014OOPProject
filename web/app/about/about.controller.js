pizzaShopApp.controller('AboutCtrl', [
   '$scope',
   function($scope){
       
       $scope.sliderInterval = 2000;
       
       $scope.slides = [
           {
               text: 'test',
               image: 'images/pizza-base.jpg'
           },
           {
               text: 'test2',
               image: 'images/pizza-base.jpg'
           }
       ];
   }
]);