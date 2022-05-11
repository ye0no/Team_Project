package net.webplate.service;

import java.util.List;

import net.webplate.vo.MemberVO;

public interface AdminMemberService {

	List<MemberVO> getMemberList(MemberVO m);

	int getListcount(MemberVO m);

	void DelteMember(String id);

	MemberVO getMember(String id);

	void edit(MemberVO m);

	

}
