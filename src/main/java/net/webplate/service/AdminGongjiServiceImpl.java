package net.webplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.webplate.dao.AdminGongjiDAO;
import net.webplate.vo.AdminGongjiVO;


@Service
public class AdminGongjiServiceImpl implements AdminGongjiService {
	
	@Autowired
	private AdminGongjiDAO gongjiDao;

	@Override
	public int getListcount(AdminGongjiVO g) {
		return gongjiDao.getListcount(g);
	}

	@Override
	public List<AdminGongjiVO> getGongjiList(AdminGongjiVO g) {		
		return gongjiDao.getGongjiList(g);
	}

	@Override
	public String findAdmin_name(String admin_id) {
		return gongjiDao.findAdmin_name(admin_id);
	}

	@Override
	public void insertGongji(AdminGongjiVO gongji) {
		gongjiDao.insertGongji(gongji);
		
	}

	@Override
	public AdminGongjiVO getInfo(int gongji_no) {
		return gongjiDao.getInfo(gongji_no);
	}

	@Override
	public void updateHit(int gongji_no) {
		gongjiDao.updateHit(gongji_no);
	}

	@Override
	public void DeleteGongji(int gongji_no) {
		gongjiDao.DeleteGongji(gongji_no);
	}

	@Override
	public void edit(AdminGongjiVO gongji) {
		gongjiDao.edit(gongji);
	}

}
