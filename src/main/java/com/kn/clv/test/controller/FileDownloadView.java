package com.kn.clv.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//?Όλ°? ?΄??€κ°? λ·°λ¦¬μ‘Έλ¬λ²? ??΄? ?€??? €λ©?
//λ°λ? ?€?λ§μ AbstractViewλ₯? ??λ°μ? ???΄??€?¬?Ό ?¨

@Component("filedown")
public class FileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1, HttpServletResponse response)
			throws Exception {
		//μ»¨νΈλ‘€λ¬?? λ·°λ¦¬μ‘Έλ¬λ³? λ¦¬ν΄? model ? λ³΄λ??
		//?? ? ?¬?¨
		System.out.println("filedown run..");
		System.out.println("file : " + ((File)arg0.get("downFile")).getName() );
	    
		File downFile = (File)arg0.get("downFile");
		//?κΈ? ??Όλͺ? ?Έμ½λ© μ²λ¦¬
		String fileName = downFile.getName();
		
		response.setContentType("text/plain; charset=utf-8");
		//?κΈ? ??Όλͺ? ?Έμ½λ© μ²λ¦¬
		response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("utf-8"),"ISO-8859-1")+"\"");
		
		response.setContentLength((int)downFile.length());
		
		OutputStream out = response.getOutputStream();
		FileInputStream fin = null;
		
		try {
			fin= new FileInputStream(downFile);
		    FileCopyUtils.copy(fin, out);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
		  if(fin!=null)
		  {
			  try {
				fin.close();
			} catch (Exception e2) {
				// TODO: handle exception
			  e2.printStackTrace();
			}
		  }
		
		}
		
		out.flush();
		out.close();
		
	}

}
