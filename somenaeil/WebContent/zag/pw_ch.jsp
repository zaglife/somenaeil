<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type='text/css' href="lib/pw_ch.css">
<link rel="stylesheet" type='text/css' href="lib/font.css">
</head>
<body>
   <div class="main">
      <div id="pw_cl_bd"> 
            <p id="bd_te1">임시 비밀번호를 변경해주세요! </p>
      </div>
      <div id="ch_bd">
       <p id="ch_t1">비밀번호변경</p><p id="ch_t2">*영문,숫자 조합 8글자 이상</p>
       <input type="password" placeholder="현재 비밀번호" id="ch_p1"> > 
         <div id="ch_bt">
          <input type="password" placeholder="변경할 비밀번호" id="ch_pw1">
          <input type="password" placeholder="비밀번호확인" id="ch_pw2">
         </div>
         <div id="ch_bt2">
          <input type="button" value="변경" id="ch_but">
         </div>
      
      
      </div>

   </div>
</body>
</html>