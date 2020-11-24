<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글자 편집기</title>
<style type="text/css">
  #text {
    -moz-appearance: textfield-multiline;
    -webkit-appearance: textarea;
    border: 1px solid gray;
    font: medium -moz-fixed;
    font: -webkit-small-control;
    overflow: auto;
    padding: 2px;
    resize: both;
  }
  button {
    -moz-box-shadow: 0px 1px 0px 0px #fff6af;
    -webkit-box-shadow: 0px 1px 0px 0px #fff6af;
    box-shadow: 0px 1px 0px 0px #fff6af;
    background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ffec64), color-stop(1, #ffab23));
    background:-moz-linear-gradient(top, #ffec64 5%, #ffab23 100%);
    background:-webkit-linear-gradient(top, #ffec64 5%, #ffab23 100%);
    background:-o-linear-gradient(top, #ffec64 5%, #ffab23 100%);
    background:-ms-linear-gradient(top, #ffec64 5%, #ffab23 100%);
    background:linear-gradient(to bottom, #ffec64 5%, #ffab23 100%);
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffec64', endColorstr='#ffab23',GradientType=0);
    background-color:#ffec64;
    -moz-border-radius:15px;
    -webkit-border-radius:15px;
    border-radius:10px;
    border:1px solid #ffaa22;
    display:inline-block;
    cursor:pointer;
    color:#333333;
    font-family:Arial;
    font-size:15px;
    font-weight:bold;
    padding:5px 10px;
    text-decoration:none;
    text-shadow:0px 1px 0px #ffee66;
  }
</style>
<script src="http://code.jquery.com/jquery-3.2.1.min.js">
</script>
<script>
  document.execCommand('styleWithCSS', false, true);
  document.execCommand('insertBrOnReturn', false, true);
  $(document).ready(function() {
    $("#text").focus();
    $('button').click(function(){
      document.execCommand($(this).attr('id'), false, true);
    });
    // $('#bold').click(function() {
    //   document.execCommand('bold', false, true);
    // });
    // $('#selectAll').click(function() {
    //   document.execCommand('selectAll', false, true);
    // });
    // $('#italic').click(function() {
    //   document.execCommand('italic', false, true);
    // });
    // $("#underLine").click(function() {
    //   document.execCommand('underLine', false, true);
    // });
    // $("#justifyLeft").click(function() {
    //   document.execCommand('justifyLeft', false);
    // });
    // $("#justifyRight").click(function() {
    //   document.execCommand('justifyRight', false);
    // });
    // $("#justifyCenter").click(function() {
    //   document.execCommand('justifyCenter', false);
    // }); 
    $('select').change(function(){
      document.execCommand($(this).attr('id'), false, $(this).val());
    });
    // $("#foreColor").change(function(){ 
    //   document.execCommand('foreColor', false, $(this).val());
    // });
    // $("#hiliteColor").change(function(){
    //   document.execCommand('hiliteColor', false, $(this).val());
    // });
    // $("#fontName").change(function(){
    //   document.execCommand('fontName', false, $(this).val());
    // });
    // $("#fontSize").change(function(){
    //   document.execCommand('fontSize', false, $(this).val());
    // });
    
  });
</script>
</head>
<body>
  <div style="background-color:#CCFFFF; width:390px; padding: 10px;">
    <button id="selectAll">전체선택</button>
    <button id="bold">굵게</button>
    <button id="italic">기울임</button>
    <button id="underLine">밑줄</button>
    <br/>
    <button id="justifyLeft">왼쪽정렬</button>
    <button id="justifyCenter">가운데정렬</button>
    <button id="justifyRight">오른쪽정렬</button>
    <br/>
    
    <select id="fontName" width="50px">
        <option value="">글꼴 선택</option>
        <option value="돋움">돋움</option>
        <option value="굴림">굴림</option>
        <option value="궁서">궁서</option>
        <option value="바탕">바탕</option>
        <option value="맑은 고딕">맑은 고딕</option>
    </select>
    <select id="fontSize" width="50px">
        <option value="">글자 크기</option>
        <option value="1">4px</option>
        <option value="2">8px</option>
        <option value="3">10px</option>
        <option value="4">12px</option>
        <option value="5">16px</option>
        <option value="6">20px</option>
        <option value="7">30px</option>
    </select>
    <select id="foreColor" width="50px">
        <option value="">글자 색깔</option>
        <option value="#f00">빨강</option>
        <option value="#00f">파랑</option>
        <option value="#0f0">초록</option>
        <option value="#ffff00">노랑</option>
        <option value="#000">검정</option>
    </select>
    <select id="hiliteColor" width="50px">
        <option value="">글자 배경색</option>
        <option value="#f00">빨강</option>
        <option value="#00f">파랑</option>
        <option value="#0f0">초록</option>
        <option value="#ffff00">노랑</option>
        <option value="#000">검정</option>
    </select>
  </div>
  <div id="text" contenteditable="true" style="width:400px; height:400px;">텍스트 편집기</div>
</body>
</html>