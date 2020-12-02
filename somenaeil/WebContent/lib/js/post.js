var origin_hidden_comment = $(".comment_hidden");

// 더 많은 댓글 보여주기
function more_comment() {
  // 히든 박스에 있는 요소들 찾기
  var parent = $(".comment_hidden").parent();									// visualable comment box
  var c_id = $(".comment_hidden > .comment_id");							
  var c_context = $(".comment_hidden > .comment_context");		 
  
  // 5개씩 댓글 추가로 보여주기
  for (var i=0; i<5; i++) {
    if (i >= c_id.length) break;
    
    parent.append(c_id[i]);
    parent.append(c_context[i]);
  }
  check_comment();
}

// 
function check_comment() {
  if ($(".comment_hidden > .comment_id").length == 0) {
    $(".btn_more_comment").addClass("btn_rotate");		// + => x
    // 버튼에 닫기 기능 추가
  }
}

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

$(".like>img").on("click", function() {
  click_icon(".like", this);
})

$(".scrap>img").on("click", function() {
  click_icon(".scrap", this);
})

$(".follow>img").on("click", function() {
  click_icon(".follow", this);
})

$().ready(function(){
  origin_hidden_comment = $(".hidden_comment");
  $(".comment_hidden").hide();
  check_comment();
})


// 댓글 등록
function writeCmt() {
  var form = $("form[name='comment_form']")[0];

  var replyWriterId = form.authorId.value;
  var replyWriterNick = form.authorNick.value;
  var postWriterId = form.postWriterId.value;
  var post_num = form.post_num.value;
  var context = form.context.value;

  // 필수 항목에 내용이 존재하지 않는 경우
  if(!context) {
    alert("댓글 내용 입력해주세요.");
    return false;
  }
  else if (!replyWriterNick) {
    alert("로그인 후 댓글 쓰기가 가능합니다.");
    return false;
  }
  else {
    $.ajax({
      type: "POST",
      url: "reply.post",
      data: {
        "replyWriterId": replyWriterId,
        "replyWriterNick": encodeURIComponent(replyWriterNick), 
        "postwriterId": postwriterId,
        "post_num": post_num, 
        "context": encodeURIComponent(context)},
      contentType: "application/x-www-form-urlencoded; charset=UTF-8",
      success: function (data) {
        $("#article_footer").load(document.location.href+" #article_footer");
      },
      error:function(){
        alert("실패");
      },
    });
  }
}