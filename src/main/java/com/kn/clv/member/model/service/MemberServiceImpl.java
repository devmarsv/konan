package com.kn.clv.member.model.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kn.clv.member.model.dao.MemberDao;
import com.kn.clv.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;

	@Override
	public Member loginCheck(Member member) {
		return memberDao.loginCheck(member);
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	@Override
	public int updateMember(Member member) {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public int deleteMember(String userid) {
		// TODO 자동 생성된 메소드 스텁
		return 0;
	}

	@Override
	public ArrayList<Member> selectBoard() {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public ArrayList<Member> selectReply() {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}

	@Override
	public int idcheck(String userid) {
		return memberDao.idcheck(userid);
	}

	@Override
	public int emailCheck(String email) {
		return memberDao.emailCheck(email);
	}

	@Override
	public int emailSuccess(String userid) {
		return memberDao.emailSuccess(userid);
	}

	@Override
	public int changePwd(Member mem) {
		return memberDao.changePwd(mem);
	}

	@Override
	public String pwdEmailCheck(String email) {
		return memberDao.pwdEmailCheck(email);
	}

	@Override
	public String findId(String email) {
		return memberDao.findId(email);
	}

	@Override
	public String findEmail(String email) {
		return memberDao.findEmail(email);
	}

}
