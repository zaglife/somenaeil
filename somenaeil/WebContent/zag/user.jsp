<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>some, 내일</title>

<link rel="stylesheet" type="text/css" href="lib/top.css">
<link rel="stylesheet" type="text/css" href="lib/user.css">
<link rel="stylesheet" type="text/css" href="lib/dm.css">
<link rel="stylesheet" type="text/css" href="lib/noti.css">
<link rel="stylesheet" type="text/css" href="lib/somenaeil_fonts.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

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
        <a href="#"><p>게시글</p><p>52</p></a>
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
    
    
    <div id="user_post_cate_wrap">
      <div id="user_post_cate_center">
        <a href="#">A전체</a>
        <a href="#">G일반</a>
        <a href="#">R리뷰</a>
        <a href="#">Q질문</a>
        <a href="#">S스크랩</a>
        <div id="cate_focus"></div>
      </div>
    </div>
  </div>
</div>

<!-- 탑 네비 메뉴 페이지 -->
<jsp:include page="top.jsp" />

</body>
</html>