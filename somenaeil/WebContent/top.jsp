<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>


<div id="top_wrap">
<!-- Logo -->
<div id="top_logo">
  <a href="index.jsp"><img src="img/logo_20.png"></a>
</div>

<!-- search bar -->
<form action="search.post" method="get" accept-charset="UTF-8">
 <div id="top_search">
	<div id="top_search_cate">
		<img id="cur_cate" src="img/cate_a_35.png">
		<div id="hidden_cate" class="d_hide">
			<label for="cate_A">
				<input id="cate_A" type="radio" name="cate">
				<img class="cate select_cate" src="img/cate_a_35.png">
			</label>

			<label for="cate_G">
			<input id="cate_G" type="radio" name="cate" value="G">
			<img class="cate" src="img/cate_g_35.png">
			</label>

			<label for="cate_R">
			<input id="cate_R" type="radio" name="cate" value="R">
			<img class="cate" src="img/cate_r_35.png">
			</label>

			<label for="cate_Q">
			<input id="cate_Q" type="radio" name="cate" value="Q">
			<img class="cate" src="img/cate_q_35.png">
			</label>
		</div>
	</div>
   <input type="hidden" name="part" value="search">
   <input type="text" name="condition" placeholder="검색">
   <button type="submit"><img src="img/btn_search01_20.png"></button>
 </div>
</form>


<!-- hidden dropdown -->
<div class="dropdown d_hide">

	<c:if test="${sessionScope.sessionUser == null}">
		<a href="login.jsp">로그인</a>
 		<a href="join.jsp">회원가입</a>
	</c:if>
	<c:if test="${sessionScope.sessionUser != null}">
    <a href="index.jsp">메인 페이지</a>
    <a href="user.do?part=user&userId=${sessionId}">마이 페이지</a>
    <a href="post_main.jsp?state=login">포스팅</a>
    <a href="noti.some?">알림</a>
    <a href="dm.some?part=view">메세지</a>
    <a href="job.do">채용정보</a>
    <a href="cs.do">고객센터</a>
  	<a href="logout.do?part=logout">로그아웃</a>
	</c:if>
</div>
<!-- top menu -->

<%-- 탑 메뉴 - 비로그인 --%>
<c:if test="${sessionScope.sessionUser == null}">
<div id="top_menu">
  <div class="top_menu_btn" onclick="dropdown();"><img src="img/icon_menu_30.png"></div>
  <!-- 로그인시 프로필 사진으로 대체 -->
  <a href="login.jsp"><img src="img/icon_profile_30.png"></a>
</div>
</c:if>

<%-- 탑 메뉴 - 로그인 --%>
<c:if test="${sessionScope.sessionUser != null}">
<div id="top_menu" class="login_success">
  <a href="noti.some"><img src="img/icon_new_n_30.png"></a>
  <a href="dm.some?part=view"><img src="img/icon_dm_n_30.png"></a>
  <div class="top_menu_btn" onclick="dropdown();"><img src="img/icon_menu_30.png"></div>
  <a href="user.do?part=user&userId=${sessionUser.id}" id="top_user_login">
    <img src="pimg/${sessionUser.pimg }" onerror="this.src='pimg/pimg_none.jpg'">
  </a>
</div>
</c:if>

</div>

<script src="lib/js/top.js"></script>
