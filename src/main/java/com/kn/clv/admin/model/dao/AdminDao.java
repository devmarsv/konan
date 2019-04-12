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

	// 1) 전체회원 조회
	public List<Member> adminMemberList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

		return session.selectList("adminMapper.adminMemberList", map);
	}

	// 2) 전체회원 수 조회
	public int adminMemberListCount() {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminMemberListCount");
	}

	// 3) 전체회원 조회 Default
	public List<Member> adminMemberSearchDefault() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchDefault");
	}

	// 4) 회원 검색 전체
	public List<Member> adminMemberSearchAll(String all) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchAll", all);
	}

	// 5) 회원 검색 이름
	public List<Member> adminMemberSearchName(String name) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchName", name);
	}

	// 6) 회원 검색 아이디
	public List<Member> adminMemberSearchId(String id) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchId", id);
	}

	// 7) 회원 업데이트 삭제
	public int adminMemberUpdateDelete(String userid) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminMemberUpdateDelete", userid);
	}

	// 8) 회원 삭제
	public int adminDeleteMember(String userid) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminDeleteMember", userid);
	}

	// 9) 공지 리스트
	public List<Notice> adminNoticeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminNoticeList", map);
	}

	// 10) 공지 리스트 수
	public int adminNoticeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminNoticeListCount", map);
	}

	// 11) 공지 조회 수
	public void adminNoticeReadCount(int noticeno) {
		// TODO Auto-generated method stub
		session.selectOne("adminMapper.addNoticeReadCount", noticeno);
	}

	// 12) 공지 상세보기
	public Notice adminNoticeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminNoticeDetail", map);
	}

	// 13) 공지 삭제
	public int adminNoticeDelete(int boardNum) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminNoticeDelete", boardNum);
	}

	// 14) 용의자 리스트
	public List<Member> adminSuspectList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectList", map);
	}

	// 15) 용의자 리스트 수
	public int adminSuspectListCount() {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminSuspectListCount");
	}
    
	// 16) 테스트
	public Member selectMember(String userid) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectMember", userid);
	}

}
