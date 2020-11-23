// 초기화
$(document).ready(function(){
  if (sessionStorage.getItem("menuTab") == null)
    sessionStorage.setItem("menuTab", "all");
  var tab_id = sessionStorage.getItem("menuTab");

  $("#main_menu_center a").removeClass("current");
  $(".main_menu[data-tab="+tab_id+"]").addClass("current");
})


// 메뉴(A,G,R,Q) 탭 기능
$("#main_menu_center a").on("click", function(){
  var tab_id = $(this).attr("data-tab");
  
  
	$("#main_menu_center a").removeClass("current");
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
  
  sessionStorage.setItem("menuTab", tab_id);
})



// TODO 스크롤 내리기 -> post 추가 로드


// TODO 상단바 이미지