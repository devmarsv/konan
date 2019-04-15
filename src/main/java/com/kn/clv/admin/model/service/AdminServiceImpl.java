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
import com.kn.clv.suspect.model.vo.Suspect;

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
	
	// 4) 회원 수정 시 ajax 회원 선택
	@Override
	public Member adminMemberSelect(String userid) {
	// TODO Auto-generated method stub
			return adminDao.adminMemberSelect(userid);
	}
	
	// 5) 회원 이름 수정
	@Override
	public int adminMemberUpdateName(Member member) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateName(member);
	}

	// 6) 회원 번호 수정
	@Override
	public int adminMemberUpdatePhone(Member member) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdatePhone(member);
	}

	// 7) 회원 상태 수정
	@Override
	public int adminMemberUpdateState(Member member) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateState(member);
	}
	
	// 8) 회원 검색 전체
	@Override
	public List<Member> adminMemberSearchAll(String all) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchAll(all);
	}

	// 9) 회원 검색 이름
	@Override
	public List<Member> adminMemberSearchName(String noticeWriter) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchName(noticeWriter);
	}

	// 10) 회원 검색 아이디
	@Override
	public List<Member> adminMemberSearchId(String id) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberSearchId(id);
	}

	// 11) 회원 업데이트 삭제
	@Override
	public int adminMemberUpdateDelete(String userid) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateDelete(userid);
	}

	// 12) 회원 삭제
	@Override
	public int adminMemberDelete(String userid) {
		// TODO Auto-generated method stub
		return adminDao.adminDeleteMember(userid);
	}

	// 13) 공지 리스트
	@Override
	public List<Notice> adminNoticeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeList(map);

	}

	// 14) 공지 리스트 수
	@Override
	public int adminNoticeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeListCount(map);
	}

	// 15) 공지 조회수
	@Override
	public void adminNoticeReadCount(int noticeno) {
		// TODO Auto-generated method stub
		adminDao.adminNoticeReadCount(noticeno);
	}

	// 16) 공지 상세보기
	@Override
	public Notice adminNoticeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeDetail(map);
	}

	// 17) 공지 삭제
	@Override
	public int adminNoticeDelete(int boardNum) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeDelete(boardNum);
	}

	// 18) 용의자 리스트
	@Override
	public List<Member> adminSuspectList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectList(map);
	}

	// 19) 용의자 리스트 수
	@Override
	public int adminSuspectListCount() {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectListCount();
	}

	
    // 20) 피의자 ajax 수정 시 선택
	@Override
	public Suspect adminSuspectSelect(int suspect_no) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectSelect(suspect_no);
	}

	
	// 21) 피의자 ajax 수정 이름 승인 
	@Override
	public int adminSuspectUpdateName(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateName(suspect);
	}

	// 22) 피의자 ajax 수정 계좌 승인 
	@Override
	public int adminSuspectUpdateAccount(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateAccount(suspect);
	}

	// 23) 피의자 ajax 수정 번호 승인 
	@Override
	public int adminSuspectUpdatePhone(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdatePhone(suspect);
	}

	// 24) 피의자 ajax 수정 횟수 승인 
	@Override
	public int adminSuspectUpdateCount(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateCount(suspect);
	}

	// 25) 피의자 삭제
	@Override
	public int adminSuspectDelete(int suspect_no) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectDelete(suspect_no);
	}

	// 26) 피의자 검색 Default
	@Override
	public List<Suspect> adminSuspectSearchDefault() {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectSearchDefault();
	}

	// 27) 피의자 검색 전체
	@Override
	public List<Suspect> adminSuspectSearchAll(String all) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectSearchAll(all);
	}

	// 28) 피의자 검색 이름
	@Override
	public List<Suspect> adminSuspectSearchName(String name) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectSearchName(name);
	}
 
	// 29) 피의자 검색 번호
	@Override
	public List<Suspect> adminSuspectSearchPhone(String phone) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectSearchPhone(phone);
	}


}
