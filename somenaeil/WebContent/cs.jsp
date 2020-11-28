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

$(document).ready(function(){

  $(".cs_title").click(function(){
    $(this).parent().children('div.cs_cont').toggleClass("cs_hide");
  });

});

</script> 

</head>
<body> 

<div class="cs_main">
  <div id="cs_top"><p>고객센터</p></div>
  <div id="cs_body">

  <c:choose>
    <c:when test="${list.hasPage() }">
    <c:forEach var="data" items="${list.getContent() }">
    <div class="cs_article">
      <div class="cs_title">${data.getTitle() }</div>
      <div class='cs_cont cs_hide'><p>${data.getCont() }</p></div>
    </div>
    </c:forEach>
    </c:when>

    <c:otherwise>
    <p>등록된 게시글이 없습니다.</p>
    </c:otherwise>
  </c:choose>
  
            <c:if test="${list.getStartPage() > 10 }">
            <a href="${m }.do?pnum=${list.getStartPage()-10 }">[이전]</a>
          </c:if>
          
          <c:forEach var="pn" begin="${list.getStartPage() }" end="${list.getEndPage() }">
            <a href="${m }.do?pnum=${pn }">[${pn }]</a>
          </c:forEach>
          
          <c:if test="${list.getEndPage() < list.getTotalPage() }">
            <a href="${m }.do?pnum=${list.getStartPage()+10 }">[다음]</a>
          </c:if>
  
  
  
  
  
  
  


  </div>
  <div id="cs_bottom">
    <div id="cs_page">
      <a href="#"><</a>
      <a href="#">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">></a>
    </div>
    <div id="cs_search">
      <input type="text" placeholder="고객센터검색">
      <a href="cs.jsp#search"><img src="img/btn_search02_20.png"></a>
    </div>
  </div>  
</div>



<div id="cs_footer">
  <p>썸,내일 고객센터</p>
  <p>사이트 이용에 문제가 있을시 저희에게알려주세요! :)</p>
  <p>1234-1234</p>
  <p>Help@somenaeil.co.kr</p>
  <p>평일 10:00 ~ 18:00 주말 및 공휴일 휴무</p>
</div>
	
<jsp:include page="top.jsp" />
<jsp:include page="totop.jsp" />

</body>
</html>