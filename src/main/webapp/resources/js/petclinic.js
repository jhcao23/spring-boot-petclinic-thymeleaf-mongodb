// NOTICE!! DO NOT USE ANY OF THIS JAVASCRIPT
// ++++++++++++++++++++++++++++++++++++++++++

!function ($) {

  $(function(){
    $("a").tooltip();
    $("button").tooltip();
    $("button")
    	.click(function(){
    		$(this).button('loading');
    		return true;
    	})
    ;

  });

}(window.jQuery);