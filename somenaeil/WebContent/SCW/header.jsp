<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/SCW/lib/header.css">

<!-- 상단 메뉴바 -->
<div id="logo">
	<a href="#" onclick="openPosting();">
	<img src="${pageContext.request.contextPath}/main/img/logo_40.png"/>
	</a>
</div>
<div id="search">
    <form id="sform" name="sform" action="" method="GET">
        <fieldset>
        	<img id="filter_search" src="${pageContext.request.contextPath}/main/img/cate_a_l.png"></img>
            <input id="search" name="search" type="text" title="검색어 입력">
            <button id="btn_search" type="submit" class="btn_submit">
            	<img src="${pageContext.request.contextPath}/main/img/btn_search01_20.png">
            </button>
        </fieldset>
    </form>
</div>
<div id="nav_list">
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/icon_new_n_50.png" /></a></div>
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/icon_dm_n_50.png" /></a></div>
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/icon_menu_50.png" /></a></div>
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/profile_default.jpg" /></a></div>
</div>