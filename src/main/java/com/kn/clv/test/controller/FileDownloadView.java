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

//?¼ë°? ?´?˜?Š¤ê°? ë·°ë¦¬ì¡¸ëŸ¬ë²? ?˜?•´?„œ ?‹¤?–‰?˜? ¤ë©?
//ë°˜ë“œ?‹œ ?Š¤?”„ë§ì˜ AbstractViewë¥? ?ƒ?†ë°›ì? ?›„?†?´?˜?Š¤?—¬?•¼ ?•¨

@Component("filedown")
public class FileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> arg0, HttpServletRequest arg1, HttpServletResponse response)
			throws Exception {
		//ì»¨íŠ¸ë¡¤ëŸ¬?—?„œ ë·°ë¦¬ì¡¸ëŸ¬ë³? ë¦¬í„´?œ model ? •ë³´ë??
		//??™ ? „?‹¬?¨
		System.out.println("filedown run..");
		System.out.println("file : " + ((File)arg0.get("downFile")).getName() );
	    
		File downFile = (File)arg0.get("downFile");
		//?•œê¸? ?ŒŒ?¼ëª? ?¸ì½”ë”© ì²˜ë¦¬
		String fileName = downFile.getName();
		
		response.setContentType("text/plain; charset=utf-8");
		//?•œê¸? ?ŒŒ?¼ëª? ?¸ì½”ë”© ì²˜ë¦¬
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
