<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
var job= 1;

function jobClick() {
	if(job == 1) {
		$('#job_click').removeClass('job_click_hide');
		++job;
	}else if(job == 2) {
		$('#job_click').addClass('job_click_hide');
		job= 1;
	}
}
</script>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

</head>
<body> 

<div id="job_main">
  <div id="job_top"><p>채용정보</p></div>
  <div id="job_body">
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
    <div class="job_go"><a onclick="jobClick()">(주)오뚜기</a><a onclick="jobClick()">- 2020년 하반기 대졸신입사원 채용</a><p>~2020년10월29일</p></div>
  </div>
  <div id="job_bt">
    <div id="job_page">
      <a href="#">&lt;</a>
      <a href="#">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">&gt;</a>
    </div>
    <div id="job_search">
      <input type="text" placeholder="채용정보검색">
      <a href="job.jsp#search"><img src="img/btn_search02_20.png"></a>
    </div>
  </div>  
</div>

<jsp:include page="job_click.jsp" />

<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>