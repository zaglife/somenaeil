<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class='pop_wrap post_pop_hide' id="post_pop_vote">
<a class="post_pop_close" onclick="postPopVote()"></a>
<div class='pop_center'>
  <div class="pop_cls_bt">
    <a onclick="postPopVote()"><img src="img/btn_close_20.png"></a>
  </div> 
  <div class='pop_des'>
    <div class="pop_des_line"></div>
  	<p>투표를 설정해 주세요</p>
  </div>
  <div id='vot_title'>
       <input type="text" placeholder="투표 타이틀" class="vot_title_input">
  </div>
  <div id='vot_cont'>
    <div class='vot_cont_t'><input type="text" class="vot_cont_input" placeholder="1번째 투표 항목"></div>
    <div class='vot_cont_t'><input type="text" class="vot_cont_input" placeholder="2번째 투표 항목"></div>
  </div>
  <div id='vot_plus'><button onclick="plus_vote()">추가</button></div>
  <div id='vot_che'>
    <div class='vot_box'>
      <input type="checkbox" name='choice' class="vot_option" id="cb1">
      <label for="cb1"></label>
      <p> 복수 선택 허용</p>
    </div>
    <div class='vot_box'>
      <input type="checkbox" name='choice' class="vot_option" id="cb2">
      <label for="cb2"></label>
      <p> 무기명 투표</p>
    </div>
    <div class='vot_box'>
      <input type="checkbox" name='choice' class="vot_option" id="cb3">
      <label for="cb3"></label>
      <p> 투표 현황 보기</p>
    </div>
    
    <div class='vot_box'>
      <input type="checkbox" name='choice' class="vot_option" id="cb4">
      <label for="cb4"></label>
      <p> 종료일 설정 +</p>
      <input type="text" value="1" class="box">
      <p>일 </p>
      <input type="text" class="box">
      <p>시간</p> 
    </div>
    <div id="vot_exp">*투표 작성일 기준 최대 +9일 24시간 설정가능합니다.</div>
  </div>
  <div id='vot_send'>
    <button id='vot_send_bt'>저장</button>
  </div>
</div>
</div>