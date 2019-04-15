package com.kn.clv.member.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		//자신의 구글계정아이디 비밀번호 정확하게 입력
		return new PasswordAuthentication("fealtyhot", "2031527zx!");
	}

}
