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
<title>게시판</title>
</head>
<body>
	 <h3> 게시글 작성 </h3>
	
	 <div class="container">
	 	<div class="row">
	 		<form method="post" action="./flow/write.jsp">
	 			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
	 				<thead>
	 					<tr>
	 						<th colspan="2" stlye="background-color: #eeeeee; text-align: center;"> 게시판 글쓰기 </th>
	 					</tr>
	 				</thead>
	 				
	 				<tbody>
	 					<tr>
	 						<td><input type="text" class="form-control" placeholder="글 제목" name="boardTitle" ></td>
	 					</tr>
	 					<tr>
	 						<td><textarea class="form-control" placeholder="글 내용" name="boardwrite" style="height: 350px;"></textarea></td>
	 					</tr>
	 				</tbody>
	 			</table>		
	 			
	 			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">	
	 		</form>
	 	</div>
	 </div>
	 
</body>
</html>