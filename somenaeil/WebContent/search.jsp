<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<div id="search_cate_wrap">
  <div id="search_cate_center">
    <a href="search.post?part=search&condition=${param.condition}" class="search_menu current" data-tabl="all">A전체</a>
    <a href="search.post?part=search&condition=${param.condition}&cate=G" class="search_menu" data-tabl="general">G일반</a>
    <a href="search.post?part=search&condition=${param.condition}&cate=R" class="search_menu" data-tabl="review">R리뷰</a>
    <a href="search.post?part=search&condition=${param.condition}&cate=Q" class="search_menu" data-tabl="qna">Q질문</a>
  </div>
</div>

<div id="search_result">"<b>${param.condition}</b>" 검색 결과 화면입니다</div>
<div id="search_wrap">  
 <!-- post start -->
 <c:forEach items="${postList}" var="post">
 	<div class="post">	  
    <!-- post_header start -->
    <div class="post_header">
    
      <div class="post_header_thumb">
      	<!-- 글 카테고리 아이콘 -->
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
        <a href="user.do?part=user&userId=${post.id}">
          <img class="user_thumb" src="pimg/${post.pimg}" onerror="this.src='pimg/pimg_none.jpg'"/>
        </a>
      </div>
      
      <div class="post_info">
        <div class="post_auth"><a href="user.do?part=user&userId=${post.id}">${post.nick}</a></div>
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
				<p>${post.getSummaryContent()}</p>
      </a>
    </div>
    <!-- post_content end -->
    <!-- post_footer start -->
    <div class="post_footer">
    
      <div class="post_footer_hashTag">
				<c:forTokens items="${post.hash}" var="hash" delims=",">
					<a class="hash" href="index.jsp#search">#${hash}</a>
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
 </c:forEach>
</div>


<script src="lib/js/search.js"></script>