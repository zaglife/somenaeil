<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<c:if test="${sessionUser!=null}">
<div id="nav_write">
	<a href="post_main.post?part=post&cate=${param.cate} ">
		<img src="img/nav_post_80_b.png">
	</a>
</div>
</c:if>
