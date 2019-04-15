package com.kn.clv.member.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public void sendEmail(String email, String userid) {
		String host = "http://localhost:9988/konan/";
		String from = "KONAN";
		String to = email;
		String str = SHA256.getSHA256(userid);
		String subject = "KONAN 비밀번호 재설정";
		String content = "KONAN 비밀번호를 재설정 하려면 누르세요 : " + "<a href='" + host.trim() + "moveChangePwd.do?code=" + str + "&userid="+ userid + "'>비밀번호 재설정</a>";
		System.out.println("사용자 이메일 : " + to);

		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try {
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html; charset=UTF-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkEmail(String userid, String to) {
		String host = "http://localhost:9988/konan/";
		String from = "KONAN";
		String str = SHA256.getSHA256(userid);
		String subject = "KONAN 가입을 위한 이메일 인증메일입니다.";
		String content = "KONAN 이메일 인증을 하려면 누르세요 : " + "<a href='" + host.trim() + "hashEmailCheck.do?code=" + str + "&userid="+ userid + "'>이메일 인증</a>";

		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try {
			Authenticator auth = new Gmail();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html; charset=UTF-8");
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
