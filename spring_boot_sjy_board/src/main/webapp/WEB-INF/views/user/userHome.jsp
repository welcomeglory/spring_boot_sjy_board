<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- c:c:url나 c:foreach  -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> <!-- 시큐리티 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>untitle</title>
</head>
<body>
<h1>유저 페이지 입니다.</h1>

 <p>principal: <sec:authentication property="principal"/></p> <!-- 시큐리티 태그 라이브러리가 있어서 사용가능 -->
 <p> <sec:authentication property="principal.username"/>님 환영합니다.</p><!-- principal.getUsername()호출 -->
  <p>principal: <sec:authentication property="principal.password"/></p>
   <p>principal: <sec:authentication property="principal.authorities"/></p>
  
<%-- <p>EmpVO: <sec:authentication property="principal.emp"/></p>
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> --%>

<p><a href="<c:url value="/" />">홈</a></p>
</body>
</html>