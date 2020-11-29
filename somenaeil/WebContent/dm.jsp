<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <c:set var="toid" value="1234" />
<%
	String toid = null;
	if(request.getParameter("toid") != null){
		toid = (String)request.getParameter("toid");
	}

%>

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
	var toid = '<%=toid%>';
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

	var lastID = 0; // 가장 마지막의 챗 아이디
	function chatListFunction(type){
		var toid = '<%=toid %>';
		var part = "list";
		$.ajax({
			type: "POST",
			url: "dm.some",
			data: {
				toid: encodeURIComponent(toid),
				listType: type,
				part : part
			},
			success : function(data){
				qwer();
				
				if(data == "")return ;
				var parsed = JSON.parse(data); // 제이슨 형태로 파싱
				var result = parsed.result;
				for(var i = 0; i < result.lenght; i++){
					addChat(result[i][0].value, result[i][2].value, result[i][3].value);
				}
				lastID = Number(parsed.last)
			}
		});
	}
	function addChat(chatName, chatContnet,chatTime){
		var formid = $("#formid").val();
		var toid = '<%=toid %>';
		if(chatName == fromid){
			$("#dm_c_list").append('<span class="msg_wrap msg_user">' +
				'<p>'+
				chatContent +
				'</p>' +
				'<p>'+
				chatTime +
				' 보냄</p>' +
				'</span>'
				);
		}else if(chatName == toid){
			$("#dm_c_list").append('<span class="msg_wrap msg_other">' +
				'<p>'+
				chatContent +
				'</p>' +
				'<p>'+
				chatTime +
				' 보냄</p>' +
				'</span>'
				);
		}
		$("#dm_c_list").scrollTop($("#dm_c_list")[0].scrollHeight);
	}
	function getInfiniteChat(){
		setInterval(function(){
			chatListFunction(lastID);
		}, 3000);
	}
	function qwer(){
		alert(<%=request.getAttribute("chatlist")%>);
		data = <%=request.getAttribute("chatlist")%>;
		if(data == "")return ;
		var parsed = JSON.parse(data); // 제이슨 형태로 파싱
		var result = parsed.result;
		for(var i = 0; i < result.lenght; i++){
			addChat(result[i][0].value, result[i][2].value, result[i][3].value);
		}
		lastID = Number(parsed.last)
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
<input type="hidden" id="part" name="part" value="chatlist">
<input type="hidden" id="fromid" name="fromid" value="${user.getId() }">
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

<script>
$(document).ready(function(){
	chatListFunction('ten');
	getInfiniteChat();
})

</script>


</html>



    <!-- 페이지 1.메세지 없는 경우 -->
    <!-- jsp include page "dm_default.jsp" -->
    <!-- 페이지 2.메세지 있는 경우 -->
    <!-- jsp include page "dm_choose.jsp" -->