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

<div id="cs_write_wrap">

  <div id="cs_write_title">
    <img src="img/logo_40.png">
    <p>고객센터 글작성</p>
  </div>
  
  <form method="post" action="cs.do">
  <input type="hidden" name="part" value="cs_update">
  
  <input type="text" id="cw_title" name="cw_title" placeholder="고객센터 타이틀">
  
  <textarea id="cw_cont" name="cw_cont"></textarea>
  
  <button id="cw_btn">글작성</button>
  </form>

</div>

<jsp:include page="top.jsp" />

</body>
</html>