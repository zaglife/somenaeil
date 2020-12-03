<%@page import="com.member.member_dao"%>
<%@page import="com.member.member_service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />


<script>
function login_alert() {
	$('#login_alert').removeClass('login_alert_dis');
	setTimeout(function() {
		$('#login_alert').removeClass('login_alert_opa');
	}, 1);
	
	setTimeout(function() {
		$('#login_alert').addClass('login_alert_opa');
	}, 3000);
	setTimeout(function() {
		$('#login_alert').addClass('login_alert_dis');
	}, 3100);
}
</script>

<!--
  parameter 및 attribute 설명
  - user: user.jsp의 member
  - sessionScope.sessionUser: 로그인된 유저
  - sessionScope.sessionId: 로그인된 유저 id
  - followList: user의 followList
  - followerList: user의 followerList
  - postList: user가 작성한 post들
-->

</head>
<body>
<div id="user_wrap">
  <div id="user_top">
	<c:choose>
		<c:when test="${user == null}">
			해당 유저가 존재하지 않습니다
		</c:when>
			
			
		<%-- 해당 유저가 존재 --%>
		<c:otherwise>
	<div id="user_img"><img src="pimg/${user.pimg}" onerror="this.src='pimg/pimg_none.jpg'"></div>
    <div id="user_info">
      <div id="user_nick">${user.nick}</div>
      <div id="user_ment">${user.comt}</div>
      <div id="user_info_follow">
        <a onclick="userFollowerPop()">팔로워 ${fn:length(followerList)}</a>
        <a onclick="userFollowPop()">팔로우 ${fn:length(followList)}</a>
        <p>게시글 ${fn:length(postList)}</p>
      </div>
    </div>
		
		<c:choose>
			<%-- 해당 user가 로그인한 자기자신--%>
			<c:when test="${user.id == sessionId}">
				<!-- 환경 설정 -->
		    <div id="user_right">
      		<a href="join_edit.jsp"><img src="img/setting_20.png"></a>
    		</div>
			</c:when>
			
			<%-- 해당 user가 다른 사람  --%>
			<c:otherwise>
				<%-- 언팔로우 아이콘을 보여준다 () --%>
				<c:if test="${sessionId == null}">
					<button class="user_follow_btn">
						<img src="img/noti_follow_n_20.png" onclick="login_alert()">
					</button>
					
					
          <div id="login_alert" class="login_alert_opa login_alert_dis">
            <p>로그인이 필요한 서비스입니다.</p>
            <a href="login.do">로그인</a>
          </div>
					
				</c:if>
				
				<%-- 유저와의 관계를 파악하여 아이콘을 보여준다 --%>
				<c:if test="${sessionId != null}">
					<c:set var="isFollow" value="${isFollow}"/>
<%-- 						${isFollow} --%>
						<button class="user_follow_btn">
						<%-- 해당 유저를 팔로우한 경우 --%>
						<c:if test='${isFollow == "follow4follow" || isFollow == "follow"}'>	
							<img src="img/noti_follow_20.png" onclick="changeFollow('${sessionId}', '${user.id}')">
						</c:if>
						<%-- 해당 유저를 팔로우 하지 않은 경우 --%>
						<c:if test='${isFollow == "follower" || isFollow == "unfollow" || isFollow == null}'>
							<img src="img/noti_follow_n_20.png" onclick="changeFollow('${sessionId}', '${user.id}')">
						</c:if>
						</button>
				</c:if>
			</c:otherwise>		
		</c:choose>
			
			</c:otherwise>
		</c:choose>

  </div>
</div>

<div id="user_post_cate_wrap">
  <div id="user_post_cate_center">
    <a href="user.jsp">A전체</a>
    <a href="user.do?part=user&userId=${user.id}&cate=G">G일반</a>
    <a href="user.do?part=user&userId=${user.id}&cate=R">R리뷰</a>
    <a href="user.do?part=user&userId=${user.id}&cate=Q">Q질문</a>
    <a href="#">S스크랩</a>
    <div id="cate_focus"></div>
  </div>
</div>

<jsp:include page="user_post.jsp" />

<div id="btm_space"></div>


<!-- 유저 팔로우 리스트 "user_follow.jsp" start -->
<c:if test="${followList != null}">
<div id="user_follow" class="user_popup_wrap user_follow_hide">
  <a onclick="userFollowPop()"></a>
  <div class="user_popup_center">
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로우</div><a onclick="userFollowPop()"></a>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${followList}" var="follow">    
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="pimg/${follow.pimg}" onerror="this.src='pimg/pimg_none.jpg'" onclick="location.href='user.do?part=user&userId=${follower.id}'"></div>
        <div class="user_popup_name" onclick="location.href='user.do?part=user&userId=${follow.id}'">${follow.nick}</div>
        <div class="user_popup_comment">${follow.comt}</div>
        <div class="user_popup_btn">
        	
        	<img src="img/noti_follow_20.png" onclick="changeFollow('${user.id}','${follow.id}')">
        </div>
      </div>
      </c:forEach>

    </div>
  </div>
</div>
</c:if>

<c:if test="${followList == null }">
<div id="user_follow" class="user_popup_wrap user_follow_hide">
<a onclick="userFollowPop()"></a>
  <div class="user_popup_center">
  
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로우</div>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowPop()"></div>
    
    <div id="user_popup_scroll">
      <p class="none_fl">팔로우가 없습니다.</p>
    </div>
  </div>
</div>
</c:if>
<!-- 유저 팔로우 리스트 "user_follow.jsp" end -->


<!-- 유저 팔로워 리스트 "user_follower.jsp" start -->
<c:if test="${followerList != null}">
<div id="user_follower" class="user_popup_wrap user_follower_hide">
<a onclick="userFollowerPop()"></a>
  <div class="user_popup_center">
  
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로워</div>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowerPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${followerList}" var="follower">
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="pimg/${follower.pimg}" onerror="this.src='pimg/pimg_none.jpg'" onclick="location.href='user.do?part=user&userId=${follower.id}'"></div>
				<div class="user_popup_name" onclick="location.href='user.do?part=user&userId=${follower.id}'">${follower.nick}</div>
        <div class="user_popup_comment">${follower.comt}</div>
        <div class="user_popup_btn"><img src="img/noti_follow_20.png" onclick="changeFollow('${user.id}','${follower.id}')"></div>
      </div>
      </c:forEach>
      
    </div>
    
  </div>
</div>
</c:if>

<c:if test="${user.follower == null }">
<div id="user_follower" class="user_popup_wrap user_follower_hide">
<a onclick="userFollowerPop()"></a>
  <div class="user_popup_center">
  
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로워</div>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowerPop()"></div>
    
    <div id="user_popup_scroll">

      <p class="none_fl">팔로워가 없습니다.</p>
      
    </div>
    
  </div>
</div>
</c:if>
<!-- 유저 팔로워 리스트 "user_follower.jsp" end -->

<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />


<script src="lib/js/user.js"> </script>
</body>
</html>

