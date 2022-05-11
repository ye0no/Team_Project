package net.webplate.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.AdminMemberService;
import net.webplate.vo.MemberVO;
import pwdconv.PwdChange;

@Controller
public class AdminMemberController {
	
	@Autowired
	private AdminMemberService adminmemberService;
	
	@GetMapping("/adminMember_List")
	public ModelAndView adminMember(HttpServletResponse response,HttpSession session,@ModelAttribute MemberVO m, HttpServletRequest request)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String admin_id=(String)session.getAttribute("admin_id");
		
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");			
		}else {
			int page=1;
			int limit=7;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			
			String find_name=request.getParameter("find_name");
			String find_field=request.getParameter("find_field");
			
			m.setFind_field(find_field);
			m.setFind_name("%"+find_name+"%");
			
			int listcount=adminmemberService.getListcount(m);
			
			m.setStartrow((page-1)*7+1);
			m.setEndrow(m.getStartrow()+limit-1);
			
			List<MemberVO> mlist=adminmemberService.getMemberList(m);
			
			int maxpage=(int)((double)listcount/limit+0.95);
			int startpage=(((int)((double)page/10+0.9))-1)*10+1;
			
			int endpage=maxpage;
			if(endpage>startpage+10-1) {
				endpage=startpage+10-1;
			}
									
			ModelAndView lm=new ModelAndView();
			lm.addObject("page",page );
			lm.addObject("mlist", mlist);
			lm.addObject("startpage", startpage);
			lm.addObject("endpage",endpage );
			lm.addObject("maxpage",maxpage );
			lm.addObject("listcount",listcount );
			lm.addObject("find_field",find_field );
			lm.addObject("find_name", find_name);		
			
			lm.setViewName("admin/adminMember_List");
			return lm;
		}
	
			
		return null;
	}
			
	// 계정삭제
	@RequestMapping("admin_member_del")
	public ModelAndView admin_member_del(@RequestParam("id") String id,HttpServletRequest request,HttpSession session,HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String admin_id=(String)session.getAttribute("admin_id");
		
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");	
		}else {
			int page=1;
			if(request.getParameter("page") != null) {
				page=Integer.parseInt(request.getParameter("page"));    		
			}
			adminmemberService.DelteMember(id);
								
			ModelAndView m=new ModelAndView();
			m.addObject("page", page);
			m.setViewName("redirect:/adminMember_List");			
			return m;
		}
		
		return null;
	}
	
	
	
	// 회원정보 수정
	@RequestMapping("admin_member_Edit")
	public ModelAndView admin_member_Edit(HttpServletResponse response,HttpSession session,HttpServletRequest request)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String admin_id=(String)session.getAttribute("admin_id");
		
		String id=request.getParameter("id");
		
		String arr[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
				
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");	
		}else {
			int page=1;
			if(request.getParameter("page") != null) {
				page=Integer.parseInt(request.getParameter("page"));    		
			}		
			
			MemberVO m=adminmemberService.getMember(id);
			
			ModelAndView em=new ModelAndView();
			em.addObject("m", m);
			em.addObject("page",page);
			em.addObject("arr", arr);
			em.setViewName("admin/admin_member_Edit");
			return em;
			
		}
		
		return null;
		
	}
	
	
	@PostMapping("admem_Edit_ok")
	public String admem_Edit_ok(MemberVO m,HttpServletResponse response,HttpSession session,HttpServletRequest request)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String admin_id=(String)session.getAttribute("admin_id");
		
		
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");	
		}else {		
			m.setPw(PwdChange.getPassWordToXEMD5String(m.getPw()));
			adminmemberService.edit(m);
						
			out.println("<script>");
			out.println("alert('정보가 수정되었습니다!');");
			out.println("location='admin_member_info?id="+m.getId()+"';");
			out.println("</script>");
				
		}
		return null;
	}
	
	
	@RequestMapping("admin_member_info")
	public ModelAndView admin_member_info(HttpServletResponse response,HttpSession session,HttpServletRequest request)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		
		String id=request.getParameter("id");		
				
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");	
		}else {
			int page=1;
			if(request.getParameter("page") != null) {
				page=Integer.parseInt(request.getParameter("page"));    		
			}
			MemberVO m=adminmemberService.getMember(id);			
						
			String jumin=m.getJumin1()+" 년 "+m.getJumin2()+" 월 "+m.getJumin3()+"일";
			String tel=m.getTel().substring(0,3)+"-"+m.getTel().substring(3,7)+"-"+m.getTel().substring(7,11);
			ModelAndView cm=new ModelAndView();
			cm.addObject("m", m);
			cm.addObject("jumin", jumin);
			cm.addObject("tel", tel);
			cm.addObject("page", page);
			cm.setViewName("admin/admin_member_info");
			return cm;
		}
		
		
		return null;
		
		
	}

}
