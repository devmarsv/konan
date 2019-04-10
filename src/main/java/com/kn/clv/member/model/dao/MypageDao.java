package com.kn.clv.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kn.clv.member.model.vo.Member;

@Repository("mypageDao")
public class MypageDao {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public int updateInfo(Member member) {
		member.setUserpwd(bcryptPasswordEncoder.encode(member.getUserpwd()));
		return mybatis.update("mypage.updateInfo",member);
	}
	

}
