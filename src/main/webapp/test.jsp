<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<%-- 로그인, 글목록 --%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<meta charset="UTF-8">
<title>게시판 로그인</title>
<link rel="stylesheet" href="/resource/css/style.css?${millis }" />


</head>
<body>
	<form action="/user/login-task" method="post" class="sign-form">
		<h2>login</h2>
		<div style="margin: 0.4em">
			<input type="text" placeholder="아이디" name="id" value="${idSave }"
				class="join-input" required />
		</div>
		<div style="margin: 0.4em">
			<input type="password" placeholder="비밀번호" name="pass"
				class="join-input" />
		</div>

		<div style="margin: 0.4em">
			<button type="submit" class="join-btn">다음</button>
		</div>
	</form>

</body>
</html>
	 
</body>
</html>