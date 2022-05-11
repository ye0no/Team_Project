package net.webplate.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;

import net.webplate.service.AdminService;
import net.webplate.vo.AdminVO;
import net.webplate.vo.FoodVO;
import net.webplate.vo.MemberVO;
import net.webplate.vo.ReviewVO;
import pwdconv.PwdChange;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	// 관리자 로그인 폼
	
	@GetMapping("admin_Login")
	public ModelAndView admin_Login() {
		return new ModelAndView("admin/admin_login");
	}
	
	@PostMapping("admin_login_ok")
	public String admin_login_ok(AdminVO ab,HttpServletResponse response, HttpSession  session) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		ab.setAdmin_pwd(PwdChange.getPassWordToXEMD5String(ab.getAdmin_pwd()));//비번 암호화
		//ab.setAdmin_name("관리자");	 관리자 아이디 : Admin12# 비번 :admin	
		//this.adminService.insertAdmin(ab);//관리자 정보 저장
		
		AdminVO admin_pwd = this.adminService.adminLogin(ab.getAdmin_id());//관리자 아이디에 해당하는 암호화 된 관리자 비번을 가져옴.
		
		if(admin_pwd==null) {
			out.println("<script>");
			out.println("alert('관리자 정보가 없습니다.');");
			out.println("history.go(-1);");//뒤로 한칸 이동		

			out.println("</script>");
		}else {
			if(!admin_pwd.getAdmin_pwd().equals(ab.getAdmin_pwd())) {//암호화 된 비번이 같지 않다면
				out.println("<script>");
				out.println("alert('관리자 비번이 다릅니다!');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				session.setAttribute("admin_id",ab.getAdmin_id());//세션 아이디 저장
				session.setAttribute("admin_name", admin_pwd.getAdmin_name());//세션이름 저장
				
				return "redirect:/admin_main";//관리자 메인으로 이동
			}
		}
		return null;
		
	}
	
	// 메인 페이지 이동
	@RequestMapping("/admin_main")
	public String admin_main(HttpServletResponse response,HttpSession session) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		if(admin_id == null) {
			out.println("<script>");
			out.println("alert('관리자로 다시 로그인 하세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");
		}else {
			return "admin/admin_main";
		}
		return null;
	}
	
	// 로그아웃
	@PostMapping("admin_logOut")
	public String admin_logOut(HttpServletResponse response,HttpSession session) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		session.invalidate(); // 세션 만료
		
		out.println("<script>");
		out.println("alert('관리자 로그아웃 되었습니다!');");
		out.println("location='admin_Login';");
		out.println("</script>");
		
		
		return null;
		
	}
	
	
	
	
	
	// 맛집 정보
	@GetMapping("admin_Board_list")
	public String admin_Board(HttpServletResponse response,HttpServletRequest request,HttpSession session,FoodVO food,Model listM) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		
		if(admin_id==null) {
			out.println("<script>");
			out.println("alert('관리자 로그인을 다시 해주세요!');");
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
			
			food.setFind_field(find_field);
			food.setFind_name("%"+find_name+"%");
			
			
			int listcount=adminService.getFoodListCount(food);			
			food.setStartrow((page-1)*10+1);
			food.setEndrow(food.getStartrow()+limit-1);
			
			List<FoodVO> flist=adminService.getFoodList(food);
			// 검색전후 음식 목록
			
			
			// 총 페이지 수
			 int maxpage=(int)((double)listcount/limit+0.95);
			 
			 int startpage=(((int)((double)page/10+0.9))-1)*10+1;
			 
			 int endpage=maxpage;
			 if(endpage >startpage+10-1) {
				 endpage=startpage+10-1;
			 }
			 
			listM.addAttribute("flist",flist );

			listM.addAttribute("page",page );

			listM.addAttribute("startpage", startpage);

			listM.addAttribute("endpage",endpage );

			listM.addAttribute("maxpage",maxpage );

			listM.addAttribute("listcount",listcount );

			listM.addAttribute("find_field", find_field);
			
			listM.addAttribute("find_name",find_name );
			
			return "admin/admin_Board_list";			
		
		}
		
		return null;		
		
	}
	
	
	// 맛집 수정
	@GetMapping("admin_Board_Edit")
	public ModelAndView admin_Board_Edit(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		
		String admin_id=(String)session.getAttribute("admin_id");
		int f_num=Integer.parseInt(request.getParameter("f_num"));
		String find_name=request.getParameter("find_name");
		String find_field=request.getParameter("find_field");
		
		if(admin_id==null) {
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인 해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");
		}else {
			int page=1;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			
			FoodVO f=adminService.getAdminFoodCont(f_num);
			String food_menu=f.getMenu().replace("/n", "<br>");
						
			ModelAndView m=new ModelAndView("admin/admin_Board_Edit");
			m.addObject("f", f);
			m.addObject("f_num", f_num);
			m.addObject("food_menu", food_menu);
			m.addObject("page", page);
			m.addObject("find_field", find_field);
			m.addObject("find_name", find_name);
			return m;	
		}
		return null;	
		
	}
	
	// 맛집정보 수정
	@PostMapping("admin_Board_Edit_ok")
	public ModelAndView admin_Board_Edit_ok(@ModelAttribute FoodVO food,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception{
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	
	String admin_id=(String)session.getAttribute("admin_id");
	
	if(admin_id==null) {
		out.println("<script>");
		out.println("alert('관리자님 다시 로그인 해주세요!');");
		out.println("location='admin_Login';");
		out.println("</script>");
	}else {
	
	

		String saveFolder=request.getRealPath("./resources/upload");
		
		
		int fileSize=10*1024*1024;  // 10mb
		MultipartRequest multi=null;
		
		multi=new MultipartRequest(request,saveFolder,fileSize,"UTF-8");
		
		int page=1;
		if(multi.getParameter("page") != null) {
			page=Integer.parseInt(multi.getParameter("page"));
		}
		
		int f_num=Integer.parseInt(multi.getParameter("f_num"));
		String category=multi.getParameter("f_category");
		String bsnsnm=multi.getParameter("f_bsnsnm");
		String bsnscond=multi.getParameter("f_bsnscond");
		String tel=multi.getParameter("f_tel");
		
		String menu=multi.getParameter("f_menu");
		String addr=multi.getParameter("f_addr");
		
		String lat=multi.getParameter("f_lat");
		String lng=multi.getParameter("f_lng");
		String rest=multi.getParameter("f_rest");
		String suyong=multi.getParameter("f_suyong");
		
		FoodVO db_file=adminService.getAdminFoodCont(f_num);
		
		File upFile1=multi.getFile("file1");
		if(upFile1 !=null) {
			String fileName=upFile1.getName();
			File delFile=new File(saveFolder+db_file.getFood_file1());
			
			if(delFile.exists()) {
				delFile.delete();
			}
			
			
			Calendar cal=Calendar.getInstance();
			int year=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH)+1;
			int date=cal.get(Calendar.DATE);
			
			String homedir=saveFolder+"/"+year+"-"+month+"-"+date;
			File path01=new File(homedir);
			if(!(path01.exists())) {
				path01.mkdir();
			}
			
			Random r=new Random();
			int random=r.nextInt();
			
			int index=fileName.lastIndexOf(".");
			String fileExtendsion=fileName.substring(index+1);
			String refileName="food"+year+month+date+random+"."+fileExtendsion;
			String fileDBName="/"+year+"-"+month+"-"+date+"/"+refileName;
			upFile1.renameTo(new File(homedir+ "/"+refileName));
			
			food.setFood_file1(fileDBName);
		}else {
			String fileDBName="";
			if(db_file.getFood_file1()!=null) {
				food.setFood_file1(db_file.getFood_file1());	
			}else {
				food.setFood_file1(fileDBName);
			}
		}
		
		
		File upFile2=multi.getFile("file2");
		if(upFile2 !=null) {
			String fileName2=upFile2.getName();
			File delFile2=new File(saveFolder+db_file.getFood_file2());
			
			if(delFile2.exists()) {
				delFile2.delete();
			}
			
			
			Calendar cal=Calendar.getInstance();
			int year=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH)+1;
			int date=cal.get(Calendar.DATE);
			
			String homedir=saveFolder+"/"+year+"-"+month+"-"+date;
			File path02=new File(homedir);
			if(!(path02.exists())) {
				path02.mkdir();
			}
			
			Random r=new Random();
			int random=r.nextInt();
			
			int index2=fileName2.lastIndexOf(".");
			String fileExtendsion2=fileName2.substring(index2+1);
			String refileName2="food"+year+month+date+random+"."+fileExtendsion2;
			String fileDBName2="/"+year+"-"+month+"-"+date+"/"+refileName2;
			upFile2.renameTo(new File(homedir+ "/"+refileName2));
			
			food.setFood_file2(fileDBName2);
		}else {
			String fileDBName2="";
			if(db_file.getFood_file2()!=null) {
				food.setFood_file2(db_file.getFood_file2());	
			}else {
				food.setFood_file2(fileDBName2);
			}
		}
					
		
		
		File upFile3=multi.getFile("file3");
		if(upFile3 !=null) {
			String fileName3=upFile3.getName();
			File delFile3=new File(saveFolder+db_file.getFood_file3());
			
			if(delFile3.exists()) {
				delFile3.delete();
			}
			
			
			Calendar cal=Calendar.getInstance();
			int year=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH)+1;
			int date=cal.get(Calendar.DATE);
			
			String homedir=saveFolder+"/"+year+"-"+month+"-"+date;
			File path03=new File(homedir);
			if(!(path03.exists())) {
				path03.mkdir();
			}
			
			Random r=new Random();
			int random=r.nextInt();
			
			int index3=fileName3.lastIndexOf(".");
			String fileExtendsion3=fileName3.substring(index3+1);
			String refileName3="food"+year+month+date+random+"."+fileExtendsion3;
			String fileDBName3="/"+year+"-"+month+"-"+date+"/"+refileName3;
			upFile3.renameTo(new File(homedir+ "/"+refileName3));
			
			food.setFood_file3(fileDBName3);
		}else {
			String fileDBName3="";
			if(db_file.getFood_file3()!=null) {
				food.setFood_file3(db_file.getFood_file3());	
			}else {
				food.setFood_file3(fileDBName3);
			}
		}
		
		System.out.println(food.getFood_file3());
		food.setF_num(f_num);
		food.setBsnscond(bsnscond); food.setBsnsnm(bsnsnm);
		food.setTel(tel); food.setAddr(addr);
		food.setLat(lat);food.setLng(lng);
		food.setRest(rest); food.setMenu(menu);
		food.setSuyong(suyong); food.setCategory(category);
		
		
		adminService.editFoodCont(food);
		
		ModelAndView em=new ModelAndView();
		em.addObject("page", page);
		em.addObject("f_num", f_num);
		em.setViewName("redirect:/admin_Board_cont");
		return em;
	}
		
		return null;	
	}
	
	
	
	@GetMapping("admin_Board_cont")
	public ModelAndView admin_Board_cont(HttpServletRequest request,HttpServletResponse response, HttpSession session,FoodVO food,ReviewVO review)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		
		if(admin_id==null) {
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인 해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");
		}else {
			int page=1;
			int limit=1000;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			int f_num=Integer.parseInt(request.getParameter("f_num"));
			double point=adminService.getPoint(f_num);						
			
			FoodVO f=adminService.getDetails(f_num); // 세부정보
			String food_menu=f.getMenu().replace("\n", "<br>");
			int listcount=adminService.GetReviewInfoCount(review);	
			review.setStartrow((page-1)*10+1);
			review.setEndrow(review.getStartrow()+limit-1);	
			
			List<ReviewVO> rlist=adminService.GetReviewInfo(review);
					
						
			ModelAndView cm=new ModelAndView();
			cm.addObject("page", page);
			cm.addObject("f_num",f_num);
			cm.addObject("f", f);
			cm.addObject("food_menu", food_menu);
			cm.addObject("point", point);
			cm.addObject("rlist",rlist);
			cm.addObject("listcount", listcount);
			cm.setViewName("admin/admin_Board_cont");
			return cm;			
		}
		return null;
		
	}
	
	
	@RequestMapping("admin_review_del")
	public String admin_review_del(HttpServletRequest request,HttpServletResponse response, HttpSession session)throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String admin_id=(String)session.getAttribute("admin_id");
		
		if(admin_id==null) {
			out.println("<script>");
			out.println("alert('관리자님 다시 로그인 해주세요!');");
			out.println("location='admin_Login';");
			out.println("</script>");
		}else {
			int f_num=Integer.parseInt(request.getParameter("f_num"));
			int rno=Integer.parseInt(request.getParameter("rno"));
			
			int page=1;
			int limit=1000;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
			}
			
			
			adminService.delReview(rno);
			  // 평점 가져오기
	    	double point=adminService.getPoint(f_num);
	    	
	    	FoodVO food=new FoodVO();
			food.setGrade(point);
			food.setF_num(f_num);
	    	// 평점 업데이트
	    	adminService.updateReviewPoint(food);
		
			

			out.println("<script>");
			out.println("alert('리뷰가 삭제되었습니다!');");
			out.println("location='admin_Board_cont?f_num="+f_num+"&page="+page+"';");
			
			out.println("</script>");
			
			
		}
		return null;
		
	}
	

}
