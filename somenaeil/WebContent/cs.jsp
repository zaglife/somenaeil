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
var csTemp= 1;

function csDown() {
	if(csTemp == 1) {
		$('.cs_cont').removeClass('cs_hide');
		++csTemp;
	}else if(csTemp == 2) {
		$('.cs_cont').addClass('cs_hide');
		csTemp= 1;
	}
}
</script>

</head>
<body> 

<div class="cs_main">
  <div id="cs_top"><p>고객센터</p></div>
  <div id="cs_body">
    <div class="cs_article">
      <a onclick="csDown()">- 마감된 채용공고는 어떻게 확인할수있나요?</a>
      <div class='cs_cont cs_hide'>
        <p>
썸,내일의 채용정보는 직접 회사의 구인요청에 의한 것이 아닌 타사이트의 채용정보를 링크와 함께 제공하는 서비스로, 마감된 채용정보의 내용을 확인하실 수 없습니다.<br>
<br>
추가적으로, 썸.내일의 채용정보는 채용공고의 마감일 기준으로 +2일이 지난 후에 삭제되므로 마감일이 지난 채용공고 중 추가 확인 가능한 게시글이 남아있을 수 있으므로, 채용정보 게시판에 검색해보시는걸 추천합니다
        </p>
      </div>
    </div>
          
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
    <div class="cs_article cs_article_last"><a href="#">- 마감된 채용공고는 어떻게 확인할수있나요?</a></div>
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

<p style="float:left;position:absolute;left:0;top:120px;">
1234

${cs_list.size() }
<c:if test="${list != null }">
34
</c:if>

</p>

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