<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>			<%-- JSTL --%>

<%
/*
<변경사항>
resource
- web-inf/lib에 tablib(JSTL) 추가
- main/img 추가

jsp
- main_page 레이아웃

*/
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>somenaeil main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/SCW/lib/font.css">
<style>

body { padding-top: 70px; }		/* 상단바(50px) + 20px */

a { text-decoration: none; }

#container {
	display: flex;
	flex-direction: column;
	align-items: center;
	
	height: 2000px;
}

#header { 
	display: flex;
	position: fixed;
	flex: 1;
	width: 100%; height: 50px;
	top: 0; left: 0;
    line-height: 50px;
        
    background: white;
    border-bottom: 1px solid black;
}

#content {
	display: flex;
	flex-flow: row wrap;
	justify-content: center;
	align-content: flex-start;
    flex: 3;
    width: 75%;
    
    border: 1px black solid;
}

#footer {
	border: 1px black solid;
}
</style>
<!-- TODO 분류탭 -->
<!-- TODO 아이콘 -->
<!--  TODO footer -->

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