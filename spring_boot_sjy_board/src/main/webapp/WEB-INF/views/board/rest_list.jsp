<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
   /* 
   $.ajax({
     type : `http method type`,
     url : `url`,
     data : `서버에 전송할 데이터`,
     contentType : "전송할 데이터 타입",
     //기본 값 : "application / x-www-form-urlencoded; charset = UTF-8"  
     dataType : '서버로 부터 수신할 데이터 타입',
     //아무것도 지정하지 않으면 jQuery는 응답의 MIME 유형을 기반으로 해석을 시도
     error : `에러 발생시 수행할 함수`,
     success : `성공시 수행할 함수`
   }); 
   */
   $(document).ready(function(){
      
      function boardList(){
         $.ajax({
            type:"GET",
            url: "${pageContext.request.contextPath}/boards/list",
            success: function(result){
               console.log(result);
               makeList(result);
            },
            error: function(e){
               console.log(e);
            }
         });
      }
      
      function makeList(result) {
         let htmls = "";
         
        /*  $("#list-table").html("");
         
          $("<tr>" , {
            html : "<td>" + "번호" + "</td>" +  // 컬럼명들
                  "<td>" + "이름" + "</td>" +
                  "<td>" + "제목" + "</td>" +
                  "<td>" + "날짜" + "</td>" +            
                  "<td>" + "히트" + "</td>"
         }).appendTo("#list-table") // 이것을 테이블에 붙임 */ 

          $(result).each(function(){
               htmls += '<tr>';
               htmls += '<td>' + this.bid + '</td>';
               htmls += '<td>' + this.bname + '</td>';
               htmls += '<td>'               
               for(var i=0; i < this.bindent; i++) { 
                     htmls += '-'   
                 }
               htmls += '<a href="${pageContext.request.contextPath}/content_view?bid=' + this.bid + '">' + this.btitle + '</a></td>';
                  htmls += '<td>'+ this.bdate + '</td>'; 
                   htmls += '<td>'+ this.bhit + '</td>';
                   htmls += '<td>'+ '<input id=' + this.bid + " type='button' class='btn_delete' value='삭제'>" + '</td>';
                   htmls += '</tr>';
            }); //each end         

         htmls+='<tr>';
            htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';                         
            htmls+='</tr>';

         $("#list-table").append(htmls);
         
      }
      
      boardList(); 

       function getBoard(id){
         $.ajax({
            type:"GET",
            url: "${pageContext.request.contextPath}/boards/" + id,
            success: function(result){
               console.log(result);
            },
            error: function(e){
               console.log(e);
            }
         });
      }
      
      function deleteBoard(id){
         $.ajax({
            type:"DELETE",
            url: "${pageContext.request.contextPath}/boards/" + id,
            success: function(result){
               console.log(result);
               //boardList(); 
            },
            error: function(e){
               console.log(e);
            }
         });
      } 
      
      //deleteBoard(348);
      
      //getBoard(328);
      //getBoard(347);
      //getBoard(348);
     // boardList();
     //게시글 작성
       function writeBoard(board){
          $.ajax({
             type:"POST",
             contentType:'application/json; charset=utf-8', 
             url: "${pageContext.request.contextPath}/boards/",
             /* js객체를 json으로 보내야함 */
              data:JSON.stringify(board),
             success: function(result){
                console.log(result);       		
                boardList(); 
             },
             error: function(e){
                console.log(e);
             }
          });
       } 
	//게시글 수정
	  function modifyBoard(board){
         $.ajax({
            type:"PUT",
            contentType:'application/json; charset=utf-8', 
            url: "${pageContext.request.contextPath}/boards/"+board.bid,
            /* js객체를 json으로 보내야함 */
             data:JSON.stringify(board),
            success: function(result){
               console.log(result);
       			boardList(); 
            },
            error: function(e){
               console.log(e);
            }
         });
      } 
	//게시글 작성 예제
	 /*  let board = {
				bname : "홍길동",
				btitle : "포스트로 인서트",
				bcontent : "빠염",
		}; 
		 writeBoard(board);  */
	//게시글 수정 예제	 
	/*  let board = {
				bid : 2173,
				bname : "호박",
				btitle:"밤고구마",
				bcontent : "빠염"
		};
		modifyBoard(board);  */
 
	   $(document).on("click","#list-table .btn_delete",function(){
	       console.log(this.bid);
	       deleteBoard($(this).attr("id"));	       
	        $(this).parent().parent().remove();
	        
	       });
   });	
   

</script>
</head>
<body>
	<table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
	<td>번호</td> 
	<td>이름</td> 
	<td>제목</td> 
	<td>날짜</td> 
	<td>조회수</td> 
	</tr>
	</table>
</body>
</html>