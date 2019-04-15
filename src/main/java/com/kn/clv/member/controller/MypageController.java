package com.kn.clv.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.service.MypageService;
import com.kn.clv.member.model.vo.ConnectionData;
import com.kn.clv.member.model.vo.FindBoardAndReply;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.member.util.CreaterConnection;

@Controller
public class MypageController {

	@Autowired
	MypageService mypageService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping("myInfo.do")
	public String moveMyInfoPage() {
		return "member/mypage/myInfo";
	}

	@RequestMapping("alterInfo.do")
	public String moveAlterInfoPage() {
		return "member/mypage/alterInfo";
	}
	
	@RequestMapping("moveDropInfo.do")
	public String moveDropInfo() {
		return "member/mypage/dropInfo";
	}
	
	@RequestMapping("dropInfo.do")
	public String dropInfo(@RequestParam("userid") String userid, @RequestParam("userpwd") String userpwd, HttpSession session, HttpServletRequest request) {
		Member member = (Member)session.getAttribute("loginMember");
		if(bcryptPasswordEncoder.matches(userpwd, member.getUserpwd())) {
			int result = mypageService.dropInfo(member.getUserid());
			if(result > 0) {
				session.invalidate();
				request.setAttribute("msg", "탈퇴 처리 실패되었습니다.");
			}else {
				request.setAttribute("msg", "탈퇴 처리되었습니다.");
			}
			request.setAttribute("url", "main.do");
		}else {
			request.setAttribute("msg", "비밀번호를 확인해주세요.");
			request.setAttribute("url", "moveDropInfo.do");
		}
		return "member/join,login/redirect";
	}
	

	@RequestMapping("myConnection.do")
	public ModelAndView moveMyConnectionPage(HttpServletRequest request, ModelAndView model, HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			model.setViewName("index");
			return model;
		}
		String userid = ((Member) session.getAttribute("loginMember")).getUserid();
		String savePath = request.getSession().getServletContext().getRealPath("resources/userConnection") + "\\" + userid + ".txt";
		
		ArrayList<ConnectionData> list = new CreaterConnection().connectionList(savePath);
		
		int currentPage = 1;
		int allCount = list.size();
		int maxPage = (int) ((double) allCount / 10 + 0.9);
		
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		if (currentPage > maxPage) {
			currentPage = maxPage;
		}

		int currentMin;
		int currentMax;

		currentMax = (int) ((currentPage / 10 + 0.9) * 10);

		if (currentMax > maxPage) {
			currentMax = maxPage;
		}

		if (currentPage >= 10) {
			currentMin = currentPage / 10 * 10;
		} else {
			currentMin = 1;
		}

//		System.out.println("board : " + list);
//		System.out.println("currentPage : " + currentPage + ", currentMax : " + currentMax + ", currentMin : " + currentMin + ", maxPage : " + maxPage + ", allcount : " + allCount);
		
		model.addObject("board", list);
		model.addObject("currentPage", currentPage);
		model.addObject("currentMax", currentMax);
		model.addObject("currentMin", currentMin);
		model.addObject("maxPage", maxPage);
		model.addObject("allCount", allCount);
		
		model.setViewName("member/mypage/myConnection");
		return model;
	}

	// 페이징 처리
	@RequestMapping("myReply.do")
	public ModelAndView moveMyReplyPage(HttpServletRequest request, ModelAndView model, HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			model.setViewName("index");
			return model;
		}

		String userid = ((Member) session.getAttribute("loginMember")).getUserid();

		int currentPage = 1;
		int allCount = mypageService.countReplyList(userid);
		int maxPage = (int) ((double) allCount / 10 + 0.9);
		
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		if (currentPage > maxPage) {
			currentPage = maxPage;
		}

		int currentMin;
		int currentMax;

		currentMax = (int) ((currentPage / 10 + 0.9) * 10);

		if (currentMax > maxPage) {
			currentMax = maxPage;
		}

		if (currentPage >= 10) {
			currentMin = currentPage / 10 * 10;
		} else {
			currentMin = 1;
		}

		ArrayList<BoardReply> board = mypageService.findAllReply(new FindBoardAndReply(currentPage, userid));

		model.addObject("board", board);
		model.addObject("currentPage", currentPage);
		model.addObject("currentMax", currentMax);
		model.addObject("currentMin", currentMin);
		model.addObject("maxPage", maxPage);
		model.addObject("allCount", allCount);
		model.setViewName("member/mypage/myReply");
		return model;
	}

	@RequestMapping("myBoard.do")
	public ModelAndView moveMyBoardPage(HttpServletRequest request, ModelAndView model, HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			model.setViewName("index");
			return model;
		}

		String userid = ((Member) session.getAttribute("loginMember")).getUserid();

		int currentPage = 1;
		int allCount = mypageService.countBoardList(userid);
		int maxPage = (int) ((double) allCount / 10 + 0.9);

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		if (currentPage > maxPage) {
			currentPage = maxPage;
		}

		int currentMin;
		int currentMax;

		currentMax = (int) ((currentPage / 10 + 0.9) * 10);

		if (currentMax > maxPage) {
			currentMax = maxPage;
		}

		if (currentPage >= 10) {
			currentMin = currentPage / 10 * 10;
		} else {
			currentMin = 1;
		}

		ArrayList<Board> board = mypageService.findAllBoard(new FindBoardAndReply(currentPage, userid));

		model.addObject("board", board);
		model.addObject("currentPage", currentPage);
		model.addObject("currentMax", currentMax);
		model.addObject("currentMin", currentMin);
		model.addObject("maxPage", maxPage);
		model.addObject("allCount", allCount);
		model.setViewName("member/mypage/myBoard");
		return model;
	}

	@RequestMapping(value = "alterInfoDo.do", method = RequestMethod.POST)
	public String alterInfo(Member member, HttpServletRequest request,
			@RequestParam(name = "image", required = false) MultipartFile file,
			@RequestParam(name = "delete", defaultValue = "false") boolean delete) {

		if (!delete) {
			if (!file.isEmpty()) {
				// 파일 저장 폴더 지정하기
				String savePath = request.getSession().getServletContext().getRealPath("resources/profileImage");
				try {
					file.transferTo(new File(savePath + "\\" + member.getUserid() + ".png"));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			String savePath = request.getSession().getServletContext()
					.getRealPath("resources/profileImage\\" + member.getUserid() + ".png");
			File saveFile = new File(savePath);
			if (saveFile.exists()) {
				saveFile.delete();
			}
		}

		int result = mypageService.updateInfo(member);
		return result > 0 ? "member/mypage/myInfo" : "common/error";
	}

	// Ajax 메소드
	@RequestMapping("imageDelete.do")
	@ResponseBody
	public void imageDelete(@RequestBody String userid, HttpServletRequest request) {
		String savePath = request.getSession().getServletContext()
				.getRealPath("resources/profileImage\\" + userid + ".png");

		File file = new File(savePath);
		if (file.exists()) {
			file.delete();
		}
	}

	@RequestMapping("findBoard.do")
	@ResponseBody
	public ArrayList<Board> findBoard(@RequestBody String userid, HttpServletRequest request) {
		return mypageService.findBoard(userid);
	}

	@RequestMapping("findReply.do")
	@ResponseBody
	public ArrayList<BoardReply> findReply(@RequestBody String userid, HttpServletRequest request) {
		return mypageService.findReply(userid);
	}

}
