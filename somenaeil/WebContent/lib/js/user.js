var userFollower= 1;

function userFollowerPop() {
	if(userFollower == 1) {
		$('#user_follower').removeClass('user_follower_hide');
		++userFollower;
	}else if(userFollower == 2) {
		$('#user_follower').addClass('user_follower_hide');
		userFollower= 1;
	}
}

var userFollow= 1;

function userFollowPop() {
	if(userFollower == 1) {
		$('#user_follow').removeClass('user_follow_hide');
		++userFollower;
	}else if(userFollower == 2) {
		$('#user_follow').addClass('user_follow_hide');
		userFollower= 1;
	}
}

var followBtn= 1;






function changeFollow(userId, targetId) {
	console.log(userId);
	console.log(targetId);
	if (userId == null || targetId == null) {
		alert("로그인 후 이용가능합니다");
		location.href = "login.jsp";
	}
	else{
		$.ajax({
			type: "POST",
			url: "user.do?part=follow",
			data: {
				"userId": userId,
				"targetId": targetId,
			},
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success: function(data) {
				var img = $(".user_follow_btn img");
				if(img.attr("src") == "img/noti_follow_20.png"){
					img.attr("src", "img/noti_follow_n_20.png");
				} else {
					img.attr("src", "img/noti_follow_20.png");
				}
				$("#user_top").load(document.location.href+" #user_top");
			}, error: function(data) {
				alert("에러");
			}
		});
	}
}
