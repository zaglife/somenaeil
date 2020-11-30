<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>some, 내일</title>

<jsp:include page="css.jsp" />

<script>
<c:forEach var="job" items="${job_list }" varStatus="status" begin="0" end="4" step="1">
$(document).ready(function(){
	$(".job_click${job.getNum() }").click(function(){
	    $("#job_click_pop${job.getNum() }").toggleClass("job_click_hide");
	});
	$("#job_click_close${job.getNum() }").click(function(){
	    $("#job_click_pop${job.getNum() }").toggleClass("job_click_hide");
	});
	$("#job_click_close_btn${job.getNum() }").click(function(){
	    $("#job_click_pop${job.getNum() }").toggleClass("job_click_hide");
	});
});
</c:forEach>

<c:forEach var="cs" items="${cs_list }" varStatus="status" begin="0" end="4" step="1">
$(document).ready(function(){
	$("#cs_click${cs.getNum() }").click(function(){
		$("#cs_click_pop${cs.getNum() }").toggleClass("cs_click_hide");
		$("#cs_click_btn${cs.getNum() }").toggleClass("cs_click_hide");
	});
	$("#cs_click_pop${cs.getNum() }").click(function(){
		$("#cs_click_pop${cs.getNum() }").toggleClass("cs_click_hide");
		$("#cs_click_btn${cs.getNum() }").toggleClass("cs_click_hide");
	});
});
</c:forEach>
</script>

</head>
<body>

<div class="info_main">
  
  <div id="info_job_wrap">
    <div id="info_job_top">
      <p>채용정보</p> 
      <a href="job.do?part=job_view" id="go_job"></a>
    </div>
    <div id="info_job_cont">
      <c:forEach var="job" items="${job_list }" varStatus="status" begin="0" end="4" step="1">
      <div class="info_job">
        <a class="job_click${job.getNum() }">${job.getCom() }</a>
        <a class="job_click${job.getNum() }">${job.getTitle() }</a>
        <p>${job.getEnd() }</p>
      </div>
      </c:forEach>
    </div>
  </div>
	
  <div id="info_cs_wrap">
    <div id="info_cs_top">
      <p>고객센터</p>
      <a href="cs.do?part=cs_view" id="go_cs"></a>
    </div>
    <div id="info_cs_cont">
      <c:forEach var="cs" items="${cs_list }" varStatus="status" begin="0" end="4" step="1">
      <div id="cs_click${cs.getNum() }" class="info_cs">
        <a id="cs_click${cs.getNum() }">${cs.getTitle() }</a>
        <p id="cs_click_btn${cs.getNum() }" class="cs_click_btn cs_click_hide">></p>
      </div>
      </c:forEach>
    </div>
  </div>
  
  <div id="info_box">
    <div id="info_box_center">
      <p>썸,내일 고객센터</p>
      <p>사이트 이용에 문제가 있을시</p>
      <p>저희에게알려주세요! :)</p>
      <p>1234-1234</p>
      <p>Help@somenaeil.co.kr</p>
      <p>평일 10:00~18:00</p>                 
      <p>주말및공휴일 휴무</p>
    </div>
    
    <c:forEach var="cs" items="${cs_list }" varStatus="status" begin="0" end="4" step="1">
    <div id="cs_click_pop${cs.getNum() }" class="cs_click cs_click_hide">
      <div class="cs_click_center">${cs.getCont() }</div>
    </div>
    </c:forEach>
  </div>
</div>



<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

<%-- job popup start --%>
<c:forEach var="job" items="${job_list }" varStatus="status" begin="0" end="4" step="1">

<div id="job_click_pop${job.getNum() }" class="job_click job_click_hide">
  <div id="job_click_close${job.getNum() }" class="job_click_close"></div>
  <div id="job_click_top" >
    <div class="job_click_bt">
      <div id="job_click_close_btn${job.getNum() }" class="job_click_close_btn"><img src="img/btn_close_20.png"></div>
    </div> 
    
    <div id="job_click_title">
      <p id="job_click_title_exp1">${job.getCom() }</p>
      <p id="job_click_title_exp2">${job.getTitle() }</p>
      <p id='job_click_title_date'>${job.getEnd() }</p>
    </div>
            
    <div id="job_click_body">
      ${job.getContent() }
    </div>
    
    <div id="job_click_bottom">
      <div id="job_click_line"></div>
      <p>채용정보 보러가기</p> 
      <div id="job_click_bottom_center">
      
        
      
        <div class="jcb_link cl_sri"><a href="${job.getLink().split('@@')[0] }" target="_blank">사람인</a></div>
        <div class="jcb_link cl_jk"><a href="${job.getLink().split('@@')[1] }" target="_blank">잡코리아</a></div>
        <div class="jcb_link cl_wn"><a href="${job.getLink().split('@@')[2] }" target="_blank">워크넷</a></div>
      </div>
      <div id="job_click_exp">
        <p>썸 ,내일의 채용공고는 본 게시글 안의 <b>타사이트 채용공고 페이지</b>로의 링크를 통해 지원이 가능합니다</p>
      </div>
    </div>
    
  </div>
</div>

</c:forEach>
<%-- job popup end --%>

</body>
</html>