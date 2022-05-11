package net.webplate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.AdminGongjiService;
import net.webplate.vo.AdminGongjiVO;

@Controller

public class FooterController {
	
	@Autowired
	private AdminGongjiService gongjiService;
	
	@GetMapping(value="board")
	public ModelAndView board(HttpServletRequest request,AdminGongjiVO g) {
		
		
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
		
		ModelAndView gm=new ModelAndView("footer/board");
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
	
	
	@GetMapping("board_cont")
	public ModelAndView board_cont(HttpServletRequest request) {
		int gongji_no=Integer.parseInt(request.getParameter("gongji_no"));
		int page=1;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		gongjiService.updateHit(gongji_no);
		AdminGongjiVO gongji=gongjiService.getInfo(gongji_no);		
		String regdate=gongji.getGongji_register().substring(0,10);
		String cont=gongji.getGongji_cont().replace("/n", "<br>");
		ModelAndView cm=new ModelAndView("footer/board_cont");
		cm.addObject("page", page);
		cm.addObject("gongji", gongji);
		cm.addObject("cont", cont);
		cm.addObject("regdate", regdate);
		return cm;
	}

	
	@GetMapping(value="NonMember")
	public ModelAndView NonMember() {
		ModelAndView m=new ModelAndView("footer/NonMember");
		return m;
	}
	
	
	@GetMapping(value="Terms_of_Use")
	public ModelAndView Terms_of_Use() {
		ModelAndView m=new ModelAndView("footer/Terms_of_Use");
		return m;
	}
	
	@GetMapping(value="AboutUS")
	public ModelAndView AboutUS() {
		ModelAndView m=new ModelAndView("footer/AboutUs");
		return m;
	}
	
	
	@GetMapping(value="Inquire")
	public ModelAndView Inquire() {
		ModelAndView m=new ModelAndView("footer/Inquire");
		return m;
	}

}
