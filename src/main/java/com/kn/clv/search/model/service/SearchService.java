package com.kn.clv.search.model.service;

import java.util.*;
import com.kn.clv.search.model.vo.Search;

public interface SearchService {

	List<Search> searchAll(HashMap<String, Object> map);
	int listCount(HashMap<String, Object> map);

}
