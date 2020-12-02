<%@page import="com.member.member_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<jsp:include page="top.jsp" />

<c:if test="${param.part == 'search'}">
	<jsp:include page="search.jsp"/>
</c:if>
<c:if test="${param.part != 'search'}">
	<jsp:include page="content.jsp" />
</c:if>
	
<div id="btm_space"></div>


<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />


</body>
</html>