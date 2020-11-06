<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <a href="#"><p>팔로워</p><p>126</p></a>
        <a href="#"><p>팔로우</p><p>98</p></a>
        <p>게시글</p><p>52</p>
      </div>
    </div>
    
    <!-- 로그인시 본인 계정 -->
    <!-- div id="user_right">
      <a href="#"><img src="img/setting_20.png"></a>
      <p>R 타입</p>
    </div -->
    <!-- 로그인시 다른 유저 계정 -->
    <div id="other_right">
      <a href="#"><img src="img/noti_follow_20.png"></a>
      <p>R 타입</p>
    </div>
    <!-- 비로그인시 other_right에 링크는 로그인 페이지 -->
  </div>

</div>



<!-- 유저 첫화면 "user_cont.jsp" -->
<!-- cont에서 카테고리 내용 변경 -->
<jsp:include page="user_cont.jsp" />



<!-- 유저 팔로워 리스트 "user_follower.jsp" -->
<!-- 유저 팔로우 리스트 "user_follow.jsp" -->
<!--jsp:include page="user_follower.jsp" /-->



<div id="btm_space"></div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />

</body>
</html>