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
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public Member loginCheck(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Member> memberAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberListCount() {
		// TODO Auto-generated method stub
		return adminDao.memberListCount();
	}

	@Override
	public List<Member> memberAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.memberAll(map);
	}

	@Override
	public int noticeListCount() {
		// TODO Auto-generated method stub
		return noticeDao.listCount();
	}

	@Override
	public List<Notice> noticeAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeList(map);
	
	}

}
