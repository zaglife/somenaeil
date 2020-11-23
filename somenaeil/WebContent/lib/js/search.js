// 초기화
$(document).ready(function(){
  if (sessionStorage.getItem("searchTab") == null)
    sessionStorage.setItem("searchTab", "all");
  var tab_id = sessionStorage.getItem("searchTab");

  $("#search_cate_center a").removeClass("current");
  $(".search_menu[data-tab="+tab_id+"]").addClass("current");
})

// 메뉴(A,G,R,Q) 탭 기능
$("#search_cate_center a").on("click", function(){
  var tab_id = $(this).attr("data-tab");
  
	$("#search_cate_center a").removeClass("current");
  $(this).addClass("current");
  
  if (tab_id="all") {
    $(".post G").css("display", "inherit")
    $(".post R").css("display", "inherit");
    $(".post Q").css("display", "inherit");
  }
  else if (tab_id=="general") {
    $(".post G").css("display", "inherit")
    $(".post R").css("display", "none");
    $(".post Q").css("display", "none");
  }
  else if (tab_id="review") {
    $(".post G").css("display", "none")
    $(".post R").css("display", "inherit");
    $(".post Q").css("display", "none");
  }
  else if (tab_id="qna") {
    $(".post G").css("display", "none")
    $(".post R").css("display", "none");
    $(".post Q").css("display", "inherit");
  }
  
  sessionStorage.setItem("searchTab", tab_id);
})