package net.webplate.food;

import java.sql.*;

import net.webplate.vo.FoodVO;
public class Insert_food {
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="web2";
	private String pw="2222";
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	
	public Insert_food() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("로딩 성공");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,user,pw);
			System.out.println("연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	// 푸드 값 추가하기 
	
	public int save(FoodVO vo) {
		int  res=0;
		
		try {
			String sql="insert into food(f_num,bsnscond,bsnsnm,menu,addr,lat,lng,tel,regdate) values(f_num.nextval,?,?,?,?,?,?,?,sysdate)";
			con=getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getBsnscond());
			pstmt.setString(2, vo.getBsnsnm());
			pstmt.setString(3, vo.getMenu());
			pstmt.setString(4, vo.getAddr());
			pstmt.setString(5, vo.getLat());
			pstmt.setString(6, vo.getLng());
			pstmt.setString(7, vo.getTel());
			res=pstmt.executeUpdate();
			
			System.out.println("1개행의 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	// 푸드 값 추가하기 
	
		public int save2(FoodVO vo) {
			int  res=0;
			
			try {
				String sql="insert into food(f_num,bsnscond,bsnsnm,menu,addr,lat,lng,tel,rest,suyong,regdate) values(f_num.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
				con=getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,vo.getBsnscond());
				pstmt.setString(2, vo.getBsnsnm());
				pstmt.setString(3, vo.getMenu());
				pstmt.setString(4, vo.getAddr());
				pstmt.setString(5, vo.getLat());
				pstmt.setString(6, vo.getLng());
				pstmt.setString(7, vo.getTel());
				pstmt.setString(8, vo.getRest());
				pstmt.setString(9, vo.getSuyong());
				res=pstmt.executeUpdate();
				
				System.out.println("1개행의 성공");
			}catch(Exception e) {
				e.printStackTrace();
			}
			return res;
		}
	

}
