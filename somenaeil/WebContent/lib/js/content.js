if (sessionStorage.getItem("menuTab") == null)
    sessionStorage.setItem("menuTab", "all");
    
// 초기화
$(document).ready(function(){
  var tab_id = sessionStorage.getItem("menuTab");

  $("#main_menu_center a").removeClass("current");
  $(".main_menu[data-tab="+tab_id+"]").addClass("current");
})


// 메뉴(A,G,R,Q) 탭 기능
$(".main_menu").on("click", function(){
  var tab_id = $(this).attr("data-tab");
  
	$("#main_menu_center a").removeClass("current");
	$(this).addClass("current");

  sessionStorage.setItem("menuTab", tab_id);
})


// 아이콘 이미지 리소스
var follow_icon = {
  active: "img/noti_follow_n_20.png",
  deactive: "img/noti_follow_20.png"
}

var like_icon = {
  active: "img/noti_like_20.png",
  deactive: "img/noti_like_n_20.png"
};

var scrap_icon = {
  active: "img/noti_scrap_20.png",
  deactive: "img/noti_scrap_n_20.png"
};

function click_icon(type, target) {
  var src = $(target).attr("src");
  var cnt = Number($(type+" span").text());
  // 이미지 리소스
  var resource = (type == ".like") ? like_icon : 
                  (type == ".scrap") ? scrap_icon :
                  (type == ".follow") ? follow_icon : null;
  
  if (src == resource.active) {
    $(target).attr("src", resource.deactive);
    $(type+" span").text(cnt-1);
  }
  else {
    $(target).attr("src", resource.active);
    $(type+" span").text(cnt+1);
  }
}

$(".post_like_btn>img").on("click", function() {
  click_icon(".like", this);
})

$(".post_scrap_btn>img").on("click", function() {
  click_icon(".scrap", this);
})

// TODO 스크롤 내리기 -> post 추가 로드