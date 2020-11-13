<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>제약바이오 60초 영상공모전</title>
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
						제약바이오 60초 영상공모전
					</div>
					<div class="article_subinfo1">
						<div class="article_auth">
							<span class="user_id"><a href="user.jsp">gagip</a></span>
							<span class="follow"> <img src="img/noti_follow_n_20.png"> </span>
							<span class="dm"> <a href="dm.jsp"><img src="img/icon_dm_20.png"></a></span>
						</div>
						<div class="article_icon">
							<span class="like">
								<img src="img/noti_like_n_20.png"> <span>1</span>
							</span>
							<span class="scrap">
								<img src="img/noti_scrap_n_20.png"><span>5</span>
							</span>
						</div>
					</div>
					<div class="article_subinfo2">
						<div class="article_follow_info">
							<span class="user_follower">팔로워 <span>126</span></span> 
							<span class="uesr_follow">팔로우 <span>98</span></span>

						</div>
						<div class="article_date">2019년 10월 2일</div>
					</div>
				</div>
			</div>
			<!-- content (글, 이미지, 해시태그)-->
			<div class="article_content">
				<p>
					제약바이오 60초 영상공모전 <br>
					1등 상금이 500만원?! <br>
					참가자격은 누구나 <br>
					지원 가능한거 같은데요?? <br>
					60초 안에 영상컨텐츠도 <br>
					...
				</p>
				<img src="img/profile04.jpg">
				<div class="article_hashTag">
					<a class="hash" href="index.jsp#search">#제약바이오</a>
					<a class="hash" href="index.jsp#search">#60초영상</a>
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
					<div class="comment_id">gagip</div>
					<input class="comment_context" type="text" placeholder="댓글을 입력하세요">
					<input class="comment_send" type="image" src="img/icon_send_20.png" alt="댓글입력">
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	<!-- js script -->
	<script>
		var origin_hidden_comment = $(".comment_hidden");

		// 더 많은 댓글 보여주기
		function more_comment() {
			// 히든 박스에 있는 요소들 찾기
			var parent = $(".comment_hidden").parent();									// visualable comment box
			var c_id = $(".comment_hidden > .comment_id");							
			var c_context = $(".comment_hidden > .comment_context");		 
			
			// 5개씩 댓글 추가로 보여주기
			for (var i=0; i<5; i++) {
				if (i >= c_id.length) break;
				
				parent.append(c_id[i]);
				parent.append(c_context[i]);
			}
			check_comment();
		}
		
		// 
		function check_comment() {
			if ($(".comment_hidden > .comment_id").length == 0) {
				$(".btn_more_comment").addClass("btn_rotate");		// + => x
				// 버튼에 닫기 기능 추가
			}
		}
		
		// 아이콘 이미지 리소스
		var follow_icon = {
			active: "img/noti_follow_n_20.png",
			deactive: "img/noti_follow_20.png"
		}

		var like_icon = {
			active: "img/noti_like_20.png",
			deactive: "img/noti_like_n_20.png"
		};
		
		var scrap_icon = {
			active: "img/noti_scrap_20.png",
			deactive: "img/noti_scrap_n_20.png"
		};

		function click_icon(type, target) {
			var src = $(target).attr("src");
			var cnt = Number($(type+" span").text());
			// 이미지 리소스
			var resource = (type == ".like") ? like_icon : 
											(type == ".scrap") ? scrap_icon :
											(type == ".follow") ? follow_icon : null;
			
			if (src == resource.active) {
				$(target).attr("src", resource.deactive);
				$(type+" span").text(cnt-1);
			}
			else {
				$(target).attr("src", resource.active);
				$(type+" span").text(cnt+1);
			}
		}

		$(".like>img").on("click", function() {
			click_icon(".like", this);
		})

		$(".scrap>img").on("click", function() {
			click_icon(".scrap", this);
		})

		$(".follow>img").on("click", function() {
			click_icon(".follow", this);
		})

		$().ready(function(){
			origin_hidden_comment = $(".hidden_comment");
			$(".comment_hidden").hide();
			check_comment();
		})
	</script>
	
	
	<jsp:include page="top.jsp" />
	<jsp:include page="totop.jsp" />
	<jsp:include page="nav.jsp" />
	
</body>