package edu.ex.two;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ex.page.Criteria;
import edu.ex.page.PageVO;
import edu.ex.service.BoardService;

/*
1. 인터페이스는 필요가 없음
2. sqlSession에서 제공하는 함수(selectList,selectOne)를 이용함
3.쿼리 구현을 위한 XML이 필요
해당 XML의 namespace는 개발자가 정함
 */

@Controller
@RequestMapping("/two")
public class BController2 {
   
   @Autowired
   private BService2 bService2;
      
   @RequestMapping("/list")
   public String list(Model model) throws Exception{
      
      System.out.println("list()");
      model.addAttribute("boards", bService2.selectBoardList());
      
      return "/board/list";
   }
   @GetMapping("/list2")
	public String list2(Criteria cri, Model model) throws Exception {
		System.out.println("list2()..");
		
		model.addAttribute("boards",bService2.selectBoardPagingList(cri));
				
		int total =bService2.getTotal() ;
		model.addAttribute("pageMaker", new PageVO(cri,total));
		
		return "/board/list2";
	}	
   
   
   
}