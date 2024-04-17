<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MyBatis게시판</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
&nbsp;&nbsp;
	<div class="d-flex justify-content-center">
		<div class="col-md-2 contents">
			<table class="table table-hover ">
				<thead>
					<tr>
						<th scope="col">직원이름</th>
						<th scope="col">월급</th>
						<th scope="col">등급</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="salgradeList" items="${SalgradeEmptList}">
						<c:forEach var="emp" items="${salgradeList.empList}">
							<tr>
								<td>${ emp.ename }</td>
								<td>${ emp.sal}</td>
								<td>${ salgradeList.grade }</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/0fa31147fa.js"
		crossorigin="anonymous"></script> -->
</body>
</html>