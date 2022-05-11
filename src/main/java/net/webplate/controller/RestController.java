package net.webplate.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.AdminService;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;
import net.webplate.vo.ReviewVO;

@Controller
@RequestMapping("/rest/*")
public class RestController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="goldpig")
	public void goldpig() {
		
	}
	
	@RequestMapping(value="rest1")
	public ModelAndView rest1(HttpServletRequest request,HttpSession session,ReviewVO review)throws Exception {
	   String Sid=(String)session.getAttribute("Sid");
	   
	   int page=1;
	   int limit=1000;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		int f_num=Integer.parseInt(request.getParameter("f_num"));
		int listcount=adminService.GetReviewInfoCount(review);	
		review.setStartrow((page-1)*10+1);
		review.setEndrow(review.getStartrow()+limit-1);	
		
		List<ReviewVO> rlist=adminService.GetReviewInfo(review);
		
		double point=adminService.getPoint(f_num);
		
		
	   if(Sid!=null) {
		   
		   adminService.getHit(f_num);		
		   
		   FoodVO f=adminService.getDetails(f_num); // 세부정보
		   f.setMem_id(Sid);	
		   String food_menu=f.getMenu().replace("\n", "<br>");
			 
		   // 회원일때
		   List<FoodVO> mem=adminService.getmem_cont(f);
		   
			ModelAndView cm=new ModelAndView();
			cm.addObject("page", page);
			cm.addObject("f_num",f_num);
			cm.addObject("mem", mem);
			cm.addObject("point", point);
			cm.addObject("food_menu", food_menu);
			cm.setViewName("/rest/rest1");
			cm.addObject("rlist",rlist);
			cm.addObject("listcount", listcount);
			return cm;	
		   
	   }else {
		
		adminService.getHit(f_num);
		FoodVO f=adminService.getDetails(f_num); // 세부정보
		String food_menu=f.getMenu().replace("\n", "<br>");
		
		// 비회원일때
		 List<FoodVO> non=adminService.getnon_cont(f);
		   
		
		ModelAndView cm=new ModelAndView();
		cm.addObject("page", page);
		cm.addObject("non", non);
		cm.addObject("f_num",f_num);
		cm.addObject("rlist",rlist);
		cm.addObject("listcount", listcount);
		cm.addObject("point", point);	
		cm.addObject("food_menu", food_menu);
		cm.setViewName("/rest/rest1");
		return cm;	
	   }
		
	}
	
	
	@PostMapping("review_ok")
	public String review_ok(HttpSession session,HttpServletResponse response,HttpServletRequest request)throws Exception {
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
			int f_num=Integer.parseInt(request.getParameter("f_num"));			
			int star_value=Integer.parseInt(request.getParameter("rating"));
			String cont=request.getParameter("review_cont");
			
			ReviewVO r=new ReviewVO();			
			r.setF_num(f_num);
			r.setR_point(star_value);
			r.setMem_id(Sid);
			r.setR_cont(cont);
			
			// 리뷰 등록
			adminService.insertReview(r);
			//  리뷰 점수 평균 가져오기
			double point=adminService.getPoint(f_num);
			
			FoodVO food=new FoodVO();
			food.setGrade(point);
			food.setF_num(f_num);
			adminService.updateReviewPoint(food);
			
			
			System.out.println(star_value);
			System.out.println(cont);
			
			out.println("<script>");
			out.println("alert('리뷰 등록 완료!');");
			out.println("location='rest1?f_num="+f_num+"';");			
			out.println("</script>");
		}
		
		
		return null;
		
	}
	
	
	@RequestMapping("/review_edit_ok")
	public ModelAndView review_edit_ok(HttpServletResponse response,HttpServletRequest request,ReviewVO review) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int f_num=Integer.parseInt(request.getParameter("f_num"));
		int rno=Integer.parseInt(request.getParameter("rno"));			
		String mem_id=request.getParameter("mem_id");
		String r_cont=request.getParameter("edit_info");
		
		String db_mem = adminService.getmem_id(review);
		
		System.out.println(mem_id);
		System.out.println(rno);
		System.out.println(f_num);
		System.out.println(r_cont);
		
		System.out.println(db_mem);
		
		if(mem_id == null) {
			out.println("<script>");
			out.println("alert('로그인 후 사용해주세요!');");
			out.println("location='../Member/login';");			
			out.println("</script>");
		} else if(!mem_id.equals(db_mem)) {
			out.println("<script>");
			out.println("alert('자신의 댓글만 수정 가능합니다!');");	
			out.println("history.go(-1);");
			out.println("</script>");
		} else if(mem_id.equals(db_mem)) {
			
			review.setMem_id(mem_id); review.setRno(rno); review.setR_cont(r_cont);
			
			adminService.updateReviewEdit(review);
			
		}
		
		
		ModelAndView em=new ModelAndView();
		em.setViewName("redirect:/rest/rest1?f_num="+f_num);
		return em;
		
	}
	
	@RequestMapping("review_del_ok")
    public String review_del_ok(HttpServletResponse response,HttpServletRequest request,ReviewVO review) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        int f_num=Integer.parseInt(request.getParameter("f_num"));
        int rno=Integer.parseInt(request.getParameter("rno"));
        String mem_id=request.getParameter("mem_id");

        adminService.delReview(review);
        
        // 평점 가져오기
    	double point=adminService.getPoint(f_num);
    	
    	FoodVO food=new FoodVO();
		food.setGrade(point);
		food.setF_num(f_num);
    	// 평점 업데이트
    	adminService.updateReviewPoint(food);
		
		

        return "redirect:/rest/rest1?f_num="+f_num;

    }
	

}
