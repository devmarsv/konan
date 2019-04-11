package com.kn.clv.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.vo.Notice;



public interface AdminService{
	Member loginCheck(Member member);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String userid);
	ArrayList<Member> memberAll();
	int memberListCount();
	List<Member> memberAll(HashMap<String, Object> map);
	int noticeListCount();
	List<Notice> noticeAll(HashMap<String, Object> map);
	List<Member> selectSearchAll(String all);
	List<Member> selectSearchName(String noticeWriter);
	List<Member> selectSearchId(String id);
	int updateDeleteMember(String userid);
	Member selectMember(String userid);
}
