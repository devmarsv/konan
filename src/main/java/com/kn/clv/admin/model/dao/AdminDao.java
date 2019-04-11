package com.kn.clv.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.vo.Notice;
@Repository("adminDao")
public class AdminDao {
	  @Autowired
	  private SqlSessionTemplate session;
	  
	public int memberListCount() {
		// TODO Auto-generated method stub
		return session.selectOne("memberMapper.getListCount");
	}

	public List<Member> memberAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
		return session.selectList("memberMapper.selectList", map);
	}

	public List<Notice> noticeAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Member> selectSearchAll(String all) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectSearchAll", all);
	}

	public List<Member> selectSearchName(String name) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectSearchName", name);
	}

	public List<Member> selectSearchId(String id) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectSearchId", id);
	}

	public int deleteMember(String userid) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.deleteMember", userid);
	}
	
	public int updateDeleteMember(String userid) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.updateDeleteMember", userid);
	}

	public Member selectMember(String userid) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectMember", userid);
	}

	public List<Member> selectMember() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectSearchDefault");
	}

	public int listCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
