<%@page import="com.member.member"%>
<%@page import="com.member.member_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!-- 분류 탭  -->
<div id="main_menu_wrap">
  <div id="main_menu_center">
    <a class="main_menu current" data-tab="all" href="read.post?part=postList">A전체</a>
    <a class="main_menu" data-tab="general" href="read.post?part=postList&cate=G">G일반</a>
    <a class="main_menu" data-tab="review" href="read.post?part=postList&cate=R">R리뷰</a>
    <a class="main_menu" data-tab="qna" href="read.post?part=postList&cate=Q">Q질문</a>
    <a style="display:none;" >S스크랩</a>
  </div>
</div>
  
  
<!-- 포스팅 내용 -->
<div class="tab_content">

	<!-- post start -->
  <c:forEach items="${postList}" var="post">
  	<!-- 이미지 X 템플릿 -->
  	<c:if test="${post.getThumbnail()==null}">
  	<div class="post ${post.cate}">	  
	    <!-- post_header start -->
	    <div class="post_header">
	    
	      <div class="post_header_thumb">
	      	<!-- 게시글 카테고리 아이콘 -->
	      	<c:choose>
	      		<c:when test="${post.cate=='G'}">
	      			<img class="tab_thumb" src="img/cate_g_s.png">
	      		</c:when>
	      		<c:when test="${post.cate=='R'}">
	      			<img class="tab_thumb" src="img/cate_r_s.png">
	      		</c:when>
	      		<c:when test="${post.cate=='Q'}">
	      			<img class="tab_thumb" src="img/cate_q_s.png">
	      		</c:when>
	      	</c:choose>
	        <a href="user.jsp">
	          <img class="user_thumb" src="img/profile01.jpg"/>
	        </a>
	      </div>
	      
	      <div class="post_info">
	        <div class="post_auth"><a href="user.jsp">${post.nick}</a></div>
	        <div class="post_date">${post.time}</div>
	      </div>
	      
	    </div>
	    <!-- post_header end -->
	    <!-- post_title start -->
	    <div class="post_title">
	      <a href="read.post?part=postDetail&pageNum=${post.num}">${post.title}</a>
	    </div>
	    <!-- post_title end -->
	    <!-- post_content start -->
	    <div class="post_content">
	      <a href="read.post?part=postDetail&pageNum=${post.num}">
					<p>${post.getSummaryContext()}</p>
	      </a>
	    </div>
	    <!-- post_content end -->
	    <!-- post_footer start -->
	    <div class="post_footer">
	    
	      <div class="post_footer_hashTag">
					<c:forTokens items="${post.hash}" var="hash" delims=",">
						<a class="hash" href="search.post?part=search&condition=${hash}">#${hash}</a>
					</c:forTokens>
	      </div>
	      
	      <div class="post_footer_subInfo">
	        <div class="post_like_btn">
	          <img src="img/noti_like_n_20.png">
	          <span>${post.like_cnt}</span>
	        </div>
	        <div class="post_scrap_btn">
	          <img src="img/noti_scrap_n_20.png">
	          <span>${post.scrap_cnt}</span>
	        </div>
	      </div>
	      
	    </div>
	    <!-- post_footer end -->
	  </div>
	  <!-- post end -->
	  </c:if>
	  
	  <!-- 이미지 O 템플릿 -->
	  <c:if test="${post.getThumbnail()!=null}">
	  <!-- post start -->
	  <div class="post ${postList}_thumbnail">
	    <!-- post_header start -->
	    <div class="post_header">
	      <div class="post_header_thumb">
	        <!-- 게시글 카테고리 아이콘 -->
	      	<c:choose>
	      		<c:when test="${post.cate=='G'}">
	      			<img class="tab_thumb" src="img/cate_g_s.png">
	      		</c:when>
	      		<c:when test="${post.cate=='R'}">
	      			<img class="tab_thumb" src="img/cate_r_s.png">
	      		</c:when>
	      		<c:when test="${post.cate=='Q'}">
	      			<img class="tab_thumb" src="img/cate_q_s.png">
	      		</c:when>
	      	</c:choose>
	        <a href="user.jsp">
	          <img class="user_thumb" src="img/profile01.jpg"/>
	        </a>
	      </div>
	      
	      <div class="post_info">
	        <div class="post_auth"><a href="user.jsp">${post.nick}</a></div>
	        <div class="post_date">${post.time}</div>
	      </div>
	      
	    </div>
	    <!-- post_header end -->
	    <!-- post_title start -->
	    <div class="post_title">
	      <a href="post.jsp">${post.title}</a>
	    </div>
	    <!-- post_title end -->
	    <!-- post_content start -->
	    <div class="post_content">
	      <div class="post_thumb_wrap">
	        <div class="post_thumb"><a href="post.jsp"><img src="img/sample01.jpg"></a></div>
	      </div>
	      <a href="post.jsp">
	        <p>${post.getSummaryContext()}</p>
	      </a>
	    </div>
	    <!-- post_content end -->
	    <!-- post_footer start -->
	    <div class="post_footer">
	    
	      <div class="post_footer_hashTag">
	        <c:forTokens items="${post.hash}" var="hash" delims=",">
						<a class="hash" href="search.post?part=search&condition=${hash}">#${hash}</a>
					</c:forTokens>
	      </div>
	      
	      <div class="post_footer_subInfo">
	        <div class="post_like_btn">
	          <img src="img/noti_like_n_20.png">
	          <span>${post.like_cnt}</span>
	        </div>
	        <div class="post_scrap_btn">
	          <img src="img/noti_scrap_n_20.png">
	          <span>${post.scrap_cnt}</span>
	        </div>
	      </div>
	      
	    </div>
	    <!-- post_footer end -->
	  </div>
	  <!-- post end -->
	  </c:if>
  </c:forEach>

</div>
<!-- 포스팅 내용 끝 -->

<script src="lib/js/content.js"></script>