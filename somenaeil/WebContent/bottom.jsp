<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="mytag.db_lib" %>

<c:set var="slide_list" value="<%=new db_lib().slide_list() %>" />

<script>
$(document).ready(function(){
<c:forEach var="slide" items="${slide_list }" varStatus="status" begin="0" end="4" step="1">
	$("#slide${slide.getNum() }").click(function(){
	    $("#job_click_pop${slide.getNum() }").toggleClass("job_click_hide");
	});
	$("#job_click_close${slide.getNum() }").click(function(){
	    $("#job_click_pop${slide.getNum() }").toggleClass("job_click_hide");
	});
	$("#job_click_close_btn${slide.getNum() }").click(function(){
	    $("#job_click_pop${slide.getNum() }").toggleClass("job_click_hide");
	});

</c:forEach>

	var nowNum = 0;
	var bannerObj = $('.slide_title');
	var maxLength = bannerObj.length;
	var timer = 5000; // 자동 롤링되는 타임 설정
	var autoRun = setInterval(function(){rollingFn('right');},timer);
	bannerObj.eq(nowNum).fadeIn();
	$('#bottom_controll_top').bind('click',function(){
		rollingFn('right');
	});
	$('#bottom_controll_bottom').bind('click',function(){
		rollingFn('left');
	});
	function rollingFn(direction){
		if(direction=='right'){
			nowNum = nowNum+1;
			if(nowNum>maxLength-1){
				nowNum = 0;
			}
		}else{
			nowNum = nowNum-1;
			if(nowNum<0){
				nowNum = maxLength-1;
			}
		}
		bannerObj.hide().eq(nowNum).fadeIn();
	}

});
</script>



<div id="bottom_wrap">
  <div id="bottom_center">
  
    <div id="bottom_left"><a href="job.do">채용정보</a></div>
    
    <div id="bottom_cont">
      <c:forEach var="slide" items="${slide_list }" varStatus="status" begin="0" end="4" step="1">
      <p class="slide_title"><a id="slide${slide.getNum() }">${slide.getTitle() }</a></p>
      </c:forEach>
    </div>
    
    <div id="bottom_controll">
      <div id="bottom_controll_top"><img src="img/btn_allow_top.png"></div>
      <div id="bottom_controll_more"><a href="job.do"><img src="img/btn_allow_more.png"></a></div>
      <div id="bottom_controll_bottom"><img src="img/btn_allow_bottom.png"></div>
    </div>
  
  </div>
</div>


<%-- job popup start --%>
<c:forEach var="slide" items="${slide_list }" varStatus="status" begin="0" end="4" step="1">

<div id="job_click_pop${slide.getNum() }" class="job_click job_click_hide">
  <div id="job_click_close${slide.getNum() }" class="job_click_close"></div>
  <div id="job_click_top" >
    <div class="job_click_bt">
      <div id="job_click_close_btn${slide.getNum() }" class="job_click_close_btn"><img src="img/btn_close_20.png"></div>
    </div> 
    
    <div id="job_click_title">
      <p id="job_click_title_exp1">${slide.getCom() }</p>
      <p id="job_click_title_exp2">${slide.getTitle() }</p>
      <p id='job_click_title_date'>${slide.getEnd() }</p>
    </div>
            
    <div id="job_click_body">
      ${slide.getContent() }
    </div>
    
    <div id="job_click_bottom">
      <div id="job_click_line"></div>
      <p>채용정보 보러가기</p> 
      <div id="job_click_bottom_center">
      
        
      
        <div class="jcb_link cl_sri"><a href="${slide.getLink().split('@@')[0] }" target="_blank">사람인</a></div>
        <div class="jcb_link cl_jk"><a href="${slide.getLink().split('@@')[1] }" target="_blank">잡코리아</a></div>
        <div class="jcb_link cl_wn"><a href="${slide.getLink().split('@@')[2] }" target="_blank">워크넷</a></div>
      </div>
      <div id="job_click_exp">
        <p>썸 ,내일의 채용공고는 본 게시글 안의 <b>타사이트 채용공고 페이지</b>로의 링크를 통해 지원이 가능합니다</p>
      </div>
    </div>
    
  </div>
</div>

</c:forEach>
<%-- job popup end --%>