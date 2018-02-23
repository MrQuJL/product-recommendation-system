// head.html 的弹出框 JS
// $(".goOut").click(function(){
//    $(".closeOut").show();
//  });
//  $(".p1").click(function(){
//    $(".closeOut").hide();
//  });
//  $(".no").click(function(){
//    $(".closeOut").hide();
//  });
 // head.html 的弹出框 JS  end


// left.html 的切换节点  JS
$(function(){
	// 点击展开事件，切换图片
	$(".leftsidebar_box dt").click(function(){
		// 先处理掉所有存在的节点,再判断是否存在
		$('.icon1').hide();
		$('.icon2').show();
		$(".leftsidebar_box dt").removeClass('menu_chioce1');
		if ($(this).parent().find('dd').is(":hidden")) {
			$(this).parent().find('.icon1').show();
			$(this).parent().find('.icon2').hide();
			$(this).parent().find('.icon3').show();
			$(this).parent().find('.icon4').hide();
			$(this).addClass('menu_chioce1');
		}else{
			$(this).parent().find('.icon1').hide();
			$(this).parent().find('.icon2').show();
			$(this).parent().find('.icon3').hide();
			$(this).parent().find('.icon4').show();
			$(this).removeClass('menu_chioce1');
		}
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".menu_chioce").slideUp();
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");

		
	});
	$(".cks").click(function(){
		// 先处理掉所有存在的节点,再判断是否存在
		$(".icon5").hide();
		$('.coin11').hide();
		$('.coin22').show();
		$(this).parent().find('.coin11').show();
		$(this).parent().find('.coin22').hide();
		$(".leftsidebar_box .cks").removeClass('menu_chioce2');
		if ($(this).parent().find('.icon5').is(":hidden")) {
			$(this).addClass('menu_chioce2');
			$(this).parent().find('.icon5').show();
		}else{
			$(this).removeClass('menu_chioce2');
			$(this).parent().find('.icon5').hide();
		}

		
	});
})
// left.html 的切换节点  JS end