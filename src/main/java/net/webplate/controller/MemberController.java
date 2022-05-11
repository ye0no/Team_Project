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
	
	// 로그인
	@GetMapping("/login")
	public void login() {
		
	}
	
	// 회원가입
	@GetMapping("loginForm")
	public void loginForm(Model m) {
		String arr[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		m.addAttribute("arr",arr);
				
	}	

	 // 중복체크
	@PostMapping("/member_idCheck")
	public String member_idcheck(@RequestParam("id") String id,MemberVO vo,HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		MemberVO db_id=memberService.idcheck(id);
		
		int re=0; // 중복아이디가 없을때 반환값
		if(db_id !=null) { // 중복아이디가 있다면
			re=1;
		}
		out.println(re); // 비동기식 값 반환
		
		return null;
	} // 중복체크 종료
	
	// 회원가입 성공
	@PostMapping("Join_Ok")
	public String Join_Ok(MemberVO m,HttpServletResponse response)throws Exception  {
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
		
	 m.setPw(PwdChange.getPassWordToXEMD5String(m.getPw()));
	 memberService.insertMember(m);	 
	 out.println("<script>");
	 out.println("alert('회원가입 성공!');");
	 out.println("location='../Member/login';");
	 out.println("</script>");
	 return null;
		
	}
	
	
	
	// 로그인 체크
	@PostMapping("Login_ok")
	public ModelAndView Login_ok(HttpServletResponse response, HttpServletRequest request, @RequestParam("m_id") String login_id,@RequestParam("m_pw")String login_pw,
			HttpSession session,Model m) throws Exception{
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		MemberVO dm=memberService.loginCheck(login_id);
		
		if(dm==null) {
			out.println("<script>");
			out.println("alert('가입되지 않은 사용자입니다!');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			if(!dm.getPw().equals(PwdChange.getPassWordToXEMD5String(login_pw))) {  // 회원가입되고 암호화  진행할예정
				out.println("<script>");
				out.println("alert('비번이 다릅니다!');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				session.setAttribute("Sid", login_id); // 세션에 id 값 저장				
				return new ModelAndView("redirect:/index");
			}
		}
		
		return null;
		
	}
	
	
	// 로그아웃 기능 구현
	@GetMapping("logOut")
	public String Member_LogOut(HttpServletResponse response, HttpSession session) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();		
			
		session.invalidate();
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!');");
		out.println("location='/controller/index';");
		
		out.println("</script>");
		
		return null;
	}
	
	// 회원 조회
	@GetMapping("list")
	public ModelAndView member_list(HttpSession session, HttpServletResponse response)throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='../Member/login';");			
			out.println("</script>");
			
		}
		else {
			MemberVO list=memberService.getMember(Sid);
			String jumin=list.getJumin1()+" 년 "+list.getJumin2()+" 월 " +list.getJumin3()+" 일 ";
			
			String tel=list.getTel().substring(0,3)+" - "+list.getTel().substring(3,7)+ " - "+list.getTel().substring(7,11);
			
			ModelAndView m=new ModelAndView("Member/list");
			m.addObject("m", list);
			m.addObject("jumin",jumin);
			m.addObject("tel", tel);
			
			
			
			return m;
		}
		

		return null;
		}
	
	// 정보 수정
	@PostMapping("mem_edit")
	public ModelAndView mem_edit(HttpServletResponse response,HttpSession session) throws Exception{
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		String Sid=(String) session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!');");
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
	
	// 정보 수정 완료
	@PostMapping("mem_edit_Ok")
	public String mem_edit_Ok(MemberVO m, HttpServletResponse response,HttpSession session)throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			m.setId(Sid);
			m.setPw(PwdChange.getPassWordToXEMD5String(m.getPw()));
			
			memberService.updateMember(m);
			
			out.println("<script>");
			out.println("alert('회원정보가 수정되었습니다!');");
			out.println("location='list';");			
			out.println("</script>");
			
		}
		return null;
		
	}
	
	// 회원탈퇴
	@GetMapping("memberDel")
	public void memberDel () {
		
	}
	
	// 회원탈퇴 성공
	@PostMapping("m_Del_ok")
	public String m_Del_ok(String del_pwd,String del_cont,HttpServletResponse response,HttpSession session) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			del_pwd = PwdChange.getPassWordToXEMD5String(del_pwd);//비번 암호화
    		MemberVO db_pwd=memberService.getMember(Sid);
    		
    		if(!db_pwd.getPw().equals(del_pwd)) {
    			out.println("<script>");
    			out.println("alert('비번이 다릅니다!');");
    			out.println("history.back();");
    			out.println("</script>");
    		}else {
    			MemberVO dm=new MemberVO();
    			dm.setId(Sid); dm.setMem_delcont(del_cont);
    			memberService.delMember(dm); // 회원탈퇴
    			// 탈퇴사유 mem_state=0 ,탈퇴날짜 수정
    			session.invalidate();
    			
    			out.println("<script>");
    			out.println("alert('회원탈퇴 성공');");
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
			out.println("alert('회원이 존재하지 않습니다!');");
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

		
	// 비번 찾기
	@GetMapping("pwd_find")
	public void pwd_find() {
		
	}
	
	@PostMapping("pwd_find_ok")
	public String pwd_find_ok(String username,String userID,HttpServletResponse response,HttpServletRequest requst,HttpSession session,MemberVO m,Model m2)throws Exception{
		response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
		
    	m.setId(userID); m.setName(username);
    	MemberVO fm=memberService.pwdMember(m); // 이름 아이디 통해 비번조회
    	
    	if(fm==null) {
    		out.println("<script>");
    		out.println("alert('회원정보를 찾을 수 없습니다!');");
    		out.println("history.back();");
    		out.println("</script>");
    	}else {
    		// 자바 1.8이용한 숫자 + 문자 랜덤생성
    		int leftLimit=48; //0부터
    		int rightLimit=122; // 문자 z
    		int targetStringLength=10;    		
    		Random r=new Random();
    		
    		
    		String ran_pwd=r.ints(leftLimit,rightLimit+1) // 시작과 끝범위
    				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // 숫자 영문만 받기위해 필터링(모르겠으면 ASCII코드 참고)
    				.limit(targetStringLength) // 최종길이
    				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) // 결과로 얻어진 것에 대해서 어떻게 처리할지 정의
    				.toString();  //문자로 반환
    		m.setPw(PwdChange.getPassWordToXEMD5String(ran_pwd));
    		
    		memberService.updatePwd(m);  //임시비번 수정
    				
    		String user="smtptest123@naver.com"; // 발신 아이디
    		String password="webplate12#"; // 발신 비번
    		    		
    		Properties prop=new Properties();
    		prop.put("mail.smtp.host","smtp.naver.com");  // 호스트 도메인주소
    		prop.put("mail.smtp.port", 465);  // 호스트 포트번호
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
    			
    			
    			// 메일 제목
    			message.setSubject("웹 플레이트 임시 비밀번호입니다.");
    			
    			//메일 내용
    			message.setText("회원님의 임시 비밀번호는"+ran_pwd+" 입니다.");  // 로그인할때 암호화니까 초기값 넣음
 			    			
    			Transport.send(message);  // 메시지 전송
    			
    			out.println("<script>");
    			out.println("alert('메일을 확인해주세요!');");
    			out.println("self.close();");
    			out.println("</script>");
    		}catch(Exception e) {
    			
    			e.printStackTrace();
    		}	
    		

    		
    	} //else   	
		
		
		
		return null;
		
	}

	
	
	
	
	// 좋아요 추가한거 확인

	@RequestMapping("like_view")
	public ModelAndView like_check(HttpServletResponse response,HttpServletRequest request,HttpSession session)throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String Sid=(String)session.getAttribute("Sid");
		if(Sid==null) {
			out.println("<script>");
			out.println("alert('다시 로그인 해주세요!');");
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
			out.println("alert('다시 로그인 해주세요!');");
			out.println("location='../Member/login';");
			out.println("</script>");
		}else {
			
			int f_num=Integer.parseInt(request.getParameter("f_num"));
			FoodVO food=new FoodVO();
			food.setF_num(f_num);
			food.setMem_id(Sid);
			
			memberService.likeDel(food);
			out.println("<script>");
			out.println("console.log('취소 되었습니다!');");
			out.println("location='like_view';");
			out.println("</script>");
			
		}
		return null;
	}

}
