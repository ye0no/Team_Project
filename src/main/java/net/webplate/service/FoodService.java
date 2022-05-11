package net.webplate.service;


import java.util.List;

import net.webplate.vo.FoodVO;

public interface FoodService {

	int getListCount(FoodVO food);

	List<FoodVO> getBoardList(FoodVO food);

	int getTotalCount(FoodVO food);
    
	
	// �˻� ��� 
	int getSearchCount(FoodVO food);

	List<FoodVO> getSearchList(FoodVO food);

	List<FoodVO> getAddrCont(String divide);

	// ������ �޴� �з�
	int foodAreaCount(String divide);

	int foodArea_Hit(String divide);
	
    // ���� ���� ����Ʈ
	List<FoodVO> getTop_8(String pig);
	
	 // �ϰ� ���� ��������Ʈ �з�
	List<FoodVO> getCondList(String eat);
	
     // �ϰ� ���� ��������Ʈ ��ȸ��
	int getContHit(String eat);
	
	 // �ϰ� ���� ��������Ʈ ����
	int getCont_Count(String eat);

	List<FoodVO> getTop_8();
	
	List<FoodVO> getLike_state(String Sid);

	List<FoodVO> getCondList2(FoodVO food);
	
	// ������ ��������Ʈ
	List<FoodVO> getAddrCont2(FoodVO food);
	
	// �޴��� ��������Ʈ ��ȸ
	int getTotal_MenuContHit(String eat2);
	
	// ȸ���� ���� �޴�����Ʈ ���ƿ� ����
	List<FoodVO> getMenuList2(FoodVO food);
    //�޴�����Ʈ ���ƿ� ����
	List<FoodVO> getMenuList(String eat2);
    
	
	

	


	
	




	
	
	




	


}
