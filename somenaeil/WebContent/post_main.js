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
		
		
		
		
//		document.addEventListener('keydown', function(event) {
//			  if (event.keyCode === 13) {
//			    event.preventDefault();
//			  };
//			}, true);
		
		function onKeyDown(){
		     if(event.keyCode == 13){
		    	 //TODO : 실행시킬 코드
		    	 var hidden_code = $(".post_hidden_code");
		    	 var code_li = $(".post_code_li");
		    	 var i = 0;
		    	 if (hidden_code[0] != undefined) {
		    		 // 한 개씩 보여주기
		    		 code_li[i++].focus();
		    		 jQuery(hidden_code[0]).removeClass("post_hidden_code");
		    		 
		    	 } 
		     }
		}

		
		/* post_main script end */