package net.webplate.controller;




import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.MemberService;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.MemberVO;
import pwdconv.PwdChange;

@Controller
@RequestMapping(value = "/Member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// �α���
	@GetMapping("/login")
	public void login() {
		
	}
	
	// ȸ������
	@GetMapping("loginForm")
	public void loginForm(Model m) {
		String arr[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		m.addAttribute("arr",arr);
				
	}	

	 // �ߺ�üũ
	@PostMapping("/member_idCheck")
	public String member_idcheck(@RequestParam("id") String id,MemberVO vo,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		MemberVO db_id=memberService.idcheck(id);
		
		int re=0; // �ߺ����̵� ������ ��ȯ��
		if(db_id !=null) { // �ߺ����̵� �ִٸ�
			re=1;
		}
		out.println(re); // �񵿱�� �� ��ȯ
		
		return null;
	} // �ߺ�üũ ����
	
	// ȸ������ ����
	@PostMapping("Join_Ok")
	public String Join_Ok(MemberVO m,HttpServletResponse response)throws Exception  {
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
		
	 m.setPw(PwdChange.getPassWordToXEMD5String(m.getPw()));
	 memberService.insertMember(m);	 
	 out.println("<script>");
	 out.println("alert('ȸ������ ����!');");
	 out.println("location='../Member/login';");
	 out.println("</script>");
	 return null;
		
	}
	
	
	
	// �α��� üũ
	@PostMapping("Login_ok")
	public ModelAndView Login_ok(HttpServletResponse response, HttpServletRequest request, @RequestParam("m_id") String login_id,@RequestParam("m_pw")String login_pw,
			HttpSession session,Model m) throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		MemberVO dm=memberService.loginCheck(login_id);
		
		if(dm==null) {
			out.println("<script>");
			out.println("alert('���Ե��� ���� ������Դϴ�!');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			if(!dm.getPw().equals(PwdChange.getPassWordToXEMD5String(login_pw))) {  // ȸ�����Եǰ� ��ȣȭ  �����ҿ���
				out.println("<script>");
				out.println("alert('����� �ٸ��ϴ�!');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				session.setAttribute("Sid", login_id); // ���ǿ� id �� ����				
				return new ModelAndView("redirect:/index");
			}
		}
		
		return null;
		
	}
	
	
	// �α׾ƿ� ��� ����
	@GetMapping("logOut")
	public String Member_LogOut(HttpServletResponse response, HttpSession session) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();		
			
		session.invalidate();
		
		out.println("<script>");
		out.println("alert('�α׾ƿ� �Ǿ����ϴ�!');");
		out.println("location='/controller/index';");
		
		out.println("</script>");
		
		return null;
	}
	
	// ȸ�� ��ȸ
	@GetMapping("list")
	public ModelAndView member_list(HttpSession session, HttpServletResponse response)throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� �ϼ���!');");
			out.println("location='../Member/login';");			
			out.println("</script>");
			
		}
		else {
			MemberVO list=memberService.getMember(Sid);
			String jumin=list.getJumin1()+" �� "+list.getJumin2()+" �� " +list.getJumin3()+" �� ";
			
			String tel=list.getTel().substring(0,3)+" - "+list.getTel().substring(3,7)+ " - "+list.getTel().substring(7,11);
			
			ModelAndView m=new ModelAndView("Member/list");
			m.addObject("m", list);
			m.addObject("jumin",jumin);
			m.addObject("tel", tel);
			
			
			
			return m;
		}
		

		return null;
		}
	
	// ���� ����
	@PostMapping("mem_edit")
	public ModelAndView mem_edit(HttpServletResponse response,HttpSession session) throws Exception{
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		String Sid=(String) session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			MemberVO m=memberService.getMember(Sid);
			String arr[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
						
			ModelAndView em=new ModelAndView("Member/mem_edit");
			em.addObject("m",m);
			em.addObject("arr", arr);
			
			return em;
			
		}
		return null;
		
	}
	
	// ���� ���� �Ϸ�
	@PostMapping("mem_edit_Ok")
	public String mem_edit_Ok(MemberVO m, HttpServletResponse response,HttpSession session)throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			m.setId(Sid);
			m.setPw(PwdChange.getPassWordToXEMD5String(m.getPw()));
			
			memberService.updateMember(m);
			
			out.println("<script>");
			out.println("alert('ȸ�������� �����Ǿ����ϴ�!');");
			out.println("location='list';");			
			out.println("</script>");
			
		}
		return null;
		
	}
	
	// ȸ��Ż��
	@GetMapping("memberDel")
	public void memberDel () {
		
	}
	
	// ȸ��Ż�� ����
	@PostMapping("m_Del_ok")
	public String m_Del_ok(String del_pwd,String del_cont,HttpServletResponse response,HttpSession session) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			del_pwd = PwdChange.getPassWordToXEMD5String(del_pwd);//��� ��ȣȭ
    		MemberVO db_pwd=memberService.getMember(Sid);
    		
    		if(!db_pwd.getPw().equals(del_pwd)) {
    			out.println("<script>");
    			out.println("alert('����� �ٸ��ϴ�!');");
    			out.println("history.back();");
    			out.println("</script>");
    		}else {
    			MemberVO dm=new MemberVO();
    			dm.setId(Sid); dm.setMem_delcont(del_cont);
    			memberService.delMember(dm); // ȸ��Ż��
    			// Ż����� mem_state=0 ,Ż��¥ ����
    			session.invalidate();
    			
    			out.println("<script>");
    			out.println("alert('ȸ��Ż�� ����');");
    			out.println("opener.location.href='../index';");
    			out.println("self.close();");
    			out.println("</script>");
    		}
		}
		return null;
		
	
		
	}
	
	@GetMapping("id_find")
	public void id_find() {
	}
	
	@PostMapping("id_find_ok")
	public ModelAndView id_find_ok(HttpServletRequest request,HttpServletResponse response,MemberVO m) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String tel=request.getParameter("tel1")+request.getParameter("tel2")+request.getParameter("tel3");
		
		String name=request.getParameter("username");
		
		m.setTel(tel); m.setName(name);
		MemberVO cm=memberService.Idfind(m);
		
		System.out.println(cm);
		if(cm==null) {
			out.println("<script>");
			out.println("alert('ȸ���� �������� �ʽ��ϴ�!');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			String id=cm.getId();
			String user=cm.getName();
			ModelAndView mem_info=new ModelAndView();
			mem_info.addObject("id",id);
			mem_info.addObject("user", user);
			mem_info.setViewName("Member/id_find_ok");
			return mem_info;
			
		}
		
		
		return null;
		
	}

		
	// ��� ã��
	@GetMapping("pwd_find")
	public void pwd_find() {
		
	}
	
	@PostMapping("pwd_find_ok")
	public String pwd_find_ok(String username,String userID,HttpServletResponse response,HttpServletRequest requst,HttpSession session,MemberVO m,Model m2)throws Exception{
		response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
		
    	m.setId(userID); m.setName(username);
    	MemberVO fm=memberService.pwdMember(m); // �̸� ���̵� ���� �����ȸ
    	
    	if(fm==null) {
    		out.println("<script>");
    		out.println("alert('ȸ�������� ã�� �� �����ϴ�!');");
    		out.println("history.back();");
    		out.println("</script>");
    	}else {
    		// �ڹ� 1.8�̿��� ���� + ���� ��������
    		int leftLimit=48; //0����
    		int rightLimit=122; // ���� z
    		int targetStringLength=10;    		
    		Random r=new Random();
    		
    		
    		String ran_pwd=r.ints(leftLimit,rightLimit+1) // ���۰� ������
    				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // ���� ������ �ޱ����� ���͸�(�𸣰����� ASCII�ڵ� ����)
    				.limit(targetStringLength) // ��������
    				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) // ����� ����� �Ϳ� ���ؼ� ��� ó������ ����
    				.toString();  //���ڷ� ��ȯ
    		m.setPw(PwdChange.getPassWordToXEMD5String(ran_pwd));
    		
    		memberService.updatePwd(m);  //�ӽú�� ����
    				
    		String user="smtptest123@naver.com"; // �߽� ���̵�
    		String password="webplate12#"; // �߽� ���
    		    		
    		Properties prop=new Properties();
    		prop.put("mail.smtp.host","smtp.naver.com");  // ȣ��Ʈ �������ּ�
    		prop.put("mail.smtp.port", 465);  // ȣ��Ʈ ��Ʈ��ȣ
    		prop.put("mail.smtp.auth", "true");
    		prop.put("mail.smtp.ssl.enable","true");
    		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
    		
    		Session session2 = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });
    		
    		try {
    			MimeMessage message=new MimeMessage(session2);			
    			message.setFrom(new InternetAddress(user));
    			message.addRecipient(Message.RecipientType.TO,new InternetAddress(fm.getEmail()));
    			
    			
    			// ���� ����
    			message.setSubject("�� �÷���Ʈ �ӽ� ��й�ȣ�Դϴ�.");
    			
    			//���� ����
    			message.setText("ȸ������ �ӽ� ��й�ȣ��"+ran_pwd+" �Դϴ�.");  // �α����Ҷ� ��ȣȭ�ϱ� �ʱⰪ ����
 			    			
    			Transport.send(message);  // �޽��� ����
    			
    			out.println("<script>");
    			out.println("alert('������ Ȯ�����ּ���!');");
    			out.println("self.close();");
    			out.println("</script>");
    		}catch(Exception e) {
    			
    			e.printStackTrace();
    		}	
    		

    		
    	} //else   	
		
		
		
		return null;
		
	}

	
	
	
	
	// ���ƿ� �߰��Ѱ� Ȯ��

	@RequestMapping("like_view")
	public ModelAndView like_check(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
				
			
			
			List<FoodVO> like=memberService.like_view(Sid);
						
						
			ModelAndView m=new ModelAndView("Member/like_view");
			
			m.addObject("like", like);
			return m;
			
		}
		return null;
		
	}
	
	
	@GetMapping("like_del")
	public String like_del(HttpSession session,HttpServletResponse response,HttpServletRequest request) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('�ٽ� �α��� ���ּ���!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			
			int f_num=Integer.parseInt(request.getParameter("f_num"));
			FoodVO food=new FoodVO();
			food.setF_num(f_num);
			food.setMem_id(Sid);
			
			memberService.likeDel(food);
			out.println("<script>");
			out.println("console.log('��� �Ǿ����ϴ�!');");
			out.println("location='like_view';");
			out.println("</script>");
			
		}
		return null;
	}

}
