package com.kn.clv.victim.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.kn.clv.suspect.model.vo.Suspect;
import com.kn.clv.victim.model.service.VictimService;
import com.kn.clv.victim.model.vo.Victim;

@Controller
public class VictimController {

	private static final Logger logger = LoggerFactory.getLogger(VictimController.class);

	@Autowired
	private VictimService victimService;

	@RequestMapping("victim.do")
	public String movenoticePage() {
		return "victim/victimEnrollForm";
	}
	
	@RequestMapping("victimboard.do")
	public String movenoticePage(Model model, HttpServletRequest request) {
		String cg = request.getParameter("cg");
		String bar = request.getParameter("bar");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cg", cg);
		map.put("bar", bar);

		// 페이징
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10; // 한페이지에 출력할 목록 갯수 지정
		int listCount = victimService.listCount(map); // 총 목록 갯수 조회
		// 총 페이지 수 계산
		int maxPage = (int) ((double) listCount / limit + 0.9);
		// 현제 페이지가 포함된 페이지 그룹의 시작값
		int startPage = ((int) ((double) currentPage / limit + 0.9));
		// 현재 페이지가 포함된 페이지 그룹의 끝값
		int endPage = startPage + limit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}

		// 쿼리문에 반영할 현재 페이지에 출력될 시작행과 끝행 계산
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<Victim> list = victimService.victimAll(map);

		model.addAttribute("victimList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);
		return "victim/victimListView";
	}

	/*@RequestMapping("vform.do")
	public String movenformPage() {
		return "victim/victimWriteForm2";
	}*/

	@RequestMapping("vinsert.do")
	public String victimInsert(Victim victim, Suspect suspect ,HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile file, @RequestParam("title") String title,
			@RequestParam("wirter") String writer, @RequestParam("content") String content, Model model) {

		victim.setBoard_title(title);
		victim.setBoard_writer(writer);
		victim.setBoard_content(content);
		String refile = "";
		victim.setBoard_rename_filename(refile);
		
		if(suspect.getSuspect_name().length()==0)
			suspect.setSuspect_name("이름없음");
		if(suspect.getSuspect_phone().length()==0)
			suspect.setSuspect_phone("번호없음");
		if(suspect.getSuspect_account().length()==0)
			suspect.setSuspect_account("계좌없음");
		
		int resultSuspect = 0;
		
		if(victimService.suspectDuplicate(suspect)==null)
			resultSuspect = victimService.suspectDuplicateNotInsert(suspect);
		else {
			victimService.suspectDuplicateUpdate(victimService.suspectDuplicate(suspect).getSuspect_no());
	        resultSuspect=1;
		}
		
		//피해사례 글 등록
		 victim.setBoard_suspectno(victimService.suspectDuplicate(suspect).getSuspect_no());
		int result = victimService.insertVictim(victim);

		// 파일 저장 폴더 지정하기
		String savePath = request.getSession().getServletContext().getRealPath("resources\\files\\victimfile");

		if (file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
			try {
				file.transferTo(new File(savePath + "\\" + file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		String viewFileName = null;
		if (result > 0) {
			viewFileName = "redirect:victim.do";
		} else {
			model.addAttribute("message", "피해사례등록 실패");
			viewFileName = "common/error";
		}

		return viewFileName;
	}

	@RequestMapping("vdetail.do")
	public String movendetailPage(Model model, HttpServletRequest request, HttpSession session) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));

		victimService.addReadCount(boardnum);

		map.put("board_num", boardnum);
		Victim victim = victimService.victimDetail(map);

		model.addAttribute("board_num", boardnum);
		model.addAttribute("victim", victim);

		return "victim/victimDetailView";
	}

	// 파일 다운로드 처리용
	@RequestMapping("vdown.do")
	public ModelAndView fileDownMethod(HttpServletRequest request, @RequestParam("filename") String fileName) {

		String savePath = request.getSession().getServletContext().getRealPath("resources/file/victimfile");

		File downFile = new File(savePath + "\\" + fileName);

		return new ModelAndView("filedown", "downFile", downFile);

	}
}
