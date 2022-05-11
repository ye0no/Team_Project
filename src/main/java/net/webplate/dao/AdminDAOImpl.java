package net.webplate.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.webplate.vo.AdminVO;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.ReviewVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SqlSession sql;
	
	@Override
	public void insertAdmin(AdminVO ab) {
		sql.insert("admin_in",ab);
	} // 관리자 저장



	@Override
	public AdminVO adminLogin(String admin_id) {
		return sql.selectOne("admin_login",admin_id);
	}



	@Override
	public int getFoodListCount(FoodVO food) {
		return sql.selectOne("admin_foodsum",food);
	}



	@Override
	public List<FoodVO> getFoodList(FoodVO food) {
		return sql.selectList("admin_foodList",food);
	}



	@Override
	public FoodVO getAdminFoodCont(int f_num) {
		return sql.selectOne("admin_foodcont",f_num);
	}



	@Override
	public void editFoodCont(FoodVO food) {
		sql.update("adfood_edit",food);
	}


    // 세부정보
	@Override
	public FoodVO getDetails(int f_num) {
		return sql.selectOne("admin_food_detail",f_num);
	}


     // 조회수 증가
	@Override
	public void getHit(int f_num) {
		sql.update("adfood_hit_up",f_num);
	}
	
	// 조회수 감소
	@Override
	public void downhit(ReviewVO r) {
		sql.update("food_hit_down",r);
	}


    // 리뷰등록
	@Override
	public void insertReview(ReviewVO r) {
		sql.insert("review_insert",r);
		
	}



	@Override
	public double getPoint(int f_num) {		
		return sql.selectOne("review_point",f_num);		
	}


     // 점수 갱신
	@Override
	public void updateReviewPoint(FoodVO food) {
		sql.update("food_grade",food);
		
	}


	 // 회원일때 세부내역 조회
		@Override
		public List<FoodVO> getmem_cont(FoodVO f) {
			return sql.selectList("food_like_m_state",f);
		}


	    // 비회원일때  세부내역 조회
		@Override
		public List<FoodVO> getnon_cont(FoodVO f) {
			return sql.selectList("food_like_none",f);
		}
		
		
		@Override
		public List<ReviewVO> GetReviewInfo(ReviewVO review) {
			return sql.selectList("review_read", review);
		}



		@Override
		public int GetReviewInfoCount(ReviewVO review) {
			return sql.selectOne("review_csum", review);
		}
		
		
		@Override
		public String getmem_id(ReviewVO review) {
			return sql.selectOne("review_memid", review);
		}



		@Override
		public void updateReviewEdit(ReviewVO review) {
			this.sql.update("review_editok", review);
			
		}



		@Override
		public void delReview(ReviewVO review) {
			sql.delete("review_delok",review);
			
		}


		
       
		// 관리자 리뷰 삭제
		@Override
		public void delReview(int rno) {
			sql.delete("review_addel_ok",rno);
			
		}





	

}
