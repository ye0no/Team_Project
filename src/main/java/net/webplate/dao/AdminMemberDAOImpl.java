package net.webplate.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.webplate.vo.MemberVO;

@Repository
public class AdminMemberDAOImpl implements AdminMemberDAO {

	
	@Autowired
	private SqlSession sql;
	
    /* 검색전후 목록수 */
	@Override
	public int getListcount(MemberVO m) {
		return sql.selectOne("admem_cnt",m);
	}
	
	
	/* 검색전후 리스트 */
	@Override
	public List<MemberVO> getMemberList(MemberVO m) {
		return sql.selectList("admem_list",m);
	}

    /* 계정 삭제*/
	@Override
	public void DeleteMember(String id) {
		sql.delete("admem_del",id);
	}
   
     /* 계정 수정을 위한 계정 조회 */
	@Override
	public MemberVO getMember(String id) {
		return sql.selectOne("admem_Edit",id);
	}


	@Override
	public void edit(MemberVO m) {
		sql.update("admem_Edit_ok",m);
	}
}
