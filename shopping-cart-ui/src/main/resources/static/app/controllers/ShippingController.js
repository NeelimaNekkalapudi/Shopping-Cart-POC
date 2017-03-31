app.controller('ShippingController',['$scope','cartFactory','$http','SERVER_PORT','SERVICE_URL','tokenFactory','$location','CHECKOUT_SERVER_PORT',
                                      function($scope,cartFactory,$http,SERVER_PORT,SERVICE_URL,tokenFactory,$location,CHECKOUT_SERVER_PORT){
$scope.stateList = ["AL","AK","AZ","AR","CA","CO"];
$scope.zipPattern = /^(\d{5}-\d{4}|\d{5})$/;
$scope.shippingInfo = cartFactory.getShipBillInfo(); 
$scope.copyShippingAddress = true;
$scope.saveBillShipInfo = function(shippingInformation){
        
        var shippingInfo = angular.copy(shippingInformation);
        shippingInfo['orderid'] = cartFactory.productOrderId?cartFactory.productOrderId.toString():'';
        shippingInfo['shiptype'] = "GROUND";
      if($scope.copyShippingAddress){
        shippingInfo['billaddress1'] = shippingInfo['shipaddress1'];
        shippingInfo['billaddress2'] = shippingInfo['shipaddress2'];
        shippingInfo['billcity']     = shippingInfo['shipcity'];
        shippingInfo['billstate']    = shippingInfo['shipstate'];
        shippingInfo['billzip']      = shippingInfo['shipzip'];
        }  
        shippingInfo['store']        = "TMOBILE-US";
        shippingInfo['expirydate']  = shippingInfo['expirymonth']+"/"+shippingInfo['expiryyear'].toString().substring(2,shippingInfo['expiryyear'].toString().length)
        delete shippingInfo['expirymonth'];
        delete shippingInfo['expiryyear'];        
        cartFactory.creditreportusagetype = shippingInfo['creditreportusagetype']['id'];
         cartFactory.customername = shippingInfo['customername'];
        delete shippingInfo['creditreportusagetype'];
        delete shippingInfo['customername'];
        
     cartFactory.saveBillShipInfo(shippingInfo).then(function success(response){
               console.log(response.data.message);
               console.log(angular.toJson(response.data.orderdetails));
              // $scope.creditRatingTypes=response.data.orderdetails;
                
          },
          function error(response){
               console.error('ShippingController->saveBillShipInfo->Error ::'+ response.data);
          });
    cartFactory.setShipBillInfo(shippingInfo);
   $location.path('/creditInformation');
     
 }

$scope.showBilling = function(){
 $scope.copyShippingAddress = false;   
}

$scope.getCreditRatingtypes = function(){
        var auth_token = "Adf"//cartFactory.auth_token;
        console.log("Inside CreditController =>getCreditRatingtypes");
        var url = CHECKOUT_SERVER_PORT+SERVICE_URL.CREDIT_TRATING_TYPES;
        console.log("Authorization"+auth_token);

        $http({
            method:'GET',
            url: url,
            headers:{
               "authorization":auth_token
            }
            
        }).then(function success(response){
               console.log(response.data.message);
            console.log(angular.toJson(response.data.items));
               $scope.creditRatingTypes=response.data.items;
          },
          function error(response){
               console.error('ShippingController->getCreditRatingtypes->Error ::'+ response.data);
          })
    }

}]);
