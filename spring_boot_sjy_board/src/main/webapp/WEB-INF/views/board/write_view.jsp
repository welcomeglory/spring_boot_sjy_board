<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 프로젝트</title>
</head>
<body>
	<h1>글작성</h1>
	<table width="500" border="1">
		<form action="${pageContext.request.contextPath}/board/write" method="post">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bname" size="50"></td>		
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle" size="50"></td>		
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcontent" rows="10"></textarea></td>		
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/board/list2">목록보기</a> </td>
			</tr>
		</form>
	</table>
<script type="text/javascript">
$(document).ready(function(){
	  var result = `<c:out value = "${result}"/>`;

	  checkModal(result);

	  function checkModal(result){
	    if(result === ``){
	      return;
	    }
	    if(parseInt(result)>0){
	      $(".model-body").html("게시물 " + parseInt(result)+" 번이 등록되었습니다.");
	    }
	      $("#myModal").modal("show");    
	  }
	});
</script>
</body>
</html>