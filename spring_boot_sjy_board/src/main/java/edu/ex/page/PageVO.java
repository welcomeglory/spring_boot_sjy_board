package edu.ex.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageVO {
	private int startPage;//화면에 보여지는 페이지 시작번호
	private int endPage;//화면에 보여지는 끝번호
	
	private boolean pre, next; //이전과 다음으로 이동가능한 링크 표시
	private int total;//전체 게시판 글 수
	private Criteria criteria;
	
	public PageVO(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;		
	}
	
	
}
