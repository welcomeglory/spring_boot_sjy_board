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
	<div class="d-flex justify-content-center">
		<div class="col-md-2 contents">
			<table class="table table-hover ">
				<thead>
					<tr>
						<th scope="col">직원이름</th>
						<th scope="col">직업</th>
						<th scope="col">부서명</th>
						<th scope="col">월급</th>
						<th scope="col">등급</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="salgradeList" items="${SalgradeEmptList}">
						<c:forEach var="DeptEmp" items="${salgradeList.DeptEmpList}">
							<tr>
								<td>${ DeptEmp.ename }</td>
								<td>${ DeptEmp.job }</td>
								<td>${ DeptEmp.dname }</td>							
								<td>${ DeptEmp.sal}</td>
								<td>${ salgradeList.grade }</td>								
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>