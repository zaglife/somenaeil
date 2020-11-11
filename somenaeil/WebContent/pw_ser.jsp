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

<div id="pw_ser_main">
  <div id="pw_ser_top">
    <div id="id_pw">
      <a id="pw_id_ser" href="id_ser.jsp">아이디찾기</a>
      <a id="pw_pw_ser">비밀번호찾기</a>
    </div>
  </div>
  
  <div id="id_pw_body">
  
    <p id="pw_ser_text">회원가입시 입력한 이메일 인증 필요</p>

    <div class="id_pw_input">
      <p>아이디</p>
      <input type='text' placeholder="썸네일">
    </div>
    <div class="id_pw_input">
      <p>이메일 주소</p>
      <input type='text' placeholder="예)id@somenaeil.net">
    </div>

    <a id="id_ser_bt" href="pw_ser_clear.jsp">메일 확인</a>

    <div id="pw_ser_bottom">
      
      <p id="pw_ser_text2">메일 확인 버튼을 누르시면 입력하신 이메일 주소로 임시 비밀번호가 전송됩니다.</p>
    </div>
    
  </div>
</div>

<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>