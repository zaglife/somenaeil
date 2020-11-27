<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.member.member"%>
<%@page import="com.member.member_dao"%>
<%@page import="com.member.member_service"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<c:if test="${other != null }">
<div id="user_wrap">
  <div id="user_top">
  
    <div id="user_img"><img src="img/profile01.jpg"></div>
    <div id="user_info">
      <div id="user_nick">${other.getNick() }</div>
      <div id="user_ment">${other.getComt() }</div>
      <div id="user_info_follow">
        <a onclick="userFollowerPop()">팔로워 ${fn:length(other_flw) }</a>
        <a onclick="userFollowPop()">팔로우 ${fn:length(other_fl) }</a>
        <p>게시글 52</p>${data.size() }
      </div>
    </div>
    
    <div id="other_right">
      <c:if test="${user != null }">
        <c:if test="${follow==null }">
팔로우 중이 아님

${follow }


          <form method="get" action="user.do">
          <input type="hidden" name="part" value="fl_update">
          <input type="hidden" name="follow" value="fl">
          <input type="hidden" name="id" value="${user.getId() }">
          <input type="hidden" name="uid" value="${other.getId() }">
            <button class="user_follow_btn"><img src="img/noti_follow_n_20.png"></button>
          </form>
        </c:if>
        <c:if test="${follow!=null }">
팔로우 중임

          <form method="get" action="user.do">
          <input type="hidden" name="part" value="fl_update">
          <input type="hidden" name="follow" value="no">
          <input type="hidden" name="id" value="${user.getId() }">
          <input type="hidden" name="uid" value="${other.getId() }">
            <button class="user_follow_btn"><img src="img/noti_follow_20.png"></button>
          </form>
        </c:if>
      
      </c:if>
      
      <c:if test="${user == null }">
      <a href="#" id="user_follow_btn_chg" class="user_follow_btn" onclick="login_alert()"><img src="img/noti_follow_n_20.png"></a>
      <div id="login_alert" class="login_alert_opa login_alert_dis">
      <p>로그인이 필요한 서비스입니다.</p>
      <a href="login.do">로그인</a>
      </div>
      </c:if>
      <p>- 타입</p>
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
</c:if>





<!-- 유저 팔로우 리스트 "user_follow.jsp" start -->
<c:if test="${fl_list != null }">
<div id="user_follow" class="user_popup_wrap user_follow_hide">
  <a onclick="userFollowPop()"></a>
  <div class="user_popup_center">
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로우</div><a onclick="userFollowPop()"></a>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${fl_list }" var="follow"  varStatus="temp">    
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="user_popup_name"><a href="user.do?part=user&uid=${follow.getId() }">${follow.getNick() }</a></div>
        <div class="user_popup_comment">${follow.getComt() }</div>
        <div class="user_popup_btn"><img src="img/noti_follow_20.png"></div>
      </div>
      </c:forEach>

    </div>
  </div>
</div>
</c:if>

<c:if test="${fl_list == null }">
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
<c:if test="${flw_list != null }">
<div id="user_follower" class="user_popup_wrap user_follower_hide">
<a onclick="userFollowerPop()"></a>
  <div class="user_popup_center">
  
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로워</div>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowerPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${flw_list }" var="follower"  varStatus="temp">
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="user_popup_name"><a href="user.do?part=user&uid=${follower.getId() }">${follower.getNick() }</a></div>
        <div class="user_popup_comment">${follower.getComt() }</div>
        <div class="user_popup_btn"><img src="img/noti_follow_20.png"></div>
      </div>
      </c:forEach>
      
    </div>
    
  </div>
</div>
</c:if>

<c:if test="${flw_list == null }">
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

<div id="btm_space"></div>

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




