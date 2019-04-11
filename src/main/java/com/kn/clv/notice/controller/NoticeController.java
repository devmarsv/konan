package com.kn.clv.notice.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kn.clv.notice.model.service.NoticeService;
import com.kn.clv.notice.model.vo.Notice;

@Controller
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("notice.do")
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
		int listCount = noticeService.listCount(map);	//총 목록 갯수 조회
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
		
		
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<Notice> list = noticeService.noticeAll(map);

		model.addAttribute("noticeList", list);
		model.addAttribute("limit", limit);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cg", cg);
		model.addAttribute("bar", bar);

		return "notice/noticeListView";
	}

	
	@RequestMapping("nform.do")
	public String movenformPage() {
		return "notice/noticeForm";
	}
	
	
	@RequestMapping("ninsert.do" )
	public String noticeinsert(Notice notice,
			HttpServletRequest request, 
			@RequestParam(name="upfile", required=false) MultipartFile file,
			@RequestParam("title") String title, @RequestParam("writer") String writer,
			@RequestParam("content") String content,
			Model model) {
		System.out.println("file : " + file.getOriginalFilename());
		
		notice.setNoticetitle(title);
		notice.setNoticewriter(writer);
		notice.setNoticecontent(content);
		notice.setOriginal_filepath(file.getOriginalFilename());
		String refile="";
		notice.setRename_filepath(refile);
		
		System.out.println("ninsert : " + notice);
		int result = noticeService.insertNotice(notice);
		
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
			viewFileName="redirect:notice.do";
		}else {
			model.addAttribute("message", "공지사항등록실패!");
			viewFileName="common/error";
		}
		return viewFileName;
	}



	@RequestMapping("ndetail.do")
	public String movendetailPage(Model model, HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int noticeno = Integer.parseInt(request.getParameter("noticeno"));

		noticeService.addReadcount(noticeno);

		map.put("noticeno", noticeno);
		Notice notice = noticeService.noticedetail(map);

		model.addAttribute("noticeno", noticeno);
		model.addAttribute("notice", notice);
		return "notice/noticeDetailView";
	}
	
	
	
	//파일 다운로드 처리용
	@RequestMapping("ndown.do")
	public ModelAndView fileDownMethod(HttpServletRequest request,
			@RequestParam("filename") String fileName) {

		String savePath = request.getSession().getServletContext().getRealPath("resources/files/noticefile");

		File downFile = new File(savePath + "\\" + fileName);

		return new ModelAndView("filedown", "downFile", downFile);
	}

}
