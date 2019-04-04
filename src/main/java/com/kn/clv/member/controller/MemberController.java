package com.kn.clv.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kn.clv.test.controller.TestController;

@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("login.do")
	public String moveLoginPage() {
		return "member/login";
	}
	
	@RequestMapping("join.do")
	public String moveJoinPage() {
		return "member/Join";
	}
	
	@RequestMapping("id.do")
	public String moveIdPage() {
		return "member/ID";
	}
	
	@RequestMapping("myInfo.do")
	public String moveMyInfoPage() {
		return "member/myInfo";
	}
	
	@RequestMapping("alterInfo.do")
	public String moveAlterInfoPage() {
		return "member/alterInfo";
	}
	
	@RequestMapping("myBoard.do")
	public String moveMyBoardPage() {
		return "member/myBoard";
	}
	
	@RequestMapping("myConnection.do")
	public String moveMyConnectionPage() {
		return "member/myConnection";
	}
	
	@RequestMapping("myReply.do")
	public String moveMyReplyPage() {
		return "member/myReply";
	}

}
