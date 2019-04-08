package com.kn.clv.admin.model.service;

import java.util.ArrayList;

import com.kn.clv.member.model.vo.Member;



public interface AdminService{
	Member loginCheck(Member member);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String userid);
	ArrayList<Member> memberAll();
}
