package net.webplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.webplate.dao.MemberDAO;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public MemberVO idcheck(String id) {
		return memberDao.idcheck(id);
	}

	@Override
	public MemberVO loginCheck(String login_id) {
		return memberDao.loginCheck(login_id);
	}

	@Override
	public MemberVO getMember(String Sid) {
		return memberDao.getMember(Sid);
	}

	@Override
	public void insertMember(MemberVO m) {
		memberDao.insertMember(m);
	}

	@Override
	public void updateMember(MemberVO m) {
		memberDao.updateMember(m);
	}

	@Override
	public void delMember(MemberVO dm) {
		memberDao.delMember(dm);
	}

	@Override
	public MemberVO pwdMember(MemberVO m) {
		return memberDao.pwdMember(m);
	}

	@Override
	public void updatePwd(MemberVO m) {
		memberDao.updatePwd(m);
	}

	@Override
	public MemberVO Idfind(MemberVO m) {
		return memberDao.Idfind(m);
	}

	@Override
	public List<FoodVO> like_view(String Sid) {
		return memberDao.like_view(Sid);
	}

	@Override
	public void likeDel(FoodVO food) {
		memberDao.likeDel(food);		
	}





}
