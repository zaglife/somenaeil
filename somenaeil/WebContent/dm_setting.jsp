<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="dm_set_wrap" class="dm_set_hide">
<a id="dm_set_close" onclick="dmSetPop()"></a>
  <div class="dm_set_center">
    
    <div id="dm_set_popup_top_space"></div>
    <div id="dm_set_popup">삭제할 대화를 선택해 주세요</div>
    <div id="dm_set_popup_close"><img src="img/btn_close_20.png" onclick="dmSetPop()"></div>
    
    <div id="dm_set_popup_scroll">
    <c:if test="${other != null}">
      <c:forEach var="other" items="${other }">
      	<c:if test="${other.fromid.equals(user.id) }">
      	<div id="dm_set_popup_cont">
        <div class="dm_set_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="dm_set_popup_name">${other.toid }</div>
        <div class="dm_set_popup_comment">${other.chatcontent }</div>
        <div class="dm_set_popup_btn"><p>대화삭제</p></div>
      </div>
      </c:if>
      <c:if test="${other.toid.equals(user.id) }">
      	<div id="dm_set_popup_cont">
        <div class="dm_set_popup_pimg"><img src="img/profile01.jpg"></div>
        <div class="dm_set_popup_name">${other.fromid }</div>
        <div class="dm_set_popup_comment">${other.chatcontent }</div>
        <div class="dm_set_popup_btn"><p>대화삭제</p></div>
      </div>
      </c:if>
      </c:forEach>
    </c:if>
    </div>
    
    
  </div>
</div>