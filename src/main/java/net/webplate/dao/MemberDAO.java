package net.webplate.dao;

import java.util.List;

import net.webplate.vo.FoodVO;
import net.webplate.vo.MemberVO;

public interface MemberDAO {

	MemberVO idcheck(String id);

	MemberVO loginCheck(String login_id);

	MemberVO getMember(String Sid);

	void insertMember(MemberVO m);

	void updateMember(MemberVO m);

	void delMember(MemberVO dm);

	MemberVO pwdMember(MemberVO m);

	void updatePwd(MemberVO m);

	MemberVO Idfind(MemberVO m);

	List<FoodVO> like_view(String sid);

	void likeDel(FoodVO food);



	

	


}
