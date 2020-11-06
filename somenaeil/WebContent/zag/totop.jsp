<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
jQuery(document).ready(function() {
	var navTop = $('#nav_top');

	navTop.on('click', function(e) {
		e.preventDefault();
		$('html, body').animate({scrollTop:0}, '300');
	});
});
</script>

<div id="nav_top"><a href="#"><img src="img/nav_top_56.png"></a></div>