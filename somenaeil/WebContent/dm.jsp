<%@page import="com.dm.chat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <c:set var="toid" value="${param.toid }" />


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


function submitFunction(){
	var toid = '${toid}';
	var chatcontent = $("#chatcontent").val();
	var part = $("#part").val();
	
	$.ajax({
		type: "POST",
		url: "dm.some",
		data: {
			toid: encodeURIComponent(toid),
			chatcontent: encodeURIComponent(chatcontent),
			part: encodeURIComponent(part)
			
		},
		success: function(result){
			if (result == 1){
				alert("메세지 전송에 성공하였습니다.");
			} else if(result == 0){
				alert("내용을 입력해주세요");
			}else {
				alert(result);
			}
		}
	});

	$("#chatcontent").val('');
}
	function getInfiniteChat(){
		
		//setTimeout(function(){
			//location.reload();
			//},3000);
	}
</script>
    

<jsp:include page="css.jsp" />
<input type="hidden" id="fromid" name="fromid" value="${user.getId() }">
<div id="dm_wrap"> 
  <div id="dm_new_wrap">
  	<c:forTokens items="${otherlist}" var="other" delims=":">
  	<a href="dm.some?part=view&toid=${other}" class="dm_new"><img src="img/profile02.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
  	</c:forTokens>
  	<%--
     <c:forEach var="other" items="${otherlist }">
     	 <a href="dm.some?part=view&toid=${other}" class="dm_new"><img src="img/profile02.jpg"><img src="img/alert_20.png" class="dm_new_icon"></a>
     </c:forEach>
     --%>
    <a onclick="dmSetPop()" id="dm_manage"><img src="img/setting_20.png"></a>
  </div>
  <div id="dm_choose">유저를 선택해주세요.</div>
  
  
  
 <c:if test="${param.toid != null }">
  <div id="dm_cont">
	<div id="dm_c_wrap">
  <div id="dm_c_left">
    <img src="img/profile01.jpg">
    <p><a href="user.jsp">${toid }</a></p>
    <div id="dm_cl_ct">
      <div class="dm_cl_btn"><a href="user.jsp"><img src="img/dm_home_20.png"></a></div>
      <div class="dm_cl_btn"><a href="#"><img src="img/noti_follow_n_20.png"></a></div>
    </div>
  </div>
  <div id="dm_c_right">
    <div id="dm_c_list">
      <c:if test="${chatlist != null }">
		<input type="hidden" id="lastid" name="lastid" value="${chatlist.size() }">
		<c:forEach var="chat" items="${chatlist}">
		 <c:if test="${chat.getFromid().equals(user.getId()) }">
		      <span class="msg_wrap msg_user">
        		<p>${chat.getChatcontent() }</p>
        		<p>${chat.getChatTime() }  보냄</p>       			
      		  </span>    
		  </c:if>
		  <c:if test="${!chat.getFromid().equals(user.getId()) }">
		      <span class="msg_wrap msg_other">
        		<p>${chat.getChatcontent() }</p>
        		<p>${chat.getChatTime() }  보냄</p>       			
      		  </span>      
		  </c:if>	
		</c:forEach>
   <%--    	<c:forEach var="i" begin="0" end="${chatlist.size() -1}" step="1">
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
      	</c:forEach> --%>	
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
  <!--   <button onclick="submitFunction()"></button> -->  
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
${result}
<div id="btm_space"></div>

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />


</body>

<script>
$(document).ready(function(){
//	
	$("#dm_c_list").scrollTop($("#dm_c_list")[0].scrollHeight);
	 getInfiniteChat();
})

</script>


</html>



    <!-- 페이지 1.메세지 없는 경우 -->
    <!-- jsp include page "dm_default.jsp" -->
    <!-- 페이지 2.메세지 있는 경우 -->
    <!-- jsp include page "dm_choose.jsp" -->