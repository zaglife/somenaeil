<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" type='text/css' href="lib/id_pw_ser.css">
<link rel="stylesheet" type='text/css' href="lib/font.css">
</head>
<body>
   <div class="main">
     <div id="ser_top">
       <div id="id_pw"> <input type="button" id="id_ser" value="아이디찾기">
                        <input type="button" id="pw_ser" value="비밀번호찾기">
       </div>
     </div>
     <div id="ser_body">
       <div id="ser_id">아이디 <input type='text' id="name_te_pw" placeholder="somenaeil"></div>
       <div id="ser_mail_pw">이메일 주소 <input type='text' id="mail_te_pw" placeholder="예)id@somenaeil.net">
                     <input type="button" id="mail_in" value="메일 확인"></div>
        <div id="ser_bt">
          	<p id="bt_te1">회원가입시 입력한 이메일 인증 필요</p>
            <p id="bt_te2">메일 확인 버튼을 누르시면 입력하신 이메일 주소로 임시 비밀번호가 전송됩니다.</p>
            <p id="bt_te3">로그인후 비밀번호를 꼭 변경해주세요.</p>
        </div>
     </div>
   </div>

</body>
</html>