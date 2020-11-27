<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>
<link rel="stylesheet" href="lib/popup.css">
<jsp:include page="css.jsp" />
<script type="text/javascript" src="post_main.js"></script>
</head>
<body>

<jsp:include page="top.jsp" />

<c:choose>
	<c:when test="${part== 'q' && part== 'a'}">
	<script>
		alert("qweqweqwe");
		$('#post_hidden').addClass('post_cate_hidden');
		var x = document.getElementById("cate_g_btn");
		x.style.checked = "checked";        
	</script>
	</c:when>
	<c:when test="${part== 'r'}">
	<script>
		$('#post_hidden').removeClass('post_cate_hidden');
		var x = document.getElementById("cate_r_btn");
		x.style.checked = "checked";        
	</script>
	</c:when>
</c:choose>





<form id="form" method="post" action="write.post?part=writer" onsubmit="return false" enctype="multipart/form-data">

<input id="context" type="hidden" name="context" value="s">
<div id="post_wrap">
  
  <!-- 타이틀 시작  -->
  <div id="post_title">
    <input type="text" placeholder="제목" name="title">
  </div>
  <!--  타이틀 끝  -->
  
  <!--     <a href="#" onclick="cate_click()"></a> -->
  <!-- 카테고리 선택 시작 -->
  <div id="post_cont">
    <div class="post_cate" id="cate_g">
      <input type="radio" name="cate_btn" id="cate_g_btn" checked="checked" value="G">
      <label for="cate_g_btn" onclick="post_cate(1)"></label>
    </div>
    
    <div class="post_cate" id="cate_r">
      <input type="radio" name="cate_btn" id="cate_r_btn" value="R">
      <label for="cate_r_btn" onclick="post_cate(2)"></label>
    </div>
    
    <div class="post_cate" id="cate_q">
      <input type="radio" name="cate_btn" id="cate_q_btn" value="Q">
      <label for="cate_q_btn" onclick="post_cate(1)"></label>
    </div>
    <p>*카테고리 필수 선택 </p>
    <div id="post_cate_exp" onclick="enter()">
      <img src="img/post_q_20.png">
    </div>
    <div id='post_cate_exp_img'><img src="img/cate_exp_s.png"></div>
    
  </div>
  <!-- 카테고리 선택 끝 -->
  
  <!-- middle 시작-->
  <div id="post_mid">
    <div id="post_mid_top">
  	  <div class="post_tcate_part">
  	    <div class="post_tcate"><button id="post_bold" class="post_func_btn" onclick="document.execCommand('bold')"><img src="img/post_b_20.png"></button></div>
  	    <div class="post_tcate"><button id="post_italic" class="post_func_btn"onclick="document.execCommand('italic')"><img src="img/post_i_20.png"></button></div>
  	    <div class="post_tcate"><button id="post_underline" type="button" class="post_func_btn"onclick="document.execCommand('underline')"><img src="img/post_u_20.png"></button></div>
  	    <div class="post_tcate"><button id="post_strike" type="button" class="post_func_btn"onclick="document.execCommand('strikeThrough')"><img src="img/post_s_20.png"></button></div>
  	    <div class="post_tcate post_color_space"><button id="post_color" type="button" class="post_func_btn" onclick="document.execCommand('color')"><img src="img/post_c_20.png"></button></div>
  	    <div id="post_color_picker">
  	      <input type="color" name="color" id="foreColor">
  	    </div>
  	  </div>
  	  <div class="post_tcate_part">
  	    <div class="post_file">
  	      <a href="#" onclick="showlink()"><img src="img/post_link_20.png"></a>
  	      <!-- 링크 기능 display none -->
  	      <div id="post_link_wrap" class="post_link">
  	      	<input type="text" placeholder="링크명" id='lk_text'>
  	        <input type="text" value="http://" id='lk'>
  	        <button id='lk_bt' type="button" onclick="lk_bt_input()">+</button>
  	      </div>
  	    </div>
  	    <div class="post_file" id="file_s">
  	      <input type="button" name="img_file" id="img_file" onclick="file_upload()">
  	     <input type="file" id="file1" name="file1" onchange='add_img()' class=hidden_file>
		 <input type="file" id="file2" name="file2" onchange='add_img()' class=hidden_file>
		 <input type="file" id="file3" name="file3" onchange='add_img()' class=hidden_file>
		 <input type="file" id="file4" name="file4" onchange='add_img()' class=hidden_file>
		 <input type="file" id="file5" name="file5" onchange='add_img()' class=hidden_file>		
  	    </div>
  	    <div class="post_file">
  	      <a href="#" onclick="showmov()"><img src="img/post_vid_20.png"></a>
  	      <!-- 영상 embed 기능 display none -->
  	      <div id="post_embed_wrap" class="post_mov">
  	        <input type="hidden" id="post_em">	
  	      	<p id='post_embed_ti'>영상주소</p>
  	        <input type="text" value="http://" id='embed'>
  	        <button id='embed_bt' type="button" onclick="em_bt_input()">+</button>	       
  	      </div>
  	    </div>
  	  </div>
  	  <div class="post_tcate_part post_cate_hidden" id="post_hidden">
  	    <div class="post_file"><a onclick="postPopCt()"><img src="img/post_table_20.png"></a></div>
  	    <div class="post_file"><a onclick="postPopGh()"><img src="img/post_graph_20.png"></a></div>
  	    <div class="post_file"><a onclick="postPopVote()"><img src="img/post_vote_20.png"></a></div>
  	    <div class="post_file"><button id="pd" type="button" onclick="post_code()" class="post_func_btn"><img src="img/post_code_20.png"></button></div>
      </div>
    </div>
    <div id="post_write" contenteditable="true">
	  <div id="post_write1" contenteditable="true"></div>
	  <!-- text입력부분 소스코드 display none -->
	
    </div>
  </div>
  
  
  <!-- 바텀 시작 -->
  <div id="post_bottom">
    <div id="post_btm_hash">
      <div class="post_hash"><input type="text" placeholder="#태그" name="hash"></div>
      <div class="post_hash"><input type="text" placeholder="#태그" name="hash"></div>
      <div class="post_hash"><input type="text" placeholder="#태그" name="hash"></div>
      
     
    </div>
	 <div id="post_hashbt" ><button id="hash_btn" type="button" onclick="more_hash();">추가</button></div>
    <!-- 게시판 파일업로드 input start -->
    <div class="filebox"> 
      <label for="file">업로드</label> 
      <input type="file" id="files"> 
      <input class="upload-name" value="파일선택">
    </div>
    <!-- 게시판 파일업로드 input end -->

    <div id="post_send"><button onclick="submit2();">올리기</button></div>
  </div>  
  <!-- 바텀 끝 -->
</div>



<jsp:include page="popup_ct.jsp" />
<jsp:include page="popup_gh.jsp" />
<jsp:include page="popup_vote.jsp" />




<script>
$(function() {
	$(".basic").spectrum({
		flat: false,
		showInput: true,
		preferredFormat: "rgb",
		color: "#000000"
	});
});
</script>


<jsp:include page="totop.jsp" />

</form>

</body>
</html>