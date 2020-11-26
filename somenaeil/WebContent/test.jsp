<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
// 파일 업로드 테스트용 (성공)
<form action="upload" id="uploadForm" method="post" enctype="multipart/form-data">


<input type="file" name="file" id="file1"/>
<input type="file" name="file" id="file2"/>
<input type="file" name="file" id="file3"/>
<input type="file" name="file" id="file4"/>
<input type="file" name="file" id="file5"/>



</form>
<script>
var cnt = 0;
var file = document.getElementsByName("file");


function aaaa(){
	alert(file[cnt]);
	document.all.file[cnt].click();
	
	cnt++;
}

</script>
onclick=document.all.file.click()

<input id="11" type="button" onclick="aaaa()" >




