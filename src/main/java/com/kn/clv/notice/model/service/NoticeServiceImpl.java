package com.kn.clv.notice.model.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.notice.model.vo.Notice;
import com.kn.clv.notice.model.dao.NoticeDao;

@Service("noticeService")
public class NoticeServiceImpl 
implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Notice> noticeAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return noticeDao.selectNoticeList(map);
	}

	@Override
	public int listCount(HashMap<String, Object> map) {
		return noticeDao.listCount(map);
	}

	@Override
	public Notice noticedetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return noticeDao.selectNotice(map);
	}

	@Override
	public int insertNotice(Notice notice) {
		System.out.println("service notice:" + notice);
		return noticeDao.insertNotice(notice);
	}

	@Override
	public void addReadcount(int noticeno) {
		noticeDao.addReadcount(noticeno);
	}



}
