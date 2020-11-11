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

<div id="pw_ch_main">
  <div id="pw_ch_top"> 
    <p>임시 비밀번호를 변경해주세요!</p>
  </div>
  <div id="pw_ch_p">
    <p>비밀번호변경</p>
    <p>*영문, 숫자 조합 8글자 이상</p>
  </div> 
  <div id="pw_ch_input">
    <input id="pw_ch1" type="password" placeholder="현재 비밀번호" >
    <p id="pw_ch1_gt">&gt;</p>
    <input id="pw_ch2" type="password" placeholder="변경할 비밀번호" >
    <input id="pw_ch3" type="password" placeholder="비밀번호확인" >
  </div>
  <div id="pw_ch_btn">
    <a href="pw_ser_clear.jsp">변경</a>
  </div>
</div>

<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />

</body>
</html>