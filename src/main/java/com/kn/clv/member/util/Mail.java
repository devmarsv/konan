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
		String subject = "[KONAN] " + userid + "님의 비밀번호 재설정 링크가 발급되었습니다.";
		String content = "<xmeta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" + 
				"\n" + 
				"    <xmeta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n" + 
				"\n" + 
				"        <div id=\"header_logo\" class=\"wrap\">\n" + 
				"            <div class=\"logo\" style=\"width: 100%; height: 80px; background: #22518A\">\n" + 
				"                <img\n" + 
				"                        src=\"https://postfiles.pstatic.net/MjAxOTA0MTVfMSAg/MDAxNTU1MjkyNTYxNTc3.V8FNI4508NTRjmVYyERtJotcD_expD8HMR1UEd-vCxIg.B_PncznZAPyJTDyfvUmrYM_c-LEtP9ylBFkauY4ZFs4g.PNG.cndfuf0159/logo2.png?type=w580\"\n" + 
				"                        style=\"margin-top: 23px; margin-left: 20px;\">\n" + 
				"            </div>\n" + 
				"            <div\n" + 
				"                style=\"width:100%;margin:0 auto;margin-top:10px;padding-bottom:8px;border-bottom:dotted 1px #e7e7e7;font-size:11px;color:#999999;\">\n" + 
				"                · 본 메일은 발신 전용으로 회신이 불가합니다.</div>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div\n" + 
				"            style=\"width:100%;margin:0 auto;margin-top:22px;padding-bottom:22px;border-bottom:1px solid #ededed;text-align:left;overflow:hidden;color:#0a7bce;font-weight:bold;font-size:24px;\">\n" + 
				"            비밀번호 변경 안내</div>\n" + 
				"\n" + 
				"        <div\n" + 
				"            style=\"width:100%;margin:0 auto;margin-top:22px;padding-bottom:22px;text-align:left;overflow:hidden;color:#000000;font-weight:normal;font-size:12px;line-height:19px;\">\n" + 
				"            안녕하세요."+ userid +"님<br>깨끗한 인터넷 거래문화를 위한 KONAN입니다.<br><br><strong>"+ userid +"</strong> 회원님의 요청으로 비밀번호 재설정 링크가\n" + 
				"            발급되었습니다.<br><br>비밀번호 재설정 후 비밀번호를 반드시 변경해 주세요.<br><br>비밀번호를 재설정 하려면 누르세요 :" + "<a href='" + host.trim() + "moveChangePwd.do?code=" + str + "&userid="+ userid + "'>비밀번호 재설정</a><br><br>고맙습니다.<br><br>KONAN\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <footer style=\"background: #D6E1EF; color: #22518A; width: 100%; height: 100px; border-top: 1px solid #B9CDE5;\">\n" + 
				"            <ul style=\"list-style: none; margin-left: 30px; margin-top: 15px;\">\n" + 
				"                <li style=\"font-size: 8pt;\n" + 
				"                color: #17375E;\n" + 
				"                float: left;\n" + 
				"                margin-top: 15px;\"><img\n" + 
				"                        src=\"https://postfiles.pstatic.net/MjAxOTA0MTVfMSAg/MDAxNTU1MjkyNTYxNTc3.V8FNI4508NTRjmVYyERtJotcD_expD8HMR1UEd-vCxIg.B_PncznZAPyJTDyfvUmrYM_c-LEtP9ylBFkauY4ZFs4g.PNG.cndfuf0159/logo2.png?type=w580\"\n" + 
				"                        style=\"margin-right: 100px;\">\n" + 
				"                </li>\n" + 
				"                <li style=\"font-size: 8pt;\n" + 
				"                color: #17375E;\n" + 
				"                float: left;\n" + 
				"                margin-top: 15px;\">\n" + 
				"                    <p>\n" + 
				"                        본 메일은 발신전용 입니다. 서비스관련 궁금하신 사항은 고객센터에서 확인해주세요.<br>\n" + 
				"                        Copyrights ⓒ TheCheat All Rights Reserved.\n" + 
				"                    </p>\n" + 
				"                </li>\n" + 
				"            </ul>\n" + 
				"        </footer>\n" + 
				"\n" + 
				"    </xmeta>\n" + 
				"</xmeta>";
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
			ses.setDebug(false);
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
		String subject = "[KONAN]" + userid + "님의 가입을 위한 이메일 인증메일입니다.";
		String content = "<xmeta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" + 
				"\n" + 
				"    <xmeta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\">\n" + 
				"\n" + 
				"        <div id=\"header_logo\" class=\"wrap\">\n" + 
				"            <div class=\"logo\" style=\"width: 100%; height: 80px; background: #22518A\">\n" + 
				"                <img\n" + 
				"                        src=\"https://postfiles.pstatic.net/MjAxOTA0MTVfMSAg/MDAxNTU1MjkyNTYxNTc3.V8FNI4508NTRjmVYyERtJotcD_expD8HMR1UEd-vCxIg.B_PncznZAPyJTDyfvUmrYM_c-LEtP9ylBFkauY4ZFs4g.PNG.cndfuf0159/logo2.png?type=w580\"\n" + 
				"                        style=\"margin-top: 23px; margin-left: 20px;\">\n" + 
				"            </div>\n" + 
				"            <div\n" + 
				"                style=\"width:100%;margin:0 auto;margin-top:10px;padding-bottom:8px;border-bottom:dotted 1px #e7e7e7;font-size:11px;color:#999999;\">\n" + 
				"                · 본 메일은 발신 전용으로 회신이 불가합니다.</div>\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <div\n" + 
				"            style=\"width:100%;margin:0 auto;margin-top:22px;padding-bottom:22px;border-bottom:1px solid #ededed;text-align:left;overflow:hidden;color:#0a7bce;font-weight:bold;font-size:24px;\">\n" + 
				"            이메일 인증 안내</div>\n" + 
				"\n" + 
				"        <div\n" + 
				"            style=\"width:100%;margin:0 auto;margin-top:22px;padding-bottom:22px;text-align:left;overflow:hidden;color:#000000;font-weight:normal;font-size:12px;line-height:19px;\">\n" + 
				"            안녕하세요."+ userid +"님<br>깨끗한 인터넷 거래문화를 위한 KONAN입니다.<br><br><strong>"+ userid +"</strong> 회원님의 요청으로 이메일 확인 링크가\n" + 
				"            발급되었습니다.<br><br> 이메일 인증을 하려면 누르세요 : " + "<a href='" + host.trim() + "hashEmailCheck.do?code=" + str + "&userid="+ userid + "'>이메일 인증</a><br><br>고맙습니다.<br><br>KONAN\n" + 
				"        </div>\n" + 
				"\n" + 
				"        <footer style=\"background: #D6E1EF; color: #22518A; width: 100%; height: 100px; border-top: 1px solid #B9CDE5;\">\n" + 
				"            <ul style=\"list-style: none; margin-left: 30px; margin-top: 15px;\">\n" + 
				"                <li style=\"font-size: 8pt;\n" + 
				"                color: #17375E;\n" + 
				"                float: left;\n" + 
				"                margin-top: 15px;\"><img\n" + 
				"                        src=\"https://postfiles.pstatic.net/MjAxOTA0MTVfMSAg/MDAxNTU1MjkyNTYxNTc3.V8FNI4508NTRjmVYyERtJotcD_expD8HMR1UEd-vCxIg.B_PncznZAPyJTDyfvUmrYM_c-LEtP9ylBFkauY4ZFs4g.PNG.cndfuf0159/logo2.png?type=w580\"\n" + 
				"                        style=\"margin-right: 100px;\">\n" + 
				"                </li>\n" + 
				"                <li style=\"font-size: 8pt;\n" + 
				"                color: #17375E;\n" + 
				"                float: left;\n" + 
				"                margin-top: 15px;\">\n" + 
				"                    <p>\n" + 
				"                        본 메일은 발신전용 입니다. 서비스관련 궁금하신 사항은 고객센터에서 확인해주세요.<br>\n" + 
				"                        Copyrights ⓒ TheCheat All Rights Reserved.\n" + 
				"                    </p>\n" + 
				"                </li>\n" + 
				"            </ul>\n" + 
				"        </footer>\n" + 
				"\n" + 
				"    </xmeta>\n" + 
				"</xmeta>";

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
			ses.setDebug(false);
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
