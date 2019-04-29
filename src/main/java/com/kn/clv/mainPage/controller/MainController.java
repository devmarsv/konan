package com.kn.clv.mainPage.controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kn.clv.mainPage.model.service.MainService;
import com.kn.clv.mainPage.model.vo.MainSuspect;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
	
	@RequestMapping("searchMain.do")
	public ModelAndView searchMain(@RequestParam("number") String value, ModelAndView model) {
		if(value.trim().equals("")) {
			model.setViewName("index");
			return model;
		}
		
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(value);
		StringBuffer sb = new StringBuffer();
		
		while(m.find()) {
			sb.append(m.group());
		}
		
		String searchValue = new String(sb);
		
		if(searchValue.equals("")) {
			model.setViewName("index");
			return model;
		}
		
		int count = mainService.searchNumber(searchValue);
		
		if(count > 0) {
			ArrayList<MainSuspect> list = mainService.searchSuspect(searchValue);
			model.addObject("list", list);
			model.addObject("size", list.size());
		}
		
		model.addObject("value", searchValue);
		model.addObject("count", count);
		
		model.setViewName("main/MainSearch");
		
		return model;
	}
	
	
	

}
