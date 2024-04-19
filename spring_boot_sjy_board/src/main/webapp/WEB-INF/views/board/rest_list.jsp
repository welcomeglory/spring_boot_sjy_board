<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
            },
            error: function(e){
               console.log(e);
            }
         });
      }

      // boardList();

      function getBoard(id){
         $.ajax({
            type:"GET",
            url: "${pageContext.request.contextPath}/boards/"+id,
            success: function(result){
               console.log(result);
            },
            error: function(e){
               console.log(e);
            }
         });
      }
  /*     getBoard(423);
      getBoard(555);
      getBoard(423); */
      
      function deleteBoard(id){
          $.ajax({
             type:"DELETE",
             url: "${pageContext.request.contextPath}/boards/"+id,
             success: function(result){
                console.log(result);
             },
             error: function(e){
                console.log(e);
             }
          });
       }
      deleteBoard(523);
      
   });

</script>


</head>
<body>

</body>
</html>