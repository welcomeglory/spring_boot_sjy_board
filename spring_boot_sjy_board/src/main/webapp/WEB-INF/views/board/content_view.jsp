<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 프로젝트</title>
</head>
<body>
	<table width="500" border="1">
		<form action="${pageContext.request.contextPath}/board/modify" method="post">
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
				<td>작성자</td>
				<td><input type="text" name="bname"
					value="${content_view.bname}"></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>
				    <fmt:formatDate value="${content_view.bdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
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
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/list2">목록보기</a> 
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/delete?bid=${content_view.bid}">삭제</a>
					 &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/reply_view?bid=${content_view.bid}">답변</a>   
					</td>
			</tr>
		</form>
	</table>

</body>
</html>