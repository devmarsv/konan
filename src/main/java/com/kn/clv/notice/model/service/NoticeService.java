
package com.kn.clv.notice.model.service;

import java.util.HashMap;
import java.util.List;

import com.kn.clv.notice.model.vo.Notice;

public interface NoticeService {
	List<Notice> noticeAll(HashMap<String, Object> map);
	int listCount();
	
	Notice noticedetail(HashMap<String, Object> map);
	void addReadcount(int noticeno);
	int insertNotice(Notice notice);
	int deleteBoard(int boardNum);
}

