package com.kn.clv.search.model.service;

import java.util.*;
import com.kn.clv.search.model.vo.Search;
import com.kn.clv.search.model.vo.Searchsuspect;

public interface SearchService {

	List<Search> searchAll(HashMap<String, Object> map);
	int listCount(HashMap<String, Object> map);
	void addReadCouunt(int board_num);
	Search searchdetail(HashMap<String, Object> map);
	Searchsuspect selectSuspect(int board_num);

}
