package com.kn.clv.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kn.clv.admin.model.service.AdminService;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.service.NoticeService;
import com.kn.clv.notice.model.vo.Notice;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private NoticeService noticeService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	// 1) 전체회원 페이징
	@RequestMapping("adminMemberList.do")
	public String adminMemberList(Model model, HttpServletRequest request) {
		int currentPage = 1;
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int limit = 10; // 한 페이지에 출력할 목록 갯수 지정
		int listCount = adminService.adminMemberListCount(); // 총 목록 갯수 조회
		// 총 페이지 수 계산
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지가 포함된 페이지 그룹의 시작값
		int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
		// 현재 페이지가 포함된 페이지 그룹의 끝값
		int endPage = startPage + limit - 1;
		// 쿼리문에 반영할 현재 페이지에 출력될 시작행과 끝행 계산

		if (maxPage < endPage)
			endPage = maxPage;

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		System.out.println("star : " + startRow);
		System.out.println("end : " + endRow);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<Member> list = adminService.adminMemberList(map);

		model.addAttribute("list", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "admin/adminMember";
	}

	// 2) 회원검색
	@RequestMapping("adminMemberSearch.do")
	public String memberSearch(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String search = request.getParameter("search");

		System.out.println("search : " + search);
		List<Member> list = null;

		if (request.getParameter("keyword").length() == 0) {
			list = adminService.adminMemberSearchDefault();
			model.addAttribute("list", list);
			return "admin/adminMember";
		}

		switch (search) {
		case "all":
			String all = request.getParameter("keyword");
			System.out.println("all : " + all);
			list = adminService.adminMemberSearchAll(all);
			break;
		case "name":
			String name = request.getParameter("keyword");
			list = adminService.adminMemberSearchName(name);
			break;
		case "id":
			String id = request.getParameter("keyword");
			list = adminService.adminMemberSearchId(id);
			break;

		}

		if (list.size() > 0) {
			System.out.println("list : " + list);
			model.addAttribute("list", list);
			return "admin/adminMember";
		} else {
			System.out.println("check ");
			model.addAttribute("message", search + "조회 실패!");
			model.addAttribute("list", list);
			return "admin/adminMember";
		}

	}

	// 3) 회원삭제
	@RequestMapping("adminMemberDelete.do")
	public String memberDelete(Model model, HttpServletRequest request, HttpServletResponse response) {

		String userId = request.getParameter("userid");
		int result = adminService.adminMemberDelete(userId);

		if (result > 0) {
			return "logout.do";
		} else {

			model.addAttribute("message", userId + " 님의 탈퇴처리가 실패하였습니다.");

			return "common/error";
		}

	}

	// 4) 회원 업데이트 삭제
	@RequestMapping("adminMemberUpdateDelete.do")
	public void memberUpdateDelete(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String userid = (String) (request.getParameter("userid"));

		int result = adminService.adminMemberUpdateDelete(userid);

		if (result > 0) {
			response.sendRedirect("adminm.do");
			// return movendetailPage(model, request);

		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			// return "common/error";
			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 5) 공지사항 페이징, 검색
	@RequestMapping("adminNoticeList.do")
	public String noticePage(Model model, HttpServletRequest request) {
		// 페이징
		String cg = request.getParameter("cg");
		String bar = request.getParameter("bar");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cg", cg);
		map.put("bar", bar);

		// 페이징
		int currentPage = 1;
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int limit = 10; // 한 페이지에 출력할 목록 갯수 지정
		int listCount = adminService.adminNoticeListCount(map); // 총 목록 갯수 조회
		// 총 페이지 수 계산
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지가 포함된 페이지 그룹의 시작값
		int startPage = ((int) ((double) currentPage / limit + 0.9));
		// 현재 페이지가 포함된 페이지 그룹의 끝값
		int endPage = startPage + limit - 1;

		if (maxPage < endPage)
			endPage = maxPage;

		// 쿼리문에 반영할 현재 페이지에 출력될 시작행과 끝행 계산
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<Notice> list = adminService.adminNoticeList(map);

		model.addAttribute("noticeList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);

		return "admin/adminNotice";
	}

	// 6) 공지사항 상세보기
	@RequestMapping("adminNoticeDetail.do")
	public String noticeDetail(Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));

		adminService.addNoticeReadcount(noticeno);

		map.put("noticeno", noticeno);
		Notice notice = adminService.adminNoticeDetail(map);

		model.addAttribute("noticeno", noticeno);
		model.addAttribute("notice", notice);
		return "admin/adminNoticeDetailView";
	}

	// 7) 공지사항 삭제
	@RequestMapping("adminNoticeDelete.do")
	public String deleteNotice(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 페이징
		/*
		 * int currentPage; if(request.getParameter("page") != null) currentPage =
		 * Integer.parseInt(request.getParameter("page"));
		 */

		int boardNum = Integer.parseInt(request.getParameter("bnum"));

		if (adminService.adminNoticedelete(boardNum) > 0) {
			// response.sendRedirect("/first/blist?page=1");
			return "admin/adminNotice";
		} else {
			// RequestDispatcher view =
			// request.getRequestDispatcher("views/board/boardError.jsp");
			// request.setAttribute("message", boardNum + "번글 삭제 실패!" );
			// view.forward(request, response);
			model.addAttribute("message", boardNum + "번글 삭제 실패!");
			return "admin/boardError";
		}

	}

	// 8) 피의자 페이징
	@RequestMapping("admins.do")
	public String moveSuspect(Model model, HttpServletRequest request) {
		int currentPage = 1;
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int limit = 10; // 한 페이지에 출력할 목록 갯수 지정
		int listCount = adminService.suspectListCount(); // 총 목록 갯수 조회
		// 총 페이지 수 계산
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현재 페이지가 포함된 페이지 그룹의 시작값
		int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
		// 현재 페이지가 포함된 페이지 그룹의 끝값
		int endPage = startPage + limit - 1;
		// 쿼리문에 반영할 현재 페이지에 출력될 시작행과 끝행 계산

		if (maxPage < endPage)
			endPage = maxPage;

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		System.out.println("star : " + startRow);
		System.out.println("end : " + endRow);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<Member> list = adminService.suspectAll(map);

		model.addAttribute("list", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "admin/adminSuspect";
	}

	// 9) Ajax test method -------------------------------
	@RequestMapping(value = "test1.do", method = RequestMethod.POST)
	@ResponseBody
	public String test1Method(Member command, HttpServletResponse response) throws IOException {
		logger.info("test1.do run...");
		System.out.println("command : " + command);

		response.setContentType("application/json; charset=utf-8");

		JSONObject job = new JSONObject();

		Member member = adminService.selectMember(command.getUserid());

		System.out.println(member);
		job.put("userid", member.getUserid());
		job.put("username", URLEncoder.encode(member.getUsername(), "utf-8"));
		job.put("phone", member.getPhone());
		job.put("email", member.getEmail());
		job.put("state", member.getState());
		;

		return job.toJSONString();
	}

}
