package edu.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalgradeEmpVO {
	private int grade;	
	private int losal;
	private int hisal;
	private List<DeptEmpVO> DeptEmpList;
}
