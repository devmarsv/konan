package com.kn.clv.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kn.clv.board.model.service.BoardService;
import com.kn.clv.board.model.vo.Board;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@RequestMapping("board.do")
	public String movenoticePage(Model model, HttpServletRequest request){
		//페이징
		int currentPage = 1;
		if(request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int limit = 10;	//한 페이지에 출력할 목록 갯수 지정
		int listCount = boardService.listCount();	//총 목록 갯수 조회
		//총 페이지 수 계산
		int maxPage = (int)((double)listCount / limit + 0.9);
		//현재 페이지가 포함된 페이지 그룹의 시작값
		int startPage = ((int)((double)currentPage / limit + 0.9));
		//현재 페이지가 포함된 페이지 그룹의 끝값
		int endPage = startPage + limit - 1;

		if(maxPage < endPage)
			endPage = maxPage;

		//쿼리문에 반영할 현재 페이지에 출력될 시작행과 끝행 계산
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String cg = request.getParameter("cg");
		String bar = request.getParameter("bar");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		map.put("cg", cg);
		map.put("bar", bar);
		
		
		
		List<Board> list = boardService.boardAll(map);

		model.addAttribute("boardList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);

		return "board/boardListView";
	}

	@RequestMapping("bform.do")
	public String movenformPage() {
		return "board/boardForm";
	}

	@RequestMapping("bdetail.do")
	public String movendetailPage(Model model, HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		boardService.addReadcount(board_num);
		
		map.put("board_num", board_num);
		Board board = boardService.boarddetail(map);
		
		model.addAttribute("board_num", board_num);
		model.addAttribute("board", board);
		
		return "board/boardDetailView";
	}
	
	//파일 다운로드 처리용
		@RequestMapping("bdown.do")
		public ModelAndView fileDownMethod(HttpServletRequest request,
				@RequestParam("filename") String fileName) {

			String savePath = request.getSession().getServletContext().getRealPath("resources/files/boardfile");

			File downFile = new File(savePath + "\\" + fileName);

			return new ModelAndView("filedown", "downFile", downFile);
		}
	
	
}
