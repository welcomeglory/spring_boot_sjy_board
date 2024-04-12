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
	<h1>글작성</h1>
	<table width="500" border="1">
		<form action="modify.do" method="post">
			<input type="hidden" name="bid" value="${content_view.bid }">
			<tr>
				<td>번호</td>
				<td>${content_view.bid}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${content_view.bhit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bname"
					value="${content_view.bname}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle"
					value="${content_view.btitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcontent" rows="10">${content_view.bcontent}</textarea></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="수정">
					&nbsp;&nbsp;<a href="list.do">목록보기</a> 
					&nbsp;&nbsp;<a href="delete.do?bid=${content_view.bid}">삭제</a>
					 &nbsp;&nbsp;<a href="reply_view.do?bid=${content_view.bid}">답변</a>   
					</td>
			</tr>
		</form>
	</table>

</body>
</html>