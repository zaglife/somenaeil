<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.member.member" %>
<%@page import="com.member.member_dao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body>

<c:choose>
	<%-- 로그인한 상태에서만 이용 가능 --%>
	<c:when test="${sessionId == null}">
	<script type="text/javascript">
		alert("로그인 상태에서만 가능합니다.");
		location.href = window.history.back();	// 뒤로가기
	</script>
	</c:when>
	
	<%-- 이전에 입력한 내용 출력 --%>
	<c:otherwise>
	
	<c:set var="user" value="${sessionUser}"/>
	
	<form method="post" action="join.do">
	<input type="hidden" name="part" value="update">

	<!-- 이메일 확인 cert, 프로필사진 pimg 작업 전 회원가입을 위한 hidden input -->
	<input type="hidden" name="pimg" value="null">
	<input type="hidden" name="cert" value="1">

	<div id="join_form_wrap">

  <div id="join_form_private">
  
    <p class="join_form_tt">개인 정보</p>
    
    <div class="join_form_sub_tt"><p>이름</p><div id="jf_name_back"></div></div>
    <input type="text" readonly value="${user.name}" class="jf_input jf_name">
    <p class="join_form_exp jfe_name">*이름 변경 불가</p>
    
    <p class="join_form_sub_tt">이메일<div id="jf_email_back"></div></p>
    <input type="text" name="email" value='${fn:substringBefore(user.email, "@")}' placeholder="" class="jf_input jf_email">
    <p id="jf_email_at">@</p>
    <select id="jf_email_addr" name="addr">
      <option>이메일</option>
      <option value="naver.com">naver.com</option>
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
    <input type="text" name="id" readonly value="${user.id}" class="jf_input jf_id">
    <p class="join_form_exp jfe_id">*아이디 변경 불가</p>
    
    <p class="join_form_sub_tt">비밀번호</p>
    <p class="join_form_exp jfe_edit_pw">*영문, 숫자 조합 8글자 이상</p>
    <div id="jf_edit_wrap">
      <input type="password" name="pw" placeholder="현재 비밀번호" class="jf_input jf_edit_pwo">
      <p>&gt;</p>
      <input type="password" name="newPw" placeholder="변경할 비밀번호" class="jf_input jf_edit_pw">
      <input type="password" placeholder="비밀번호 확인" class="jf_input jf_edit_pwc">
      <span class="jf_edit_pw_incorrect">&lt;비밀번호가 맞지 않습니다&gt;</span>
      <span class="jf_edit_pw_correct">&lt;비밀번호가 일치합니다&gt;</span>
    </div>

  </div>
  
  
  
  <div id="join_form_open">
  
    <p class="join_form_tt">공개 정보</p>
    
    <p class="join_form_sub_tt">프로필 사진</p>
    <div id="join_form_pimg">
      <img id="join_form_pimg_edit" src="pimg/${user.pimg}" onerror="this.src='pimg/pimg_none.jpg'">
      <div id="join_form_pimg_back"><a href="#upload" class="setting_btn_center"><img src="img/setting_w_20.png"></a></div>
      <!-- input type file이 css 스타일링 적용이 잘 안됨, a태그로 대체 가능한지 여쭤보기 -->
      <a href="#upload" id="join_form_pimg_btn">업로드</a>
      <p class="join_form_exp jfe_pimg">*사진크기 - 최소 가로 500px, 세로 500px(jpg, png, gif 가능)</p>
    </div>
    
    <p class="join_form_sub_tt">닉네임</p>
    <input type="text" name="nick" value="${user.nick}" placeholder="nickname" class="jf_input jf_nick">
    <p class="join_form_exp jfe_nick">*한글 8자, 영문 16자 내외</p>

    <p class="join_form_sub_tt">프로필 한줄 소개 내용</p>
    <input type="text" name="comt" value="${user.comt}" placeholder="취업을 준비하는 사람들과 실무자간의 소통을 위한 SNS" class="jf_input jf_comment">
    <p class="join_form_exp jfe_comment1">*총 100byte 작성 가능 (한글 2btye, 영문 1byte)</p>
    <p class="join_form_exp jfe_comment2">(0/100)</p>
    
  </div>
  
  <div id="join_form_end">
    <button id="join_form_cancle" onclick="pre()">취소</button>
    <button id="join_form_clear">수정</button>
  </div>

</div>
</form>
	
	</c:otherwise>
</c:choose>



<jsp:include page="top.jsp" />
<jsp:include page="bottom.jsp" />
<jsp:include page="totop.jsp" />
<jsp:include page="nav.jsp" />


<script>
window.onload = function(){
  setMailAddr('${fn:substringAfter(user.email, "@")}');
}

// 이전에 입력한 email 주소와 options 값 매칭
function setMailAddr(val) {
  var selectMail = document.getElementById("jf_email_addr");
  for (i = 0, j = selectMail.length; i<j; i ++){
    if (selectMail.options[i].value == val) {
      selectMail.options[i].selected = true;
    }
  }
}
</script>

</body>
</html>