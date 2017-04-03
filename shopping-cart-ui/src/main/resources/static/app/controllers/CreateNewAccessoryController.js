app.controller('CreateNewAccessoryController',['$scope','$http','ACCESSORIES_SERVER_PORT','SERVICE_URL',
                                    function($scope,$http,ACCESSORIES_SERVER_PORT,SERVICE_URL){
    $scope.myForm = {};

    $scope.saveNewAccessory = function(isValid) {
        if (isValid) {
            var accessory = {
                "id": 16,
                "epid": $scope.myForm.epid,
                "availability": "AVAILABLE",
                "name": $scope.myForm.name,
                "description": $scope.myForm.desc,
                "retail_price": $scope.myForm.rp,
                "sale_price": $scope.myForm.sp,
                "promotion": $scope.myForm.promotion,
                "size": $scope.myForm.size,
                "configuration": $scope.myForm.config,
                "color": $scope.myForm.color,
                "skuid": $scope.myForm.skuid,
                "picture": "http://ec2-54-149-225-7.us-west-2.compute.amazonaws.com/mobile_ui/img/lightning-usb-201609.png",
                "active": $scope.myForm.active,
                "contract": $scope.myForm.contract,
                "store": $scope.myForm.store,
                "accessory_detail": {
                    "id": 1,
                    "accessory_id": 1,
                    "more_description": "490 mins of Full HD Video or 1050 mins of HD Video or 15330 Songs, Save Over 5470 Photos, EMC (FCC, CE, VCCI, NATA) Certified, Smartphone, Tablet, Camera, Full HD Video Recording Support. Minimum Storage Temperature: -407deg;C, Resist Magnetic Fields of upto 15000 Gauss, Can Survive Upto 72 Hours in Seawater",
                    "warranty": "10 Year Limited Warranty",
                    "processor": "xww",
                    "vendor": "SAMSUNG",
                    "store_num": "IN"
                }
            };


            var url = ACCESSORIES_SERVER_PORT + SERVICE_URL.NEW_ACCESSORY_URL;

            $http({
                method: 'POST',
                url: url,
                headers: {
                    "Content-Type": "application/json"
                },
                data: JSON.stringify(accessory)

            }).then(
                function success(response) {
                    console.log("successfully saved");
                },
                function error(response) {
                    console.log("error...");
                }
            )

        }
        else
        {
            alert("Please fill the form");
        }
    }
}]);