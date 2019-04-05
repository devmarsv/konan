package com.kn.clv.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping("search.do")
	public String movenoticePage() {
		return "search/searchView";
	}
	
	
	@RequestMapping("sdetail.do")
	public String movendetailPage() {
		return "search/searchDetailView";
	}

}
