<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>some, 내일</title>
<link rel='stylesheet' href='lib/post_main.css'>
<link rel='stylesheet' href='lib/popup.css'>
<link rel='stylesheet' href='lib/somenaeil_fonts.css'>

<script type="text/javascript">
// 게시판 파일업로드 input
/*
$(document).ready(function(){ 
	var fileTarget = $('#file'); 
	fileTarget.on('change', function(){ // 값이 변경되면
		var cur=$(".filebox input[type='file']").val();
		$(".upload-name").val(cur);
	}); 
});
*/
</script>

</head>
<body>

<div id="post_wrap">
  
  <!-- 타이틀 시작  -->
  <div id="post_title">
  title
  </div>
  <!--  타이틀 끝  -->
  
  <!-- 카테고리 선택 시작 -->
  <div id="post_cont">
    <div class="post_cate"><a href="#"><img src="img/cate_g_m.png"></a></div>
    <div class="post_cate"><a href="#"><img src="img/cate_r_m.png"></a></div>
    <div class="post_cate"><a href="#"><img src="img/cate_q_m.png"></a></div>
    <div id="post_cate_exp">*카테고리 필수 선택 <img src="img/post_q_20.png"></div>
  </div>
  <!-- 카테고리 선택 끝 -->
  
  <!-- middle 시작-->
  <div id="post_mid">
    <div id="post_mid_top">
  	  <div class="post_tcate_part">
  	    <div class="post_tcate tcate_b"><a href="#"><img src="img/post_b_20.png"></a></div>
  	    <div class="post_tcate tcate_i"><a href="#"><img src="img/post_i_20.png"></a></div>
  	    <div class="post_tcate tcate_u"><a href="#"><img src="img/post_u_20.png"></a></div>
  	    <div class="post_tcate tcate_s"><a href="#"><img src="img/post_s_20.png"></a></div>
  	    <div class="post_tcate tcate_c"><a href="#"><img src="img/post_c_20.png"></a></div>
  	  </div>
  	  <div class="post_tcate_part tcate_side">
  	    <div class="post_file">
  	      <a href="#"><img src="img/post_link_20.png"></a>
  	      <!-- 링크 기능 display none -->
  	      <div id="post_link_wrap">	
  	      	<input type="text" value="링크명" id='lk_text'>
  	        <input type="text" value="http://" id='lk'>
  	        <button id='lk_bt'>+</button>	       
  	      </div>
  	    </div>
  	    <div class="post_file"><a href="#"><img src="img/post_pic_20.png"></a></div>
  	    <div class="post_file">
  	      <a href="#"><img src="img/post_vid_20.png"></a>
  	      <!-- 영상 embed 기능 display none -->
  	      <div id="post_embed_wrap">	
  	      	<p id='post_embed_ti'>영상주소</p>
  	        <input type="text" value="http://" id='embed'>
  	        <button id='embed_bt'>+</button>	       
  	      </div>
  	    </div>
  	    <div class="post_file"><a href="#"><img src="img/Untitled-5.png"></a></div>
  	  </div>
  	  <div class="post_tcate_part">
  	    <div class="post_file"><a href="#"><img src="img/post_table_20.png"></a></div>
  	    <div class="post_file"><a href="#"><img src="img/post_graph_20.png"></a></div>
  	    <div class="post_file"><a href="#"><img src="img/post_vote_20.png"></a></div>
  	    <div class="post_file"><a href="#"><img src="img/post_code_20.png"></a></div>
      </div>
    </div>
    <div id="post_write">
      <p>글씨를 입력해주세요</p>
	
	  
	
	  <!-- 영상 embed 기능 display none -->
	  <div id="post_code_cont">
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
	
    </div>
  </div>
  
  
  <!-- 바텀 시작 -->
  <div id="post_bottom">
    <div id="post_btm_hash">
      <div class="post_hash"><input type="text" placeholder="#태그"></div>
      <div class="post_hash"><input type="text" placeholder="#태그"></div>
      <div class="post_hash"><input type="text" placeholder="#태그"></div>
      <div id="post_hashbt"><button>추가</button></div>
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



<jsp:include page="popup_vote.jsp"/>
<!--jsp:include page="popup_ct.jsp"/-->
<!--jsp:include page="popup_gh.jsp" /-->
<!--jsp:include page="popup_vote.jsp" /-->

</body>
</html>