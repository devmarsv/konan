package com.kn.clv.member.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class DeleteConnection {
	
	public static void deleteConnection(String userid, HttpServletRequest request) {
		String savePath = request.getSession().getServletContext().getRealPath("resources/userConnection");
		
		File file = new File(savePath+ "\\" + userid + ".txt");
		
		if(file.exists()) {
			if(file.delete()) {
				
			}else {
				System.err.println("파일 삭제 실패");
			}
		}else {
			System.err.println("파일을 찾을 수 없습니다.");
		}
	}

}
