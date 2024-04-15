<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis게시판</title>
</head>
<body>
   <table width="500" cellpadding="0" cellspacing="0" >
      <tr align="center">
         <td>글번호</td>
         <td>작성자</td>
         <td>제목</td>
         <td>작성일</td>
         <td>조회수</td>            
      </tr>
      <c:forEach var="board" items="${boards}">
         <tr>
            <td>${board.bid}</td>
            <td>${board.bname}</td>                    
            <td>
               <c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
               <a href="${pageContext.request.contextPath}/board/content_view?bid=${board.bid}">${board.btitle}</a>
            </td>
            <td>${board.bdate}</td>
            <td>${board.bhit}</td>         
         </tr>
      </c:forEach>
      <tr>
         <td colspan="5"><a href="${pageContext.request.contextPath}/board/write_view">글작성</a></td>
      </tr>      
   </table>
</body>
</html>