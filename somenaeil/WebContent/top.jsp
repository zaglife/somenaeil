<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<script>
$( window ).scroll( function() {
	if ( $( this ).scrollTop() > 200 ) {
		$('#top_wrap').addClass('sc_down');
		$('#top_search_cate').addClass('tsc_down');
		$('#top_search input').addClass('tsi_down');
		$('#top_search a').addClass('tsa_down');
		$('#nav_top').addClass('btn_show');
	} else {
		$('#top_wrap').removeClass('sc_down');
		$('#top_search_cate').removeClass('tsc_down');
		$('#top_search input').removeClass('tsi_down');
		$('#top_search a').removeClass('tsa_down');
		$('#nav_top').removeClass('btn_show');
	}
} );

$( '#nav_top' ).click( function() {
	$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
	return false;
} );

var drop= 1;

function dropdown() {
	if(drop == 1) {
		$('.dropdown').removeClass('d_hide');
		setTimeout(function() {
			$('.dropdown').addClass('d_down');
		}, 1);
		$('.top_menu_btn').addClass('d_rotation');
		
		++drop;
		
	}else if(drop == 2) {
		$('.dropdown').removeClass('d_down');
		setTimeout(function() {
			$('.dropdown').addClass('d_hide');
		}, 1);
		$('.top_menu_btn').removeClass('d_rotation');
		
		drop= 1;
	}
}

</script>




<c:choose>
  <%-- 로그인 후 --%>
  <c:when test="${user != null }">
    <div class="dropdown d_hide">
      <a href="index.do">메인 페이지</a>
      <a href="user.do?part=user&uid=some">마이 페이지</a>
      <a href="post_main.jsp?state=login">포스팅</a>
      <a href="noti.jsp?state=login">알림</a>
      <a href="dm.jsp?state=login">메세지</a>
      <a href="info.jsp?state=login">채용정보</a>
      <a href="logout.do">로그아웃</a>
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
        
      </div>
    </div>
    <a href="user.do?part=user&uid=some" id="top_user_pimg"><img src="img/profile01.jpg"></a>
  </c:when>
  
  <%-- 로그인 전 --%>
  <c:otherwise>
    <div class="dropdown d_hide">
      <a href="login.do">로그인</a>
      <a href="join.do">회원가입</a>
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
        <a href="login.do" id="top_user_login"><img src="img/icon_profile_30.png"></a>
      </div>
    </div>
  </c:otherwise>
</c:choose>


  <div id="top_logo">
    <a href="read.post?part=postList"><img src="img/logo_20.png"></a>
  </div>
  
  <form action="search.post" method="get" accept-charset="UTF-8">
	  <div id="top_search">
			<div id="top_search_cate">
				<label>
					<input type="radio" name="cate" class="cate select_cate">
					<img src="img/cate_a_35.png">
				</label>
				<div id="hidden_cate" class="d_hide">
				<label>
					<input type="radio" name="cate" value="G" class="cate">
					<img src="img/cate_g_35.png">
				</label>
				<label>
					<input type="radio" name="cate" value="R" class="cate">
					<img src="img/cate_r_35.png">
				</label>
				<label>
					<input type="radio" name="cate" value="Q" class="cate">
					<img src="img/cate_q_35.png">
				</label>
			</div>
			</div>
	    <!-- <input type="hidden" name="cate" value="G">  -->
	    <input type="hidden" name="part" value="search">
	    <input type="text" name="condition" placeholder="검색">
	    <button type="submit"><img src="img/btn_search01_20.png"></button>
	  </div>
  </form>
  
  <div id="top_menu">
    <a href="noti.jsp"><img src="img/icon_new_n_30.png"></a>
    <a href="dm.jsp"><img src="img/icon_dm_n_30.png"></a>
    <div class="top_menu_btn" onclick="dropdown();"><img src="img/icon_menu_30.png"></div>
    <a href="login.jsp"><img src="img/icon_profile_30.png"></a>
  </div>

</div>

<script src="lib/js/top.js"></script>
