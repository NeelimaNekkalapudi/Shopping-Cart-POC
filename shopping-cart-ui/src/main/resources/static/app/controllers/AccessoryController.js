app.controller('AccessoryController',['$scope','$http','$location','cartFactory','ACCESSORIES_SERVER_PORT','SERVICE_URL','$routeParams',
                                       function($scope,$http, $location,cartFactory,ACCESSORIES_SERVER_PORT, SERVICE_URL,$routeParams){
      $scope.accesoryList = "";
      $scope.viewby = 3;
      $scope.totalItems = $scope.accesoryList.length;
      $scope.currentPage = 1;
      $scope.itemsPerPage = $scope.viewby;
      $scope.maxSize = 5; //Number of pager buttons to show
      $scope.noResults = false;
      $scope.totalCartSize =  cartFactory.totalCartSize
      var auth_token = "abc";//cartFactory.auth_token;
      $scope.accessoryDetails = "";
      $scope.sizeList = ["2 Meter","3 Meter","6 Meter"];
      $scope.colorList =["Gold","White","Grey"];
      var epid = $routeParams.epid;
    console.log("Route epid Params "+epid);

      if(epid){
          $scope.showLoadder = true;
        cartFactory.getDownstreamAcc(epid).then(function success(response){
            $scope.showLoadder = false;
            console.log("data"+response.data);
            $scope.accesoryList= response.data;
            $scope.totalItems = $scope.accesoryList.length;
            $scope.skuId = undefined;
           if($scope.accesoryList.length ==0){
               $scope.noResults = true;
           }
            //$location.path('/searchAccessories');
        },
       function error(response){
          $scope.showLoadder = false;
          console.log("Error Occured "+ response.data);
          $scope.noResults = true;
       })
    }

    //Get all accessories => $http call
    $scope.getAccessories =function(){
      if(!epid){
      $scope.token = "abc";//cartFactory.auth_token;
      console.log('Inside the ProductController::after $scope.token====='+ $scope.token);
       $scope.showLoadder = true;
       var url = ACCESSORIES_SERVER_PORT+SERVICE_URL.ACCESSORY_URL;
       if($scope.skuId != undefined){
           url = ACCESSORIES_SERVER_PORT+SERVICE_URL.ACCESSORY_DETAILS_URL;
          url += $scope.skuId;
       }
       $http({
        method:'GET',
        url: url,
       headers: {
           "Content-Type": "application/json"
        }
       }).then(function success(response){
         $scope.showLoadder = false;
        $scope.accesoryList= response.data;
        $scope.totalItems = $scope.accesoryList.length;
        $scope.skuId = undefined;
           if($scope.accesoryList.length ==0){
               $scope.noResults = true;
           }

        },
         function error(response){
          $scope.showLoadder = false;
           console.log("Error Occured"+response.message);
        });
     }

     }

    $scope.getAccessoryDetails = function(accessoryId){
        cartFactory.getAccessoryDetails(accessoryId).then(function success(response){
          console.log(response.data);
          var result = response.data;
          if(result != undefined) {
            result.quantity = 1;
            cartFactory.accessoryDetails = result;
             $location.path('/showAccessoryDetails');
           }
         },
         function error(response){
             console.log('Error ::'+ response);
         });

    }


     $scope.addItemsToCart =function(itemObj){
       itemObj.isAccessory = true;
         cartFactory.addToCart(itemObj);
           $location.path('/cart');

      }

    $scope.buttonNames={
         "cart":"Add To Cart"
     }

     //Pagination Code
     $scope.previous= function(currentPage){
         $scope.currentPage = $scope.currentPage -1;
     }

     $scope.next= function(currentPage){
         $scope.currentPage = $scope.currentPage +1;
     }



     $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
      };

     $scope.pageChanged = function() {
        console.log('Page changed to: ' + $scope.currentPage);

      };

     $scope.setItemsPerPage = function(num) {
      $scope.itemsPerPage = num;
      $scope.currentPage = 1; //reset to first paghe
    }
}])
