package net.webplate.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.AdminGongjiService;
import net.webplate.vo.AdminGongjiVO;

@Controller
public class AdminGongjiController {
	
	
	@Autowired
	private AdminGongjiService gongjiService;
	
	@GetMapping("admin_Gongji_list")
	public ModelAndView admin_Gongji_list(HttpServletResponse response,HttpServletRequest request, @ModelAttribute AdminGongjiVO g,HttpSession session )throws Exception {
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
			int limit=10;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			
			String find_name=request.getParameter("find_name");
			String find_field=request.getParameter("find_field");
			
			g.setFind_field(find_field);
			g.setFind_name("%"+find_name+"%");
			
			int listcount=gongjiService.getListcount(g);
			
			g.setStartrow((page-1)*10+1);
			g.setEndrow(g.getStartrow()+limit-1);
			
			List<AdminGongjiVO> glist=gongjiService.getGongjiList(g);
			
			int maxpage=(int)((double)listcount/limit+0.95);
			int startpage=(((int)((double)page/10+0.9))-1)*10+1;
			
			int endpage=maxpage;
			if(endpage>startpage+10-1) {
				endpage=startpage+10-1;
			}
			
			ModelAndView gm=new ModelAndView("admin/admin_Gongji_list");
			gm.addObject("page", page);
			gm.addObject("glist", glist);
			gm.addObject("startpage",startpage);
			gm.addObject("endpage",endpage);
			gm.addObject("maxpage",maxpage);
			gm.addObject("listcount",listcount);
			gm.addObject("find_field",find_field);
			gm.addObject("find_name",find_name);
			
			return gm;
		}			
		return null;
	}
	
	
	@GetMapping("admin_Gongji_insert")
	public ModelAndView admin_Gongji_insert(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws Exception {
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
			String admin_name=gongjiService.findAdmin_name(admin_id);
			
			ModelAndView im=new ModelAndView("admin/admin_Gongji_insert");
			im.addObject("admin_name",admin_name);
			im.addObject("page", page);
			
			return im;
		}
		
		return null;
		
	}
	
	@PostMapping("admin_Gongji_ok")
	public String admin_Gongji_ok(HttpSession session,AdminGongjiVO gongji,HttpServletResponse response)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String admin_id=(String)session.getAttribute("admin_id");
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");
		}else {
			gongjiService.insertGongji(gongji);  // 글 등록

			out.println("<script>");
			out.println("alert('글 등록 완료 !');");
			out.println("location='admin_Gongji_list';");
			out.println("</script>");
			
		}
		
		return null;
		
	}
	
	@GetMapping("admin_gongji_info")
	public ModelAndView admin_gongji_info(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws Exception{
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
			int gongji_no=Integer.parseInt(request.getParameter("gongji_no"));
			gongjiService.updateHit(gongji_no);
			AdminGongjiVO g=gongjiService.getInfo(gongji_no);			
			String cont=g.getGongji_cont().replace("/n", "<br>");
			ModelAndView m=new ModelAndView("admin/admin_gongji_info");
			m.addObject("g",g);
			m.addObject("cont", cont);
			m.addObject("page", page);
			return m;
			
			
		}
		
		return null;
	}
	
	
	@GetMapping("admin_Gongji_Del")
	public String admin_Gongji_Del(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws Exception{
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
			int gongji_no=Integer.parseInt(request.getParameter("gongji_no"));
			gongjiService.DeleteGongji(gongji_no);
			
			out.println("<script>");
			out.println("alert('공지글이 삭제되었습니다!');");
			out.println("location='admin_Gongji_list?page="+page+"';");
			out.println("</script>");
		}
		return null;
		
		
	}
	@GetMapping("admin_Gongji_Edit")
	public ModelAndView admin_Gongji_Edit(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws Exception{
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
			int gongji_no=Integer.parseInt(request.getParameter("gongji_no"));
			AdminGongjiVO g=gongjiService.getInfo(gongji_no);
			String cont=g.getGongji_cont().replace("/n", "<br>");
			ModelAndView em=new ModelAndView("admin/admin_Gongji_Edit");
			em.addObject("g",g);
			em.addObject("cont", cont);
			em.addObject("page", page);
			return em;
			
		}
		return null;
	}
	
	
	@PostMapping("admin_Gongji_Edit_ok")
	public String admin_Gongji_Edit_ok(HttpServletRequest request,HttpSession session,HttpServletResponse response,AdminGongjiVO gongji)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
				
		String admin_id=(String)session.getAttribute("admin_id");
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");
		}else {
			gongjiService.edit(gongji);
			
			out.println("<script>");
			out.println("alert('정보가 수정되었습니다!');");
			out.println("location='admin_gongji_info?gongji_no="+gongji.getGongji_no()+"';");
			out.println("</script>");
			
		}
		return null;
	}


}
