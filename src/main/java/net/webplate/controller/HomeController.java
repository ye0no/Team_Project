package net.webplate.controller;


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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.FoodService;
import net.webplate.vo.FoodVO;


@Controller
public class HomeController {	
	
	
	@Autowired
	private FoodService foodService;

	@GetMapping(value={"/","/index"})
	public String home(Model list) {	
		String pig="%돼지%";
		
		// 돼지고기 탑8만 보이게 가져오기
		List<FoodVO> pig8=foodService.getTop_8(pig);
		
		List<FoodVO> sashimi8=foodService.getTop_8();
		
		
		
		
		list.addAttribute("pig8", pig8);
		list.addAttribute("sashimi8", sashimi8);
		
		return "index";
	}
	
	@GetMapping("test")
	public void test() {
		
	}
	

	
	// 검색기능
	@GetMapping("search")
	public ModelAndView search(HttpServletResponse response,HttpServletRequest request, @ModelAttribute FoodVO food)throws Exception {	
				
		int page=1;
		int limit=5;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		String find_name=request.getParameter("find_name");		
		food.setFind_name("%"+find_name+"%");
		
		int listcount=foodService.getSearchCount(food);	
		
		food.setStartrow((page-1)*5+1);
		food.setEndrow(food.getStartrow()+limit-1);
				
		List<FoodVO> flist=foodService.getSearchList(food);

	    int maxpage=(int)((double)listcount/limit+0.95);
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
			
		int endpage=maxpage;
		if(endpage>startpage+10-1) {
			endpage=startpage+10-1;
		}
			ModelAndView m=new ModelAndView();
			m.addObject("page", page);
			m.addObject("flist", flist);
			m.addObject("startpage", startpage);
			m.addObject("endpage", endpage);
			m.addObject("maxpage", maxpage);
			m.addObject("listcount", listcount);
			m.addObject("find_name",find_name);
			m.setViewName("search");
			
			return m;
		
		
	}
	
	

			
	
}
