package net.webplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.webplate.dao.AdminDAO;
import net.webplate.vo.AdminVO;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.ReviewVO;

@Service
public class AdminServiceImpl implements AdminService {

	
	@Autowired
	private AdminDAO adminDao;
	
	@Override
	public void insertAdmin(AdminVO ab) {
		adminDao.insertAdmin(ab);
	}


	@Override
	public AdminVO adminLogin(String admin_id) {
		return adminDao.adminLogin(admin_id);
	}


	@Override
	public int getFoodListCount(FoodVO food) {
		return adminDao.getFoodListCount(food);
	}


	@Override
	public List<FoodVO> getFoodList(FoodVO food) {
		return adminDao.getFoodList(food);
	}


	@Override
	public FoodVO getAdminFoodCont(int f_num) {
		return adminDao.getAdminFoodCont(f_num);
	}


	@Override
	public void editFoodCont(FoodVO food) {
		adminDao.editFoodCont(food);
	}


	@Override
	public FoodVO getDetails(int f_num) {
		return adminDao.getDetails(f_num);
	}


	@Override
	public void getHit(int f_num) {
		adminDao.getHit(f_num);
	}

    
	
	// ¸®ºäµî·Ï
	@Transactional
	@Override
	public void insertReview(ReviewVO r) {
		adminDao.insertReview(r);	
		adminDao.downhit(r);
	}

    // ¸®ºä Æò±Õ °¡Á®¿À±â
	@Override
	public double getPoint(int f_num) {
		return adminDao.getPoint(f_num);
	}


	@Override
	public void updateReviewPoint(FoodVO food) {
		adminDao.updateReviewPoint(food);		
	}



	@Override
	public List<FoodVO> getmem_cont(FoodVO f) {
		return adminDao.getmem_cont(f);
	}


	@Override
	public List<FoodVO> getnon_cont(FoodVO f) {
		return adminDao.getnon_cont(f);
	}
	
	@Override
	public List<ReviewVO> GetReviewInfo(ReviewVO review) {
		return adminDao.GetReviewInfo(review);
	}


	@Override
	public int GetReviewInfoCount(ReviewVO review) {
		return adminDao.GetReviewInfoCount(review);
	}
	
	@Override
	public String getmem_id(ReviewVO review) {
		return adminDao.getmem_id(review);
	}

	@Transactional
	@Override
	public void updateReviewEdit(ReviewVO review) {
		this.adminDao.updateReviewEdit(review);
		adminDao.downhit(review);
		
	}

	@Transactional
	@Override
	public void delReview(ReviewVO review) {
		adminDao.delReview(review);
		adminDao.downhit(review);
		
	}


	// °ü¸®ÀÚ ¸®ºä »èÁ¦
	@Override
	public void delReview(int rno) {
		adminDao.delReview(rno);		
	}












}
