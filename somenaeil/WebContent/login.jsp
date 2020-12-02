<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

<script>
<c:if test="${fail.equals('0') }">
alert("아이디 또는 비밀번호가 잘못되었습니다.");
</c:if>

<c:if test="${fail.equals('-1') }">
alert("존재하지 않는 아이디입니다.");
</c:if>
</script>

<%-- remove 동작 안함 --%>
<c:remove var="fail"/>

</head>
<body>
  <div id="login_main">
    <!-- Login Top -->
	<div id="login_title">    
	<div id="login_title_text">로그인</div>
    </div>
    
    <!-- Login body -->
    <form method="post" action="login.do" id="loginForm">
    <input type="hidden" name="part" value="login">
    <div id="login_body"> 
	  <div id="login_body_text">
	  
	    <div id="lb_text_left">
		  <input type='text' placeholder="아이디" name="id" id="login_id"> 
		  <input type='password' placeholder="••••" name="pw" id="login_pw">
	    </div>
	    
	    <input type="button" id="login_bt" onclick="loginCheck()" value="로그인">
	    
	    <div id="lb_bt">
		  <input type="checkbox" id="login_ing">
		  <p>로그인 상태 유지</p>
		  <div id="lb_bt_right">
		    <a href="id_ser.jsp">아이디 찾기</a> / <a href="pw_ser.jsp">비밀번호 찾기</a>
		  </div>
	    </div>
	    
	  </div>
    </div>
    </form>
    
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
	  <div id="login_join_btn"><a href="join.do">회원가입</a></div>
    </div>
  </div>
  
  
<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />
  
  
</body>
</html>