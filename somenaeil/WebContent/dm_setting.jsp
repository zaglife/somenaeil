<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
	memberList
	lastText
	otherlist
	
 --%>

<div id="dm_set_wrap" class="dm_set_hide">
<a id="dm_set_close" onclick="dmSetPop()"></a>
  <div class="dm_set_center">
    <div id="dm_set_popup_top_space"></div>
    <div id="dm_set_popup">삭제할 대화를 선택해 주세요</div>
    <div id="dm_set_popup_close"><img src="img/btn_close_20.png" onclick="dmSetPop()"></div>
    
    <div id="dm_set_popup_scroll">
    <c:if test="${fn:length(lastText)-1 < 0}">
    	대화중인 상대가 없습니다.
    </c:if>
    <c:if test="${fn:length(lastText)-1 >= 0}">
   	<c:if test="${memberList != null}">
      <c:forEach var="i" begin="0" end="${fn:length(lastText)-1 }" step="1">
      	<div id="dm_set_popup_cont">
      	<a href="dm.some?part=view&toid=${memberList.get(i).getId()}&tonick=${memberList.get(i).getNick()}">
          <div class="dm_set_popup_pimg"><img src="pimg/pimg_${memberList.get(i).getId()}.jpg" onerror="this.src='pimg/pimg_none.jpg'"></div>
          <div class="dm_set_popup_name">${memberList.get(i).getNick()}</div>
          <div class="dm_set_popup_comment">${lastText.get(i)}</div>
        </a>
        <div class="dm_set_popup_btn"><p>대화삭제</p></div>
      </div>
      </c:forEach>
    </c:if>
    	
    </c:if>
    </div>
    
    
  </div>
</div>