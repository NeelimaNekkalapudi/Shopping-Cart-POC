app.controller('AccessoryDetailsController',['$scope','$http', '$location','cartFactory','SERVER_PORT','SERVICE_URL',
                            function($scope,$http, $location, cartFactory,SERVER_PORT, SERVICE_URL){

      $scope.accessoryDetails = cartFactory.accessoryDetails;  
      $scope.sizeList = ["2 Meter","3 Meter","6 Meter"];
      $scope.colorList =["Gold","White","Grey"];                                    
                                
    
     $scope.addItemsToCart =function(itemObj){
       itemObj.isAccessory = true;
         cartFactory.addToCart(itemObj);
           $location.path('/cart');

      }                                
}]);