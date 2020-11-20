<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<div class='pop_wrap post_pop_hide' id="post_pop_gh">
<a class="post_pop_close" onclick="postPopGh()"></a>
<div class='pop_center'>
  <div class="pop_cls_bt">
    <a onclick="postPopGh()"><img src="img/btn_close_20.png"></a>
  </div> 
  <div class='pop_des'>
    <div class="pop_des_line"></div>
  	<p>그래프 타입을 정해주세요</p>
  </div>
  <div id='gh_cate'>
    <div class='gh_ty'><a href="#"><img src="img/btn_graph01_60.png"></a></div>
    <div class='gh_ty'><a href="#"><img src="img/btn_graph02_60.png" onclick="temporary()"></a></div>
  </div>
  <div id='gh_cont'>
    <div id='gh_d'>
      <div class="gh">
       <div class='gh_dt_name' id="name1_out"></div>
		<div class='gh_rod'>
          <div class='gh_cl1 cl_red' id="data1_out"></div>
        </div>
      </div>
      
      <div class="gh">
       <div class='gh_dt_name' id="name2_out"></div>
		<div class='gh_rod'>
          <div class='gh_cl2 cl_ylw' id="data2_out"></div>
          
        </div>
      </div>
      

      
    </div>
    <div id='gh_data'>
      <div class='gh_dt'><input type="text" id="g_name1" class='gh_dt_ne' placeholder='데이터명1' size="5" maxlength="5"><input type="text" id="g_data1" class='gh_dt_vl' placeholder='데이터1'></div>
      <div class='gh_dt'><input type="text" id="g_name2"class='gh_dt_ne' placeholder='데이터명2' size="5" maxlength="5"><input type="text" id="g_data2" class='gh_dt_vl' placeholder='데이터2'></div>
      <div id='gh_plus'><button id='gh_plus_bt' onclick="gh_plus()">추가</button></div>
    </div>
    
  </div>
  <div id='gh_bt'><button>저장</button></div>
</div>
</div>





