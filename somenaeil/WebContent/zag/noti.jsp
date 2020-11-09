<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<div id="noti_wrap">

  <div id="noti_title"><p>NEW 스크랩</p></div>
  
  <!-- 알림 7개까지만 나오게 -->
  <div id="noti_scrap_wrap">
    <div class="noti_center">
      <div class="noti_scrap"><img src="img/profile01.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile02.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile03.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile04.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile_default.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile_default.jpg"><div class="noti_icon"></div></div>
      <div class="noti_scrap"><img src="img/profile_default.jpg"><div class="noti_icon"></div></div>
    </div>
  </div>
  
  <!-- 페이지 1.기본 알림페이지 -->
  <!-- "noti_basic.jsp" -->
  <!-- 페이지 2.스크랩 전체 알림페이지 -->
  <!-- "noti_scrap.jsp" -->
<%--   <c:choose> --%>
<%--     <c:when test="${param.state= scrap }"> --%>
      <jsp:include page="noti_scrap.jsp" />
<%--     </c:when> --%>
<%--     <c:otherwise> --%>
<%--       <jsp:include page="noti_basic.jsp" /> --%>
<%--     </c:otherwise> --%>
<%--   </c:choose> --%>

</div>


<div id="btm_space"></div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />


</body>
</html>