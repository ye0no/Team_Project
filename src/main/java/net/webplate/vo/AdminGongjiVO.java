package net.webplate.vo;

public class AdminGongjiVO {
	
	private int gongji_no;
	private String title;
	private String writer;
	private String gongji_cont;
	private String gongji_register;
	private int hit;
	
	private int startrow;
	private int endrow;
	
	
	private String find_name; // 검색어
	private String find_field; // 검색 필드
	
	
	public int getGongji_no() {
		return gongji_no;
	}
	public void setGongji_no(int gongji_no) {
		this.gongji_no = gongji_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGongji_cont() {
		return gongji_cont;
	}
	public void setGongji_cont(String gongji_cont) {
		this.gongji_cont = gongji_cont;
	}
	public String getGongji_register() {
		return gongji_register;
	}
	public void setGongji_register(String gongji_register) {
		this.gongji_register = gongji_register;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public String getFind_name() {
		return find_name;
	}
	public void setFind_name(String find_name) {
		this.find_name = find_name;
	}
	public String getFind_field() {
		return find_field;
	}
	public void setFind_field(String find_field) {
		this.find_field = find_field;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
	

}
