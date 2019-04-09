package com.kn.clv.notice.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.notice.model.vo.Notice;

@Repository("NoticeDao")
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public List<Notice> selectNoticeList(HashMap<String, Object> map){
		return session.selectList("noticeMapper.selectList", map);
		
	}
	
	public int listCount() {
		return session.selectOne("noticeMapper.listCount");
	}

	public Notice selectNotice(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("noticeMapper.selectNotice", map);
	}
	
	public void addReadcount(int noticeno) {
		session.selectOne("noticeMapper.addReadCount", noticeno);
	}

	public int insertNotice(Notice notice) {
		return session.insert("noticeMapper.insertNotice", notice);
	}
	

}
