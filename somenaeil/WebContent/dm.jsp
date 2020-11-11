<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<script>
var dmTemp= 1;

function dmSetPop() {
	if(dmTemp == 1) {
		$('#dm_set_wrap').removeClass('dm_set_hide');
		++dmTemp;
	}else if(dmTemp == 2) {
		$('#dm_set_wrap').addClass('dm_set_hide');
		dmTemp= 1;
	}
}
</script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<div id="dm_wrap">

  <div id="dm_new_wrap">
    <a href="dm.jsp?state=login" class="dm_new"><img src="img/profile01.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="dm.jsp?state=login" class="dm_new"><img src="img/profile02.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="dm.jsp?state=login" class="dm_new"><img src="img/profile03.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="dm.jsp?state=login" class="dm_new"><img src="img/profile04.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="dm.jsp?state=login" class="dm_new"><img src="img/profile_default.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    <a href="dm.jsp?state=login" class="dm_new"><img src="img/profile_default.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
    
    <a onclick="dmSetPop()" id="dm_manage"><img src="img/setting_20.png"></a>
  </div>
  <div id="dm_choose">유저를 선택해주세요.</div>
  
  <div id="dm_cont">
    <c:choose>
      <c:when test="${param.state == login }">
        <jsp:include page="dm_choose.jsp" />
      </c:when>
      <c:otherwise>
        <jsp:include page="dm_default.jsp" />
      </c:otherwise>
    </c:choose>
  </div>
  
</div>

<jsp:include page="dm_setting.jsp" />

<div id="btm_space"></div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />


</body>
</html>



    <!-- 페이지 1.메세지 없는 경우 -->
    <!-- jsp include page "dm_default.jsp" -->
    <!-- 페이지 2.메세지 있는 경우 -->
    <!-- jsp include page "dm_choose.jsp" -->