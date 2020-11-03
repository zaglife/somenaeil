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
       	<div id="id_cl_bd">
       	        <div id="cl_te">
       	        	   <p id="cl_te1">인증성공!</p>
       	               <p id="cl_te2">고객님의 아이디는 @@ 입니다 </p>
       	        </div>
       	        <div id="cl_bt">
       	         <input type="button" value="로그인" id="cl_lo">
       	         <input type="button" value="비밀번호 찾기" id="cl_pw">
       	        </div>
       	</div>


   </div>
</body>
</html>