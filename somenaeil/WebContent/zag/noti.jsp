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


<!-- 탑 네비 메뉴 페이지 -->
<jsp:include page="top.jsp" />


<div id="noti_wrap">

  <div id="noti_title"><p>NEW 스크랩</p></div>
  
  <!-- 알림 7개까지만 나오게 -->
  <div id="noti_scrap_wrap">
    <div class="noti_center">
      <div class="noti_scrap"><img src="img/profile01.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile02.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile03.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile04.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile_default.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile_default.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile_default.jpg"><div class="noti_icon"></div></div>
    </div>
  </div>
  
  <!-- 페이지 1.기본 알림페이지 -->
  <!-- "noti_basic.jsp" -->
  <!-- 페이지 2.스크랩 전체 알림페이지 -->
  <!-- "noti_scrap.jsp" -->
  <jsp:include page="noti_basic.jsp" />

</div>

</body>
</html>