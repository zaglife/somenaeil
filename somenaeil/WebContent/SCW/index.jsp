<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>			<%-- JSTL --%>

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

<title>somenaeil main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/SCW/lib/font.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/SCW/lib/index.css">

</head>
<body>
    <div id="container">
        <div id="header">
        	<jsp:include page="header.jsp" />
        </div>
        <div id="content">
        	<jsp:include page="content.jsp" />
        </div>
        <div id="footer">
        	하단
        </div>
    </div>
</body>
</html>