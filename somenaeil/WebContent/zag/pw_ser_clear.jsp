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

<div class="pw_ser_clear_main">
  <div id="pw_ser_cl_bd"> 
    <p id="pw_ser_bd_te1">임시 비밀번호 전송완료 !</p>
    <p id="pw_ser_bd_te2">입력하신 이메일 주소로 임시 비밀번호가 전송되었습니다.</p>
    <p id="pw_ser_bd_te3">로그인 후 비밀번호를 꼭 변경해주세요.</p>
    <a id="pw_ser_lo_bt" href="login.jsp">로그인 하러가기 </a>
  </div>
</div>

<jsp:include page="top.jsp" />

</body>
</html>