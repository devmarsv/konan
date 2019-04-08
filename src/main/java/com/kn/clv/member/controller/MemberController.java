package com.kn.clv.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.kn.clv.member.model.service.MemberService;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.test.controller.TestController;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
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
	
	@RequestMapping("loginDo.do")
	public String loginCheck(Member member, HttpSession session, SessionStatus status) {
		logger.info("member : " + member);
		Member check = memberService.loginCheck(member);
		if(check != null) {
			status.setComplete();
			session.setAttribute("loginMember", check);
			return "index";
		}else {
			return "common/error";
		}
	}
	
	@RequestMapping("joinDo.do")
	public String join(Member member) {
		logger.info("member : " + member);
		int result = memberService.insertMember(member);
		return result > 0 ? "index" : "common/error";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
}
