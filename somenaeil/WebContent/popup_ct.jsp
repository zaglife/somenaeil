<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class='pop_wrap post_pop_hide' id="post_pop_ct">
<a class="post_pop_close" onclick="postPopCt()"></a>
<div class='pop_center'>
  <div class="pop_cls_bt">
    <a onclick="postPopCt()"><img src="img/btn_close_20.png"></a>
  </div> 
  <div class='pop_des'>
    <div class="pop_des_line"></div>
  	<p>표를 작성해 주세요</p>
  </div>
  <div id='ct_top'>
    <div id='ct_set'>
      <input id="row" type="number" maxlength="1" oninput="maxLengthCheck(this)">
      <p>행</p>
      <input id="col" type="number" maxlength="1" oninput="maxLengthCheck(this)">
      <p>열</p>
      <button id='ct_apply' onclick="ct()">적용</button>
    </div>
    
    <div id='ct_exp'>*행과 열은 최대 6개까지 가능합니다.</div>
    <div id='ct_style'>
      <div id="ct_ts_title">표스타일</div>
      <div id="ct_ts">
        <input type="radio" name="table_style" id="ts_on" checked>
        <label for="ts_on" id="table_style_on"></label>
        
        <input type="radio" name="table_style" id="ts_off">
        <label for="ts_off" id="table_style_off"></label>
      </div>
      
      
    </div>
  </div>
  <div id='ct_table'>
  </div>
  <div id='ct_bottom'>
  	<button>저장</button>
  </div>
</div>
</div>