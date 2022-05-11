package net.webplate.dao;

import java.util.List;

import net.webplate.vo.MemberVO;

public interface AdminMemberDAO {

	int getListcount(MemberVO m);

	List<MemberVO> getMemberList(MemberVO m);

	void DeleteMember(String id);

	MemberVO getMember(String id);

	void edit(MemberVO m);

	

}
