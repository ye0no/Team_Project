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
		
		
		String user="smtptest123@naver.com"; // �߽� ���̵�
		String password="webplate12#"; // �߽� ���
		
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host","smtp.naver.com");  // ȣ��Ʈ �������ּ�
		prop.put("mail.smtp.port", 465);  // ȣ��Ʈ ��Ʈ��ȣ
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
			
			
			// ���� ����
			message.setSubject("�ӽ� ��й�ȣ �߼��մϴ�.");
			
			//���� ����
			message.setText("������� �ӽ� ����� xx�Դϴ�.");
			
			
			Transport.send(message);  // �޽��� ����
			System.out.println("���� �߼� ����!");
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}


		

	}

}
