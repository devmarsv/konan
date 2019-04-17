package com.kn.clv.admin.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kn.clv.admin.model.service.AdminService;
import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.service.NoticeService;
import com.kn.clv.notice.model.vo.Notice;
import com.kn.clv.suspect.model.vo.Suspect;
import com.kn.clv.victim.model.vo.Victim;

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

		return "admin/member/adminMemberList";
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
			return "admin/member/adminMemberList";
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
			return "admin/member/adminMemberList";
		} else {
			System.out.println("check ");
			model.addAttribute("message", search + "조회 실패!");
			model.addAttribute("list", list);
			return "admin/member/adminMemberList";
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
			response.sendRedirect("adminMemberList.do");

		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 5) 회원 수정 Ajax 보기
	@RequestMapping(value = "adminMemberUpdateAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String adminMemberUpdateAjax(Member command, HttpServletResponse response) throws IOException {
		logger.info("test1.do run...");
		System.out.println("command : " + command);

		response.setContentType("application/json; charset=utf-8");

		JSONObject job = new JSONObject();

		Member member = adminService.adminMemberSelect(command.getUserid());

		System.out.println(member);
		job.put("userid", member.getUserid());
		job.put("username", URLEncoder.encode(member.getUsername(), "utf-8"));
		job.put("phone", member.getPhone());
		job.put("email", member.getEmail());
		job.put("state", member.getState());
		;

		return job.toJSONString();
	}

	// 6) 회원 수정 승인
	@RequestMapping(value = "adminMemberUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public void test2Method(Model model, Member command, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("test2.do run...");
		System.out.println("command : " + command);

		int result = 0;

		if (command.getUsername() != null) {
			result = adminService.adminMemberUpdateName(command);
		}

		else if (command.getPhone() != null) {
			result = adminService.adminMemberUpdatePhone(command);
		}

		else {
			result = adminService.adminMemberUpdateState(command);
		}

		// int result =
		// adminService.adminMemberUpdateDelete((String)request.getParameter("userid"));
		System.out.println("result: " + result);

		if (result > 0) {
			System.out.println("완료");
			response.sendRedirect("adminMemberList.do");

		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 7) 공지사항 페이징, 검색
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

		return "admin/notice/adminNoticeList";
	}

	// 8) 공지사항 상세보기
	@RequestMapping("adminNoticeDetail.do")
	public String noticeDetail(Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));

		adminService.adminNoticeReadCount(noticeno);

		map.put("noticeno", noticeno);
		Notice notice = adminService.adminNoticeDetail(map);

		model.addAttribute("noticeno", noticeno);
		model.addAttribute("notice", notice);
		return "admin/notice/adminNoticeDetailView";
	}

	// 9) 공지사항 글쓰기
	@RequestMapping("adminNoticeWrite.do")
	public String noticeinsert(Notice notice, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile file, @RequestParam("title") String title,
			@RequestParam("writer") String writer, @RequestParam("content") String content, Model model) {
		System.out.println("file : " + file.getOriginalFilename());

		notice.setNoticetitle(title);
		notice.setNoticewriter(writer);
		notice.setNoticecontent(content);
		notice.setOriginal_filepath(file.getOriginalFilename());
		String refile = "";
		notice.setRename_filepath(refile);

		System.out.println("ninsert : " + notice);
		int result = noticeService.insertNotice(notice);

		// 파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("resources\\files\\noticefile");

		if (file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
			try {
				file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		String viewFileName = null;
		if (result > 0) {
			viewFileName = "redirect:adminNoticeList.do";
		} else {
			model.addAttribute("message", "공지사항등록실패!");
			viewFileName = "common/error";
		}
		return viewFileName;
	}

	// 10) 공지사항 글쓰기 폼
	@RequestMapping("adminNoticeWriteForm.do")
	public String adminNoticeWriteForm() {
		return "admin/notice/adminNoticeWrite";
	}

	// 11) 공지사항 삭제
	@RequestMapping("adminNoticeDelete.do")
	public void deleteNotice(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 페이징
		/*
		 * int currentPage; if(request.getParameter("page") != null) currentPage =
		 * Integer.parseInt(request.getParameter("page"));
		 */

		int noticeno = Integer.parseInt(request.getParameter("noticeno"));
		System.out.println("boardnum " + noticeno);
		if (adminService.adminNoticeDelete(noticeno) > 0) {
			// response.sendRedirect("/first/blist?page=1");
			response.sendRedirect("adminNoticeList.do");
		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 12) 피의자 페이징
	@RequestMapping("adminSuspectList.do")
	public String moveSuspect(Model model, HttpServletRequest request) {
		int currentPage = 1;
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int limit = 10; // 한 페이지에 출력할 목록 갯수 지정
		int listCount = adminService.adminSuspectListCount(); // 총 목록 갯수 조회
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

		List<Member> list = adminService.adminSuspectList(map);

		model.addAttribute("list", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		return "admin/suspect/adminSuspectList";
	}

	// 13) 피의자 삭제
	@RequestMapping("adminSuspectDelete.do")
	public void adminSuspectDelete(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		int suspect_no = Integer.parseInt(request.getParameter("suspect_no"));
		System.out.println("suspect_no" + suspect_no);
		int result = adminService.adminSuspectDelete(suspect_no);

		if (result > 0) {
			System.out.println("완료");
			response.sendRedirect("adminSuspectList.do");
		} else {

			model.addAttribute("message", suspect_no + " 번 용의자 삭제처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 14) 피의자 수정 Ajax 보기
	@RequestMapping(value = "adminSuspectUpdateAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String test3d(Suspect command, HttpServletResponse response) throws IOException {
		logger.info("test1.do run...");
		System.out.println("command : " + command);

		response.setContentType("application/json; charset=utf-8");

		JSONObject job = new JSONObject();

		Suspect suspect = adminService.adminSuspectSelect(command.getSuspect_no());

		System.out.println(suspect);
		job.put("suspect_no", suspect.getSuspect_no());
		job.put("suspect_name", URLEncoder.encode(suspect.getSuspect_name(), "utf-8"));
		job.put("suspect_account", URLEncoder.encode(suspect.getSuspect_account(), "utf-8"));
		job.put("suspect_phone", suspect.getSuspect_phone());
		job.put("suspect_count", suspect.getSuspect_count());
		;

		return job.toJSONString();
	}

	// 15) 피의자 수정 승인
	@RequestMapping(value = "adminSuspectUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public void test2Method(Model model, Suspect command, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("test2.do run...");
		System.out.println("command : " + command);

		int result = 0;

		if (command.getSuspect_name() != null) {
			result = adminService.adminSuspectUpdateName(command);
		}

		else if (command.getSuspect_account() != null) {
			result = adminService.adminSuspectUpdateAccount(command);
		}

		else if (command.getSuspect_phone() != null) {
			result = adminService.adminSuspectUpdatePhone(command);
		} else {
			result = adminService.adminSuspectUpdateCount(command);
		}

		System.out.println("result: " + result);

		if (result > 0) {
			System.out.println("완료");
			response.sendRedirect("adminSuspectList.do");

		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 16) 피의자검색
	@RequestMapping("adminSuspectSearch.do")
	public String adminSuspectSearch(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String search = request.getParameter("search");

		System.out.println("search : " + search);
		List<Suspect> list = null;

		if (request.getParameter("keyword").length() == 0) {
			list = adminService.adminSuspectSearchDefault();
			model.addAttribute("list", list);
			return "admin/suspect/adminSuspectList";
		}

		switch (search) {
		case "all":
			String all = request.getParameter("keyword");
			System.out.println("all : " + all);
			list = adminService.adminSuspectSearchAll(all);
			break;
		case "name":
			String name = request.getParameter("keyword");
			list = adminService.adminSuspectSearchName(name);
			break;
		case "phone":
			String phone = request.getParameter("keyword");
			list = adminService.adminSuspectSearchPhone(phone);
			break;

		}

		if (list.size() > 0) {
			System.out.println("list : " + list);
			model.addAttribute("list", list);
			return "admin/suspect/adminSuspectList";
		} else {
			System.out.println("check ");
			model.addAttribute("message", search + "조회 실패!");
			model.addAttribute("list", list);
			return "admin/suspect/adminSuspectList";
		}

	}

	// 17) 자유게시판 페이징 및 검색
	@RequestMapping("adminFreeList.do")
	public String adminFreeList(Model model, HttpServletRequest request) {
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
		int listCount = adminService.adminFreeListCount(map); // 총 목록 갯수 조회
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

		List<Board> list = adminService.adminFreeList(map);

		model.addAttribute("boardList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);

		return "admin/board/adminFreeList";
	}

	// 18) 자유게시판 상세보기
	@RequestMapping("adminFreeDetail.do")
	public String adminFreeDetail(Model model, HttpServletRequest request, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		adminService.adminFreeReadCount(board_num);

		map.put("board_num", board_num);
		Board board = adminService.adminFreeDetail(map);

		model.addAttribute("board_num", board_num);
		model.addAttribute("board", board);

		return "admin/board/adminFreeDetailView";
	}

	// 19) 자유게시판 글쓰기
	@RequestMapping("adminFreeInsert.do")
	public String adminFreeInsert(Board board, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile file, @RequestParam("title") String title,
			@RequestParam("writer") String writer, @RequestParam("content") String content, Model model) {

		board.setBoard_title(title);
		board.setBoard_writer(writer);
		board.setBoard_content(content);
		board.setBoard_original_filename(file.getOriginalFilename());
		String refile = "";
		board.setBoard_rename_filename(refile);

		int result = adminService.adminFreeInsert(board);

		// 파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("resources\\files\\boardfile");

		if (file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
			try {
				file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		String viewFileName = null;
		if (result > 0) {
			viewFileName = "redirect:adminFreeList.do";
		} else {
			model.addAttribute("message", "공지사항등록실패");
			viewFileName = "common/error";
		}

		return viewFileName;
	}

	// 20) 자유게시판 글쓰기 폼
	@RequestMapping("adminFreeForm.do")
	public String adminFreeform() {
		return "admin/board/adminFreeForm";
	}
	// 21) 자유게시판 삭제

	@RequestMapping("adminFreeDelete.do")
	public void adminFreeDelete(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 페이징
		/*
		 * int currentPage; if(request.getParameter("page") != null) currentPage =
		 * Integer.parseInt(request.getParameter("page"));
		 */

		int board_num = Integer.parseInt(request.getParameter("board_num"));
		System.out.println("boardnum " + board_num);
		if (adminService.adminFreeDelete(board_num) > 0) {
			// response.sendRedirect("/first/blist?page=1");
			response.sendRedirect("adminFreeList.do");
		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 22) 자유게시판 파일 다운로드 처리용
	@RequestMapping("adminFreeDown.do")
	public ModelAndView adminFreeDown(HttpServletRequest request, @RequestParam("filename") String fileName) {

		String savePath = request.getSession().getServletContext().getRealPath("resources/file/boardfile");

		File downFile = new File(savePath + "\\" + fileName);

		return new ModelAndView("filedown", "downFile", downFile);
	}

	// 23) 자유게시판 댓글
	@RequestMapping(value = "adminFreeReplyInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> adminFreeReplyInsert(@RequestParam("content") String content,
			@RequestParam("board_num") String board_num, HttpServletRequest request, HttpSession session) {
		Member member = (Member) session.getAttribute("loginMember");
		BoardReply boardReply = new BoardReply();
		System.out.println("컨트롤러 : " + content);
		boardReply.setBoard_reply_content(content);
		boardReply.setBoard_num(Integer.parseInt(board_num));
		boardReply.setUserid(member.getUserid());
		System.out.println("컨트롤러 boardReply: " + boardReply);
		int result = adminService.adminFreeReplyInsert(boardReply);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println("result" + result);
		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	}

	// 24) 자유게시판 게시물 댓글 불러오기
	@RequestMapping(value = "adminFreeReplyList.do", method = RequestMethod.POST, produces = "application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity<String> adminFreeReplyList(@RequestParam("board_num") String board_num,
			HttpServletRequest request) throws IOException {
		BoardReply boardReply = new BoardReply();
		boardReply.setBoard_num(Integer.parseInt(board_num));
		// 해당게시물댓글
		List<BoardReply> replyList = adminService.adminFreeReplySelect(boardReply);
		JSONArray json = new JSONArray();
		if (replyList.size() > 0) {
			for (int i = 0; i < replyList.size(); i++) {
				JSONObject joj = new JSONObject();
				joj.put("writer", replyList.get(i).getUserid());
				joj.put("date", replyList.get(i).getBoard_reply_date().toString());
				joj.put("comment", replyList.get(i).getBoard_reply_content());

				json.add(joj);
			}
		}
		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);

	}

	// 25) 자유 게시판 댓글 Ajax
	@RequestMapping(value = "adminFreeReplyAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public String adminFreeReplyAjax(BoardReply command, HttpServletResponse response) throws IOException {
		logger.info("adminFreeReplyAjax run...");
		System.out.println("command : " + command);

		response.setContentType("application/json; charset=utf-8");

		JSONObject job = new JSONObject();

		// Member reply = adminService.adminFreeReplySelect(command);

		/*
		 * System.out.println(member); job.put("userid", member.getUserid());
		 * job.put("username", URLEncoder.encode(member.getUsername(), "utf-8"));
		 * job.put("phone", member.getPhone()); job.put("email", member.getEmail());
		 * job.put("state", member.getState()); ;
		 */

		return job.toJSONString();
	}

	// 26) 피해게시판 페이징 및 검색
	@RequestMapping("adminVictimList.do")
	public String adminVictimList(Model model, HttpServletRequest request) {
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
		int listCount = adminService.adminVictimListCount(map); // 총 목록 갯수 조회
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

		List<Board> list = adminService.adminVictimList(map);

		model.addAttribute("victimList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);

		return "admin/victim/adminVictimList";
	}

	// 27) 피해게시판 상세보기
	@RequestMapping("adminVictimDetail.do")
	public String adminVictimDetail(Model model, HttpServletRequest request, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));

		adminService.adminVictimReadCount(boardnum);

		map.put("board_num", boardnum);
		Victim victim = adminService.adminVictimDetail(map);

		model.addAttribute("board_num", boardnum);
		model.addAttribute("victim", victim);

		return "admin/victim/adminVictimDetailView";
	}

	// 28) 피해게시판 글쓰기
	@RequestMapping("adminVictimInsert.do")
	  
	public String adminVictimInsert(Victim victim,
			HttpServletRequest request, 
			@RequestParam(name="upfile", required=false) MultipartFile file,
			@RequestParam("title") String title, @RequestParam("writer") String writer,
			@RequestParam("content") String content,
			Model model) {
		System.out.println("file : " + file.getOriginalFilename());
		
		victim.setBoard_content(content);
		victim.setBoard_writer(writer);
		victim.setBoard_original_filename(file.getOriginalFilename());
		
		String refile="";
		
		victim.setBoard_rename_filename(refile);
		
		System.out.println("vinsert : " + victim);
		//int result = noticeService.insertNotice(notice);
		
		int result = adminService.adminVictimInsert(victim);
		//파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("resources\\files\\noticefile");
		
		if(file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
			try {
				file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));						
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} 
		String viewFileName = null;
		if(result > 0) {
			viewFileName="redirect:adminVictimList.do";
		}else {
			model.addAttribute("message", "공지사항등록실패!");
			viewFileName="common/error";
		}
		return viewFileName;
	}

	// 29) 피해게시판 글쓰기 폼
	@RequestMapping("adminVictimForm.do")
	public String adminVictimform() {
		return "admin/victim/adminVictimWrite";
	}
	
	// 30) 피해게시판 삭제

	@RequestMapping("adminVictimDelete.do")
	public void adminVictimDelete(Model model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 페이징
		/*
		 * int currentPage; if(request.getParameter("page") != null) currentPage =
		 * Integer.parseInt(request.getParameter("page"));
		 */

		int board_num = Integer.parseInt(request.getParameter("board_num"));
		System.out.println("boardnum " + board_num);
		if (adminService.adminVictimDelete(board_num) > 0) {
			// response.sendRedirect("/first/blist?page=1");
			response.sendRedirect("adminVictimList.do");
		} else {

			model.addAttribute("message", "탈퇴처리가 실패하였습니다.");

			response.sendRedirect("/konan/views/common/error.jsp");
		}

	}

	// 31) 피해게시판 파일 다운로드 처리용
	@RequestMapping("adminVictimDown.do")
	public ModelAndView adminVictimDown(HttpServletRequest request, @RequestParam("filename") String fileName) {

		String savePath = request.getSession().getServletContext().getRealPath("resources/file/boardfile");

		File downFile = new File(savePath + "\\" + fileName);

		return new ModelAndView("filedown", "downFile", downFile);
	}

}
