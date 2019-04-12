package com.kn.clv.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.admin.model.dao.AdminDao;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.dao.NoticeDao;
import com.kn.clv.notice.model.vo.Notice;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	// 1) 전체회원 조회
	@Override
	public List<Member> adminMemberList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberList(map);
	}

	// 2) 전체회원 수 조회
	@Override
	public int adminMemberListCount() {
		// TODO Auto-generated method stub
		return adminDao.adminMemberListCount();
	}

	// 3) 전체회원 조회 Default
	@Override
	public List<Member> adminMemberSearchDefault() {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchDefault();
	}

	// 4) 회원 검색 전체
	@Override
	public List<Member> adminMemberSearchAll(String all) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchAll(all);
	}

	// 5) 회원 검색 이름
	@Override
	public List<Member> adminMemberSearchName(String noticeWriter) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchName(noticeWriter);
	}

	// 6) 회원 검색 아이디
	@Override
	public List<Member> adminMemberSearchId(String id) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchId(id);
	}

	// 7) 회원 업데이트 삭제
	@Override
	public int adminMemberUpdateDelete(String userid) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateDelete(userid);
	}

	// 8) 회원 삭제
	@Override
	public int adminMemberDelete(String userid) {
		// TODO Auto-generated method stub
		return adminDao.adminDeleteMember(userid);
	}

	// 9) 공지 리스트
	@Override
	public List<Notice> adminNoticeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeList(map);

	}

	// 10) 공지 리스트 수
	@Override
	public int adminNoticeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeListCount(map);
	}

	// 11) 공지 조회수
	@Override
	public void adminNoticeReadCount(int noticeno) {
		// TODO Auto-generated method stub
		adminDao.adminNoticeReadCount(noticeno);
	}

	// 12) 공지 상세보기
	@Override
	public Notice adminNoticeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeDetail(map);
	}

	// 13) 공지 삭제
	@Override
	public int adminNoticeDelete(int boardNum) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeDelete(boardNum);
	}

	// 14) 용의자 리스트
	@Override
	public List<Member> adminSuspectList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectList(map);
	}

	// 15) 용의자 리스트 수
	@Override
	public int adminSuspectListCount() {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectListCount();
	}

	// 16) 테스트
	@Override
	public Member selectMember(String userid) {
		// TODO Auto-generated method stub
		return adminDao.selectMember(userid);
	}

}
