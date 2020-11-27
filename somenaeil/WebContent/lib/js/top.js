$( window ).scroll( function() {
	if ( $( this ).scrollTop() > 200 ) {
		$('#top_wrap').addClass('sc_down');
		$('#top_search_cate').addClass('tsc_down');
		$('#top_search input').addClass('tsi_down');
		$('#top_search a').addClass('tsa_down');
		$('#nav_top').addClass('btn_show');
	} else {
		$('#top_wrap').removeClass('sc_down');
		$('#top_search_cate').removeClass('tsc_down');
		$('#top_search input').removeClass('tsi_down');
		$('#top_search a').removeClass('tsa_down');
		$('#nav_top').removeClass('btn_show');
	}
} );

$( '#nav_top' ).click( function() {
	$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
	return false;
} );

var drop= 1;

function dropdown() {
	if(drop == 1) {
		$('.dropdown').removeClass('d_hide');
		setTimeout(function() {
			$('.dropdown').addClass('d_down');
		}, 1);
		$('.top_menu_btn').addClass('d_rotation');
		
		++drop;
		
	}else if(drop == 2) {
		$('.dropdown').removeClass('d_down');
		setTimeout(function() {
			$('.dropdown').addClass('d_hide');
		}, 1);
		$('.top_menu_btn').removeClass('d_rotation');
		
		drop= 1;
	}
}

/////////////////////// author: gagip //////////////////////
// 클릭시 카테고리 선택지 보여주기
$("#cur_cate").on("click", function(){
	console.log("카테고리 선택지");
	$("#hidden_cate").removeClass("d_hide");
})

$(".cate").on("click", function(){
  if (!$(this).hasClass("select_cate")) {
		// 이전 select_cate를 해당 클래스에 추가
		$(".cate").removeClass("select_cate");
		$(this).addClass("select_cate");
		
		// 선택된 카테고리가 상단에 보여준다
		var select_cate = $(this).parent();		// label 태그까지 포함
		var select_cate_input = select_cate.children("input");
		var select_cate_img = select_cate.children("img");

		// 해당 이미지로 보여준다
		$("#cur_cate").attr("src", select_cate_img.attr("src"));
		// 해당 이미지로 체크
		$("input[type=radio]").removeAttr("checked");
		select_cate_input.attr("checked", true);

		// 선택지 닫기(실행 종료)
		if (!$("#hidden_cate").hasClass("d_hide")) {
			$("#hidden_cate").addClass("d_hide");
		}
	} 
	else {
		if (!$("#hidden_cate").hasClass("d_hide")) {
			$("#hidden_cate").addClass("d_hide");
		}
		else {
			$("#hidden_cate").removeClass("d_hide");
		}
	}
})