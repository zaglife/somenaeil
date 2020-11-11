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
<div id="join_main">
  <div id="join_title">
    <div id="join_title_text">회원가입</div>
  </div>
  <div id="join_body">
    <div id="join_sns">
      <a href="#" class="join_sns_m">SNS</a>
      <a href="#" class="join_sns_t1">회원가입</a>
      <a href="#" class="join_sns_t2">SNS계정를 통한 회원가입</a>
    </div>
    <div id="join_st">
      <a href="join_form.jsp" class="join_sns_m">일 반</a> 
      <a href="join_form.jsp" class="join_sns_t1">회원가입</a>   
      <a href="join_form.jsp" class="join_sns_t2">E-mail인증을통한 회원가입</a>
    </div>
  </div>
  <div id="join_bt">
    <p class="join_bt_te"><b>일반 회원가입</b>의 경우 기재해주신 E-Mail주소로 가입 인증 링크를 보내드립니다.</p>
    <p class="join_bt_te"><b>SNS 회원가입</b>의 경우 카카오, 네이버, 페이스북 계정을 통해 회원가입을 하실 수 있습니다.</p>
    <div id="join_bt_cm">개인정보 취급방침 및 이용약관</div>
  </div>
</div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>