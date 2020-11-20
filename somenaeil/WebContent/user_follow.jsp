<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.ArrayList"%>
<%@page import="com.member.member"%>
<%@page import="com.member.member_dao"%>
<%@page import="com.member.member_service"%>




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