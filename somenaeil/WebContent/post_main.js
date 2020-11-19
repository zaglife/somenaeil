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
					 
		    	 }else
		    		 alert("소스는 20줄까지 생성됩니다.");
		    	 
		    	 
		    	 
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
		var before_row = 0;
		var before_col = 0;
		
		function ct(){
			var row = document.getElementById('row').value;
			var col = document.getElementById('col').value;
			var k = 0;
			
			if(before_row == row && before_col == col){
				alert("바뀔 행과열이 없습니다.");
			}else{
				for(var i = 1; i <= row; i++){
					for(var j = 1; j <= col; j++){
						var para = document.createElement("div");
						jQuery(para).addClass("ct_cell");
						document.getElementById("ct_table").appendChild(para);
							
						var para2 = document.createElement("input");
						document.getElementsByClassName("ct_cell")[k].appendChild(para2);
						k++;
					}
					var para = document.createElement("br");
					document.getElementById("ct_table").appendChild(para);
				}	
			}
			
			before_row = row;
			before_col = col;
			
		}
		
		
		
		/* post_main script end */