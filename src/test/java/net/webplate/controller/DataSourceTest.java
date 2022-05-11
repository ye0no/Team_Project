package net.webplate.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class DataSourceTest {

	@Inject //자동 의존성 주입 =>의존성 주입 방법으로는 생성자를 통한 의존성 주입, setter()메서드를 통한 의존성 주입
	private DataSource ds;
	
	@Test
	public void testCon() throws Exception{
		try(Connection con=ds.getConnection()){
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
