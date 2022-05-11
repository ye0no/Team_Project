package net.webplate.service;

import java.util.HashMap;

import net.webplate.vo.LikeVO;

public interface LikeService {

	public int create(HashMap hashMap);

	int like_check_cancel(HashMap hashMap);

	public LikeVO read(HashMap hashMap);

	public int like_check(HashMap hashMap);

	public int firstcheck(HashMap hashMap);

}
