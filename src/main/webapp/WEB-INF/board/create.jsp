<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<link rel="stylesheet" href="/resource/css/style.css?${millis }">
</head>
<body>
	<h1>글쓰기</h1>
	<c:if test="${param.cause eq 'error' }">
		글의 양식이 맞지 않습니다. 다시 작성해주세요
	</c:if>
	<form action="/board/create-task">
		<div align="right">
			<button>작성하기</button>
		</div>
		<c:if test="${!sessionScope.logon }">
			<input type="text" name="writer" placeholder="닉네임"/> | <input type="text" name="boardPass" placeholder="비밀번호"/>
		</c:if>
		<div>
		</div>
		<div>
			<input type="text" name="title" placeholder="제목"/>
		</div>
		<div>
			<textarea name="content" placeholder="내용"></textarea>
		</div>
	</form>
</body>
</html>