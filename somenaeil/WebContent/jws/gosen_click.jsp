<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link rel="stylesheet" type='text/css' href="lib/gosen.css">
<link rel="stylesheet" type='text/css' href="lib/font.css">
<script type="text/javascript">
 var dis="true";
 function display(){
	 var con = document.getElementById("gosen_tecl");
	 var bt= document.getElementById("bt");
	 var num=0;
	 if(con.style.display=='none'){
		  con.style.display=="block";
		  num=1;
	 }else {
		  num=0;
		  con.style.display="none";
	 }
 }
</script>
</head>
<body> 
  <div class="main">
      <div id="g_top"><p>고객센터</p></div>
        <div id="g_body">
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</a></div>
         <div id="gosen_tecl">썸,내일의 채용정보는 직접 회사의 구인요청에 의한것이 아닌 타사이트의 채용정보를
                링크와 함께 제공하는서비스로,마감된 채용정보의 내용을 확인하실 수 없습니다.
                추가적으로,썸.내일의 채용정보는 채용공고의 마감일 기준으로 +2일이 지난 후에 삭제되므로 마감일이 지난 채용공고 중
                추가 확인 가능한 게시글이 남아있을 수 있으므로, 채용정보 게시판에 검색해보시는걸 추천합니다
                <a id="bt" href="javascript:display(-1);">X</a> </div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</a></div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</a></div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</a></div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</a></div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</div>
         <div class="gosen_te">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</div>
         <div class="gosen_te" style="border:0px;">-<a href="javascript:display();">마감된 채용공고는 어떻게 확인할수있나요?</a></div>
        </div>
      <div id="g_bt">
         <div id="g_n">
         <a href="">1</a>
         <a href="">2</a>
         <a href="">3</a>
         <a href="">4</a>
         <a href="">5</a>
         <a href="">...</a>
         </div>
         <div id="g_ser">
          <input type="text" placeholder="고객센터검색">
         </div>
      
      </div>  
          <a href="" style=
        "float: right;
   		 position: relative;
   		 top: 70px;
   		 left: 20%;
   		 ">
         <img src="img/nav_post_50.png"></a>
         
        </div>
          
  </div>

</body>
</html>