package net.webplate.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberVO idcheck(String id) {
		return sqlSession.selectOne("m_check",id);
	}
	
	// 로그인 체크
	@Override
	public MemberVO loginCheck(String login_id) {
		return sqlSession.selectOne("login_check",login_id);
	}

	@Override
	public MemberVO getMember(String Sid) {
		return sqlSession.selectOne("member_list",Sid);
	}

	@Override
	public void insertMember(MemberVO m) {
		sqlSession.insert("mem_in",m);
	}

	@Override
	public void updateMember(MemberVO m) {
		sqlSession.update("mem_edit",m);
	}

	@Override
	public void delMember(MemberVO dm) {
		sqlSession.update("mem_del",dm);
	}

	@Override
	public MemberVO pwdMember(MemberVO m) {
		return sqlSession.selectOne("mem_pwd",m);
	}

	@Override
	public void updatePwd(MemberVO m) {
		sqlSession.update("pwd_edit",m);
	}

	@Override
	public MemberVO Idfind(MemberVO m) {
		return sqlSession.selectOne("id_find",m);
	}

	@Override
	public List<FoodVO> like_view(String Sid) {
		return sqlSession.selectList("like_view",Sid);
	}

	@Override
	public void likeDel(FoodVO food) {
		sqlSession.delete("like_User_del",food);
	}


	
	
	

	

	


	
}
