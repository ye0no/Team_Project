package net.webplate.vo;


public class FoodVO {
	
	private int f_num;  /* 글번호 */ 
	private String bsnscond;
	private String bsnsnm;
	private String menu;
	private String addr;
	private String lat;
	private String lng;
	private String tel;
	private int viewcnt;  /* 조회수 */
	private String rest;  /*  휴무일*/ 
	private String suyong; /*  수용인원 */
	
	private String food_file1;
	private String food_file2;
	private String food_file3;
	
	private String category;
	private double grade;
	private String regdate;
	
	// 임시로 저장되기 위한 변수
	private int like_state;
	private String mem_id;	
	
	//  페이징 변수
	private int startrow;
	private int endrow;
	
	// 검색 기능
	private String find_name; // 검색어
	private String find_field; // 검색 필드
	
	
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public String getBsnscond() {
		return bsnscond;
	}
	public void setBsnscond(String bsnscond) {
		this.bsnscond = bsnscond;
	}
	public String getBsnsnm() {
		return bsnsnm;
	}
	public void setBsnsnm(String bsnsnm) {
		this.bsnsnm = bsnsnm;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getRest() {
		return rest;
	}
	public void setRest(String rest) {
		this.rest = rest;
	}
	public String getSuyong() {
		return suyong;
	}
	public void setSuyong(String suyong) {
		this.suyong = suyong;
	}
	public String getFood_file1() {
		return food_file1;
	}
	public void setFood_file1(String food_file1) {
		this.food_file1 = food_file1;
	}
	public String getFood_file2() {
		return food_file2;
	}
	public void setFood_file2(String food_file2) {
		this.food_file2 = food_file2;
	}
	public String getFood_file3() {
		return food_file3;
	}
	public void setFood_file3(String food_file3) {
		this.food_file3 = food_file3;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
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
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	public int getLike_state() {
		return like_state;
	}
	public void setLike_state(int like_state) {
		this.like_state = like_state;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	
	
	
 
}
