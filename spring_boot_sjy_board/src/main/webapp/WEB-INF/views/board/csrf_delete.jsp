<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<script type="text/javascript">
// ajax 요청시 사용할 csrf 글로벌 변수설정
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
</script>

<script type="text/javascript">
$(document).ready(function (){
   
    function deleteBoard(id){
       
      $.ajax({
         type:"DELETE",
         url: "/boards/" + id,
         success: function(result){
            console.log(result);
         },
           beforeSend : function(xhr){
               //ajax호출 중 처리
               //글로벌 변수로 설정한 csrf token 셋팅
               xhr.setRequestHeader(header,token);
           },
         error: function(e){
            console.log(e);
         }
      });
    }
   
    deleteBoard(2361);
   
});
</script>


</head>
<body>
   <table width="500" cellpadding="0" cellspacing="0"  border="1">
      <tr>
         <td>번호</td>
         <td>이름</td>
         <td>제목</td>
         <td>날짜</td>
         <td>히트</td>            
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