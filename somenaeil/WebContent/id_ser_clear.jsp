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

<div id="id_clear_wrap">

  <p id="id_clear_p1">인증성공</p>
  <p id="id_clear_p2">고객님의 아이디는 [&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;] 입니다 </p>
      
  <div id="id_clear_bt">
    <a href="login.jsp">로그인</a>
    <a href="pw_ser.jsp">비밀번호 찾기</a>
  </div>
</div>

<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />
  
</body>
</html>