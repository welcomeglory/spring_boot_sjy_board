<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 프로젝트</title>
</head>
<body>
	<h1>${reply_view.bid}번댓글쓰기</h1>

	<table width="500" border="1">
		<form action="${pageContext.request.contextPath}/board/reply"
			method="post">
			<!-- 		댓글을 달고자 하는 글의 댓글 정보 -->
			<input type="hidden" name="bid" value="${reply_view.bid }"> <input
				type="hidden" name="bgroup" value="${reply_view.bgroup }"> <input
				type="hidden" name="bstep" value="${reply_view.bstep }"> <input
				type="hidden" name="bindent" value="${reply_view.bindent }">
		<tr>
			<td>이름</td>
			<td><input type="text" name="bname"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="btitle"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="bcontent" rows="10"></textarea></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="답변">
				&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/list">목록보기</a>
			</td>
		</tr>
		</form>
	</table>

</body>
</html>