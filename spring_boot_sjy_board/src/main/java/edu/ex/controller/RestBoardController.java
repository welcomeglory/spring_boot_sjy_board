package edu.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ex.service.BoardService;
import edu.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

/*
//REST : Representational State Transfer
//하나의 URI가 하나의 고유한 리소스를 대표하도록 설계된 개념
*/

//http://localhost/spring02/list?bno=1 ==> url+파라미터
//http://localhost/spring02/list/1 ==> url
//RestController은 스프링 4.0부터 지원
//@Controller, @RestController 차이점은 메서드가 종료되면 화면전환의 유무
//@RestController 기존의 @Controller 와는 완전다른 기능임

@Slf4j
@RestController
@ RequestMapping("/boards")
public class RestBoardController {
   
   @Autowired
   private BoardService boardService;
   
   @GetMapping("/list")
   public List<BoardVO> list(){
      log.info("list()..");
      
      return boardService.getList();
   }
   
   @GetMapping("/{bid}")
   public BoardVO restContentView(BoardVO boardVO){
      log.info("restContentView()..");
      
      return boardService.get(boardVO.getBid());
   }
   
//   @DeleteMapping("/{bid}")
//   public String restDelete(BoardVO boardVO){
//      log.info("restDelete()..");
//      boardService.remove(boardVO.getBid());
//      
//      return "Success";
//   }
   
 @DeleteMapping("/{bid}")
 public ResponseEntity<String> restDelete(BoardVO boardVO){
	 ResponseEntity<String> entity = null;
    log.info("restDelete()..");
    
    try {
    	 boardService.remove(boardVO.getBid());
    	 //삭제가 성공하면 성공 상태메시지 저장
    	 entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);		
	} catch (Exception e) {
		e.printStackTrace();
		//삭제가 실패하면 실패 상태메시지 저장
   	 entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);		
	}
    return entity;
 }
   
   
   
   @GetMapping("/start")
   public ModelAndView start(ModelAndView mv){
      log.info("start()..");      
      mv.setViewName("/board/rest_list");            
      return mv;
   }
   

   
}