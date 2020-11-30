<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.member.member"%>
<%@page import="com.member.member_dao"%>
<%@page import="com.member.member_service"%>

<%

	String id= (String) session.getAttribute("id");
	String uid= (String) session.getAttribute("uid");
	member_service ms= new member_service();
	
	if(id != null){
		ArrayList<member> follow_list= ms.follow_list(id);
		ArrayList<member> follower_list= ms.follower_list(id);
		request.setAttribute("follow_list", follow_list);
		request.setAttribute("follower_list", follower_list);
	}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<div id="user_wrap">
  <div id="user_top">
  
    <div id="user_img"><img src="img/profile01.jpg"></div>
    <div id="user_info">
      <div id="user_nick">${user.getNick() }</div>
      <div id="user_ment">취업을 준비하는 사람들과 실무자간의 소통을 위한 SNS</div>
      <div id="user_info_follow">
        <a onclick="userFollowerPop()">팔로워 ${follower_list.size() }</a>
        <a onclick="userFollowPop()">팔로우 ${follow_list.size() }</a>
        <p>게시글 512</p>
      </div>
    </div>

    <!-- 로그인시 본인 계정 -->
    <div id="user_right">
      <a href="join.do?part=edit"><img src="img/setting_20.png"></a>
      <p>R 타입</p>
    </div>

  </div>

</div>

<div id="user_post_cate_wrap">
  <div id="user_post_cate_center">
    <a href="user.jsp">A전체</a>
    <a href="user.jsp?state=userGeneral">G일반</a>
    <a href="user.jsp?state=userReview">R리뷰</a>
    <a href="user.jsp?state=userQuestion">Q질문</a>
    <a href="user.jsp?state=userScrap">S스크랩</a>
    <div id="cate_focus"></div>
  </div>
</div>


<c:choose>
  <c:when test="${param.state == 'userGeneral' }">
    <jsp:include page="user_general.jsp" />
  </c:when>
  <c:when test="${param.state == 'userReview' }">
    <jsp:include page="user_review.jsp" />
  </c:when>
  <c:when test="${param.state == 'userQuestion' }">
    <jsp:include page="user_question.jsp" />
  </c:when>
  <c:when test="${param.state == 'userScrap' }">
    <jsp:include page="user_scrap.jsp" />
  </c:when>
  <c:otherwise>
    <jsp:include page="user_cont.jsp" />
  </c:otherwise>
</c:choose>


<div id="btm_space"></div>


<!-- 유저 팔로우 리스트 "user_follow.jsp" start -->
<c:if test="${follow_list != null }">
<div id="user_follow" class="user_popup_wrap user_follow_hide">
  <a onclick="userFollowPop()"></a>
  <div class="user_popup_center">
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로우</div><a onclick="userFollowPop()"></a>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${follow_list }" var="follow"  varStatus="temp">    
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="user_popup_name">${follow.getNick() }</div>
        <div class="user_popup_comment">${follow.getComt() }</div>
        <div class="user_popup_btn"><img src="img/noti_follow_20.png"></div>
      </div>
      </c:forEach>

    </div>
  </div>
</div>
</c:if>

<c:if test="${follow_list == null }">
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
<c:if test="${follower_list != null }">
<div id="user_follower" class="user_popup_wrap user_follower_hide">
<a onclick="userFollowerPop()"></a>
  <div class="user_popup_center">
  
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로워</div>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowerPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${follower_list }" var="follower"  varStatus="temp">
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="user_popup_name">${follower.getNick() }</div>
        <div class="user_popup_comment">${follower.getComt() }</div>
        <div class="user_popup_btn"><img src="img/noti_follow_20.png"></div>
      </div>
      </c:forEach>
      
    </div>
    
  </div>
</div>
</c:if>

<c:if test="${follower_list == null }">
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

</body>
</html>

<script>
var userFollower= 1;

function userFollowerPop() {
	if(userFollower == 1) {
		$('#user_follower').removeClass('user_follower_hide');
		++userFollower;
	}else if(userFollower == 2) {
		$('#user_follower').addClass('user_follower_hide');
		userFollower= 1;
	}
}

var userFollow= 1;

function userFollowPop() {
	if(userFollower == 1) {
		$('#user_follow').removeClass('user_follow_hide');
		++userFollower;
	}else if(userFollower == 2) {
		$('#user_follow').addClass('user_follow_hide');
		userFollower= 1;
	}
}

var followBtn= 1;

function FollowBtnChg() {
	if(followBtn == 1) {
		$('#user_follow_btn_chg').removeClass('user_follow_btn');
		$('#user_follow_btn_chg').addClass('user_unfollow_btn');
		++followBtn;
	}else if(followBtn == 2) {
		$('#user_follow_btn_chg').removeClass('user_unfollow_btn');
		$('#user_follow_btn_chg').addClass('user_follow_btn');
		followBtn= 1;
	}
}
</script>