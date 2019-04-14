package com.kn.clv.member.util;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.kn.clv.member.model.vo.ConnectionData;
import com.kn.clv.member.model.vo.Member;

public class CreaterConnection {

	public void createConnection(HttpServletRequest request, Member member) {
		BufferedOutputStream bs = null;

		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		
		String agent = request.getHeader("User-Agent");

		String os = null;
		if (agent.indexOf("NT 6.0") != -1)
			os = "Windows Vista/Server 2008";
		else if (agent.indexOf("NT 5.2") != -1)
			os = "Windows Server 2003";
		else if (agent.indexOf("NT 5.1") != -1)
			os = "Windows XP";
		else if (agent.indexOf("NT 5.0") != -1)
			os = "Windows 2000";
		else if (agent.indexOf("NT") != -1)
			os = "Windows NT";
		else if (agent.indexOf("9x 4.90") != -1)
			os = "Windows Me";
		else if (agent.indexOf("98") != -1)
			os = "Windows 98";
		else if (agent.indexOf("95") != -1)
			os = "Windows 95";
		else if (agent.indexOf("Win16") != -1)
			os = "Windows 3.x";
		else if (agent.indexOf("Windows") != -1)
			os = "Windows";
		else if (agent.indexOf("Linux") != -1)
			os = "Linux";
		else if (agent.indexOf("Macintosh") != -1)
			os = "Macintosh";
		else
			os = "";

		String brower = null;
		if (agent != null) {
			if (agent.indexOf("Trident") > -1) {
				brower = "MSIE";
			} else if (agent.indexOf("Chrome") > -1) {
				brower = "Chrome";
			} else if (agent.indexOf("Opera") > -1) {
				brower = "Opera";
			} else if (agent.indexOf("iPhone") > -1 && agent.indexOf("Mobile") > -1) {
				brower = "iPhone";
			} else if (agent.indexOf("Android") > -1 && agent.indexOf("Mobile") > -1) {
				brower = "Android";
			}
		}

		try {
			String savePath = request.getSession().getServletContext().getRealPath("resources/userConnection");
			bs = new BufferedOutputStream(new FileOutputStream(savePath + "\\" + member.getUserid() + ".txt", true));
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			String str = ip + "," + brower + "," + os + "," + format.format(date) + "/";
			byte[] by = str.getBytes();
			bs.write(by);
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				bs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<ConnectionData> connectionList(String filePath) {
		ArrayList<ConnectionData> list = new ArrayList<ConnectionData>();
		
		try {
			// 파일 객체 생성
			FileInputStream fileStream = null; // 파일 스트림

			fileStream = new FileInputStream(filePath);// 파일 스트림 생성
			// 버퍼 선언
			byte[] readBuffer = new byte[fileStream.available()];
			while (fileStream.read(readBuffer) != -1) {
			}
			
			String[] arr = new String(readBuffer).split("/");
			
			for (int i = 0; i < arr.length; i++) {
				String[] info = arr[i].split(",");
				list.add(new ConnectionData(info[0], info[1], info[2], info[3]));
			}
			fileStream.close(); // 스트림 닫기
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return list;
	}

}
