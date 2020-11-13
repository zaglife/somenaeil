<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />
<script>
var popCt= 1;

function postPopCt() {
	if(popCt == 1) {
		$('#post_pop_ct').removeClass('post_pop_hide');
		++popCt;
	}else if(popCt == 2) {
		$('#post_pop_ct').addClass('post_pop_hide');
		popCt= 1;
	}
}

var popGh= 1;

function postPopGh() {
	if(popGh == 1) {
		$('#post_pop_gh').removeClass('post_pop_hide');
		++popGh;
	}else if(popGh == 2) {
		$('#post_pop_gh').addClass('post_pop_hide');
		popGh= 1;
	}
}

var popVote= 1;

function postPopVote() {
	if(popVote == 1) {
		$('#post_pop_vote').removeClass('post_pop_hide');
		++popVote;
	}else if(popVote == 2) {
		$('#post_pop_vote').addClass('post_pop_hide');
		popVote= 1;
	}
}

var sc_temp= 1;

function showCode() {
	if(sc_temp == 1) {
		$('#post_code_cont').removeClass('post_code_hide');
		++sc_temp;
	}else if(sc_temp == 2) {
		$('#post_code_cont').addClass('post_code_hide');
		sc_temp= 1;
	}
}

var like_temp= 1;

function showlink() {
	if(like_temp == 1) {
		$('.post_link').addClass('post_link_hide');
		$('.post_mov').removeClass('post_mov_hide');
		++like_temp;
	}else if(like_temp == 2) {
		$('.post_link').removeClass('post_link_hide');
		
		like_temp= 1;
	}
}

var mov_temp= 1;

function showmov() {
	if(mov_temp == 1) {
		$('.post_mov').addClass('post_mov_hide');
		$('.post_link').removeClass('post_link_hide');
		++mov_temp;
	}else if(mov_temp == 2) {
		$('.post_mov').removeClass('post_mov_hide');
		
		mov_temp= 1;
	}
}

function post_cate(num) {
	if(num == 2){
		$('#post_hidden').removeClass('post_cate_hidden');
	}else{
		$('#post_hidden').addClass('post_cate_hidden');
	}	
}


 //새로운 태그 만드는 작업 중요 !
function more_hash() {
	 
	
			// 히든 박스에 있는 요소들 찾기
			var hidden_hash = $(".post_hash_hidden");
			if (hidden_hash[0] != undefined) {
				// 한 개씩 보여주기
				jQuery(hidden_hash[0]).removeClass("post_hash_hidden");
			} 
			
			
			if ($(".post_hash_hidden").length == 0) {
				$("#post_hashbt").remove();
			}
		}
		// 댓글 개수 확인 후 
		function check_hash() {
			if (jQuery(hidden_hash[0]).length == 0) {
				$(".post_hashbt").addClass("hash_btn");
			}
		}
		
		
</script>
</head>
<body>
<jsp:include page="top.jsp" />

<form method="post" action="write.post">
<input type="hidden" name="part" value="write">
<div id="post_wrap">
  
  <!-- 타이틀 시작  -->
  <div id="post_title">
    <input type="text" placeholder="제목">
  </div>
  <!--  타이틀 끝  -->
  
  <!--     <a href="#" onclick="cate_click()"></a> -->
  <!-- 카테고리 선택 시작 -->
  <div id="post_cont">
    <div class="post_cate" id="cate_g">
      <input type="radio" name="cate_btn" id="cate_g_btn" checked="checked">
      <label for="cate_g_btn" onclick="post_cate(1)"></label>
    </div>
    
    <div class="post_cate" id="cate_r">
      <input type="radio" name="cate_btn" id="cate_r_btn">
      <label for="cate_r_btn" onclick="post_cate(2)"></label>
    </div>
    
    <div class="post_cate" id="cate_q">
      <input type="radio" name="cate_btn" id="cate_q_btn">
      <label for="cate_q_btn" onclick="post_cate(1)"></label>
    </div>
    
    
<!--     <div class="post_cate" id="cate_r"> -->
<!--       <a href="#" onclick="cate_click2()"> -->

<!--       </a> -->
<!--     </div> -->
<!--     <div class="post_cate" id="cate_q"><a href="#" onclick="cate_click3()"><img src="img/cate_q_m.png" onclick="cate_click()"></a></div> -->
    <p>*카테고리 필수 선택 </p>
    <div id="post_cate_exp">
      <img src="img/post_q_20.png">
    </div>
    <div id='post_cate_exp_img'><img src="img/cate_exp_s.png"></div>
    
  </div>
  <!-- 카테고리 선택 끝 -->
  
  <!-- middle 시작-->
  <div id="post_mid">
    <div id="post_mid_top">
  	  <div class="post_tcate_part">
  	    <div class="post_tcate"><a href="#"><img src="img/post_b_20.png"></a></div>
  	    <div class="post_tcate"><a href="#"><img src="img/post_i_20.png"></a></div>
  	    <div class="post_tcate"><a href="#"><img src="img/post_u_20.png"></a></div>
  	    <div class="post_tcate"><a href="#"><img src="img/post_s_20.png"></a></div>
  	    <div class="post_tcate"><a href="#"><img src="img/post_c_20.png"></a></div>
  	  </div>
  	  <div class="post_tcate_part">
  	    <div class="post_file">
  	      <a href="#" onclick="showlink()"><img src="img/post_link_20.png"></a>
  	      <!-- 링크 기능 display none -->
  	      <div id="post_link_wrap" class="post_link">
  	      	<input type="text" placeholder="링크명" id='lk_text'>
  	        <input type="text" value="http://" id='lk'>
  	        <button id='lk_bt'>+</button>	       
  	      </div>
  	    </div>
  	    <div class="post_file"><a href="#"><img src="img/post_pic_20.png"></a></div>
  	    <div class="post_file">
  	      <a href="#" onclick="showmov()"><img src="img/post_vid_20.png"></a>
  	      <!-- 영상 embed 기능 display none -->
  	      <div id="post_embed_wrap" class="post_mov">	
  	      	<p id='post_embed_ti'>영상주소</p>
  	        <input type="text" value="http://" id='embed'>
  	        <button id='embed_bt'>+</button>	       
  	      </div>
  	    </div>
  	  </div>
  	  <div class="post_tcate_part post_cate_hidden" id="post_hidden">
  	    <div class="post_file"><a onclick="postPopCt()"><img src="img/post_table_20.png"></a></div>
  	    <div class="post_file"><a onclick="postPopGh()"><img src="img/post_graph_20.png"></a></div>
  	    <div class="post_file"><a onclick="postPopVote()"><img src="img/post_vote_20.png"></a></div>
  	    <div class="post_file"><a onclick="showCode()"><img src="img/post_code_20.png"></a></div>
      </div>
    </div>
    <div id="post_write">
      <p>글씨를 입력해주세요</p>
	
	  
	
	  <!-- text입력부분 소스코드 display none -->
	  <div id="post_code_cont" class="post_code_hide">
	    <div id="post_code_scroll">
        <div class="post_code_li">1</div>
	    <div class="post_code_li">2</div>
	    <div class="post_code_li">3</div>
	    <div class="post_code_li">4</div>
	    <div class="post_code_li">5</div>
	    <div class="post_code_li">6</div>
	    <div class="post_code_li">7</div>
	    <div class="post_code_li">8</div>
	    <div class="post_code_li">9</div>
	    <div class="post_code_li">10</div>
	    <div class="post_code_li">11</div>
	    <div class="post_code_li">12</div>
	    <div class="post_code_li">13</div>
	    <div class="post_code_li">14</div>
	    <div class="post_code_li">15</div>
	    </div>
	    <span class="post_code_li_last"></span>
	    
	  </div>
	
    </div>
  </div>
  
  
  <!-- 바텀 시작 -->
  <div id="post_bottom">
    <div id="post_btm_hash">
      <div class="post_hash"><input type="text" placeholder="#태그" name="hash"></div>
      <div class="post_hash"><input type="text" placeholder="#태그" name="hash"></div>
      <div class="post_hash"><input type="text" placeholder="#태그" name="hash"></div>
      <div class="post_hash post_hash_hidden"><input type="text" placeholder="#태그" name="hash"></div>
      <div class="post_hash post_hash_hidden"><input type="text" placeholder="#태그" name="hash"></div>
      <div id="post_hashbt" ><button id="hash_btn" type="button" onclick="more_hash();">추가</button></div>
    </div>

    <!-- 게시판 파일업로드 input start -->
    <div class="filebox"> 
      <label for="file">업로드</label> 
      <input type="file" id="file"> 
      <input class="upload-name" value="파일선택">
    </div>
    <!-- 게시판 파일업로드 input end -->

    <div id="post_send"><button>올리기</button></div>
  </div>  
  <!-- 바텀 끝 -->
</div>



<jsp:include page="popup_ct.jsp" />
<jsp:include page="popup_gh.jsp" />
<jsp:include page="popup_vote.jsp" />






<jsp:include page="totop.jsp" />

</form>
</body>
</html>