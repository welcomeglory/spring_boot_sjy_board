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
	<button type="button" class="btn btn-secondary" >
		<a href="${pageContext.request.contextPath}/board/write_view"
			class="text-decoration-none text-white">글작성</a>
	</button>
	<table class="table table-hover  text-center">
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boards}">
				<tr>
					<th scope="row">${board.bid}</th>
					<td class="text-start"><c:if test="${board.bindent > 0}">
							<!-- 답글 bindent만큼 띄어쓰기 추가 -->
							<c:forEach var="i" begin="1" end="${board.bindent}">
									&nbsp;&nbsp;
								</c:forEach>
							<!-- 답글에 아이콘 추가 -->
							<i class="fa-solid fa-reply fa-rotate-180"></i>
						</c:if> <a
						href="${pageContext.request.contextPath}/board/content_view?bid=${board.bid}"
						class="text-decoration-none text-black"> ${board.btitle} </a></td>
					<td>${board.bname}</td>
					<td><fmt:formatDate value="${board.bdate}"
							pattern="yyyy-MM-dd" /></td>
					<td>${board.bhit}</td>
				</tr>
			</c:forEach>
		<tbody>
	</table>

  <nav aria-label="Page navigation example " >
  <ul class="pagination justify-content-center">
   	 <c:if test="${pageMaker.prev}">
    <li class="page-item">
      <a class="page-link" href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>    
    <c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" >
    <li class="page-item">
    <a class="page-link" href="list2${pageMaker.makeQuery(idx)}">${idx}</a></li>
   
      </c:forEach>   
       <c:if test="${pageMaker.next && pageMaker.endPage > 0}">    
    <li class="page-item">    
      <a class="page-link" href="list2${pageMaker.makeQuery(pageMaker.endPage + 1) }" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
    
  </ul>
</nav>
   
 	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/0fa31147fa.js"
		crossorigin="anonymous"></script>
</body>
</html>