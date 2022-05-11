package net.webplate.vo;

import lombok.Data;

@Data
public class ReviewVO {
	private int rno;
	private int f_num;
	private String mem_id;
	private int r_point;
	private String r_cont;
	private String regdate;
	
	private int Startrow;
	private int Endrow;

}
