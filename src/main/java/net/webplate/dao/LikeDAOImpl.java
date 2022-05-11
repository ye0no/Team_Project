package net.webplate.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.webplate.vo.LikeVO;

@Repository
public class LikeDAOImpl implements LikeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int likecreate(HashMap hashMap) {
		return sqlSession.insert("like_create", hashMap);
	}

	@Override
	public int likecancel(HashMap hashMap) {
		return sqlSession.delete("like_cancel", hashMap);
	}

	@Override
	public LikeVO read(HashMap hashMap) {
		LikeVO likeVO = sqlSession.selectOne("like_read", hashMap);
		return likeVO;
	}

	@Override
	public int like_check(HashMap hashMap) {
		return sqlSession.update("like_check", hashMap);

	}

	@Override
	public int firstcheck(HashMap hashMap) {
		return sqlSession.selectOne("first_check", hashMap);
	}


}
