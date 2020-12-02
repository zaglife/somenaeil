<%@page import="com.member.member_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="noti_scrap_all"><a href="noti.jsp?state=scrap"><p>+전체 92개의 스크랩</p></a></div>

<div id="noti_cont_wrap">
  <div class="noti_border">
<%--
    <div class="noti_timeline">방금전</div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_follow"><p>luv_seowoo</p>님께서 팔로우 하셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_like"><p>kmpark</p>님께서 좋아요를 누르셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_like"><p>364d</p>님께서 좋아요를 누르셨습니다.</a></div>

    <div class="noti_timeline">6시간 전</div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_like"><p>chana</p>님께서 좋아요를 누르셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_like"><p>jaewoneey</p>님께서 좋아요를 누르셨습니다.</a></div>

    <div class="noti_timeline">1일 전</div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_like"><p>share_bin</p>님께서 좋아요를 누르셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_follow"><p>amogoto</p>님께서 팔로우 하셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_scrap"><p>znuyaa</p>님께서 게시물을 스크랩하셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_follow"><p>souunni</p>님께서 팔로우 하셨습니다.</a></div>
    <div class="noti_newline"><a href="user.jsp" class="noti_new_scrap"><p>dabin_ovo</p>님께서 게시물을 스크랩하셨습니다.</a></div>
 --%>    

		<c:forEach items="${notiList}" var="noti">
			<c:choose>
				<%-- 팔로우 --%>
				<c:when test="${noti.type == 1}">
					<div class="noti_newline"><a href="user.do?part=user&userId=${noti.otherId}" class="noti_new_follow"><p>${noti.otherNick}</p>님께서 팔로우 하셨습니다.</a></div>
				</c:when>
				<%-- 댓글 --%>
				<c:when test="${noti.type == 2}">
					<div class="noti_newline"><a href="user.do?part=user&userId=${noti.otherId}" class="noti_new_scrap"><p>${noti.otherNick}</p>님께서 게시물에 댓글을 작성하셨습니다.</a></div>
				</c:when>
				<%-- 좋아요 --%>
				
				<%-- 스크랩 --%>
			</c:choose>
			
		</c:forEach>
  </div>
</div>