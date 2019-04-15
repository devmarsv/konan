package com.kn.clv.search.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.search.model.vo.Search;



@Repository("SearchDao")
public class SearchDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public List<Search> selectSearchList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("searchMapper.selectList", map);
	}

	public int listCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("searchMapper.listCount", map);
	}

}
