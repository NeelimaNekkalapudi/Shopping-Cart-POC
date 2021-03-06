app.controller('PersonalController',['$scope','cartFactory','$http','SERVER_PORT','SERVICE_URL','$location','$rootScope',
                                      function($scope,cartFactory,$http,SERVER_PORT,SERVICE_URL,$location,$rootScope){


console.info('Inside personalController ===================');
$scope.totalCartSize =  cartFactory.totalCartSize;

$scope.currentCarriers=["AT&T","Verizon","Sprint","Others"];
$scope.numberPattern = /^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/;

var personaInfo = cartFactory.getPersonalInfo();
personaInfo.username = $rootScope.username;
personaInfo.cemail = personaInfo.email;
personaInfo.productsList = cartFactory.getProductsList();
if(cartFactory.getAccesoriesList().length > 0)
{
     personaInfo.accessoriesList = cartFactory.getAccesoriesList();
}

$scope.personalInfo = personaInfo;
$scope.savePersonalInfo = function(personalInformation){
    var personalInfo = angular.copy(personalInformation);
    delete personalInfo['cemail'];    cartFactory.savePersonalInfo(personalInfo).then(function success(response){
               console.log(response.data.message);
               console.log(angular.toJson(response.data.orderdetails));
               cartFactory.productOrderId = response.data.orderdetails[0].orderid;
               
              
          },
          function error(response){
               console.error('PersonalController->savePersonalInfo->Error ::'+ response.data);
          });
     cartFactory.setPersonalInfo(personalInfo);
     $location.path('/shippingInformation');
 }
}]);
