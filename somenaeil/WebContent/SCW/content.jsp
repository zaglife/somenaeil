<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	.post {
		display: flex;
		flex-direction: column;
		
		flex: 1 0 500px;
		width: 500px; height: 500px;
		margin: 15px; padding: 15px;
		
		border: 1px solid black;
		box-sizing: border-box;
		border-radius: 40px 40px;
	}
	
	.use_img {
		
	}
	/* post_tab*/
	.tab_content {
		height: 50px;
		border: 1px solid black;
	} 
	
	/* post */
	.post_profile {
		display: flex;
		flex-direction: row;
		flex: 1;
	}
	
	.user_thumb {
		width: 15%; height: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.user_thumb img {
		border-radius: 50%;
		width: 70px;
	}
	
	.post_info {
		display: flex;
		flex-direction: column;
		justify-content: center;
		
		width: 85%; height: 100%;
	}
	
	.post_auth {
		font-size: 20pt;
		font-weight: bold;
	}
	
	.post_date {
		font-size: 12pt;
	}
	
	.post_title {
		display: table;
		height: 80px;
		flex: 1 0;
	}
	
	.post_title a {
		display: table-cell;
		text-align: center;
		vertical-align: middle;
		
		font-size: 30pt; font-weight: bold;
	}
	
	.post_content {
		display: flex;
		
		justify-content: center;
		align-items: center;
		
		flex: 3 0 100px;
	}
	.post_content p {
		text-align: center;
		font-size: 17pt;
	}
	
	.post_footer {
		display: flex;
		
		flex: 0.5 0;
	}
	
	.post_footer_hashTag {
		flex: 4;
	}
	
	.hash {
		margin: 0 10px;
	}
	
	.post_footer_subInfo {
		flex: 1;
		
		margin: 0 auto;
		text-align: center;
	}

</style>

<!-- 분류 탭  https://hkhub.tistory.com/43 -->
<div id="tab_content">
	<input type="radio" name="tabmenu" id="all" checked>
	<label for="all">All</label>
	<input type="radio" name="tabmenu" id="general">
	<label for="general">General</label>
	<input type="radio" name="tabmenu" id="review">
	<label for="review">Review</label>
	<input type="radio" name="tabmenu" id="qna">
	<label for="qna">QnA</label>

<!-- 포스팅 내용 -->
<div class="post p_all">
	<article class="post">
		<header class="post_profile">
			<div class="user_thumb"><a href="#"><img class="user_" src="${pageContext.request.contextPath}/main/img/profile01.jpg"/></a></div>
			<div class="post_info">
				<div class="post_auth"><a href="#">gagip</a></div>
				<div class="post_date">2019년 10월 2일</div>
			</div>
		</header>
		<div class="post_title"><a href="#">제약바이오 60초 영상공모전</a></div>
		<div class="post_content">
			<p>
			제약바이오 60초 영상공모전 <br>
			1등 상금이 500만원?! <br>
			참가자격은 누구나 <br>
			지원 가능한거 같은데요?? <br>
			60초 안에 영상컨텐츠도 <br>
			...
			</p>
		</div>
		<div class="post_footer">
			<div class="post_footer_hashTag">
				<a class="hash" href="#">#제약바이오</a> 
				<a class="hash" href="#">#60초영상</a>
			</div>
			<div class="post_footer_subInfo">
				댓글: 1  스크랩: 5
			</div>
		</div>
	</article>
	<article class="post use_img"></article>
	<article class="post use_img"></article>
	<article class="post"></article>
</div>
<div class="post p_general"></div>
<div class="post p_review"></div>
<div class="post p_qna"></div>
</div>
