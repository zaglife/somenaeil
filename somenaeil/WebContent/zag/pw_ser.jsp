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
      <a href="id_ser.jsp" id="id_ser">아이디찾기</a>
      <a href="pw_ser.jsp" id="pw_ser">비밀번호찾기</a>
    </div>
  </div>
  <div id="ser_body">
    <div id="ser_body_center">
    <div id="ser_id">
      <p>아이디</p>
      <input type='text' id="name_te_pw" placeholder="somenaeil"></div>
    <div id="ser_mail_pw">
      <p>이메일 주소</p>
      <input type='text' id="mail_te_pw" placeholder="예)id@somenaeil.net">
      <a href="#" id="mail_in">메일 확인</a>
    </div>
    </div>
    <div id="ser_bt">
      <p id="bt_te1">회원가입시 입력한 이메일 인증 필요</p>
      <p id="bt_te2">메일 확인 버튼을 누르시면 입력하신 이메일 주소로 임시 비밀번호가 전송됩니다.</p>
      <p id="bt_te3">로그인후 비밀번호를 꼭 변경해주세요.</p>
    </div>
  </div>
</div>

<jsp:include page="top.jsp" />

</body>
</html>