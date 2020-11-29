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

<div id="job_write_wrap">

  <div id="job_write_title">
    <img src="img/logo_40.png">
    <p>채용정보 글작성</p>
  </div>
  
  <form method="post" action="job.do">
  <input type="hidden" name="job_part" value="job_update">
  
  <input type="text" id="job_title_input" name="job_title" placeholder="채용정보 타이틀">
  
  <input type="text" id="job_write_com" name="job_com" placeholder="회사명">
  <input type="text" id="job_write_end" name="job_end" value="~ 2021년 01월 01일">
  
  <textarea id="job_write_cont" name="job_cont">
지원자격
경력 : 
학력 : 

근무조건
고용형태 : (정규직/계약직/파견직)
급여 : 
지역 : 
  </textarea>
  
  <p class="job_write_link_type">워크넷</p>
  <input type="text" class="job_write_link" name="job_linkA" value="http://">
  <p class="job_write_link_type">사람인</p>
  <input type="text" class="job_write_link" name="job_linkB" value="http://">
  <p class="job_write_link_type">잡코리아</p>
  <input type="text" class="job_write_link" name="job_linkC" value="http://">
  
  <button id="job_btn">글작성</button>
  </form>

</div>

<jsp:include page="top.jsp" />

</body>
</html>