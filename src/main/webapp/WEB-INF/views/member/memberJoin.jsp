<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function() {
		
		
		$("#btn").click(function() {
			var path='';
			$(".g").each(function() {
				if($(this).prop("checked")){
					path=$(this).val()+"Join";
				}
			});
			
			$("#frm").attr("action", path);
			$("#frm").submit();
			
		});
		
	});

</script>
</head>
<body>

	<form action="${grade}Join" id="frm" method="post" enctype="multipart/form-data">
		<div>
			<p>STUDENT<input type="radio" checked="checked" name="grade" value="student" class="g"></p>
			<p>TEACHER<input type="radio" name="grade" value="teacher" class="g"></p>
		</div>
		<!--공통입력  -->	
		<div>
			<p>ID : <input type="text" name="id"></p>
			<p>PW : <input type="password" name="pw"></p>
			<p>NAME : <input type="text" name="name"></p>
			<p>AGE : <input type="number" name="age"></p>
			<p>FIlE : <input type="file" name="f1"></p>
			
			
		</div>
		
		<!-- student전용 -->
		<div id="s">
			
			<p>PHONE : <input type="text" name="phone"></p>
			<p>TID : <input type="text" name="tid"></p>
		</div>
	
		<!-- teacher전용 -->
		<div id="t">
			
			<p>SUBJECT : <input type="text" name="subject"></p>
			<p>HIREDATE : <input type="date" name="hiredate"></p>
		</div>
		
		<input type="button" value="JOIN" id="btn">
		
	</form>

</body>
</html>