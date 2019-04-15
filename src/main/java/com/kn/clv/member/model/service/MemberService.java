package com.kn.clv.member.model.service;

import java.util.ArrayList;

import com.kn.clv.member.model.vo.Member;

public interface MemberService {
	Member loginCheck(Member member);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String userid);
	ArrayList<Member> selectBoard();
	ArrayList<Member> selectReply();
	int idcheck(String userid);
	int emailCheck(String email);
	int emailSuccess(String userid);
	int changePwd(Member mem);
	String pwdEmailCheck(String email);
	String findId(String email);
	String findEmail(String email);
}
