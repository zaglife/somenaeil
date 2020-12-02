<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<% request.setCharacterEncoding("UTF-8"); %>

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
							<span class="dm"> <a href="dm.some?part=view&toid=${post.id }&tonick=${post.nick}"><img src="img/icon_dm_20.png"></a></span>
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
			<div id="article_footer">
			<c:if test="${replyList != null}">
				<div class="article_comment">
					<!-- 댓글 5개 보여주기 -->
					<c:forEach items="${replyList}" var="reply" varStatus="cur" end="4">
						<div class="comment_id"><a href="user.jsp">${reply.author}</a></div>
						<div class="comment_context">${reply.context}</div>
					</c:forEach>
					
					
					<!-- more comment -->
					<div class="comment_hidden">
						<c:forEach items="${replyList}" var="reply" varStatus="cur" begin="5">
							<div class="comment_id"><a href="user.jsp">${reply.author}</a></div>
							<div class="comment_context">${reply.context}</div>
						</c:forEach>
					</div>
				</div>
					
				<!-- 추가 댓글 보기 버튼 -->
				<div class="btn_more_comment">
					<a><img src="img/btn_more_20.png" onclick="more_comment();"></a>
				</div>
			</c:if>

			<!-- 댓글 작성 -->
			<div class="input_comment">
				<form action="reply.post" method="post" name="comment_form" accept-charset="UTF-8">
				<input type="hidden" name="part" value="reply">
				<input type="hidden" name="author" value="${user.nick}">
				<input type="hidden" name="post_num" value="${post.num}">
				<div class="comment_id">${user.nick}</div>
				<input class="comment_context" type="text" name="context" placeholder="댓글을 입력하세요"
								required maxlength="400">
				<input class="comment_send" type="image" src="img/icon_send_20.png" alt="댓글입력"
								onclick="writeCmt();">
				</form>
			</div>
		</div>
	</div>
</div>
	
	
<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />

<script src="lib/js/post.js"></script>
</body>