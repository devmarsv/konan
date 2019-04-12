package com.kn.clv.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.vo.Notice;



public interface AdminService{
	
	// 1) 전체회원 조회
	List<Member> adminMemberList(HashMap<String, Object> map);
	// 2) 전체회원 수 조회
	int adminMemberListCount();
	// 3) 전체회원 조회 Default
	List<Member> adminMemberSearchDefault();
    // 4) 회원 검색 전체 
	List<Member> adminMemberSearchAll(String all);
	// 5) 회원 검색 이름
	List<Member> adminMemberSearchName(String noticeWriter);
	// 6) 회원 검색 아이디
	List<Member> adminMemberSearchId(String id);
    // 7) 회원 업데이트 삭제
	int adminMemberUpdateDelete(String userid);
	// 8) 회원 삭제
	int adminMemberDelete(String userid);
	// 9) 공지 리스트
	List<Notice> adminNoticeList(HashMap<String, Object> map);
	// 10) 공지 리스트 수
	int adminNoticeListCount(HashMap<String, Object> map);
	// 11) 공지 조회수
	void adminNoticeReadCount(int noticeno);
	// 12) 공지 상세보기
	Notice adminNoticeDetail(HashMap<String, Object> map);
	
	Member selectMember(String userid);
	
	
	
	
	
	int suspectListCount();
	List<Member> suspectAll(HashMap<String, Object> map);
	int adminNoticedelete(int boardNum);
	
}
