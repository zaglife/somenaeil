<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- TODO create js -->
<!--  
<TODO List>
- footer 구현 
- 포스팅 읽기 페이지

<변경사항>
- main 분류탭
- 아이콘 추가
- 코드 및 파일 정리 (유지보수) (css, html, js)
- 상호작용 (create js file) -> tab 기능
- main page에 필요한 데이터 정리
-->
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>




<!--jsp:include page="content.jsp" /-->
<!--jsp:include page="search.jsp" /-->

<jsp:include page="content.jsp" />



<div id="btm_space"></div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />

  
</body>
</html>