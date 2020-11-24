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