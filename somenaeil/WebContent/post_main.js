/* post_main script start */
var popCt= 1;

function postPopCt() {
	if(popCt == 1) {
		$('#post_pop_ct').removeClass('post_pop_hide');
		++popCt;
	}else if(popCt == 2) {
		$('#post_pop_ct').addClass('post_pop_hide');
		popCt= 1;
	}
}

var popGh= 1;

function postPopGh() {
	if(popGh == 1) {
		$('#post_pop_gh').removeClass('post_pop_hide');
		++popGh;
	}else if(popGh == 2) {
		$('#post_pop_gh').addClass('post_pop_hide');
		popGh= 1;
	}
}

var popVote= 1;

function postPopVote() {
	if(popVote == 1) {
		$('#post_pop_vote').removeClass('post_pop_hide');
		++popVote;
	}else if(popVote == 2) {
		$('#post_pop_vote').addClass('post_pop_hide');
		popVote= 1;
	}
}

var sc_temp= 1;

function showCode() {
	if(sc_temp == 1) {
		$('#post_code_cont').removeClass('post_code_hide');
		++sc_temp;
		$("#post_write").append("<textarea class='autosize' onkeydown='resize(this)' onkeyup='resize(this)'></textarea>");
	}else if(sc_temp == 2) {
		$('#post_code_cont').addClass('post_code_hide');
		sc_temp= 1;
	}
}

var like_temp= 1;

function showlink() {
	if(like_temp == 1) {
		$('.post_link').addClass('post_link_hide');
		$('.post_mov').removeClass('post_mov_hide');
		++like_temp;
	}else if(like_temp == 2) {
		$('.post_link').removeClass('post_link_hide');
		
		like_temp= 1;
	}
}

var mov_temp= 1;

function showmov() {
	if(mov_temp == 1) {
		$('.post_mov').addClass('post_mov_hide');
		$('.post_link').removeClass('post_link_hide');
		++mov_temp;
	}else if(mov_temp == 2) {
		$('.post_mov').removeClass('post_mov_hide');
		
		mov_temp= 1;
	}
}

function post_cate(num) {
	if(num == 2){
		$('#post_hidden').removeClass('post_cate_hidden');
	}else{
		$('#post_hidden').addClass('post_cate_hidden');
	}	
}


// 해시태그 만드는 법 
var hash_cnt = 3;
function more_hash() {
	 
	var para = document.createElement("div");
	jQuery(para).addClass("post_hash");
	document.getElementById("post_btm_hash").appendChild(para);
		
	var para2 = document.createElement("input");
	document.getElementsByClassName("post_hash")[hash_cnt].appendChild(para2);
	hash_cnt++;
		
	var at = document.createAttribute("type");
	at.value = "text";
	para2.setAttributeNode(at);
	var at = document.createAttribute("name");
	at.value = "hash";
	para2.setAttributeNode(at);
	var at = document.createAttribute("placeholder");
	at.value = "#태그";
	para2.setAttributeNode(at);
		
	if(hash_cnt == 5){
		document.getElementById('post_hashbt').style.display='none'
	}
}
		
//글쓰기 생성 
function resize(obj) {
	obj.style.height = "1px";
	obj.style.height = (12+obj.scrollHeight)+"px";
}
		
// 소스코드에서 enter시 소스코드가 한줄 생성되면서  커서도 같이 움직인다.
var code_i= 2;
function onKeyDown(){
	if(event.keyCode == 13){
		if(code_i <= 20){
			var para = document.createElement("div");
			jQuery(para).addClass("post_code_li");
			document.getElementsByClassName("post_code_cont")[0].appendChild(para);
					 
			var para2 = document.createElement("p");
			var p_text = document.createTextNode(code_i);
			para2.appendChild(p_text);
					 
			document.getElementsByClassName("post_code_li")[code_i-1].appendChild(para2);
					 
			var para3 = document.createElement("input");
			document.getElementsByClassName("post_code_li")[code_i-1].appendChild(para3);
			para3.focus();
					 
			var at = document.createAttribute("type");
			at.value = "text";
			para3.setAttributeNode(at);
			var at = document.createAttribute("onkeydown");
			at.value = "onKeyDown();";
			para3.setAttributeNode(at);
				
			++code_i;
					 
		}else alert("소스는 20줄까지 생성됩니다.");
	}
}

var s_code_num = 1;
function s_code(){
	if(s_code_num == 1){
		var para = document.createElement("div");
		jQuery(para).addClass("post_code_cont");
		document.getElementById("post_write").appendChild(para);
				
		var para2 = document.querySelector(".post_code_cont");
		para2.innerHTML= "<div class='post_code_li'><p>1</p><input type='text' onKeyDown='onKeyDown();'></div>";
				
		var para3 = document.createElement("textarea");
		jQuery(para3).addClass("autosize");
		document.getElementById("post_write").appendChild(para3);
				
		var at = document.createAttribute("onkeydown");
		at.value = "resize(this);";
		para3.setAttributeNode(at);
		
		
		var at = document.createAttribute("onkeydown");
		at.value = "resize(this);";
		para3.setAttributeNode(at);
		
		
		
		var at = document.createAttribute("id");
		at.value = "text_cont";
		para3.setAttributeNode(at);
		
		var at = document.createAttribute("class");
		at.value = "autosize "+"tc_num"+s_code_num;
		para3.setAttributeNode(at);
		
		s_code_num++;

		
	}else{
		$('.post_code_cont').remove();
		$('#text_cont').remove();
		s_code_num = 1;
	}
}
		
// 그래프에 데이터명 입력시 실시간으로 이름이 입력된다.
$(document).ready(function(){
	// 입력란에 입력을 하면 입력내용에 내용이 출력

	// 1. #data 공간에서 keyup이라는 이벤트가 발생했을 때

	$("#g_name1").keyup(function(){

		// 2. #out 공간에 #data의 내용이 출력된다.

		$("#name1_out").text($("#g_name1").val());

		// #out의 위치에 text로 데이터를 받는다.(setter)

		// 들어가는 데이터는 #data의 값(.val())이다. (getter)

		// 메서드 괄호 안에 아무것도 없으면 getter, 파라미터가 있으면 setter이다.
	});
			
	$("#g_name2").keyup(function(){
		$("#name2_out").text($("#g_name2").val());
	});
	
	$(document).on('propertychange change keyup paste input', '#g_name3', function(){
		$("#name3_out").text($("#g_name3").val());
	});
	
	$(document).on('propertychange change keyup paste input', '#g_name4', function(){
		$("#name4_out").text($("#g_name4").val());
	});

	var g1 = 0;
	var g2 = 0;
	var g3 = 0;
	var g4 = 0;
			
	function gh_calc() {
		var g_all = parseInt(g1)+parseInt(g2)+parseInt(g3)+parseInt(g4);
		
		var result1 = g1 *190/g_all;
		var result2 = g2 *190/g_all;
		var result3 = g3 *190/g_all;
		var result4 = g4 *190/g_all;
		
		
		$("#data1_out").width(result1+'px');
		$("#data2_out").width(result2+'px');
		$("#data3_out").width(result3+'px');
		$("#data4_out").width(result4+'px');
	}
				
	$("#g_data1").keyup(function(){
		g1= $("#g_data1").val();
		gh_calc();
	});
			
	$("#g_data2").keyup(function(){
		g2= $("#g_data2").val();
		gh_calc();
	});
	
	$(document).on('propertychange change keyup paste input', '#g_data3', function(){
		g3= $("#g_data3").val();
		gh_calc();
	});
			
	$(document).on('propertychange change keyup paste input', '#g_data4', function(){
		g4= $("#g_data4").val();
		gh_calc();
	});
	
	
	

});
		
// 투표 추가버튼시 생성 6개째 생성시 alert띄우면서 버튼 사라진다.
var plus_cnt = 2;
function plus_vote(){
	
	if(plus_cnt > 5){
		
	}else {
		var para = document.createElement("div");
		jQuery(para).addClass("vot_cont_t");
		document.getElementById("vot_cont").appendChild(para);
		
		var para2 = document.createElement("input");
		jQuery(para2).addClass("vot_cont_input");
		
		var at = document.createAttribute("type");
		at.value = "text";
		para2.setAttributeNode(at);
		 
		 var at = document.createAttribute("placeholder");
		 at.value = ""+(plus_cnt+1)+"번째 투표 항목";
		 para2.setAttributeNode(at);
		
		document.getElementsByClassName("vot_cont_t")[plus_cnt].appendChild(para2);
		
		plus_cnt++;
		if(plus_cnt > 5){
			alert("투표항목은 6개가 최대입니다.");
			document.getElementById('vot_plus').style.display='none';
		}
	}
	
}
		
		
function maxLengthCheck(object){
	if (object.value.length > object.maxLength){
      object.value = object.value.slice(0, object.maxLength);
	}    
}
		
		
// 표 만들기(미완성)
var before_row = -1;
var before_col = -1;
		
function ct(){
	var row = document.getElementById('row').value;
	var col = document.getElementById('col').value;
	var k = 0;
			
			
	if(row == 0 && col == 0){
		alert("행과 열을 모두 입력해주세요.");
		$('#row').focus();
	}else if(row == 0){
		alert("열을 입력해주세요.");
		$('#row').focus();
	}else if(col == 0){
		alert("행을 입력해주세요.");
		$('#col').focus();
	}else if(before_row == row && before_col == col){
		alert("바뀔 행과 열이 없습니다.");
	}else{
		for(var i = 1; i <= col; i++){
			for(var j = 1; j <= row; j++){
				var para = document.createElement("div");
				jQuery(para).addClass("ct_cell");
				document.getElementById("ct_table").appendChild(para);
					
				var para2 = document.createElement("input");
				document.getElementsByClassName("ct_cell")[k].appendChild(para2);
				k++;
				var at = document.createAttribute("placeholder");
				at.value = "데이터";
				para2.setAttributeNode(at);
			}
			
			document.getElementById("ct_table").appendChild(para);
		}
				
		var ct_style= document.getElementsByName("table_style");
		var ct = document.querySelectorAll(".ct_cell");
		
		if(ct_style[0].checked) {
			for(var i = 0; i < row; i++){
				ct[i].className += " ct_cell_top";
			}
			for(var i = 1; i <= col; i++){
				ct[(i-1)*row].className += " ct_cell_left";
			}
		} else if(ct_style[1].checked) {
			if(col == 1){
				ct[(row-1)].className += " ct_cell_right";
				for(var i = 1; i <= row; i++){				
					ct[i-1].className += " ct_cell_bottom";
				}
			} else {
				for(var i = 1; i <= col; i++){
					ct[(i-1)*row].className += " ct_cell_left2";
				}
				for(var i = 0; i < row; i++){
					ct[row*(col-1)+i].className += " ct_cell_bottom";
				}
				for(var i = 1; i <= col; i++){
					ct[i*col-1].className += " ct_cell_right";
				}
			}
		}
				
		var ct_size = ct.length;
		if(row % 2 == 0){
			var k=0;
			for(var i = 0; i < ct_size/2; i++){
//				alert(k);
				if(k < row/2) {
					ct[i*2].className +=  " ct_cell_back";
					k++;
				} else if(row/2 < k) {
					ct[i*2+1].className +=  " ct_cell_back";
					k++;
				} else if(k == ct_size/4 ) {
					k= 0;
				}
			}
		}else if(row % 2 == 1){
			for(var i = 0; i < ct_size/2; i++){
				ct[i*2].className +=  " ct_cell_back";
			}
		}

	}
	before_row = row;
	before_col = col;
			
}
		
		
		
		
		
		
		
		
var gh_cnt = 2;

function gh_plus(){
	var para = document.createElement("div");
	jQuery(para).addClass("gh");
	document.getElementById("gh_d").appendChild(para);
	
	
	
	
	var para2 = document.createElement("div");
	jQuery(para2).addClass("gh_dt_name");
	jQuery(para2).attr("id","name"+(gh_cnt+1)+"_out");
	document.getElementsByClassName("gh")[gh_cnt].appendChild(para2);
	
	
	
	
	var para3 = document.createElement("div");
	jQuery(para3).addClass("gh_rod");
	document.getElementsByClassName("gh")[gh_cnt].appendChild(para3);
			
			
			
			
	var para4 = document.createElement("div");
	jQuery(para4).addClass("gh_cl"+(gh_cnt+1));
	if(gh_cnt == 2){
		jQuery(para4).addClass("cl_bl");
	}else{
		jQuery(para4).addClass("cl_gr");
	}
	jQuery(para4).attr("id","data"+(gh_cnt+1)+"_out");
	document.getElementsByClassName("gh_rod")[gh_cnt].appendChild(para4);
			
			
	// 인풋 만들기
	
	var para = document.createElement("div");
	jQuery(para).addClass("gh_dt");
	document.getElementById("gh_data").appendChild(para);
	
	var para2 = document.createElement("input");
	jQuery(para2).addClass("gh_dt_ne");
	jQuery(para2).attr("id","g_name"+(gh_cnt+1));
	var at = document.createAttribute("type");
	at.value = "text";
	para2.setAttributeNode(at);
	var at = document.createAttribute("placeholder");
	at.value = "데이터명"+(gh_cnt+1);
	para2.setAttributeNode(at);
	var at = document.createAttribute("size");
	at.value = "5";
	para2.setAttributeNode(at);
	var at = document.createAttribute("maxlength");
	at.value = "5";
	para2.setAttributeNode(at);
	document.getElementsByClassName("gh_dt")[gh_cnt].appendChild(para2);
	
	
	var para3 = document.createElement("input");
	jQuery(para3).addClass("gh_dt_vl");
	jQuery(para3).attr("id","g_data"+(gh_cnt+1));
	var at = document.createAttribute("placeholder");
	at.value = "데이터"+(gh_cnt+1);
	para3.setAttributeNode(at);
	var at = document.createAttribute("type");
	at.value = "number";
	para3.setAttributeNode(at);
	document.getElementsByClassName("gh_dt")[gh_cnt].appendChild(para3);

			
	if(gh_cnt == 3){
		gh_cnt = 1;
		alert("그래프는 4개까지만 생성됩니다.");
		document.getElementById('gh_plus_bt').style.visibility='hidden';
	}
	gh_cnt++;
}

function temporary(){
	alert("현재 이 그래프타입은 준비중입니다.");
}

function insertText() {
	var txtArea = document.getElementById('txtForm');
	var txtValue = txtArea.value;
	
	var selectPos = txtArea.selectionStart; // 커서 위치 지정
	var beforeTxt = txtValue.substring(0, selectPos); // 기존텍스트 ~ 커서시작점 까지의 문자
	var afterTxt = txtValue.substring(txtArea.selectionEnd, txtValue.length); // 커서끝지점 ~ 기존텍스트 까지의 문자
	var addTxt = document.getElementById('addInput').value; // 추가 입력 할 텍스트
	
	txtArea.value = beforeTxt + addTxt + afterTxt;
	selectPos = selectPos + addTxt.length;
	txtArea.selectionStart = selectPos; // 커서 시작점을 추가 삽입된 텍스트 이후로 지정
	txtArea.selectionEnd = selectPos; // 커서 끝지점을 추가 삽입된 텍스트 이후로 지정
	txtForm.focus();
}
	

function submit1(){
	//아이디 안에있는 값 태그까지 스트링타입으로 가져온다.
	var jbHtml = $('#post_write').html();
	
	var f = document.getElementById("form");
	
	var i = document.createElement("input"); // input 엘리멘트 생성 
	i.setAttribute("type","hidden"); // type 속성을 hidden으로 설정
	i.setAttribute("name","content"); // name 속성을 'm_nickname'으로 설정 
	i.setAttribute("value",jbHtml); // value 속성을 neilong에 담겨있는 값으로 설정 
	f.appendChild(i); // form 엘리멘트에 input 엘리멘트 추가 

	f.submit();
	
}

function submit2(){
	var context = $("#post_write").html();
	
	$("#context").val(context);
	var f = document.getElementById("form");
	f.submit();
}

/* post_main script end */