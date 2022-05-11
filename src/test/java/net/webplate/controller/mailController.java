package net.webplate.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.stereotype.Controller;



@Controller
public class mailController {
	
	
	@Test
	public void sendMailTest() throws Exception{
		
		
		String user="smtptest123@naver.com"; // 발신 아이디
		String password="webplate12#"; // 발신 비번
		
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host","smtp.naver.com");  // 호스트 도메인주소
		prop.put("mail.smtp.port", 465);  // 호스트 포트번호
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable","true");
		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
		
		try {
			MimeMessage message=new MimeMessage(session);			
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress("tjddyd1060@kakao.com"));
			
			
			// 메일 제목
			message.setSubject("임시 비밀번호 발송합니다.");
			
			//메일 내용
			message.setText("성용님의 임시 비번은 xx입니다.");
			
			
			Transport.send(message);  // 메시지 전송
			System.out.println("메일 발송 성공!");
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}


		

	}

}
