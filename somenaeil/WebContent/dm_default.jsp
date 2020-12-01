<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="dm_c_wrap">
  <div id="dm_c_left">
    <img src="img/profile01.jpg">
    <p><a href="user.jsp">nickname</a></p>
    
    <div id="dm_cl_ct">
      <div class="dm_cl_btn"><a href="user.jsp"><img src="img/dm_home_20.png"></a></div>
      <div class="dm_cl_btn"><a href="#"><img src="img/noti_follow_n_20.png"></a></div>
    </div>
  </div>
  <div id="dm_c_right">
    <div id="dm_c_list">
    asjhdgasdh
      <c:if test="${chatlist != null }">
      asjhdgaslhd
		<input type="hidden" id="lastid" name="lastid" value="${chatlist.size() }">
      	<c:forEach var="i" begin="0" end="${chatlist.size() }" step="1">
      	ajksdhsakjdhsad
		  <c:if test="${chatlist.get(i).getFromid().equals(user.getId()) }">
		      <span class="msg_wrap msg_other">
        		<p>${chatlist.get(i).getChatcontent() }</p>
        		<p>${chatlist.get(i).getChatTime() } + 보냄</p>       			
      		  </span>    
		  </c:if>
		  <c:if test="${!chatlist.get(i).getFromid().equals(user.getId()) }">
		      <span class="msg_wrap msg_other">
        		<p>${chatlist.get(i).getChatcontent() }</p>
        		<p>${chatlist.get(i).getChatTime() } + 보냄</p>       			
      		  </span>      
		  </c:if>	
      	</c:forEach>	
      </c:if>
    </div>
    
    <div id="dm_c_msg">
      <input type="text" id="chatcontent" placeholder="메세지를 입력하세요.">
      <button onclick="submitFunction()"></button>
    </div>
  </div>
</div>