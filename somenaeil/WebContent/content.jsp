<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
	// TODO tab 기능 -> 상단바 상호작용
	$(document).ready(function(){
		var tab_id = $(this).attr("data-tab");
		
		$("#main_menu_center a").removeClass("current");
		$(".tab_content").removeClass("current");
		
		$(this).addClass("current");
		$("#"+tab_id).addClass("current");
	})
	
	// TODO post 보이게 만들기
</script>

<!-- 분류 탭  -->
<div id="main_menu_wrap">
  <div id="main_menu_center">
    <a href="#" class="main_menu current" data-tab="all" >A전체</a>
    <a href="#" class="main_menu" data-tab="general">G일반</a>
    <a href="#" class="main_menu" data-tab="review">R리뷰</a>
    <a href="#" class="main_menu" data-tab="qna">Q질문</a>
    <a href="#" style="display:none;">S스크랩</a>
    <div id="main_menu_focus"></div>
  </div>
</div>
  
  
<!-- 포스팅 내용 -->
<div id="all" class="tab_content current">

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
  
  
  
  <!-- post start -->
  <div class="post">
  
    <!-- post_header start -->
    <div class="post_header">
    
      <div class="post_header_thumb">
        <img class="tab_thumb" src="img/cate_r_s.png">
        <a href="user.jsp">
          <img class="user_thumb" src="img/profile01.jpg"/>
        </a>
      </div>
      
      <div class="post_info">
        <div class="post_auth"><a href="user.jsp">gagip</a></div>
        <div class="post_date">2019년 10월 2일</div>
      </div>
      
    </div>
    <!-- post_header end -->
    <!-- post_title start -->
    <div class="post_title">
      <a href="post.jsp">제약바이오 60초 영상공모전</a>
    </div>
    <!-- post_title end -->
    <!-- post_content start -->
    <div class="post_content">
      <div class="post_thumb_wrap">
        <div class="post_thumb"><a href="post.jsp"><img src="img/sample01.jpg"></a></div>
      </div>
      <a href="post.jsp">
        <p>
제약바이오 60초 영상공모전 <br>
1등 상금이 500만원?! <br>
...
        </p>
      </a>
    </div>
    <!-- post_content end -->
    <!-- post_footer start -->
    <div class="post_footer">
    
      <div class="post_footer_hashTag">
        <a class="hash" href="index.jsp#search">#제약바이오</a> 
        <a class="hash" href="index.jsp#search">#60초영상</a>
      </div>
      
      <div class="post_footer_subInfo">
        <div class="post_like_btn">
          <img src="img/noti_like_n_20.png">
          <span>2</span>
        </div>
        <div class="post_scrap_btn">
          <img src="img/noti_scrap_n_20.png">
          <span>5</span>
        </div>
      </div>
      
    </div>
    <!-- post_footer end -->
  </div>
  <!-- post end -->
  
  

</div>
<!-- 포스팅 내용 끝 -->

<div id="general" class="tab_content">

</div>

<div id="review" class="tab_content">

</div>

<div id="qna" class="tab_content">

</div>
