window.onload = function() {
	if(document.getElementById("login_id")) {
		document.getElementById("login_id").focus();	
	}
};

function loginCheck() {
	if($("#login_id").val() == null || $("#login_id").val() == "") {
		alert("아이디를 입력하세요.");
		$("#id").focus();
	} else if($("#login_pw").val() == null || $("#login_pw").val() == "") {
		alert("비밀번호를 입력하세요.");
		$("#login_pw").focus();
	} else {
		$("#loginForm").submit();
	}
}