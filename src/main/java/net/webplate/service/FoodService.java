package net.webplate.service;


import java.util.List;

import net.webplate.vo.FoodVO;

public interface FoodService {

	int getListCount(FoodVO food);

	List<FoodVO> getBoardList(FoodVO food);

	int getTotalCount(FoodVO food);
    
	
	// 검색 기능 
	int getSearchCount(FoodVO food);

	List<FoodVO> getSearchList(FoodVO food);

	List<FoodVO> getAddrCont(String divide);

	// 지역별 메뉴 분류
	int foodAreaCount(String divide);

	int foodArea_Hit(String divide);
	
    // 돼지 맛집 리스트
	List<FoodVO> getTop_8(String pig);
	
	 // 믿고 보는 맛집리스트 분류
	List<FoodVO> getCondList(String eat);
	
     // 믿고 보는 맛집리스트 조회수
	int getContHit(String eat);
	
	 // 믿고 보는 맛집리스트 개수
	int getCont_Count(String eat);

	List<FoodVO> getTop_8();
	
	List<FoodVO> getLike_state(String Sid);

	List<FoodVO> getCondList2(FoodVO food);
	
	// 지역별 맛집리스트
	List<FoodVO> getAddrCont2(FoodVO food);
	
	// 메뉴별 맛집리스트 조회
	int getTotal_MenuContHit(String eat2);
	
	// 회원에 따라 메뉴리스트 좋아요 구분
	List<FoodVO> getMenuList2(FoodVO food);
    //메뉴리스트 좋아요 구분
	List<FoodVO> getMenuList(String eat2);
    
	
	

	


	
	




	
	
	




	


}
