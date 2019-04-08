package com.kn.clv.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.member.model.dao.MemberDao;
import com.kn.clv.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl 
implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Member> memberAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
