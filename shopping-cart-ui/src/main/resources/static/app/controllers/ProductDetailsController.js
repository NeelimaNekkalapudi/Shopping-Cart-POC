app.controller('ProductDetailsController',['$scope','$http', '$location','cartFactory','SERVER_PORT','SERVICE_URL',
                            function($scope,$http, $location,cartFactory,SERVER_PORT, SERVICE_URL){
        $scope.productDetails = cartFactory.productDetails;     
        $scope.sizeList = ["M","S","L"];
        $scope.colorList =["Gold","White","Grey"];
                                
       $scope.addItemsToCart =function(itemObj){
          cartFactory.addToCart(itemObj);
          $location.path('/cart');

     } // End of addItemsToCart
}]);