app.directive('tmoMenu',function(){
var directive = {
restrict: 'E',
template:'<div id="undefined-sticky-wrapper" class="sticky-wrapper" style="height: 84px;"><header class="header fixed"><div class="header-wrapper bg-tmo"><div class="container"><div class="logo"><a href="#welcome"><img src="./images/t-mobile-logo.png" alt="TMOBILE-US"></a></div><a href="#" class="menu-toggle btn btn-theme-transparent"><i class="fa fa-bars"></i></a> <nav class="navigation closed clearfix swiper-container-vertical swiper-container-free-mode"><div class="swiper-wrapper"><div class="swiper-slide swiper-slide-active"><a href="#" class="menu-toggle-close btn"><i class="fa fa-times"></i></a><ul class="nav sf-menu sf-js-enabled sf-arrows"><li><a href="#searchProducts">Phones</a></li><li class="active"><a class="active" href="#searchAccessories">Accesories</a></li><li><a href="#cart">Cart{{totalCartSize?(totalCartSize):""}}</a></li><li class="active"><a class="active" href="#orderHistory">OrderHistory</a></li>  </ul><b><i class="login-label" style="padding-top: 15px;float: right;padding-left: 30px">Welcome {{username}}!</i></b> </div></div></nav> </div></div></header></div>'
};
return directive; 
})
