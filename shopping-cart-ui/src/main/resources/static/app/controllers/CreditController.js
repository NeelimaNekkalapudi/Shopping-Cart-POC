app.controller('CreditController',['$scope','cartFactory','$http','SERVER_PORT','SERVICE_URL','$location',
                                      function($scope,cartFactory,$http,SERVER_PORT,SERVICE_URL,$location){
    
  console.info('Inside CreditController ===================');
  $scope.totalCartSize =  cartFactory.totalCartSize;
  var auth_token = cartFactory.auth_token;                                        
  $scope.customerInfo = cartFactory.getCreditInfo();  
  $scope.ssnValidation = /^\d\d\d-\d\d-\d\d\d\d$/;
  $scope.dobValidation = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/i;
  $scope.idTypeList = ["State issued ID","Drivers License","Military ID","Passport","Federal issued disability ID","US issued alien ID","Mexican matricula ID"];
                                          
   $scope.stateList=["AL","AK","AZ","AR","CA","CO","CT","DE","DC","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"];
   $scope.minAge = function () {
            var current = new Date();
            var minYear = current.getFullYear() - 100;
            var min = new Date(minYear,current.getMonth(),current.getDate()).toISOString();
            return min;
        };
                                          
  $scope.saveCreditRating = function(creditInformation){  
        var creditInfo = angular.copy(creditInformation);        
        creditInfo['expdate'] = creditInfo['expirymonth']+"/"+creditInfo['expiryyear'].toString().substring(2,creditInfo['expiryyear'].toString().length)
        delete creditInfo['expirymonth'];
        delete creditInfo['expiryyear'];
        delete creditInfo['acceptInfo'];
        creditInfo['creditscorerangetype'] = cartFactory.creditreportusagetype;
        creditInfo['nameoncard'] = cartFactory.customername;
        var personaldetails = cartFactory.mergePersonalDetails(creditInfo);
       cartFactory.saveCreditRating(personaldetails).then(function success(response){
               console.log(response.data.message);
               console.log(angular.toJson(response.data.orderdetails[0].orderid));
              // $scope.creditRatingTypes=response.data.orderdetails;             
               cartFactory.orderId = response.data.orderdetails[0].orderid?response.data.orderdetails[0].orderid: cartFactory.productOrderId;;   
                $location.path('/orderConfirm');
             
          },
          function error(response){
               console.error('CreditController->saveCreditRating->Error ::'+ response.data);
          });     
     
      cartFactory.setCreditInfo(creditInfo);
      
      //submit the call.
       /*var url = SERVER_PORT+SERVICE_URL.CHECKOUT_URL;
       $http({
        method:'POST',
        url: url,
        data: personaldetails,
        headers: {
           "Content-Type": "application/json",
            "authorization": auth_token
        }
       }).then(function success(response){
           console.log(response.data.order_id);             
           cartFactory.orderId = response.data.order_id;   
           $location.path('/orderConfirm');
      },
      function error(response){
           console.error('ShippingInfoController->shippingInfoFormSubmit->Error ::'+ response.data);
      });*/  
 }                                        

                        
}]);
