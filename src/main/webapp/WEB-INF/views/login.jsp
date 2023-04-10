<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<form action="/user/login-task">
		<div>
			아이디 : <input type="text" name="id"/>
		</div>
		<div>
			비밀번호 : <input type="password" name="pass"/>
		</div>
		<p>
			<c:if test="${param.cause eq 'error' }">
				아이디 또는 비밀번호가 틀렸습니다
			</c:if>
		</p>
		<button>전송</button>
	</form>
</body>
</html>