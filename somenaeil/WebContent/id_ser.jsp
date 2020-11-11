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

<div id="id_ser_main">
  <div id="id_ser_top">
    <div id="id_pw">
      <a id="id_id_ser">아이디찾기</a>
      <a id="id_pw_ser" href="pw_ser.jsp">비밀번호찾기</a>
    </div>
  </div>
  
  <div id="id_pw_body">
  
    <p id="id_ser_text">회원가입시 입력한 이메일 주소를 입력해주세요 </p>
    
    <div class="id_pw_input">
      <p>이름</p>
      <input type='text' placeholder="썸네일">
    </div>
    <div class="id_pw_input">
      <p>이메일 주소</p>
      <input type='text' placeholder="예)id@somenaeil.net">
    </div>

    <a id="id_ser_bt" href="id_ser_clear.jsp">아이디 찾기</a>

  </div>
</div>

<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>