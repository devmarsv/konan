package com.kn.clv.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("board.do")
	public String movenoticePage() {
		return "board/boardListView";
	}
	
	@RequestMapping("bform.do")
	public String movenformPage() {
		return "board/boardForm";
	}
	
	@RequestMapping("bdetail.do")
	public String movendetailPage() {
		return "board/boardDetailView";
	}
}
