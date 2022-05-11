package net.webplate.service;

import java.util.List;

import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.MemberVO;

public interface MemberService {

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
	
	// 삭제 버튼 누르면 좋아요 삭제
	void likeDel(FoodVO food);
	
	

	

	

	
	


}
