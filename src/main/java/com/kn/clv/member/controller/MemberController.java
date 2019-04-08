package com.kn.clv.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String loginCheck(Member member, HttpSession session, SessionStatus status, HttpServletRequest request) {
		logger.info("member : " + member);
		Member check = memberService.loginCheck(member);
		if(check != null) {
			status.setComplete();
			session.setAttribute("loginMember", check);
			return "index";
		}else {
			request.setAttribute("message", "아이디와 비밀번호를 확인해주세요.");
			return "member/login";
		}
	}
	
	@RequestMapping("joinDo.do")
	public String join(Member member, HttpServletRequest request) {
		logger.info("member : " + member);
		int result = memberService.insertMember(member);
		if(result <= 0) {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		return result > 0 ? "index" : "member/Join";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("idcheck.do")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userid){
		Map<Object, Object> map = new HashMap<Object, Object>();
		int score = memberService.idcheck(userid);
		map.put("cnt", score);
		return map;
	}
	
	
	@RequestMapping("emailCheck.do")
	@ResponseBody
	public Map<Object, Object> emailCheck(@RequestBody String email){
		Map<Object, Object> map = new HashMap<Object, Object>();
		int score = memberService.emailCheck(email);
		map.put("cnt", score);
		return map;
	}
	
	
	
}
