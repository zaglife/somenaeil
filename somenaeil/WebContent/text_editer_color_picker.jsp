<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script type="text/javascript">
// 2015-09-06 박용서 : 작성
// [/dev?tn=158](/dev?tn=158)
var cp = {
	bar : null, // color bar
	barc : null, // color bar context
	pal : null, // palette
	palc : null, // palette context
	pallc : null, // palette last color

	// 초기화
	init : function() {
		// 오른쪽 바를 새로고침한다.
		cp.initBar();

		// 팔렛트를 초기화한다.
		cp.initPalette();

		// 기본값 : 빨강색 선택
		cp.drawPalette(255, 0, 0);
	},

	// 색상바 초기화
	initBar : function() {
		var bar = cp.bar = document.getElementById('bar');
		var ctx = cp.barc = bar.getContext('2d');
		
		// 처음 크기가 멋대로 잡혀있다. (초기화)
		// ignore css?? init resize..;;
		var w = bar.width = 20;
		var h = bar.height = 256;
		
		// 그라디언트를 불러온다.
		var grd = ctx.createLinearGradient(0,0,w,h);
		grd.addColorStop(0,'#ff0000');
		grd.addColorStop(0.166,'#ff00ff');
		grd.addColorStop(0.333,'#0000ff');
		grd.addColorStop(0.5,'#00ffff');
		grd.addColorStop(0.666,'#00ff00');
		grd.addColorStop(0.834,'#ffff00');
		grd.addColorStop(1,'#ff0000');

		// 지정한 그라데이션을 그린다.
		ctx.fillStyle = grd;
		ctx.fillRect(0, 0, w, h);

		bar.onclick = function(e) {
			// y 좌표를 가져온다.
			var y = e.pageY - cp.bar.offsetTop;
			// 해당 위치의 색상을 가져온다.
			var c = cp.barc.getImageData(0, y, 1, 1).data;
			// r g b  순서대로 부른다.
			cp.drawPalette(c[0], c[1], c[2]);
		};
	},

	// 팔렛트를 초기화한다.
	initPalette : function() {
		var pal = cp.pal = document.getElementById('palette');
		cp.palc = pal.getContext('2d');

		// 이유는 모르겠지만.. 크기가 이상해서 다시 잡아준다.
		pal.width = 256;
		pal.height = 256;
	},

	// 팔렛트를 그린다.
	drawPalette : function(r, g, b) {
		// 마지막으로 선택된 컬러와 같다면 자원을 아까기위해 스킵한다.
		var nowColor = (r+'-'+g+'-'+b);
		if (cp.pallc == nowColor) { return; } else { cp.pallc = nowColor; }
		
		// 팔렛트의 컨텍스를 가져옴
		var palc = cp.palc;

		// 위에서부터 1픽셀씩 내려오면서 그림
		for (i = 0; i < 255; )
		{
			var leftColor = 255 - i; // 왼쪽 [상 -> 하] 명도 계산!
			
			// 그리기
			var grd = palc.createLinearGradient(0, 0, 256, 1);
			grd.addColorStop(0,'rgb('+leftColor+', '+leftColor+', '+leftColor+')');
			grd.addColorStop(1,'rgb('+r+', '+g+', '+b+')');
			palc.fillStyle = grd;
			palc.fillRect(0, i++, 256, i);

			// 위 설명대로 루프당 명도를 1씩 떨어뜨립니다.
			if (r > 0) { r--; }
			if (g > 0) { g--; }
			if (b > 0) { b--; }
			
			
		}
	}
};
</script>
<style>
#palette { width:256px; height:256px; }
#bar { width:20px; height:256px; }
</style>
</head>
<body onload="cp.init();">

<canvas id="palette"></canvas>
<canvas id="bar"></canvas>

</body>
</html>