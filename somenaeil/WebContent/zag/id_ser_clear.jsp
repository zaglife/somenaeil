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
  <div class="login_clear_main">
    <div id="ser_top">
      <div id="id_pw"> <input type="button" id="id_ser" value="아이디찾기">
					   <input type="button" id="pw_ser" value="비밀번호찾기">
      </div>
    </div>
    <div id="id_cl_bd">
      <div id="cl_te">
        <p id="cl_te1">인증성공!</p>
        <p id="cl_te2">고객님의 아이디는 [&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;] 입니다 </p>
      </div>
      <div id="login_cl_bt">
        <a href="login.jsp" id="cl_lo">로그인</a>
        <a href="#" id="cl_pw">비밀번호 찾기</a>
      </div>
    </div>
  </div>
</body>
</html>