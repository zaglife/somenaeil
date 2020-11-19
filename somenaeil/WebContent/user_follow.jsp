<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.member.member"%>
<%@page import="com.member.member_dao"%>
<%@page import="com.member.member_service"%>

<!-- test -->
<!-- 해당 구문은 service에 넣을 것 -->
<!-- some_service의 'some'이 하는 역할이 명확하지 않습니다.
	만약 some이 관할하는 역할이 dm, noti라면,
	아래 구문은 member변수에서도 충분히 다룰 수 있으니 'some'이 아닌 'member'에 넣으면 어떨까싶네요.
	(= some_service -> memeber_service)
	따라서 충분히 some이 하는 역할을 엄밀히 정의한 후, 팔로우 리스트를 some에 넣을지 member에 넣을지
-->
<!-- ss.follow_list() 메소드 이름가지고는 의미를 충분히 전달하지 못하므로 네이밍 필요 
	여담으로 메소드는 보통 동사가 먼저 옵니다 st. (getObject, toString, setObject, insertObject, saveFile, etc.) 
	
	추천 네이밍
	1. getFollowList()
	2. selectFollowList()
	3. loadFollowList()
-->
<%
	member_dao md = new member_dao();
	member my = md.select_member("some");
	request.setAttribute("my", my);
	
	
	member_service ms = new member_service();
	ArrayList<member> follow_list = ms.follow_list(my.getId());
	request.setAttribute("follow_list", follow_list);
%>
<!-- test end -->

        <!-- test 지우셔도 됩니다-->
<%--         <c:forEach items="${follow_list}" var="follow"  varStatus="temp"> --%>
<%--         	${temp.count} --%>
<%--         	${follow.getId()} --%>
<%--         	${follow.getNick()} --%>
<%--         	${follow.getPimg()}<br> --%>
<%--         </c:forEach> --%>
        <!-- test end -->


<div id="user_follow" class="user_popup_wrap user_follow_hide">
<a onclick="userFollowPop()"></a>
  <div class="user_popup_center">
    <div id="user_popup_top_space"></div>
    <div id="user_popup_top">팔로우</div><a onclick="userFollowPop()"></a>
    <div id="user_popup_close"><img src="img/btn_close_20.png" onclick="userFollowPop()"></div>
    
    <div id="user_popup_scroll">

      <c:forEach items="${follow_list}" var="follow"  varStatus="temp">    
      <div id="user_popup_cont">
        <div class="user_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="user_popup_name">${follow.getNick()}</div>
        <div class="user_popup_comment">${follow.getComt()}</div>
        <div class="user_popup_btn"><img src="img/noti_follow_20.png"></div>
      </div>
      </c:forEach>

    </div>
    
  </div>
</div>