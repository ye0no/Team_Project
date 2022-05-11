package net.webplate.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.webplate.dao.LikeDAO;
import net.webplate.dao.MemberDAO;
import net.webplate.vo.LikeVO;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private LikeDAO likeDAO;
	
	
	@Override
	public int create(HashMap hashMap) {
		return likeDAO.likecreate(hashMap);
	}

	@Override
	public int like_check_cancel(HashMap hashMap) {
		return likeDAO.likecancel(hashMap);
		
	}

	@Override
	public LikeVO read(HashMap hashMap) {
		return likeDAO.read(hashMap);
	}

	@Override
	public int like_check(HashMap hashMap) {
		return likeDAO.like_check(hashMap);
	}

	@Override
	public int firstcheck(HashMap hashMap) {
		return likeDAO.firstcheck(hashMap);
	}

}
