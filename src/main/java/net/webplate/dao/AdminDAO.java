package net.webplate.dao;

import java.util.List;

import net.webplate.vo.AdminVO;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.ReviewVO;

public interface AdminDAO {


	AdminVO adminLogin(String admin_id);

	void insertAdmin(AdminVO ab);

	int getFoodListCount(FoodVO food);

	List<FoodVO> getFoodList(FoodVO food);

	FoodVO getAdminFoodCont(int f_num);

	void editFoodCont(FoodVO food);

	FoodVO getDetails(int f_num);

	void getHit(int f_num);

	void insertReview(ReviewVO r);

	double getPoint(int f_num);

	void updateReviewPoint(FoodVO food);
     
	// 조회수 감소
	void downhit(ReviewVO r);

	List<FoodVO> getmem_cont(FoodVO f);

	List<FoodVO> getnon_cont(FoodVO f);

	List<ReviewVO> GetReviewInfo(ReviewVO review);

	int GetReviewInfoCount(ReviewVO review);

	String getmem_id(ReviewVO review);

	void updateReviewEdit(ReviewVO review);

	void delReview(ReviewVO review);
   
	// 관리자 리뷰 삭제
	
	void delReview(int rno);




	

}
