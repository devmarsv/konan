package com.kn.clv.board.controller;

import java.io.File;
import java.io.IOException;
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

import com.kn.clv.board.model.service.BoardService;
import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.Member;


@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@RequestMapping("board.do")
	public String movenoticePage(Model model, HttpServletRequest request) {
		String cg = request.getParameter("cg");
		String bar = request.getParameter("bar");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cg", cg);
		map.put("bar", bar);

		//페이징
		int currentPage = 1;
		if(request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int limit = 10;	//한 페이지에 출력할 목록 갯수 지정
		int listCount = boardService.listCount(map);	//총 목록 갯수 조회
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

		if(currentPage > maxPage) {
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

		map.put("startRow", startRow);
		map.put("endRow", endRow);
		System.out.println("map :" + map );

		List<Board> list = boardService.boardAll(map);
		System.out.println("boardList : " + list);  
		
		
		model.addAttribute("boardList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("currentMax", currentMax);
		model.addAttribute("currentMin", currentMin);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);

		return "board/boardListView";
	}

	@RequestMapping("bform.do")
	public String movenformPage() {
		return "board/boardForm";
	}

	@RequestMapping("binsert.do")
	public String boardinsert(Board board, HttpServletRequest request,
			@RequestParam(name="upfile", required=false) MultipartFile file,
			@RequestParam("title") String title, @RequestParam("writer") String writer,
			@RequestParam("content") String content, Model model) {

	
		board.setBoard_title(title);
		board.setBoard_writer(writer);
		board.setBoard_content(content);
		
		board.setBoard_original_filename(file.getOriginalFilename());
		board.setBoard_rename_filename(file.getOriginalFilename());
		
		System.out.println("board :" + board);
		
		int result = boardService.insertBoard(board);

		//파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("resources\\files\\boardfile");

		if(file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
			try {
				file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		String viewFileName = null;
		if(result > 0) {
			viewFileName = "redirect:board.do";
		}else {
			model.addAttribute("message", "게시판등록실패");
			viewFileName="common/error";
		}

		return viewFileName;
	}

	@RequestMapping("bdetail.do")
	public String movendetailPage(Model model, HttpServletRequest request, HttpSession session) {
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

		File downFile = new File(savePath + "\\" +fileName);

		return new ModelAndView("filedown", "downFile", downFile);
	}
	
	
	//게시글 삭제
	@RequestMapping("bdelete.do")
	public void deleteBoard(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		boardService.deleteBoard(board_num);
		boardService.deleteBreply2(board_num);
		System.out.println("board_num : " + board_num);
		
		response.sendRedirect("board.do");
	}
	
	//게시글 수정뷰
	@RequestMapping("bupdateView.do")
	public String updateBoardView(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		map.put("board_num", board_num);
		Board board = boardService.boarddetail(map);

		model.addAttribute("board_num", board_num);
		model.addAttribute("board", board);
		
		return "board/boardUpdateView";
	}
	
	//게시글 수정
	@RequestMapping("bupdate.do")
	public String updateBoard(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name="upfile", required=false) MultipartFile renameFile,
			@RequestParam("ofile") String originFileName,
			@RequestParam("title") String title,
			@RequestParam("content") String content) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		//파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("resources\\files\\boardfile");
		
		//1. 오리지날 파일 삭제 
		String originFilePath = savePath + "\\" + originFileName;
		//이전파일 삭제 
		File originFile = new File(originFilePath);
		if (originFile.exists()) {
			originFile.delete();
		}
		
		//2. 업로드파일 업로드
		//파일 업로드
		if(renameFile.getOriginalFilename() != null && !"".equals(renameFile.getOriginalFilename())) {
			try {
				renameFile.transferTo(new File(savePath + "\\" + renameFile.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}	
			map.put("title", title);
			map.put("content", content);
			map.put("board_num", board_num);
			map.put("originFileName", renameFile.getOriginalFilename());
			//map.put("renameFile", renameFile.getOriginalFilename());
			
			int result = boardService.boardupdate(map);

			model.addAttribute("board_num", board_num);
			
		
		String viewFileName = null;
		if(result > 0) {
			viewFileName = "redirect:board.do";
		}else {
			model.addAttribute("message", "게시판글수정실패");
			viewFileName="common/error";
		}

		return viewFileName;
	}
	

	//댓글
	@RequestMapping(value="addBreply.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> boardReply(
			@RequestParam("content") String content,
			@RequestParam("board_num") String board_num,
			HttpServletRequest request, HttpSession session){
		Member member = (Member)session.getAttribute("loginMember");
		BoardReply boardReply = new BoardReply();
		System.out.println("컨트롤러 : " + content);
		boardReply.setBoard_reply_content(content);
		boardReply.setBoard_num(Integer.parseInt(board_num));
		boardReply.setUserid(member.getUserid());
		System.out.println("컨트롤러 boardReply: " + boardReply);
		int result = boardService.addBreply(boardReply);
		JSONObject json = new JSONObject();
		json.put("result", result);
		System.out.println("result" + result);
		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	}

	//게시물 댓글 불러오기
	@RequestMapping(value="breplyList.do", method=RequestMethod.POST, produces="application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity<String> commentList(@RequestParam("board_num") String board_num,
			HttpServletRequest request) throws IOException{
		BoardReply boardReply = new BoardReply();
		boardReply.setBoard_num(Integer.parseInt(board_num));
		//해당게시물댓글
		List<BoardReply> replyList = boardService.selectReply(boardReply);
		JSONArray json = new JSONArray();
		System.out.println("replyList : " + replyList);
		if(replyList.size() > 0) {
			for(int i =0; i<replyList.size(); i++) {
				JSONObject joj = new JSONObject();
				joj.put("writer", replyList.get(i).getUserid());
				joj.put("date", replyList.get(i).getBoard_reply_date().toString());
				joj.put("comment", replyList.get(i).getBoard_reply_content());
				joj.put("br_num", replyList.get(i).getBoard_reply_num());

				json.add(joj);
			}
		}
		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	}
	
	//댓글 삭제
	@RequestMapping("deleteBreply.do")
	public void deleteBreply(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		int br_num = Integer.parseInt(request.getParameter("br_num"));
		System.out.println("br_num : " + br_num);
		boardService.deleteBreply(br_num);
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		System.out.println("board_num : " + board_num);
		
		response.sendRedirect("bdetail.do?board_num="+board_num);
	}

}
