package net.webplate.dao;

import java.util.HashMap;

import net.webplate.vo.LikeVO;

public interface LikeDAO {


	public int likecreate(HashMap hashMap);

	public int likecancel(HashMap hashMap);

	public LikeVO read(HashMap hashMap);

	public int like_check(HashMap hashMap);

	public int firstcheck(HashMap hashMap);

}
