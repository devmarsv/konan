$(".nav>li").mouseover(function(){
	$(this).children(".submenu").stop().slideDown();
});
$(".nav>li").mouseleave(function(){
	$(this).children(".submenu").stop().slideUp();	
});