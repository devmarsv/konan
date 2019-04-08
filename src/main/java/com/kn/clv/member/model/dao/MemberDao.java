package com.kn.clv.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kn.clv.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	//마이바티스 연동 객체 선언
	@Autowired
	private SqlSessionTemplate mybatisSession;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public Member loginCheck(Member member) {	
		
		Member loginMember = mybatisSession.selectOne(
				"memberMapper.loginCheck", member);
	
		if(!bcryptPasswordEncoder.matches(
				member.getUserpwd(), 
				loginMember.getUserpwd())) {
			loginMember = null;
		}
		
		return loginMember;
	}

	public int insertMember(Member member) {		
		return mybatisSession.insert(
				"memberMapper.insertMember", member);

	}
}
