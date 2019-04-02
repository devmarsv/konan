package com.kn.clv.test.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kn.clv.test.model.vo.Sample;

@Controller
public class TestController {
	//로그 처리?�� 객체 ?��존성 주입(종속객체 주입) 처리
	private static final Logger logger = 
			LoggerFactory.getLogger(TestController.class);

	//�? ?��?���? ?��보내�? 메소?��
	@RequestMapping("moveAOP.do")
	public String moveAOPPage() {
		return "test/testAOPPage";
	}
	
	@RequestMapping("moveFileup.do")
	public String moveFileUploadPage() {
		return "test/testFileUpload";
	}
	
	@RequestMapping("moveAjax.do")
	public String moveAjaxPage() {
		return "test/testAjaxPage";
	}
	
	@RequestMapping("testView.do")
	public String moveCryptoPage() {
		return "test/testCrypto";
	}
	
	//?��?�� ?��로드 처리?��
	@RequestMapping(value="tinsert.do", method=RequestMethod.POST)
	public String testFileUpload(Sample sample, 
			HttpServletRequest request, 
			@RequestParam(name="upfile", required=false) MultipartFile file) {
		//System.out.println("sample : " + sample);
		//System.out.println("file : " + file.getOriginalFilename());
		
		//?��?�� ???�� ?��?�� �??��?���?
		String savePath = request.getSession()
				.getServletContext().getRealPath(
						"resources/files/test");
		
		try {
			file.transferTo(new File(savePath + "\\" 
					+ file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();			
		}
		
		return "home";
	}
	
	
	@RequestMapping("fdown.do")
	public ModelAndView fileDownMethod(HttpServletRequest request, @RequestParam("filename") String fileName) {
		String fileName1 = request.getParameter("filename");
		
		String savePath = request.getSession()
				.getServletContext().getRealPath(
						"resources/files/test");
		  File downFile = new File(savePath +"\\" + fileName1);
		  //ModelAndView(java.lang.String viewName,
		  //java.lang.String ModelName,
		  //java.lang.Object model(Object)
		  //model == request 객체
		  //modelName == ?���? , modelObject == 객체
		  //request.setAttribute("?���?", 객체)?? ?��?��
		return new ModelAndView("filedown", "downFile", downFile);
	}
}










