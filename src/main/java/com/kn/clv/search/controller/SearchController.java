package com.kn.clv.search.controller;

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

import com.kn.clv.search.model.service.SearchService;
import com.kn.clv.search.model.vo.Search;
import com.kn.clv.search.model.vo.Searchsuspect;


@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;

	@RequestMapping("search.do")
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
		int listCount = searchService.listCount(map);	//총 목록 갯수 조회
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

		List<Search> list = searchService.searchAll(map);

		model.addAttribute("searchList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("currentMax", currentMax);
		model.addAttribute("currentMin", currentMin);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);




		return "search/searchView";
	}


	@RequestMapping("sdetail.do")
	public String movendetailPage(Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int board_num = Integer.parseInt(request.getParameter("board_num"));

		searchService.addReadCouunt(board_num);
		Searchsuspect suspect = searchService.selectSuspect(board_num);

		map.put("board_num", board_num);
		Search search = searchService.searchdetail(map);



		System.out.println("search 컨트롤러 : " + search);
		model.addAttribute("board_num", board_num);
		model.addAttribute("search", search);
		model.addAttribute("suspect", suspect);



		return "search/searchDetailView";
	}
	
	@RequestMapping("msearch.do")
	public String mainSearchPage() {
		return "search/mainSearchListView";
	}
	
	//파일 다운로드 처리용
		@RequestMapping("sdown.do")
		public ModelAndView fileDownMethod(HttpServletRequest request,
				@RequestParam("filename") String fileName) {

			String savePath = request.getSession().getServletContext().getRealPath("resources/file/searchfile");

			File downFile = new File(savePath + "\\" +fileName);

			return new ModelAndView("filedown", "downFile", downFile);
		}

}
