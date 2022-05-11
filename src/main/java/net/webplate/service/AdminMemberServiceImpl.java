package net.webplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.webplate.dao.AdminMemberDAO;
import net.webplate.vo.MemberVO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService {
	
	@Autowired
	private AdminMemberDAO AdminmemberDao;

	@Override
	public List<MemberVO> getMemberList(MemberVO m) {
		return AdminmemberDao.getMemberList(m);
	}

	@Override
	public int getListcount(MemberVO m) {
		return AdminmemberDao.getListcount(m);
	}

	@Override
	public void DelteMember(String id) {
		AdminmemberDao.DeleteMember(id);
	}

	@Override
	public MemberVO getMember(String id) {
		return AdminmemberDao.getMember(id) ;
	}

	@Override
	public void edit(MemberVO m) {
		AdminmemberDao.edit(m);
	}

	

}
