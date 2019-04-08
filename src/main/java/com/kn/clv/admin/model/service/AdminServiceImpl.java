package com.kn.clv.admin.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kn.clv.member.model.vo.Member;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Override
	public Member loginCheck(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
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
