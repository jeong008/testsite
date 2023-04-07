<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 로그인</title>
<link rel="stylesheet" href="/resource/style.css?${millis }" />


</head>
<body>
	<form action="./home/list" method="post" class="sign-form">
		<h2>login</h2>
		<div style="margin: 0.4em" >
			<input type="text" placeholder="아이디" name="id" value="${idSave }"/>
		</div>
		<div style="margin: 0.4em">
			<input type="password" placeholder="비밀번호" name="pass"/>
		</div>

		<div style="margin: 0.4em">
			<button type="submit" class="join-btn"><a href="./home/list.jsp"> 다음 </a></button>
		</div>
	</form>

</body>
</html>