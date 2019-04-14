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
		if (loginMember != null && !bcryptPasswordEncoder.matches(member.getUserpwd(), loginMember.getUserpwd())) {
			loginMember = null;
		}
		return loginMember;
	}

	public int insertMember(Member member) {
		member.setUserpwd(bcryptPasswordEncoder.encode(member.getUserpwd()));
		int result = mybatisSession.insert("memberMapper.insertMember", member);
		return result;
	}

	public int idcheck(String userid) {
		return mybatisSession.selectOne("memberMapper.checkId", userid);
	}

	public int emailCheck(String email) {
		return mybatisSession.selectOne("memberMapper.checkEmail", email);
	}

	public int emailSuccess(String userid) {
		return mybatisSession.update("memberMapper.emailSuccess", userid);
	}

	public int changePwd(Member mem) {
		mem.setUserpwd(bcryptPasswordEncoder.encode(mem.getUserpwd()));
		return mybatisSession.update("memberMapper.changePwd", mem);
	}

	public String pwdEmailCheck(String email) {
		return mybatisSession.selectOne("memberMapper.pwdEmailCheck", email);
	}

	//Email로 Id찾기 메소드
	public String findId(String email) {
		return mybatisSession.selectOne("memberMapper.findId", email);
	}

	public String findEmail(String email) {
		return mybatisSession.selectOne("memberMapper.findEmail", email);
	}

}
