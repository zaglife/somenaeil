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

<div class="login_main">
  <div id="ser_top">
    <div id="id_pw">
      <input type="button" id="id_ser" value="아이디찾기">
      <input type="button" id="pw_ser" value="비밀번호찾기">
    </div>
  </div>
  
  <div id="ser_body">
    <p id="bd_te">회원가입시 입력한 이메일 주소를 입력해주세요 </p>
    <div id="ser_name">이름 <input type='text' id="name_te" placeholder="썸네일"></div>
    <div id="ser_mail">이메일 주소 <input type='text' id="mail_te" placeholder="예)id@somenaeil.net"></div>
    <div id="id_bt"><a href="id_ser_clear.jsp" id="idser_bt">아이디 찾기</a></div>
  </div>
</div>
</body>
</html>