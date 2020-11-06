<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>
  <div class="login_main">
  
    <!-- Login Top -->
	<div id="login_title">    
	<div id="login_title_text">로그인</div>
    </div>
    
    <!-- Login body -->
    <div id="login_body"> 
	  <div id="body_text">
	    <div id="body_text_left">
		  <input type='text' id="login_id" placeholder="아이디"> 
		  <input type='text' id="password" placeholder="••••">
	    </div>
	    <input type="button" id="login_bt" value="로그인">
	    <div id="body_bt">
		  <input type="checkbox" id="login_ing"><p>로그인 상태 유지</p>
		  <div id="body_bt_right"><a href="id_ser.jsp">아이디 찾기</a> / <a href="pw_ser.jsp">비밀번호 찾기</a></div>
	    </div>
	  </div>
    </div>
    
    <!--  SNSLogin -->
    <div id="sns_login">
  	  <div id="sns_text">SNS 로그인 </div>
      <div class="sns_box"> 
	    <a href="#"><img src="img/sns_kakao_64.png" id="kakao"></a>
	    <p>카카오톡</p>
      </div>
      <div class="sns_box">
  	    <a href="#"><img src="img/sns_naver_64.png" id="naver"></a>
	    <p>네이버</p>
      </div>
      <div class="sns_box">
	   <a href="#"><img src="img/sns_fb_64.png" id="facebook"></a>
	   <p>페이스북</p>
      </div>
    </div>
    <!-- Join -->
    
    <div id="login_bot">
	  <div id="bot_text">아직 회원이 아니신가요 ?</div> 
	  <div id="newjoin"><a id="login_join_btn" href="join.jsp">회원가입</a></div>
    </div>
  </div>
</body>
</html></html>