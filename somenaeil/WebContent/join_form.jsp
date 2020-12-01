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
	$(".jf_pw_correct").hide();
	$(".jf_pw_incorrect").hide();
	
	$("input").keyup(function(){
		var pw1=$(".jf_pw").val();
		var pw2=$(".jf_pwc").val();
		if(pw1 != "" || pw2 != ""){
			if(pw1 == pw2){
				$(".jf_pw_correct").show();
				$(".jf_pw_incorrect").hide();
			}else{
				$(".jf_pw_correct").hide();
				$(".jf_pw_incorrect").show();
			}
		}
	});
});

</script>

</head>
<body>

<form method="post" action="join.do?part=join" enctype="multipart/form-data">
<input type="hidden" name="part" value="join">

<!-- 이메일 확인 cert, 프로필사진 pimg 작업 전 회원가입을 위한 hidden input -->
<input type="hidden" name="cert" value="1">


<div id="join_form_wrap">

  <div id="join_form_title"><img src="img/logo_40.png"></div>

  <div id="join_form_private">
  
    <p class="join_form_tt">개인 정보</p>
    
    <div class="join_form_sub_tt"><p>이름</p><div id="jf_name_back"></div></div>
    <input type="text" name="name" placeholder="썸내일" class="jf_input jf_name">
    <p class="join_form_exp jfe_name">*이름 변경 불가, 아이디찾기시 필요</p>
    
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
    
    <p class="join_form_sub_tt">비밀번호</p>
    <input type="password" name="pw" placeholder="비밀번호" class="jf_input jf_pw">
    <input type="password" placeholder="비밀번호 확인" class="jf_input jf_pwc">
    <span class="jf_pw_incorrect">&lt;비밀번호가 맞지 않습니다&gt;</span>
    <span class="jf_pw_correct">&lt;비밀번호가 일치합니다&gt;</span>
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
    <p class="join_form_exp jfe_nick_match">&lt;사용중인 닉네임입니다&gt;</p>

    <p class="join_form_sub_tt">프로필 한줄 소개 내용</p>
    <input type="text" name="comt" placeholder="취업을 준비하는 사람들과 실무자간의 소통을 위한 SNS" class="jf_input jf_comment">
    <p class="join_form_exp jfe_comment1">*총 100byte 작성 가능 (한글 2btye, 영문 1byte)</p>
    <p class="join_form_exp jfe_comment2">(0/100)</p>
    
  </div>
  
  <div id="join_form_end">
    <a href="index.jsp" id="join_form_cancle">취소</a>
    <button id="join_form_clear">회원가입</button>
  </div>

</div>
</form>

</body>
</html>