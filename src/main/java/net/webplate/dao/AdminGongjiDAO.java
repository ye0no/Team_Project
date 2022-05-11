package net.webplate.dao;

import java.util.List;

import net.webplate.vo.AdminGongjiVO;

public interface AdminGongjiDAO {

	int getListcount(AdminGongjiVO g);

	List<AdminGongjiVO> getGongjiList(AdminGongjiVO g);

	String findAdmin_name(String admin_id);

	void insertGongji(AdminGongjiVO gongji);

	AdminGongjiVO getInfo(int gongji_no);

	void updateHit(int gongji_no);

	void DeleteGongji(int gongji_no);

	void edit(AdminGongjiVO gongji);

}
