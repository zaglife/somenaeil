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
  <div id="login_main">
  
    <!-- Login Top -->
	<div id="login_title">    
	<div id="login_title_text">로그인</div>
    </div>
    
    <!-- Login body -->
    <div id="login_body"> 
	  <div id="login_body_text">
	  
	    <div id="lb_text_left">
		  <input type='text' placeholder="아이디" id="login_id" name="login_id"> 
		  <input type='text' placeholder="••••" id="login_pw" name="login_pw">
	    </div>
	    
	    <a href="index.jsp?state=login" id="login_bt">로그인</a>
	    
	    <div id="lb_bt">
		  <input type="checkbox" id="login_ing">
		  <p>로그인 상태 유지</p>
		  <div id="lb_bt_right">
		    <a href="id_ser.jsp">아이디 찾기</a> / <a href="pw_ser.jsp">비밀번호 찾기</a>
		  </div>
	    </div>
	    
	  </div>
    </div>
    
    <!--  SNSLogin -->
    <div id="login_sns_wrap">
  	  <div id="login_sns_text">SNS 로그인 </div>
      <div class="login_sns_box"> 
	    <a href="#"><img src="img/sns_kakao_64.png" id="kakao"></a>
	    <p>카카오톡</p>
      </div>
      <div class="login_sns_box">
  	    <a href="#"><img src="img/sns_naver_64.png" id="naver"></a>
	    <p>네이버</p>
      </div>
      <div class="login_sns_box">
	   <a href="#"><img src="img/sns_fb_64.png" id="facebook"></a>
	   <p>페이스북</p>
      </div>
    </div>
    <!-- Join -->
    
    <div id="login_bottom">
	  <div id="login_bottom_text">아직 회원이 아니신가요 ?</div> 
	  <div id="login_join_btn"><a href="join.jsp">회원가입</a></div>
    </div>
  </div>
  
  
<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />
  
  
</body>
</html></html>