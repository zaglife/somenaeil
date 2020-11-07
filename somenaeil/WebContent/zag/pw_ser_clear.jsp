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

<div id="pw_clear_wrap">
    <p id="pw_clear_p1">임시 비밀번호 전송완료 !</p>
    <p id="pw_clear_p2">입력하신 이메일 주소로 임시 비밀번호가 전송되었습니다.</p>
    <p id="pw_clear_p3">로그인 후 비밀번호를 꼭 변경해주세요.</p>
    <a href="login.jsp">로그인 하러가기 </a>
</div>

<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>