<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>some, 내일</title>

<jsp:include page="css.jsp" />

<script>
function pimg_show(event) {
	var reader = new FileReader();
	
	reader.onload = function(event) {
		var img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		img.setAttribute("class", "pimg_upload");
		document.querySelector("div#join_form_pimg_back").appendChild(img);

	};
	reader.readAsDataURL(event.target.files[0]);
}

$(function(){
	var pw_result = true;
	var id_result = true;
	var nick_result = true;
	
	$(".jfe_pw_match").hide();
	$(".jfe_pw_mismatch").hide();
	
	$(".jf_pw_check").keyup(function(){
		<%-- 비밀번호 비교 --%>
		pw_result = true;
		var pw1 = $(".jf_pw").val();
		var pw2 = $(".jf_pwc").val();
		
		if(pw1 != "" || pw2 != ""){
			if(pw1 == pw2){
				$(".jfe_pw_match").show();
				$(".jfe_pw_mismatch").hide();
				pw_result= true;
			}else{
				$(".jfe_pw_match").hide();
				$(".jfe_pw_mismatch").show();
				pw_result= false;
			}
		}
	});
	

	$(".jfe_id_match").hide();
	$(".jfe_id_mismatch").hide();
	
	$(".jf_id").keyup(function(){
		<%-- 아이디 비교 --%>
		id_result = true;
		var idCheck = $(".jf_id").val();
		var id_list = ${nick_list};
		
		
		for(var i=0; i<id_list.length; i++) {
			if(idCheck == id_list[i]) {
				id_result = false;
				break;
			}
		}
		
		if(id_result) {
			$(".jfe_id_match").show();
			$(".jfe_id_mismatch").hide();
		} else {
			$(".jfe_id_match").hide();
			$(".jfe_id_mismatch").show();
		}
	});
	
	
	$(".jfe_nick_match").hide();
	$(".jfe_nick_mismatch").hide();
	
	$(".jf_nick").keyup(function(){
		<%-- 닉네임 비교 --%>
		nick_result = true;
		var nickCheck = $(".jf_nick").val();
		var nick_list = ${nick_list};

		for(var i=0; i<nick_list.length; i++) {
			if(nickCheck == nick_list[i]) {
				nick_result = false;
				break;
			}
		}
		
		if(nick_result) {
			$(".jfe_nick_match").show();
			$(".jfe_nick_mismatch").hide();
		} else {
			$(".jfe_nick_match").hide();
			$(".jfe_nick_mismatch").show();
		}
	});
	
	$("#join_form_clear").click(function() {
		if($(".jf_name").val() == null || $(".jf_name").val() == "") {
			alert("이름를 확인하세요.");
			$(".jf_name").focus();
		} else if($(".jf_email").val() == null || $(".jf_email").val() == "") {
			alert("이메일을 확인하세요.");
			$(".jf_email").focus();
		} else if($(".jf_id").val() == null || $(".jf_id").val() == "") {
			alert("아이디를 확인하세요.");
			$(".jf_id").focus();
		} else if(	$(".jf_pw").val() == null ||
					$(".jf_pw").val() == "" ||
					$(".jf_pwc").val() == null ||
					$(".jf_pwc").val() == "" ||
					$(".jf_pw").val() != $(".jf_pwc").val()) {
			alert("비밀번호를 확인하세요.");
			$(".jf_pw").focus();
		} else if($(".jf_nick").val() == null || $(".jf_nick").val() == "" || nick_result == false) {
			alert("닉네임을 확인하세요.");
			$(".jf_nick").focus();
		} else {
			$("#joinForm").submit();
		}
	});
});



</script>

</head>
<body>

<form method="post" action="join.do?part=join" enctype="multipart/form-data" id="joinForm">
<input type="hidden" name="part" value="join">

<!-- 이메일 확인 cert, 프로필사진 pimg 작업 전 회원가입을 위한 hidden input -->
<input type="hidden" name="cert" value="1">


<div id="join_form_wrap">

  <div id="join_form_title"><img src="img/logo_40.png"></div>

  <div id="join_form_private">
  
    <p class="join_form_tt">개인 정보</p>
    
    <div class="join_form_sub_tt"><p>이름</p><div id="jf_name_back"></div></div>
    <input type="text" name="name" placeholder="썸내일" class="jf_input jf_name">
    <p class="join_form_exp jfe_name">*이름 변경 불가, 아이디 찾기시 필요</p>
    
    <p class="join_form_sub_tt">이메일<div id="jf_email_back"></div></p>
    <input type="text" name="email" placeholder="somenaeil" class="jf_input jf_email">
    <p id="jf_email_at">@</p>
    <select id="jf_email_addr" name="addr">
      <option>이메일</option>
      <option value="naver.com" selected>naver.com</option>
      <option value="gmail.com">gmail.com</option>
      <option value="daum.net">daum.net</option>
      <option value="hanmail.net">hanmail.net</option>
      <option value="nate.com">nate.com</option>
      <option value="empas.com">empas.com</option>
      <option value="yahoo.co.kr">yahoo.co.kr</option>
      <option value="hotmail.com">hotmail.com</option>
    </select>
    <a href="#veri" id="join_form_email_btn">인증메일</a>
    <p class="join_form_exp jfe_email">*이메일 주소로 수신된 링크 인증 필수</p>
    
    <div class="join_form_sub_tt"><p>아이디</p><div id="jf_id_back"></div></div>
    <input type="text" name="id" placeholder="id" class="jf_input jf_id">
    <p class="join_form_exp jfe_id">*아이디 변경 불가</p>
    <span class="jfe_id_mismatch">&lt;사용중인 아이디입니다&gt;</span>
    <span class="jfe_id_match">&lt;사용가능한 아이디입니다&gt;</span>
    
    <p class="join_form_sub_tt">비밀번호</p>
    <input type="password" name="pw" placeholder="비밀번호" class="jf_input jf_pw jf_pw_check">
    <input type="password" placeholder="비밀번호 확인" class="jf_input jf_pwc jf_pw_check">
    <span class="jfe_pw_mismatch">&lt;비밀번호가 맞지 않습니다&gt;</span>
    <span class="jfe_pw_match">&lt;비밀번호가 일치합니다&gt;</span>
    <p class="join_form_exp jfe_pw">*영문, 숫자 조합 8글자 이상</p>
    
  </div>
  
  <div id="join_form_open">
  
    <p class="join_form_tt">공개 정보</p>
    
    <p class="join_form_sub_tt">프로필 사진</p>
    <div id="join_form_pimg">
      <div id="join_form_pimg_back"><label id="join_form_pimg_btn2" for="pimg"><img src="img/setting_w_20.png"></label></div>
      <input type="file" name="pimg" id="pimg" onchange="pimg_show(event)">
      <label id="join_form_pimg_btn" for="pimg">업로드</label>
      <p class="join_form_exp jfe_pimg">*사진크기 - 최소 가로 500px, 세로 500px(jpg, png, gif 가능)</p>
    </div>
    
    <p class="join_form_sub_tt">닉네임</p>
    <input type="text" name="nick" placeholder="nickname" class="jf_input jf_nick">
    <p class="join_form_exp jfe_nick">*한글 8자, 영문 16자 내외</p>
    <p class="join_form_exp jfe_nick_mismatch">&lt;사용중인 닉네임입니다&gt;</p>
    <p class="join_form_exp jfe_nick_match">&lt;사용가능한 닉네임입니다&gt;</p>

    <p class="join_form_sub_tt">프로필 한줄 소개 내용</p>
    <input type="text" name="comt" placeholder="취업을 준비하는 사람들과 실무자간의 소통을 위한 SNS" class="jf_input jf_comment">
    <p class="join_form_exp jfe_comment1">*총 100byte 작성 가능 (한글 2btye, 영문 1byte)</p>
    <p class="join_form_exp jfe_comment2">(0/100)</p>
    
  </div>
  
  <div id="join_form_end">
    <a href="index.jsp" id="join_form_cancle">취소</a>
    <input type="button" id="join_form_clear" value="회원가입">
  </div>

</div>
</form>

</body>
</html>