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
    <div class='gh_ty'><a href="#"><img src="img/btn_graph02_60.png"></a></div>
  </div>
  <div id='gh_cont'>
    <div id='gh_d'>
      <div class="gh">
       <div class='gh_dt_name' id="out"></div>
		<div class='gh_rod'>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1 cl_red'></div>
          <div class='gh_cl1'></div>
          <div class='gh_cl1'></div>
          <div class='gh_cl1'></div>
        </div>
      </div>
      
      <div class="gh">
       <div class='gh_dt_name' id="out2"></div>
		<div class='gh_rod'>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
          <div class='gh_cl2 cl_ylw'></div>
        </div>
      </div>
      
      <div class="gh">
       <div class='gh_dt_name' id="out3"></div>
		<div class='gh_rod'>
          <div class='gh_cl3 cl_bl'></div>
          <div class='gh_cl3 cl_bl'></div>
          <div class='gh_cl3 cl_bl'></div>
          <div class='gh_cl3 cl_bl'></div>
          <div class='gh_cl3 cl_bl'></div>
          <div class='gh_cl3 cl_bl'></div>
          <div class='gh_cl3'></div>
          <div class='gh_cl3'></div>
          <div class='gh_cl3'></div>
          <div class='gh_cl3'></div>
        </div>
      </div>
      
      <div class="gh">
       <div class='gh_dt_name' id="out4"></div>
		<div>
          <div class='gh_cl4 cl_gr'></div>
          <div class='gh_cl4 cl_gr'></div>
          <div class='gh_cl4 cl_gr'></div>
          <div class='gh_cl4 cl_gr'></div>
          <div class='gh_cl4'></div>
          <div class='gh_cl4'></div>
          <div class='gh_cl4'></div>
          <div class='gh_cl4'></div>
          <div class='gh_cl4'></div>
          <div class='gh_cl4'></div>
        </div>
      </div>
      
    </div>
    <div id='gh_data'>
      <div class='gh_dt'><input type="text" id="data" class='gh_dt_ne' placeholder='데이터명1' size="5" maxlength="5"> <input type="text" class='gh_dt_vl' placeholder='데이터1'></div>
      <div class='gh_dt'><input type="text" id="data2"class='gh_dt_ne' placeholder='데이터명2' size="5" maxlength="5"> <input type="text" class='gh_dt_vl' placeholder='데이터2'></div>
      <div class='gh_dt'><input type="text" id="data3"class='gh_dt_ne' placeholder='데이터명3' size="5" maxlength="5"> <input type="text" class='gh_dt_vl' placeholder='데이터3'></div>
      <div class='gh_dt'><input type="text" id="data4"class='gh_dt_ne' placeholder='데이터명4' size="5" maxlength="5"> <input type="text" class='gh_dt_vl' placeholder='데이터4'></div>
    </div>
    <div id='gh_plus'><button id='gh_plus_bt'>추가</button></div>
  </div>
  <div id='gh_bt'><button>저장</button></div>
</div>
</div>






<script type="text/javascript">

$(document).ready(function(){

	// 입력란에 입력을 하면 입력내용에 내용이 출력

	// 1. #data 공간에서 keyup이라는 이벤트가 발생했을 때

	$("#data").keyup(function(){

		// 2. #out 공간에 #data의 내용이 출력된다.

		$("#out").text($("#data").val());

		// #out의 위치에 text로 데이터를 받는다.(setter)

		// 들어가는 데이터는 #data의 값(.val())이다. (getter)

		// 메서드 괄호 안에 아무것도 없으면 getter, 파라미터가 있으면 setter이다.

	});
	
	$("#data2").keyup(function(){
		$("#out2").text($("#data2").val());
	});
	$("#data3").keyup(function(){
		$("#out3").text($("#data3").val());
	});
	$("#data4").keyup(function(){
		$("#out4").text($("#data4").val());
	});

});

</script>