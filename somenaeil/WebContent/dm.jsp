<%@page import="com.dm.chat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
	memberList
	chatlist
 --%>




 <c:set var="toid" value="${param.toid}" />
 <c:set var="tonick" value="${param.tonick}" />

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
    

<jsp:include page="css.jsp" />
<input type="hidden" id="fromid" name="fromid" value="${user.getId() }">
<div id="dm_wrap"> 
  <div id="dm_new_wrap">
  	<c:set var="memberListCnt" value="${fn:length(memberList)}" />
  	<c:choose>
  		<c:when test="${memberList == null || memberListCnt == 0}">
  			<a href="" class="dm_new" style="opacity:0;"></a>
  			대화중인 상대가 없습니다.
  		</c:when>
  		<c:otherwise>
  			<c:forEach items="${memberList}" var="other">
  				<a href="dm.some?part=view&toid=${other.id}&tonick=${other.nick}" class="dm_new"><img src="pimg/pimg_${other.id}.jpg" onerror="this.src='pimg/pimg_none.jpg'"></a>
  			</c:forEach>
  		</c:otherwise>
  	</c:choose>
    <a onclick="dmSetPop()" id="dm_manage"><img src="img/setting_20.png"></a>
  </div>
  <div id="dm_choose">유저를 선택해주세요.</div>
  
  
 <c:if test="${param.toid != null }">
  <div id="dm_cont">
	<div id="dm_c_wrap">
  <div id="dm_c_left">
    <img src="pimg/pimg_${toid}.jpg" onerror="this.src='pimg/pimg_none.jpg'">
    
    <p><a href="user.jsp">${tonick}</a></p>
    <div id="dm_cl_ct">
      <div class="dm_cl_btn"><a href="user.do?part=user&userId=${toid }"><img src="img/dm_home_20.png"></a></div>
      <div class="dm_cl_btn"><a href="#"><img src="img/noti_follow_n_20.png"></a></div>
    </div>
  </div>
  <div id="dm_c_right">
    <div id="dm_c_list">
      <c:if test="${chatlist != null }">
		<input type="hidden" id="lastid" name="lastid" value="${chatlist.size() }">
		<c:forEach var="chat" items="${chatlist}">
		 <c:if test="${chat.getFromid().equals(sessionId) }">
		      <span class="msg_wrap msg_user">
        		<p>${chat.getChatcontent() }</p>
        		<p>${chat.getChatTime() }  보냄</p>       			
      		  </span>    
		  </c:if>
		  <c:if test="${!chat.getFromid().equals(sessionId) }">
		      <span class="msg_wrap msg_other">
        		<p>${chat.getChatcontent() }</p>
        		<p>${chat.getChatTime() }  보냄</p>       			
      		  </span>      
		  </c:if>	
		</c:forEach>
      </c:if>
    </div>
    
    <div id="dm_c_msg">
    <form method="get" action="dm.some">
    <input type="hidden" id="part" name="part" value="chatlist" >
    <input type="hidden" id="toid" name="toid" value="${toid }">
    <input type="hidden" id="fromid" name="fromid" value="${user.getId() }">
      <input type="text" id="chatcontent" name="chatcontent" placeholder="메세지를 입력하세요.">
      <button></button>
    </form>
    </div>
  </div>
</div>
  </div>
 </c:if>
 
 <c:if test="${param.toid == null }">
 <div id="dm_d_wrap">
  <div id="dm_d_cont">
    <p>메세지</p>
    <p>아이디를 통해서 썸유저에게<br>메세지를 보낼수 있어요 :)</p>
    <button type="button">메세지 보내기</button>
  </div>
</div>
 
 </c:if>
 
  
</div>

<jsp:include page="dm_setting.jsp" />
<div id="btm_space"></div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />


</body>

<script>
$(document).ready(function(){
	$("#dm_c_list").scrollTop($("#dm_c_list")[0].scrollHeight);
	document.getElementById('chatcontent').focus();
})

</script>


</html>



    <!-- 페이지 1.메세지 없는 경우 -->
    <!-- jsp include page "dm_default.jsp" -->
    <!-- 페이지 2.메세지 있는 경우 -->
    <!-- jsp include page "dm_choose.jsp" -->