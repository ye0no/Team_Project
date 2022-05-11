package net.webplate.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.webplate.dao.FoodDAO;
import net.webplate.vo.FoodVO;


@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodDAO foodDao;

	@Override
	public int getListCount(FoodVO food) {
		return foodDao.getListCount(food);
	}

	@Override
	public List<FoodVO> getBoardList(FoodVO food) {
		return foodDao.getBoardList(food);
	}

	@Override
	public int getTotalCount(FoodVO food) {
		return foodDao.getTotalCount(food);
	}

	@Override
	public int getSearchCount(FoodVO food) {
		return foodDao.getSerachCount(food);
	}

	@Override
	public List<FoodVO> getSearchList(FoodVO food) {		
		return foodDao.getSearchList(food);
	}

	@Override
	public List<FoodVO> getAddrCont(String divide) {
		return foodDao.getAddrCont(divide);
	}

	@Override
	public int foodAreaCount(String divide) {
		return foodDao.foodAreaCount(divide);
	}

	@Override
	public int foodArea_Hit(String divide) {
		return foodDao.foodArea_Hit(divide);
	}

	@Override
	public List<FoodVO> getTop_8(String pig) {
		return foodDao.getTop_8(pig);
	}

	@Override
	public List<FoodVO> getCondList(String eat) {
		return foodDao.getCondList(eat);
	}

	@Override
	public int getContHit(String eat) {
		return foodDao.getContHit(eat);
	}

	@Override
	public int getCont_Count(String eat) {
		return foodDao.getCont_Count(eat);
	}
	
	// 평점 탑 8 리스트 출력
	@Override
	public List<FoodVO> getTop_8() {
		
		return foodDao.getTop_8();
	}

	@Override
	public List<FoodVO> getLike_state(String Sid) {
		return foodDao.getLike_state(Sid);
	}

	// 좋아요 구분하기 위한 믿고보는 맛집리스트
	@Override
	public List<FoodVO> getCondList2(FoodVO food) {		
		return foodDao.getCondList2(food);
	}
	
	// 좋아요 구분하기 위한 지역별 맛집리스트
	@Override
	public List<FoodVO> getAddrCont2(FoodVO food) {
		return foodDao.getAddrCont2(food);
	}

	@Override
	public int getTotal_MenuContHit(String eat2) {
		return foodDao.getTotal_MenuContHit(eat2);
	}

	@Override
	public List<FoodVO> getMenuList2(FoodVO food) {		
		return foodDao.getMenuList2(food);
	}

	@Override
	public List<FoodVO> getMenuList(String eat2) {
		return foodDao.getMenuList(eat2);
	}




	
	












}
