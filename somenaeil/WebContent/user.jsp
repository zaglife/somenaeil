<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<div id="user_wrap">
  <div id="user_top">
  
    <div id="user_img"><img src="img/profile01.jpg"></div>
    <div id="user_info">
      <div id="user_nick">nickname</div>
      <div id="user_ment">취업을 준비하는 사람들과 실무자간의 소통을 위한 SNS</div>
      <div id="user_info_follow">
        <a onclick="userFollowerPop()">팔로워 126</a>
        <a onclick="userFollowPop()">팔로우 98</a>
        <p>게시글 52</p>
      </div>
    </div>
    
    <c:choose>
      <c:when test="${param.state == 'login' }">
        <!-- 로그인시 본인 계정 -->
        <div id="user_right">
          <a href="join_edit.jsp"><img src="img/setting_20.png"></a>
          <p>R 타입</p>
        </div>
      </c:when>
      <c:otherwise>
        <!-- 로그인시 다른 유저 계정 -->
        <div id="other_right">
          <a href="#" id="user_follow_btn_chg" class="user_follow_btn" onclick="FollowBtnChg()"></a>
          <p>R 타입</p>
        </div>
      </c:otherwise>
    </c:choose>
    
  </div>

</div>

<div id="user_post_cate_wrap">
  <div id="user_post_cate_center">
    <a href="user.jsp">A전체</a>
    <a href="user.jsp?state=userGeneral">G일반</a>
    <a href="user.jsp?state=userReview">R리뷰</a>
    <a href="user.jsp?state=userQuestion">Q질문</a>
    <a href="user.jsp?state=userScrap">S스크랩</a>
    <div id="cate_focus"></div>
  </div>
</div>


<c:choose>
  <c:when test="${param.state == 'userGeneral' }">
    <jsp:include page="user_general.jsp" />
  </c:when>
  <c:when test="${param.state == 'userReview' }">
    <jsp:include page="user_review.jsp" />
  </c:when>
  <c:when test="${param.state == 'userQuestion' }">
    <jsp:include page="user_question.jsp" />
  </c:when>
  <c:when test="${param.state == 'userScrap' }">
    <jsp:include page="user_scrap.jsp" />
  </c:when>
  <c:otherwise>
    <jsp:include page="user_cont.jsp" />
  </c:otherwise>
</c:choose>




<div id="btm_space"></div>

<!-- 유저 팔로워 리스트 "user_follower.jsp" -->
<!-- 유저 팔로우 리스트 "user_follow.jsp" -->
<jsp:include page="user_follower.jsp" />
<jsp:include page="user_follow.jsp" />



<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />

</body>
</html>

<script>
var userFollower= 1;

function userFollowerPop() {
	if(userFollower == 1) {
		$('#user_follower').removeClass('user_follower_hide');
		++userFollower;
	}else if(userFollower == 2) {
		$('#user_follower').addClass('user_follower_hide');
		userFollower= 1;
	}
}

var userFollow= 1;

function userFollowPop() {
	if(userFollower == 1) {
		$('#user_follow').removeClass('user_follow_hide');
		++userFollower;
	}else if(userFollower == 2) {
		$('#user_follow').addClass('user_follow_hide');
		userFollower= 1;
	}
}

var followBtn= 1;

function FollowBtnChg() {
	if(followBtn == 1) {
		$('#user_follow_btn_chg').removeClass('user_follow_btn');
		$('#user_follow_btn_chg').addClass('user_unfollow_btn');
		++followBtn;
	}else if(followBtn == 2) {
		$('#user_follow_btn_chg').removeClass('user_unfollow_btn');
		$('#user_follow_btn_chg').addClass('user_follow_btn');
		followBtn= 1;
	}
}
</script>