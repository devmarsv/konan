package com.kn.clv.search.model.service;

import java.util.*;
import com.kn.clv.search.model.vo.Search;
import com.kn.clv.search.model.vo.Searchsuspect;
import com.kn.clv.suspect.model.vo.Suspect;

public interface SearchService {

	//List<Search> searchAll(HashMap<String, Object> map);
	int listCount(HashMap<String, Object> map);
	void addReadCouunt(int suspect_no);
	Search searchdetail(HashMap<String, Object> map);
	Searchsuspect selectSuspect(int suspect_no);
	List<Suspect> suspectAll(HashMap<String, Object> map);

}
