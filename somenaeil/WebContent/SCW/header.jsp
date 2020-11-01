<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	img {
		vertical-align: middle;
	}

    #logo {
    	flex: 1;
    	width: 200px;
    }
    
    #search {
    	flex: 2;
    }
    
    #nav_list {
    	display: flex;
    	justify-content: flex-end;
        flex: 1;
        width: 30%;
    }
	
	/* logo 파트 */
	#logo img {
		width: 130px;
		height: 45px;
		padding-left: 10px;
	}
	
	/* search 파트 */
	fieldset {
		margin: 0;
		padding: 0;
		border: 0;
		height: 50px;
		
		text-align: center;
	}
	
	fieldset > * { vertical-align: middle }
	
	#filter_search {
		flex: 1;
		width: 30px;
		height: 30px;
	}
	
    #search {
    	flex: 2;
        width: 300px;
		height: 30px;
    }


    #btn_search {
    	flex: 1;
        width: 30px;
        height: 30px;
    }
    
    /* list_nav 파트 */
    .nav_item {
    	width: 50px;
    	height: 50px;
    	float: left;
    	padding: 0 5px;
    }
    
    .nav_item_img {
	    width: 90%;
	    height: 90%;
    }
</style>

<!-- 상단 메뉴바 -->
<div id="logo">
	<a href="#">
	<img src="${pageContext.request.contextPath}/main/img/cate_a_l.png"/>
	</a>
</div>
<div id="search">
    <form id="sform" name="sform" action="" method="GET">
        <fieldset>
        	<img id="filter_search" src="${pageContext.request.contextPath}/main/img/cate_a_l.png"></img>
            <input id="search" name="search" type="text" title="검색어 입력">
            <button id="btn_search" type="submit" title="검색" class="btn_submit"></button>
        </fieldset>
    </form>
</div>
<div id="nav_list">
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/profile_default.jpg" /></a></div>
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/profile_default.jpg" /></a></div>
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/profile_default.jpg" /></a></div>
    <div class="nav_item"><a href="#"><img class="nav_item_img" src="${pageContext.request.contextPath}/main/img/profile_default.jpg" /></a></div>
</div>