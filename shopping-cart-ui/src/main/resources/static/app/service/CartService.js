app.factory("cartFactory",['$http','SERVER_PORT','SERVICE_URL','tokenFactory','PRODUCTS_SERVER_PORT','CHECKOUT_SERVER_PORT','ACCESSORIES_SERVER_PORT', function($http,SERVER_PORT,SERVICE_URL,tokenFactory,PRODUCTS_SERVER_PORT,CHECKOUT_SERVER_PORT,ACCESSORIES_SERVER_PORT){

    console.log("Inside the cartFactory======================");

    var cartItems = [];
    var personalInfo = {};
    var shipBillInfo = {};
    var creditInfo = {};
    var personalCart = {};
    var productDetails = {};
    var accessoryDetails = {};
    var productOrderId = '';
    var customername ='';
    var creditreportusagetype ='';
    
    var finalCartInfo = {};     
    var orderId = "";
    var totalCartSize = 0;
    var auth_token = '';
    tokenFactory.getToken().then(function success(response){
            auth_token = response.data;
            console.log("new Auth TOken"+auth_token);
    },
    function error(response){

    });
    
    return {
        
        addToCart: function(items) {
          console.log("itmes values"+ cartItems.length);
            console.log("current item "+ angular.toJson(items));
            var quantity = 1;
             items.quantity = quantity;
             cartItems.push(items);
        },

        setItem: function(key, value){
            console.log('key ::'+ key);
            console.log('value::'+ JSON.stringify(value));
            cartItems.push(value);
        },

        getAllCartItems: function(){
            return cartItems;
        },

        getItem: function(key){
             return cartItems[key];
        },
        getPersonalInfo: function(){
            return personalInfo;
        },
        
        setPersonalInfo: function(obj){
          personalInfo = obj;
         },
         getShipBillInfo: function(){
            return shipBillInfo;
         },
        
         setShipBillInfo: function(obj){
          shipBillInfo = obj;
         },
         getCreditInfo: function(){
            return creditInfo;
         },
        
         setCreditInfo: function(obj){
          creditInfo = obj;
         },     

        setCart: function(obj){
            finalCartInfo['cart'] = obj;
            console.info('cartFactory->setCart::'+ angular.toJson(finalCartInfo));
        },

        prepareFinalCart: function(obj) {
            finalCartInfo['customer'] = obj;
            console.info('cartFactory->prepareFinalCart::'+ angular.toJson(finalCartInfo));
        },
        mergePersonalDetails: function(creditInfo){ 
           finalCartInfo['cart']['id'] = shipBillInfo.orderid;
           personalCart['cart'] = finalCartInfo['cart'];
           personalCart['customer'] = creditInfo;
           return personalCart; 
        },

        getFinalCart: function(){
            return angular.toJson(finalCartInfo);
        },

        getCartProductDetails: function(id){
            console.log('Inside Cartservice => getCartProductDetails ====================');
           var url = PRODUCTS_SERVER_PORT+SERVICE_URL.PRODUCT_DETAILS_URL+id;

           return $http({
                method:'GET',
                url: url,
               headers: {
               "Content-Type": "application/json",
                "authorization": auth_token
            }
            });
        },
        
        getAccessoryDetails: function(id){
            console.log('Inside Cartservice => getAccessoryDetails ====================');
           var url = SERVER_PORT+SERVICE_URL.ACCESSORY_DETAILS_URL+id;

           return $http({
                method:'GET',
                url: url,
               headers: {
               "Content-Type": "application/json",
                "authorization": auth_token
              }
            });
        },
        savePersonalInfo: function(personalInfo){
            console.log('Inside Cartservice => savePersonalInfo ====================');
           var url = CHECKOUT_SERVER_PORT+SERVICE_URL.SAVE_PERSONALINFO_URL;

           return $http({
                method:'POST',
                url: url,
                headers: {
                "Content-Type": "application/json",
                "authorization": auth_token
                },
                data:personalInfo
            });
        },
        saveBillShipInfo: function(shippingInfo){
            console.log('Inside Cartservice => saveBillShipInfo ====================');
           var url = CHECKOUT_SERVER_PORT+SERVICE_URL.SAVE_BILLSHIPINFO_URL;

           return $http({
                method:'PATCH',
                url: url,
                headers: {
                "Content-Type": "application/json",
                "authorization": auth_token
                },
                data:shippingInfo
            });
        },
        saveCreditRating: function(personaldetails){
            console.log('Inside Cartservice => saveCreditRating ====================');
           var url = CHECKOUT_SERVER_PORT+SERVICE_URL.SAVE_CREDITRATING_URL;

           return $http({
                method:'PATCH',
                url: url,
                headers: {
                "Content-Type": "application/json",
                "authorization": auth_token
                },
                data:personaldetails
            });
        },
        getDownstreamAcc: function(epid){
             console.log('Inside Cartservice => getDownstreamAcc ====================');
           var url = ACCESSORIES_SERVER_PORT+SERVICE_URL.GET_DOWNSTREAMACC_URL+epid;

           return $http({
                method:'GET',
                url: url,
                headers: {
                "Content-Type": "application/json"                
                }
            });
        },
        
        clearAll: function(){
           cartItems = [];
           personalInfo = {};
           finalCartInfo = {};
           creditInfo = {};
           productDetails={};
           totalCartSize = 0;
           productOrderId = '';
            accessoryDetails = {};
            customername ='';
           creditreportusagetype ='';
         }
    }
}]);
