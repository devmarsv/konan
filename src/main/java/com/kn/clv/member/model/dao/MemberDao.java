package com.kn.clv.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kn.clv.member.model.vo.Member;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate mybatisSession;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public Member loginCheck(Member member) {
		Member loginMember = mybatisSession.selectOne("memberMapper.loginCheck", member);
		if(!bcryptPasswordEncoder.matches(member.getUserpwd(), loginMember.getUserpwd())) {
			loginMember = null;
		}
		return loginMember;
	}
	
	public int insertMember(Member member) {
		member.setUserpwd(bcryptPasswordEncoder.encode(member.getUserpwd()));
		int result = mybatisSession.insert("memberMapper.insertMember", member);
		return result;
	}
	

}
