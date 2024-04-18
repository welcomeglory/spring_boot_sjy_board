<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>직원번호</td>
			<td>직원이름</td>
			<td>월급</td>
			<td>부서번호</td>
			<td>부서명</td>			
		</tr>
		<c:forEach var="dept" items="${DeptEmps}">
			<!-- DeptVO 3개 -->
			<c:forEach var="emp" items="${dept.empList}">
				<!-- DeptVO와 조인된 EmpVO -->
				<tr>
					<td>${ emp.empno }</td>
					<td>${ emp.ename }</td>
					<td>${ emp.sal}</td>
					<td>${ dept.deptno }</td>
					<td>${ dept.dname }</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>