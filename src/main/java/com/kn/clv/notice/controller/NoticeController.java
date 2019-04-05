package com.kn.clv.notice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
	
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@RequestMapping("notice.do")
	public String movenoticePage() {
		return "notice/noticeListView";
	}
	
	@RequestMapping("nform.do")
	public String movenformPage() {
		return "notice/noticeForm";
	}
	
	@RequestMapping("ndetail.do")
	public String movendetailPage() {
		return "notice/noticeDetailView";
	}

}
