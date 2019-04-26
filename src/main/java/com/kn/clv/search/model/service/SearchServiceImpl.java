package com.kn.clv.search.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.search.model.dao.SearchDao;
import com.kn.clv.search.model.vo.Search;
import com.kn.clv.search.model.vo.Searchsuspect;
import com.kn.clv.suspect.model.vo.Suspect;

@Service("searchService")
public class SearchServiceImpl 
implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	/*@Override
	public List<Search> searchAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDao.selectSearchList(map);
	}*/

	@Override
	public int listCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDao.listCount(map);
	}

	@Override
	public void addReadCouunt(int suspect_no) {
		searchDao.addReadCount(suspect_no);
		
	}

	@Override
	public Search searchdetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDao.searchDetail(map);
	}

	@Override
	public Searchsuspect selectSuspect(int suspect_no) {
		// TODO Auto-generated method stub
		return searchDao.selectSuspect(suspect_no);
	}

	@Override
	public List<Suspect> suspectAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return searchDao.selectSuspectList(map);
	}
	
}
