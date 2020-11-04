<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
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
		$('#nav_top').addClass('btn_show');
	} else {
		// Scroll Up
		if(st + $(window).height() < $(document).height()) {
			$('#top_wrap').removeClass('sc_down');
			$('#top_search_cate').removeClass('tsc_down');
			$('#top_search input').removeClass('tsi_down');
			$('#top_search a').removeClass('tsa_down');
			$('#nav_top').removeClass('btn_show');
		}
	}
	lastScrollTop = st;
}

var drop= 1;

function dropdown() {
	if(drop == 1) {
		$('.dropdown').addClass('d_down');
		$('.top_menu_btn').addClass('d_rotation');
		++drop;
	}else if(drop == 2) {
		$('.dropdown').removeClass('d_down');
		$('.top_menu_btn').removeClass('d_rotation');
		drop= 1;
	}
}
</script>

<div class="dropdown" style="display:none;">
  <a href="#">로그인</a>
  <a href="#">회원가입</a>
</div>

<div class="dropdown">
  <a href="index.jsp">메인 페이지</a>
  <a href="user.jsp">마이 페이지</a>
  <a href="#">포스팅</a>
  <a href="noti.jsp">알림</a>
  <a href="dm.jsp">메세지</a>
  <a href="#">채용정보</a>
  <a href="#">로그아웃</a>
</div>

<div id="top_wrap">

  <div id="top_logo">
    <a href="index.jsp"><img src="img/logo_20.png"></a>
  </div>
  
  <div id="top_search">
    <div id="top_search_cate"><img src="img/cate_a_35.png"></div>
    <input type="text" placeholder="검색">
    <a href="#"><img src="img/btn_search01_20.png"></a>
  </div>
  
  <div id="top_menu">
    <a href="noti.jsp"><img src="img/icon_new_n_30.png"></a>
    <a href="dm.jsp"><img src="img/icon_dm_n_30.png"></a>
    <div class="top_menu_btn" onclick="dropdown();"><img src="img/icon_menu_30.png"></div>
    <a href="user.jsp"><img src="img/icon_profile_30.png"></a>
  </div>

</div>