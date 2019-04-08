package com.kn.clv.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kn.clv.admin.model.service.AdminService;
import com.kn.clv.member.model.vo.Member;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping("adminm.do")
	public String movendetailPage(Model model, HttpServletRequest request) {
		int currentPage = 1;
		if(request.getParameter("page")!=null)
			 currentPage= Integer.parseInt(request.getParameter("page"));
        
        int limit = 10; //한 페이지에 출력할 목록 갯수 지정
        int listCount = adminService.listCount(); //총 목록 갯수 조회
        //총 페이지 수 계산
        int maxPage = (int)((double)listCount/limit+0.9);
        //현재 페이지가 포함된 페이지 그룹의 시작값
        int startPage = (((int)((double)currentPage/limit+0.9)) -1)*limit+1;
        //현재 페이지가 포함된 페이지 그룹의 끝값
        int endPage = startPage + limit -1;
        //쿼리문에 반영할 현재 페이지에 출력될 시작행과 끝행 계산
        
        if(maxPage<endPage)
       	 endPage = maxPage;
		
        int startRow = (currentPage-1)*limit + 1;
        int endRow = startRow+limit-1;
        
        System.out.println("star : "+ startRow);
        System.out.println("end : " + endRow);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("startRow", startRow);
        map.put("endRow", endRow);
        
        
        List<Member> list = adminService.memberAll(map);
		
        
        model.addAttribute("list", list);
        model.addAttribute("limit", limit);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
		
		return "admin/adminMember";
	}
	
	
  
	
}
