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


 //새로운 태그 만드는 작업 중요 !
function more_hash() {
	 
	
			// 히든 박스에 있는 요소들 찾기
			var hidden_hash = $(".post_hash_hidden");
			if (hidden_hash[0] != undefined) {
				// 한 개씩 보여주기
				jQuery(hidden_hash[0]).removeClass("post_hash_hidden");
			} 
			
			
			if ($(".post_hash_hidden").length == 0) {
				$("#post_hashbt").remove();
			}
		}
		// 댓글 개수 확인 후 
		function check_hash() {
			if (jQuery(hidden_hash[0]).length == 0) {
				$(".post_hashbt").addClass("hash_btn");
			}
		}
		
		
		function resize(obj) {
			  obj.style.height = "1px";
			  obj.style.height = (12+obj.scrollHeight)+"px";
		}
		

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
		
		/* post_main script end */