package com.kn.clv.victim.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VictimController {
	
	private static final Logger logger = LoggerFactory.getLogger(VictimController.class);
	
	@RequestMapping("victim.do")
	public String movenoticePage() {
		return "victim/victimEnrollForm";
	}
}
