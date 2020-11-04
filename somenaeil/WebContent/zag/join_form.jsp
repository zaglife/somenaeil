<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<div id="join_form_wrap">

  <div id="join_form_title"><img src="img/logo_40.png"></div>

  <div id="join_form_open">
  
    <p class="join_form_tt">공개 정보</p>
    
    <p class="join_form_sub_tt">프로필 사진</p>
    <div id="join_form_pimg">
      <div id="join_form_pimg_back"><a href="#upload"><img src="img/setting_w_20.png"></a></div>
      <!-- input type file이 css 스타일링 적용이 잘 안됨, a태그로 대체 가능한지 여쭤보기 -->
      <a href="#upload" id="join_form_pimg_btn">업로드</a>
      <p class="join_form_exp jfe_pimg">*사진크기 - 최소 가로 500px, 세로 500px(jpg, png, gif 가능)</p>
    </div>
    
    <p class="join_form_sub_tt">닉네임</p>
    <input type="text" placeholder="nickname" class="jf_input jf_nick">
    <p class="join_form_exp jfe_nick">*한글 8자, 영문 16자 내외</p>

    <p class="join_form_sub_tt">프로필 한줄 소개 내용</p>
    <input type="text" placeholder="취업을 준비하는 사람들과 실무자간의 소통을 위한 SNS" class="jf_input jf_comment">
    <p class="join_form_exp jfe_comment1">*총 100byte 작성 가능 (한글 2btye, 영문 1byte)</p>
    <p class="join_form_exp jfe_comment2">(0/100)</p>
    
  </div>
  
  
  
  <div id="join_form_private">
  
    <p class="join_form_tt">개인 정보</p>
    
    <p class="join_form_sub_tt">이름<div id="jf_name_back"></div></p>
    <input type="text" placeholder="썸내일" class="jf_input jf_name">
    <p class="join_form_exp jfe_name">*이름 변경 불가</p>
    
    <p class="join_form_sub_tt">이메일<div id="jf_email_back"></div></p>
    <input type="text" placeholder="somenaeil" class="jf_input jf_email">
    <p id="jf_email_at">@</p>
    <select id="jf_email_addr">
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
    <a href="#veri" id="join_form_pimg_btn">인증메일</a>
    <p class="join_form_exp jfe_name">*이름 변경 불가</p>
    
  </div>

</div>

</body>
</html>