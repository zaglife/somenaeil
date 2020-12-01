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
<c:choose>
<c:forEach var="data" items="${list.getContent() }">

$(document).ready(function(){
	$(".job_click${data.getNum() }").click(function(){
	    $("#job_click_pop${data.getNum() }").toggleClass("job_click_hide");
	});
	$("#job_click_close${data.getNum() }").click(function(){
	    $("#job_click_pop${data.getNum() }").toggleClass("job_click_hide");
	});
	$("#job_click_close_btn${data.getNum() }").click(function(){
	    $("#job_click_pop${data.getNum() }").toggleClass("job_click_hide");
	});
});

</c:forEach>
</c:choose>
</script>

</head>
<body>

<div id="job_main">
  <div id="job_top"><p>채용정보</p></div>
  <div id="job_body">
  
    <div id="job_article_title">
      <p class="job_com">회사명</p>
      <p class="job_title job_title_center">채용정보</p>
      <p class="job_end job_title_center">마감일</p>
    </div>
  
    <c:choose>
      <c:when test="${list.hasPage() }">
      <c:forEach var="data" items="${list.getContent() }">
      
      <div class="job_article">
        <a class="job_com job_click${data.getNum() }">${data.getCom() }</a>
        <a class="job_title job_click${data.getNum() }">${data.getTitle() }</a>
        <a class="job_end">${data.getEnd() }</a>
      </div>
      
      </c:forEach>
      </c:when>

      <c:otherwise>
      <p>등록된 게시글이 없습니다.</p>
      </c:otherwise>
    </c:choose>

  
  
    <div id="job_bottom">
      <div id="job_page">

        <c:if test="${list.getStartPage() > 10 }">
        <a href="${m }.do?part=job_view&pnum=${list.getStartPage()-10 }">&lt;</a>
        </c:if>
          
        <c:forEach var="pn" begin="${list.getStartPage() }" end="${list.getEndPage() }">
        <a href="${m }.do?part=job_view&pnum=${pn }">${pn }</a>
        </c:forEach>
          
        <c:if test="${list.getEndPage() < list.getTotalPage() }">
        <a href="${m }.do?part=job_view&pnum=${list.getStartPage()+10 }">&gt;</a>
        </c:if>

      </div>
      <div id="job_search">
        <input type="text" placeholder="채용정보검색">
        <a href="job.jsp#search"><img src="img/btn_search02_20.png"></a>
      </div>
    </div>

  </div>
</div>

<%-- popup start --%>
<c:choose>
<c:when test="${list.hasPage() }">
<c:forEach var="data" items="${list.getContent() }">

<div id="job_click_pop${data.getNum() }" class="job_click job_click_hide">
  <div id="job_click_close${data.getNum() }" class="job_click_close"></div>
  <div id="job_click_top" >
    <div class="job_click_bt">
      <div id="job_click_close_btn${data.getNum() }" class="job_click_close_btn"><img src="img/btn_close_20.png"></div>
    </div> 
    
    <div id="job_click_title">
      <p id="job_click_title_exp1">${data.getCom() }</p>
      <p id="job_click_title_exp2">${data.getTitle() }</p>
      <p id='job_click_title_date'>${data.getEnd() }</p>
    </div>
            
    <div id="job_click_body">
      ${data.getContent() }
    </div>
    
    <div id="job_click_bottom">
      <div id="job_click_line"></div>
      <p>채용정보 보러가기</p> 
      <div id="job_click_bottom_center">
      
        
      
        <div class="jcb_link cl_sri"><a href="${data.getLink().split('@@')[0] }" target="_blank">사람인</a></div>
        <div class="jcb_link cl_jk"><a href="${data.getLink().split('@@')[1] }" target="_blank">잡코리아</a></div>
        <div class="jcb_link cl_wn"><a href="${data.getLink().split('@@')[2] }" target="_blank">워크넷</a></div>
      </div>
      <div id="job_click_exp">
        <p>썸 ,내일의 채용공고는 본 게시글 안의 <b>타사이트 채용공고 페이지</b>로의 링크를 통해 지원이 가능합니다</p>
      </div>
    </div>
    
  </div>
</div>


</c:forEach>
</c:when>

<c:otherwise>
</c:otherwise>

</c:choose>
<%-- popup end --%>


<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>