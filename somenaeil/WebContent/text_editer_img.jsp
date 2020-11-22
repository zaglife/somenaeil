<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>textarea form 커서 영역에 텍스트 추가 삽입하기</title>
<style>
#editContent {
	float: left;
	position: relative;
	width: 800px;
	min-height:300px;
	padding: 0 10px;
	border:1px solid #aaa;
	background:#fff;
}

#editContent div {
	clear: both;
	float: left;
	position: relative;
	width: 100%;
	height: auto;
	line-height: 25px;
	left:0;
	top: 0;
}

.post_code_content{
	clear: both;
    float: left;
    position: relative;
    width: 750px !important;
    min-height: 100px;
    padding: 0;
    margin: 20px 23px;
    border: 2px solid #999;
    border-radius: 20px;
    overflow-x: hidden;
}

.post_code_content div:nth-child(2n) {
	background: rgba(0, 0, 0, .05);
}

.post_code_content div:last-child {
	border-bottom: 0;
}

.post_code_list{
	float: left;
	position: relative;
	width: 730px;
    height: 20px;
    line-height: 20px;
    padding: 5px 10px;
    border-bottom: 1px dashed #999;
}

.new_post_write {
	float: left;
	position: relative;
	width: 100px;
	min-height: 40px;
}

</style>

<script type="text/javascript">


// 모던브라우저용
function insertImg(){
	var sel = window.getSelection();
	var range = sel.getRangeAt(0);
	var startNode = range.startContainer;
	var startOffset = range.startOffset;
	var insertNode = document.createElement('img');	// img 객체 생성
	insertNode.setAttribute("src","http://nuli.navercorp.com/upload/91f4ad04ae6539ab297de0b934ef03df.jpg")	// 생성한 img 에 src 경로 추가
	range.insertNode(insertNode);
	range.setStartAfter(insertNode);
    document.getElementById("editContent").focus();
}

function insertCode(){
    
	var sel = window.getSelection();
	var range = sel.getRangeAt(0);
	var startNode = range.startContainer;
	var startOffset = range.startOffset;
	var insertNode = document.createElement('div');
	insertNode.setAttribute("class","post_code_content");
	insertNode.setAttribute("contenteditable","true");
	
	var post_code_cont= document.createElement('div');
	post_code_cont.setAttribute("class", "post_code_list");
	
	
	insertNode.appendChild(post_code_cont);

	range.insertNode(insertNode);
	range.setStartAfter(insertNode);
	
	var new_post_write= document.createElement('div');
	new_post_write.setAttribute("class", "new_post_write");
	new_post_write.setAttribute("contenteditable", "true");
	
	document.getElementById("editContent").appendChild(new_post_write);    
}

</script>

</head>
<body style="background:#eee;">
    <p>하단 편집란에 글을 쓰고 이미지삽입 버튼을 클릭해보세요 (모던브라우저에서만 작동)</p>
    <input type="button" id="submitAdd" onclick="insertImg()" value="이미지삽입">
    <input type="button" id="submitAdd2" onclick="insertCode()" value="이미지삽입">
	<div id="editContent" contenteditable="true"></div>
</body>

