<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${post.title}</title>
	<jsp:include page="css.jsp" />
</head>

<body>
	<!-- 포스팅 내용 -->
	<div class="article_wrap">
		<div class="article">
			<!-- header -->
			<div class="article_header">
				<div class="article_header_thumb">
					<a href="user.jsp">
						<img class="article_tab_thumb" src="img/cate_a_m.png">
						<img class="article_user_thumb" src="img/profile01.jpg" />
					</a>
				</div>
				<div class="article_info">
					<div class="article_title">
						${post.title}
					</div>
					<div class="article_subinfo1">
						<div class="article_auth">
							<span class="user_id"><a href="user.jsp">${post.nick}</a></span>
							<span class="follow"> <img src="img/noti_follow_n_20.png"> </span>
							<span class="dm"> <a href="dm.jsp"><img src="img/icon_dm_20.png"></a></span>
						</div>
						<div class="article_icon">
							<span class="like">
								<img src="img/noti_like_n_20.png"> <span>${post.like_cnt}</span>
							</span>
							<span class="scrap">
								<img src="img/noti_scrap_n_20.png"><span>${post.scrap_cnt}</span>
							</span>
						</div>
					</div>
					<div class="article_subinfo2">
						<div class="article_follow_info">
							<span class="user_follower">팔로워 <span>126</span></span> 
							<span class="uesr_follow">팔로우 <span>98</span></span>

						</div>
						<div class="article_date">${post.time}</div>
					</div>
				</div>
			</div>
			<!-- content (글, 이미지, 해시태그)-->
			<div class="article_content">
			
				${post.context}

				<div class="article_hashTag">
					<c:forTokens items="${post.hash}" var="hash" delims=",">
						<a class="hash" href="index.jsp#search">#${hash}</a>
					</c:forTokens>
				</div>
				
			</div>
			<!-- footer (댓글) -->
			<div class="article_footer">
				<div class="article_comment">
					<div class="comment_id"><a href="user.jsp">gggg</a></div>
					<div class="comment_context">좋은 정보 감사합니다</div>
					<div class="comment_id"><a href="user.jsp">asdfsgdf</a></div>
					<div class="comment_context">공모전 공고는 어디서 확인할 수 있나요?</div>
					<div class="comment_id"><a href="user.jsp">soalx</a></div>
					<div class="comment_context">안녕하세요. 인사 남깁니다. 잘 보고가요</div>
					<div class="comment_id"><a href="user.jsp">asdfsgdf</a></div>
					<div class="comment_context">제약바이오 제가 관심있는 회사였는데ㅠㅠ</div>
					<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
					<div class="comment_context">감사합니다</div>

					<!-- more comment -->
					<div class="comment_hidden">
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
						<div class="comment_id"><a href="user.jsp">gkvw426</a></div>
						<div class="comment_context">감사합니다</div>
					</div>
				</div>
				<div class="btn_more_comment">
					<a><img src="img/btn_more_20.png" onclick="more_comment();"></a>
				</div>
				<div class="input_comment">
					<div class="comment_id">${post.nick}</div>
					<input class="comment_context" type="text" placeholder="댓글을 입력하세요">
					<input class="comment_send" type="image" src="img/icon_send_20.png" alt="댓글입력">
				</div>
			</div>
		</div>
	</div>
	
	
	<jsp:include page="top.jsp" />
	<jsp:include page="totop.jsp" />
	<jsp:include page="nav.jsp" />
	
	<script src="lib/js/content.js"></script>
</body>