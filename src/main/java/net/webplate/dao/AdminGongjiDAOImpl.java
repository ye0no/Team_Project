package net.webplate.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.webplate.vo.AdminGongjiVO;

@Repository
public class AdminGongjiDAOImpl implements AdminGongjiDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public int getListcount(AdminGongjiVO g) {
		return sql.selectOne("gongji_count",g);
	}

	@Override
	public List<AdminGongjiVO> getGongjiList(AdminGongjiVO g) {		
		return sql.selectList("gongji_list",g);
	}

	@Override
	public String findAdmin_name(String admin_id) {
		return sql.selectOne("find_admin_name",admin_id);
	}

	@Override
	public void insertGongji(AdminGongjiVO gongji) {
		sql.insert("gongji_insert",gongji);
		
	}

	@Override
	public AdminGongjiVO getInfo(int gongji_no) {
		return sql.selectOne("gongji_info",gongji_no);
	}

	@Override
	public void updateHit(int gongji_no) {
		sql.update("gongji_hit",gongji_no);
		
	}

	@Override
	public void DeleteGongji(int gongji_no) {
		sql.delete("gongji_del",gongji_no);
		
	}

	@Override
	public void edit(AdminGongjiVO gongji) {
		sql.update("gongji_edit",gongji);		
	}

}
