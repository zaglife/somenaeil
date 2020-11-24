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

// 카테고리 체크 후 변화

var active_hidden_cate = false;
$(".select_cate").on("click", function(){
  if (active_hidden_cate) {
    $("#hidden_cate").addClass("d_hide");
  }
  else {
    $("#hidden_cate").removeClass("d_hide");
  }
  active_hidden_cate = !active_hidden_cate;
})

$(".cate").on("click", function(){
  if ($(this).hasClass("select_cate")) {
    $("")
  }
})