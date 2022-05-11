package net.webplate.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
public class OracleConTest {
	private static final String Driver="oracle.jdbc.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String User="web2";
	private static final String PW="2222";
	
	@Test
	public void testCon() throws Exception {
		Class.forName(Driver);
		
		try(Connection con=DriverManager.getConnection(URL,User,PW)){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

} 
