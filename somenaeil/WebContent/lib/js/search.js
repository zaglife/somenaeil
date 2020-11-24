if (sessionStorage.getItem("searchTab") == null)
  sessionStorage.setItem("searchTab", "all");

// 초기화
$(document).ready(function(){

  var tab_id = sessionStorage.getItem("searchTab");

  $("#search_cate_center a").removeClass("current");
  $(".search_menu[data-tab="+tab_id+"]").addClass("current");
})

// 메뉴(A,G,R,Q) 탭 기능
$("#search_cate_center a").on("click", function(){
  var tab_id = $(this).attr("data-tab");
  
	$("#search_cate_center a").removeClass("current");
  $(this).addClass("current");
  
  sessionStorage.setItem("searchTab", tab_id);
})