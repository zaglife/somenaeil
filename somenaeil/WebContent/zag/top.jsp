<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
//Hide Header on on scroll down
var didScroll;
var lastScrollTop = 0;
var delta = 5;
var navbarHeight = $('#top_wrap').outerHeight();

$(window).scroll(function(event){
	didScroll = true;
});

setInterval(function() {
	if (didScroll) {
		hasScrolled();
		didScroll = false;
	}
}, 250);

function hasScrolled() {
	var st = $(this).scrollTop();

	if(Math.abs(lastScrollTop - st) <= delta) { return; }

	if (st > lastScrollTop && st > navbarHeight){
		// Scroll Down
		$('#top_wrap').addClass('sc_down');
		$('#top_search_cate').addClass('tsc_down');
		$('#top_search input').addClass('tsi_down');
		$('#top_search a').addClass('tsa_down');
	} else {
		// Scroll Up
		if(st + $(window).height() < $(document).height()) {
			$('#top_wrap').removeClass('sc_down');
			$('#top_search_cate').removeClass('tsc_down');
			$('#top_search input').removeClass('tsi_down');
			$('#top_search a').removeClass('tsa_down');
		}
	}
	lastScrollTop = st;
}
</script>

<div id="top_wrap">

  <div id="top_logo"><a href="#"><img src="img/logo_20.png"></a></div>
  
  <div id="top_search">
    <div id="top_search_cate"><img src="img/cate_a_35.png"></div>
    <input type="text" placeholder="검색">
    <a href="#"><img src="img/btn_search01_20.png"></a>
  </div>

</div>