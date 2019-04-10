package com.kn.clv.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kn.clv.member.model.service.MypageService;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.member.util.Mail;

@Controller
public class MypageController {

	@Autowired
	MypageService mypageService;

	@RequestMapping("myInfo.do")
	public String moveMyInfoPage() {
		return "member/mypage/myInfo";
	}

	@RequestMapping("alterInfo.do")
	public String moveAlterInfoPage() {
		return "member/mypage/alterInfo";
	}

	@RequestMapping("myBoard.do")
	public String moveMyBoardPage() {
		return "member/mypage/myBoard";
	}

	@RequestMapping("myConnection.do")
	public String moveMyConnectionPage() {
		return "member/mypage/myConnection";
	}

	@RequestMapping("myReply.do")
	public String moveMyReplyPage() {
		return "member/mypage/myReply";
	}

	@RequestMapping(value = "alterInfoDo.do", method = RequestMethod.POST)
	public String alterInfo(Member member, HttpServletRequest request,
			@RequestParam(name = "image", required = false) MultipartFile file,
			@RequestParam(name="delete", defaultValue="false") boolean delete) {
		
		if (!delete) {
			if (!file.isEmpty()) {
				// 파일 저장 폴더 지정하기
				String savePath = request.getSession().getServletContext().getRealPath("resources/profileImage");
				try {
					file.transferTo(new File(savePath + "\\" + member.getUserid() + ".png"));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			String savePath = request.getSession().getServletContext()
					.getRealPath("resources/profileImage\\" + member.getUserid() + ".png");
			File saveFile = new File(savePath);
			if (saveFile.exists()) {
				saveFile.delete();
			}
		}

		int result = mypageService.updateInfo(member);
		return result > 0 ? "member/mypage/myInfo" : "common/error";
	}

	// Ajax 메소드
	@RequestMapping("imageDelete.do")
	@ResponseBody
	public void imageDelete(@RequestBody String userid, HttpServletRequest request) {
		String savePath = request.getSession().getServletContext()
				.getRealPath("resources/profileImage\\" + userid + ".png");

		File file = new File(savePath);
		if (file.exists()) {
			file.delete();
		}
	}
}
