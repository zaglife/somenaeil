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

<div id="join_clear_main"> 
  <div id="join_clear_text">
    회원가입을 축하합니다 :)
    <p id="join_clear_p">당신의 내일을 위한 썸,내일 첫 게시글을 작성해주세요 ♥</p>    
  </div>
  <div id="join_clear_post">
    <a href="post_main.jsp"><img src="img/nav_post_80.png"></a>
    <p id="join_clear_post_te"><a href="post_main.jsp">포스팅 하러가기</a></p>        
  </div>     
</div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />
  
</body>
</html>