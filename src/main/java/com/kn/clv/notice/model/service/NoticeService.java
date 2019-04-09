package com.kn.clv.notice.model.service;

import java.util.*;

import com.kn.clv.notice.model.vo.Notice;

public interface NoticeService {
	List<Notice> noticeAll(HashMap<String, Object> map);
	int listCount();
	Notice noticedetail(HashMap<String, Object> map);
	void addReadcount(int noticeno);
	int insertNotice(Notice notice);
	
}
