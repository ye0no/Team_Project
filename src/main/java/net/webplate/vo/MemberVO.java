package net.webplate.vo;




public class MemberVO {
	
	
	private String id;
	private String pw;
	private String name;
	private String jumin1;
	private String jumin2;
	private String jumin3;	
	private String gender;
	private String email;
	private String tel;
	private String mem_state;
	private String mem_date;
	private String mem_delcont;
	private String mem_deldate;
	
	// 관리자 페이징
	private int startrow;
	private int endrow;
	
	
	// 관리자 회원 목록 검색 기능
	private String find_name; // 검색어
	private String find_field; // 검색 필드
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin1() {
		return jumin1;
	}
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	public String getJumin3() {
		return jumin3;
	}
	public void setJumin3(String jumin3) {
		this.jumin3 = jumin3;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMem_state() {
		return mem_state;
	}
	public void setMem_state(String mem_state) {
		this.mem_state = mem_state;
	}
	public String getMem_date() {
		return mem_date;
	}
	public void setMem_date(String mem_date) {
		this.mem_date = mem_date;
	}
	public String getMem_delcont() {
		return mem_delcont;
	}
	public void setMem_delcont(String mem_delcont) {
		this.mem_delcont = mem_delcont;
	}
	public String getMem_deldate() {
		return mem_deldate;
	}
	public void setMem_deldate(String mem_deldate) {
		this.mem_deldate = mem_deldate;
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
	
	
	
	
		

}
