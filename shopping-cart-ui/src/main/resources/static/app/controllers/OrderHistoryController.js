app.controller('OrderHistoryController',['$scope','$http','DASHBOARD','SERVICE_URL','$rootScope',function($scope,$http,DASHBOARD,SERVICE_URL,$rootScope){

    $scope.noOrders = false;
    $scope.showOrders = function()
    {
        var url = DASHBOARD + SERVICE_URL.ORDER_URL + $rootScope.username;

        $http({
            method: 'GET',
            url: url,
            headers: {
                "Content-Type": "application/json"
            }

        }).then(
            function success(response) {
                console.log("Order details");
               /* if(response.data[0].createdAt)
                {
                    var date = new Date(response.data[0].createdAt);
                    response.data.createdAt = date.toString("MMM dd");
                }*/
                $scope.ordersList = response.data;


            },
            function error(response) {
                console.log("error...");
                $scope.noOrders = true;
            }
        )
    }

}]);
