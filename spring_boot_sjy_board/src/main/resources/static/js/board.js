/*
 * boardService 
 * 모듈 구성하기
 *    
 * 모듈 패턴은 쉽게 말해서 Java의 클래스처럼 JavaScript를 이용해서 메서드를 가지는 객체를 구성한다. 
 * 모듈 패턴은 JavaScript의 즉시 실행함수와 '{}'를 이용해서 객체를 구성한다. 
 *  
 * 
 * */
console.log("board 모듈화");
//boardService는 익명함수
let boardService = (function() {
	function boardList(callback) {
		$.ajax({
			type : "GET",
			url : "/boards/list",
			success : function(result) {
				console.log(result);
				if (callback) {
					callback(result);
				}
			},
			error : function(e) {
				console.log(e);
			}
		});
	}
	
	 function getBoard(id) {
			$.ajax({
				type : "GET",
				url : "/boards/" + id,
				success : function(result) {
					console.log(result);
				},
				error : function(e) {
					console.log(e);
				}
			});
		}   
	
	function deleteBoard(id) {
		$.ajax({
			type : "DELETE",
			url : "/boards/" + id,
			success : function(result) {
				console.log(result);
				boardList();
			},
			error : function(e) {
				console.log(e);
			}
		});
	}

	return {
		list : boardList,
		get : getBoard,
		del : deleteBoard
	}//객체
})();//즉시 실행 : (function(){})();

//위와 똑같은 함수
/*let boardService =  function(){	
 return {
 test:function test(){
 console.log("테스트입니다");
 }
 }
 }*/
