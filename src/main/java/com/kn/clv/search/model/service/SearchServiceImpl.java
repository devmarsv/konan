package com.kn.clv.search.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.search.model.dao.SearchDao;
import com.kn.clv.search.model.vo.Search;

@Service("searchService")
public class SearchServiceImpl 
implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public List<Search> searchAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDao.selectSearchList(map);
	}

	@Override
	public int listCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDao.listCount(map);
	}
	
}
