<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>카카오 로그인 테스트</h1>
	<span th:if=${userId == null}>
	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=741cd954512e5f9393bedab5828e5449&redirect_uri=http://localhost:8282/login">
	<img  src="img/kakao_Login_medium_narrow.png">
	</a>
	</span>
	<span  th:if="${userId != null}">
	<form name="logout"  action="http://localhost:8282/logout">
	<input type="submit" value="로그아웃"> 
	
	</form>
	
	</span>
	
</body>
</html>
