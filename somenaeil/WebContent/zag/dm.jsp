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


<div id="dm_wrap">

  <div id="dm_new_wrap">
    <a href="#" class="dm_new"><img src="img/profile01.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="#" class="dm_new"><img src="img/profile02.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="#" class="dm_new"><img src="img/profile03.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="#" class="dm_new"><img src="img/profile04.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="#" class="dm_new"><img src="img/profile_default.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="#" class="dm_new"><img src="img/profile_default.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    
    <a href="#" id="dm_manage"><img src="img/setting_20.png"></a>
  </div>
  <div id="dm_choose"><a href="#">메세지를 선택해주세요.</a></div>
  
  <div id="dm_cont">
    <!-- 페이지 1.메세지 없는 경우 -->
    <!-- jsp include page "dm_default.jsp" -->
    <!-- 페이지 2.메세지 있는 경우 -->
    <!-- jsp include page "dm_choose.jsp" -->
    <jsp:include page="dm_choose.jsp" />
  </div>
  
</div>

</body>
</html>