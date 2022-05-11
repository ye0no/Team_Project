package net.webplate.service;

import java.util.List;

import net.webplate.vo.AdminVO;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.ReviewVO;

public interface AdminService {

	
	void insertAdmin(AdminVO ab);
	AdminVO adminLogin(String admin_id);
	
	// ����
	int getFoodListCount(FoodVO food);
	List<FoodVO> getFoodList(FoodVO food);
	FoodVO getAdminFoodCont(int f_num);
	void editFoodCont(FoodVO food);
	FoodVO getDetails(int f_num);
	void getHit(int f_num);
	
	// ���� ���
	void insertReview(ReviewVO r);
	
	// ���� �޾ƿ���
	double getPoint(int f_num);
	// �� ����
	void updateReviewPoint(FoodVO food);
	List<FoodVO> getmem_cont(FoodVO f);
	
	List<FoodVO> getnon_cont(FoodVO f);
	
	int GetReviewInfoCount(ReviewVO review);
	
	List<ReviewVO> GetReviewInfo(ReviewVO review);
	
	void updateReviewEdit(ReviewVO review);
	
	String getmem_id(ReviewVO review);
	// ���� ����
	void delReview(ReviewVO review);
	
	// ������ ���� ����
	
	void delReview(int rno);
	
	
	
	
	
	

}
