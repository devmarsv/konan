package com.kn.clv.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.kn.clv.member.model.service.MemberService;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.member.util.CreaterConnection;
import com.kn.clv.member.util.Mail;
import com.kn.clv.member.util.SHA256;
import com.kn.clv.test.controller.TestController;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	// 페이징 처리 메소드
	@RequestMapping("login.do")
	public String moveLoginPage() {
		return "member/join,login/login";
	}

	@RequestMapping("join.do")
	public String moveJoinPage() {
		return "member/join,login/Join";
	}

	@RequestMapping("id.do")
	public String moveIdPage() {
		return "member/join,login/ID";
	}

	// 로그인 확인
	@RequestMapping("loginDo.do")
	public String loginCheck(Member member, HttpSession session, SessionStatus status, HttpServletRequest request) {
		logger.info("member : " + member);
		Member check = memberService.loginCheck(member);
		String jspName = null;
		if (check == null) {
			request.setAttribute("message", "아이디와 비밀번호를 확인해주세요.");
			return "member/join,login/login";
		}
		if (check.getState() == 0) {
			status.setComplete();
			session.setAttribute("loginMember", check);
			jspName = "index";
			String ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null)
				ip = request.getRemoteAddr();
			session.setAttribute("ip", ip);
			new CreaterConnection().createConnection(request, member);
		} else if (check.getState() == -1) {
			request.setAttribute("message", "이메일 인증이 되지 않은 계정입니다.");
			jspName = "member/join,login/login";
		} else if(check.getState() == 1) {
			request.setAttribute("message", "탈퇴된 회원입니다.");
			jspName = "member/join,login/login";
		}
		
		return jspName;
	}

	// 회원가입
	@RequestMapping("joinDo.do")
	public String join(Member member, HttpServletRequest request) {
		logger.info("member : " + member);
		int result = memberService.insertMember(member);
		if (result <= 0) {
			request.setAttribute("message", "회원가입에 실패하였습니다.");
		}
		new Mail().checkEmail(member.getUserid(), member.getEmail());
		return result > 0 ? "index" : "member/join,login/Join";
	}

	// 로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	// 이메일 인증시 해시코드 검사
	@RequestMapping("hashEmailCheck.do")
	public String hashEmailCheck(@RequestParam("code") String code, @RequestParam("userid") String userid,
			Model model) {
		String cpCode = SHA256.getSHA256(userid);
		if (code.equals(cpCode)) {
			memberService.emailSuccess(userid);
			model.addAttribute("msg", "이메일 인증 성공");
		} else {
			model.addAttribute("msg", "이메일 인증 실패");
		}
		model.addAttribute("url", "main.do");
		return "member/join,login/redirect";
	}

	// 패스워드 변경 메소드
	@RequestMapping("changePwd.do")
	public String changePwd(@RequestParam("userpwd") String userpwd, @RequestParam("userid") String userid) {
		Member mem = new Member();
		mem.setUserid(userid);
		mem.setUserpwd(userpwd);
		int result = memberService.changePwd(mem);
		return result > 0 ? "index" : "common/error";
	}

	// 패스워드 변경 이메일 인증시 해시코드 검사
	@RequestMapping("moveChangePwd.do")
	public String moveChangePwd(@RequestParam("code") String code, @RequestParam("userid") String userid,
			HttpServletRequest request) {
		String cpCode = SHA256.getSHA256(userid);
		if (code.equals(cpCode)) {
			request.setAttribute("userid", userid);
			return "member/join,login/changePwd";
		} else {
			return "common/error";
		}
	}

	// Ajax 메소드

	@RequestMapping("idcheck.do")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String userid) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		int score = memberService.idcheck(userid);
		map.put("cnt", score);
		return map;
	}

	@RequestMapping("emailCheck.do")
	@ResponseBody
	public Map<Object, Object> emailCheck(@RequestBody String email) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		int score = memberService.emailCheck(email);
		map.put("cnt", score);
		return map;
	}

	@RequestMapping("pwdEmailCheck.do")
	@ResponseBody
	public Map<Object, Object> pwdEmailCheck(@RequestBody String email) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String score = memberService.pwdEmailCheck(email);
		map.put("cnt", score);
		return map;
	}

	@RequestMapping("sendMail.do")
	@ResponseBody
	public void sendMail(@RequestBody String email) {
		System.out.println(email);
		String userid = memberService.findId(email);
		String userEmail = memberService.findEmail(email);
		new Mail().sendEmail(userEmail, userid);
	}
}
