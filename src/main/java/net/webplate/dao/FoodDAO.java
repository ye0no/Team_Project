package net.webplate.dao;

import java.util.List;

import net.webplate.vo.FoodVO;

public interface FoodDAO {

	int getListCount(FoodVO food);

	List<FoodVO> getBoardList(FoodVO food);

	int getTotalCount(FoodVO food);

	int getSerachCount(FoodVO food);

	List<FoodVO> getSearchList(FoodVO food);

	List<FoodVO> getAddrCont(String divide);

	int foodAreaCount(String divide);

	int foodArea_Hit(String divide);
	
	// Å¾8 ÃßÃµ
	List<FoodVO> getTop_8(String pig);
   
	List<FoodVO> getCondList(String eat);

	int getContHit(String eat);

	int getCont_Count(String eat);

	List<FoodVO> getTop_8();
	
	List<FoodVO> getLike_state(String Sid);

	List<FoodVO> getCondList2(FoodVO food);

	List<FoodVO> getAddrCont2(FoodVO food);

	int getTotal_MenuContHit(String eat2);

	List<FoodVO> getMenuList2(FoodVO food);

	List<FoodVO> getMenuList(String eat2);



	



	






}
