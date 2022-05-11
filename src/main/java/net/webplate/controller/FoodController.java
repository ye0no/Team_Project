package net.webplate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.webplate.service.FoodService;
import net.webplate.vo.FoodVO;

@Controller
@RequestMapping(value="/recomTop/*")
public class FoodController {
	
	
	@Autowired
	private FoodService foodservice;
	
	@GetMapping(value="/reTop10")
	public ModelAndView reTop10(HttpServletRequest request,HttpSession session)throws Exception {
		
		Date nowTime = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String Date=dt.format(nowTime);
		String Sid=(String)session.getAttribute("Sid");
		
		
		int res=Integer.parseInt(request.getParameter("addr"));
		
		if(res==1) {
			String divide="%안산%";
			String divide2="안산";
			String ment="안산 음식 구경해 볼래?";
			
			int listcount=foodservice.foodAreaCount(divide);
			int hit=foodservice.foodArea_Hit(divide); // 총 조회수
			
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setAddr(divide);
				List<FoodVO> like_list=foodservice.getAddrCont2(food);				
				ModelAndView m=new ModelAndView("recomTop/reTop10");
				m.addObject("divide2", divide2);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);
				m.addObject("listcount",listcount);
				m.addObject("hit", hit);
				m.addObject("ment",ment);		
				return m;
			}else {									
			List<FoodVO> food=foodservice.getAddrCont(divide);
			ModelAndView m=new ModelAndView("recomTop/reTop10");
			m.addObject("divide2", divide2);
			m.addObject("food", food);
			m.addObject("Date", Date);
			m.addObject("listcount",listcount);
			m.addObject("hit", hit);
			m.addObject("ment",ment);		
			return m;
			}
		}
		else if(res==2) {
			String divide="%횡성%";
			String divide2="횡성";
			String ment="횡성 찐맛집 여기 다 있네!";			
			int listcount=foodservice.foodAreaCount(divide);		
			int hit=foodservice.foodArea_Hit(divide); // 총 조회수
			
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setAddr(divide);
				List<FoodVO> like_list=foodservice.getAddrCont2(food);				
				ModelAndView m=new ModelAndView("recomTop/reTop10");
				m.addObject("divide2", divide2);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);
				m.addObject("listcount",listcount);
				m.addObject("hit", hit);
				m.addObject("ment",ment);		
				return m;
			}else {	
			List<FoodVO> food=foodservice.getAddrCont(divide);
			ModelAndView m2=new ModelAndView("recomTop/reTop10");
			m2.addObject("divide2", divide2);
			m2.addObject("food", food);
			m2.addObject("Date", Date);
			m2.addObject("listcount",listcount);
			m2.addObject("hit", hit);
			m2.addObject("hit",hit);
			m2.addObject("ment",ment);	
			return m2;
			}
		}
		else if(res==3) {
			String divide="%용산구%";
			String divide2="용산";
			String ment="다양한 먹거리는 용산에서";
			int listcount=foodservice.foodAreaCount(divide);
			int hit=foodservice.foodArea_Hit(divide); // 총 조회수
			
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setAddr(divide);
				List<FoodVO> like_list=foodservice.getAddrCont2(food);				
				ModelAndView m=new ModelAndView("recomTop/reTop10");
				m.addObject("divide2", divide2);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);
				m.addObject("listcount",listcount);
				m.addObject("hit", hit);
				m.addObject("ment",ment);		
				return m;
			} else {
							
			List<FoodVO> food=foodservice.getAddrCont(divide);
			ModelAndView m3=new ModelAndView("recomTop/reTop10");
			m3.addObject("divide2", divide2);
			m3.addObject("food", food);
			m3.addObject("Date", Date);
			m3.addObject("listcount",listcount);
			m3.addObject("hit",hit);
			m3.addObject("ment",ment);	
			return m3;
			}
		}
		else if(res==4) {
			String divide="%춘천시%";
			String divide2="춘천";
			String ment="춘천을 가면 여긴 꼭 가야지";
			int listcount=foodservice.foodAreaCount(divide);
			int hit=foodservice.foodArea_Hit(divide); // 총 조회수
			
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setAddr(divide);
				List<FoodVO> like_list=foodservice.getAddrCont2(food);				
				ModelAndView m=new ModelAndView("recomTop/reTop10");
				m.addObject("divide2", divide2);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);
				m.addObject("listcount",listcount);
				m.addObject("hit", hit);
				m.addObject("ment",ment);		
				return m;
			}else {
			List<FoodVO> food=foodservice.getAddrCont(divide);
			ModelAndView m4=new ModelAndView("recomTop/reTop10");
			m4.addObject("divide2", divide2);
			m4.addObject("food", food);
			m4.addObject("Date", Date);
			m4.addObject("listcount",listcount);
			m4.addObject("hit",hit);
			m4.addObject("ment",ment);	
			return m4;
			}
		}
		else if(res==5) {
			String divide="%대구광역시%";			
			String divide2="대구";
			String ment="맛집하면 대구! 대구하면 맛집!";
			int listcount=foodservice.foodAreaCount(divide);
			int hit=foodservice.foodArea_Hit(divide); // 총 조회수
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setAddr(divide);
				List<FoodVO> like_list=foodservice.getAddrCont2(food);				
				ModelAndView m=new ModelAndView("recomTop/reTop10");
				m.addObject("divide2", divide2);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);
				m.addObject("listcount",listcount);
				m.addObject("hit", hit);
				m.addObject("ment",ment);		
				return m;
			}else {
							
			List<FoodVO> food=foodservice.getAddrCont(divide);
			ModelAndView m5=new ModelAndView("recomTop/reTop10");
			m5.addObject("divide2", divide2);
			m5.addObject("food", food);
			m5.addObject("Date", Date);
			m5.addObject("listcount",listcount);
			m5.addObject("hit",hit);	
			m5.addObject("ment",ment);	
			return m5;
			}
		}
		else if(res==6) {
			String divide="%부산광역시%";
			String divide2="부산";
			String ment="이곳이 부산 맛집이라 안카나";
			int listcount=foodservice.foodAreaCount(divide);
			int hit=foodservice.foodArea_Hit(divide); // 총 조회수
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setAddr(divide);
				List<FoodVO> like_list=foodservice.getAddrCont2(food);				
				ModelAndView m=new ModelAndView("recomTop/reTop10");
				m.addObject("divide2", divide2);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);
				m.addObject("listcount",listcount);
				m.addObject("hit", hit);
				m.addObject("ment",ment);		
				return m;
			}else {			
			
			List<FoodVO> food=foodservice.getAddrCont(divide);
			ModelAndView m6=new ModelAndView("recomTop/reTop10");
			m6.addObject("divide2", divide2);
			m6.addObject("food", food);
			m6.addObject("Date", Date);
			m6.addObject("listcount",listcount);
			m6.addObject("hit", hit);
			m6.addObject("ment",ment);	
			return m6;
			}
		}
				
		return null;			
	}
	
	@RequestMapping(value="/reTop15")
	public ModelAndView reTop15(HttpServletRequest request,HttpSession session) {
		Date nowTime = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String Date=dt.format(nowTime);		
		
		int cond=Integer.parseInt(request.getParameter("cond"));
		String Sid=(String)session.getAttribute("Sid");
		
		
		if(cond==1) {
			String eat="한식";
			String ment="가족과 함께 따뜻한 식사를";
			int count=30;
			int hit=foodservice.getContHit(eat);
			if(Sid!=null) {
				
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setBsnscond(eat);
	
				List<FoodVO>like_list=foodservice.getCondList2(food);
				
				ModelAndView m=new ModelAndView("recomTop/reTop15");
				m.addObject("eat", eat);
				m.addObject("Date", Date);
				m.addObject("like_list", like_list);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				m.addObject("count", count);
				return m;
			}else {		
			List<FoodVO>food=foodservice.getCondList(eat);			
			ModelAndView m=new ModelAndView("recomTop/reTop15");
			m.addObject("eat", eat);
			m.addObject("Date", Date);
			m.addObject("food", food);		
			m.addObject("ment", ment);
			m.addObject("hit", hit);
			m.addObject("count", count);
			return m;
			}
		}
		else if(cond==2) {
			String eat="중식";
			String ment="오늘 짜장면 어때?";
			
			int count=foodservice.getCont_Count(eat);
			int hit=foodservice.getContHit(eat);
		    if(Sid!=null) {
				
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setBsnscond(eat);
	
				List<FoodVO>like_list=foodservice.getCondList2(food);
				
				ModelAndView m=new ModelAndView("recomTop/reTop15");
				m.addObject("eat", eat);
				m.addObject("Date", Date);
				m.addObject("like_list", like_list);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				m.addObject("count", count);
				return m;
			}		
			
		    else {
		    	List<FoodVO>food=foodservice.getCondList(eat);
		    
			
			ModelAndView m=new ModelAndView("recomTop/reTop15");
			m.addObject("eat", eat);
			m.addObject("Date", Date);
			m.addObject("food", food);		
			m.addObject("ment", ment);
			m.addObject("hit", hit);
			m.addObject("count", count);
			return m;
		    }
		}	else if(cond==3) {
			String eat="일식";
			String ment="회를 정말 좋아한다면?";
			
			int count=foodservice.getCont_Count(eat);
			int hit=foodservice.getContHit(eat);
			
		    if(Sid!=null) {
				
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setBsnscond(eat);
	
				List<FoodVO>like_list=foodservice.getCondList2(food);
				
				ModelAndView m=new ModelAndView("recomTop/reTop15");
				m.addObject("eat", eat);
				m.addObject("Date", Date);
				m.addObject("like_list", like_list);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				m.addObject("count", count);
				return m;
			}else {				
			
			List<FoodVO>food=foodservice.getCondList(eat);
			
			ModelAndView m=new ModelAndView("recomTop/reTop15");
			m.addObject("eat", eat);
			m.addObject("Date", Date);
			m.addObject("food", food);		
			m.addObject("ment", ment);
			m.addObject("hit", hit);
			m.addObject("count", count);
			return m;
			}
		}	else if(cond==4) {
			String eat="양식";
			String ment="용산 가면 뭐 먹지?";
			
			int count=foodservice.getCont_Count(eat);
			int hit=foodservice.getContHit(eat);
		    if(Sid!=null) {
				
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setBsnscond(eat);
	
				List<FoodVO>like_list=foodservice.getCondList2(food);
				
				ModelAndView m=new ModelAndView("recomTop/reTop15");
				m.addObject("eat", eat);
				m.addObject("Date", Date);
				m.addObject("like_list", like_list);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				m.addObject("count", count);
				return m;
			}else {				
			
			List<FoodVO>food=foodservice.getCondList(eat);
			
			ModelAndView m=new ModelAndView("recomTop/reTop15");
			m.addObject("eat", eat);
			m.addObject("Date", Date);
			m.addObject("food", food);		
			m.addObject("ment", ment);
			m.addObject("hit", hit);
			m.addObject("count", count);
			return m;
			}
		}else if(cond==5) {
			String eat="외국 음식";
			String eat2="%외국%";
			String ment="여기에 이런 맛집이?";
			
			int count=foodservice.getCont_Count(eat2);
			int hit=foodservice.getContHit(eat2);
			
		    if(Sid!=null) {
				
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setBsnscond(eat2);
	
				List<FoodVO>like_list=foodservice.getCondList2(food);
				
				ModelAndView m=new ModelAndView("recomTop/reTop15");
				m.addObject("eat", eat);
				m.addObject("Date", Date);
				m.addObject("like_list", like_list);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				m.addObject("count", count);
				return m;
			}else {
							
			List<FoodVO>food=foodservice.getCondList(eat2);
			
			ModelAndView m=new ModelAndView("recomTop/reTop15");
			m.addObject("eat", eat);
			m.addObject("Date", Date);
			m.addObject("food", food);		
			m.addObject("ment", ment);
			m.addObject("hit", hit);
			m.addObject("count", count);
			return m;
			}
		}	else if(cond==6) {
			String eat="디저트";

			String eat2="%디저트%";
			String ment="디저트가 땡긴다면? 요기어때?";
			
			int count=foodservice.getCont_Count(eat2);
			int hit=foodservice.getContHit(eat2);
		    
			if(Sid!=null) {
				
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setBsnscond(eat2);
	
				List<FoodVO>like_list=foodservice.getCondList2(food);
				
				ModelAndView m=new ModelAndView("recomTop/reTop15");
				m.addObject("eat", eat);
				m.addObject("Date", Date);
				m.addObject("like_list", like_list);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				m.addObject("count", count);
				return m;
			}
			else {				
			
			List<FoodVO>food=foodservice.getCondList(eat2);
			
			ModelAndView m=new ModelAndView("recomTop/reTop15");
			m.addObject("eat", eat);
			m.addObject("Date", Date);
			m.addObject("food", food);		
			m.addObject("ment", ment);
			m.addObject("hit", hit);
			m.addObject("count", count);
			return m;
			}
		}
		
		
		return null;
	}
		

	
	// 메뉴별 맛집 리스트
	@RequestMapping(value="/reTop30")
	public ModelAndView reTop30(HttpServletRequest request,HttpSession session) {
		Date nowTime = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String Date=dt.format(nowTime);		
		
		int menu=Integer.parseInt(request.getParameter("menu"));
		String Sid=(String)session.getAttribute("Sid");
		
		if(menu==1) {
			String eat="국수 인기";
			String eat2="%국수%";
			String ment="국수가 땡기는 날엔~";
			
			int hit=foodservice.getTotal_MenuContHit(eat2);
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setCategory(eat2);
				
				List<FoodVO>like_list=foodservice.getMenuList2(food);

				ModelAndView m=new ModelAndView("recomTop/reTop30");
				m.addObject("eat", eat);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				return m;
			}else {
				List<FoodVO>food=foodservice.getMenuList(eat2);
				ModelAndView m=new ModelAndView("recomTop/reTop30");
				m.addObject("eat", eat);
				m.addObject("eat2", eat2);
				m.addObject("food", food);
				m.addObject("Date", Date);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				return m;
			}
			
		}
			else if(menu==2) {
				String eat="스시 인기";
				String eat2="%회%";
				String ment="스시 먹으려면  여기를 가야지";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
				
			}else if(menu==3) {
				String eat="돼지고기 인기";
				String eat2="%돼지%";
				String ment="한국인의 소울푸드는 돼지고기가 아닐까?";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
				
			}else if(menu==4) {
				String eat="소고기 인기";
				String eat2="%소고기%";
				String ment="소고기가 입에 들어가면 정말 행복해!";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
				
			}else if(menu==5) {
				String eat="스테이크 인기";
				String eat2="%스테이크%";
				String ment="스테이크 썰어서 먹어볼까?";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
				
			}else if(menu==5) {
				String eat="스테이크 인기";
				String eat2="%스테이크%";
				String ment="스테이크 썰어서 먹어볼까?";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
								
			}
			else if(menu==6) {
				String eat="정식 인기";
				String eat2="%정식%";
				String ment="2022 정식 맛집이 궁금하다면 주목!";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop30");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}
		
			return null;
	}
	
	
	@GetMapping("/Food_list")
	public ModelAndView search(FoodVO food,HttpSession session) {		
		String Sid=(String)session.getAttribute("Sid");
		
		if(Sid!=null) {
			ModelAndView m=new ModelAndView();
			int listcount=foodservice.getTotalCount(food);
			List<FoodVO> like_list=foodservice.getLike_state(Sid);			
			
			m.addObject("like_list", like_list);		
			m.addObject("listcount", listcount);
			m.setViewName("/recomTop/Food_list");
			return m;
		}else {
		
		ModelAndView m=new ModelAndView();
		int listcount=foodservice.getTotalCount(food);		
		List<FoodVO> flist=foodservice.getBoardList(food);
					
		m.addObject("flist", flist);
		
		m.addObject("listcount", listcount);
		m.setViewName("/recomTop/Food_list");
				
		return m;
		
		}
	}
	
	
	// 리스트 더보기 했을때 메뉴별 맛집 리스트
	@RequestMapping(value="/reTop20")
	public ModelAndView reTop20(HttpSession session,HttpServletRequest request)throws Exception {
		Date nowTime = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String Date=dt.format(nowTime);		
		
		int menu=Integer.parseInt(request.getParameter("menu"));
		String Sid=(String)session.getAttribute("Sid");
		
		
		if(menu==1) {
			String eat="국수 인기";
			String eat2="%국수%";
			String ment="국수가 땡기는 날엔~";
			
			int hit=foodservice.getTotal_MenuContHit(eat2);
			if(Sid!=null) {
				FoodVO food=new FoodVO();
				food.setMem_id(Sid);
				food.setCategory(eat2);
				
				List<FoodVO>like_list=foodservice.getMenuList2(food);

				ModelAndView m=new ModelAndView("recomTop/reTop20");
				m.addObject("eat", eat);
				m.addObject("like_list", like_list);
				m.addObject("Date", Date);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				return m;
			}else {
				List<FoodVO>food=foodservice.getMenuList(eat2);
				ModelAndView m=new ModelAndView("recomTop/reTop20");
				m.addObject("eat", eat);
				m.addObject("eat2", eat2);
				m.addObject("food", food);
				m.addObject("Date", Date);		
				m.addObject("ment", ment);
				m.addObject("hit", hit);
				return m;
			}
		}
			else if(menu==2) {
				String eat="스시 인기";
				String eat2="%회%";
				String ment=" 스시 먹으려면  여기를 가야지 ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==3) {
				String eat="돼지고기 인기";
				String eat2="%돼지%";
				String ment=" 한국인의 소울푸드는 돼지고기가 아닐까?  ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==4) {
				String eat="소고기 인기";
				String eat2="%소%";
				String ment=" 소고기가 입에 들어가면 정말 행복해 ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==5) {
				String eat="스테이크 인기";
				String eat2="%스테이크%";
				String ment=" 스테이크 썰어서 먹어볼까? ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==6) {
				String eat="닭요리  인기";
				String eat2="%닭%";
				String ment=" 치킨말고 오늘은 이 닭 어때...? ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==7) {
				String eat="정식  인기";
				String eat2="%정식%";
				String ment=" 2022 정식 맛집이 궁금하다면 주목! ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==8) {
				String eat="햄버거  인기";
				String eat2="%햄버거%";
				String ment=" 출출할땐 햄버어억 ~~~ ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==9) {
				String eat="양고기  인기";
				String eat2="%양고기%";
				String ment=" 맥주가 떙길땐? 양고기지~ ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}
			else if(menu==10) {
				String eat="보쌈  인기";
				String eat2="%보쌈%";
				String ment=" 오늘은 어떤 고기를 싸먹어볼까? ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}
			else if(menu==11) {
				String eat="짜장면  인기";
				String eat2="%짜장면%";
				String ment=" 오늘은 내가 중국집 요리사~  ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}else if(menu==12) {
				String eat="낙지  인기";
				String eat2="%낙지%";
				String ment=" 쫄깃쫄깃하고 싱싱한 낙지맛 ";
				
				int hit=foodservice.getTotal_MenuContHit(eat2);
				if(Sid!=null) {
					FoodVO food=new FoodVO();
					food.setMem_id(Sid);
					food.setCategory(eat2);
					
					List<FoodVO>like_list=foodservice.getMenuList2(food);

					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("like_list", like_list);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}else {
					List<FoodVO>food=foodservice.getMenuList(eat2);
					ModelAndView m=new ModelAndView("recomTop/reTop20");
					m.addObject("eat", eat);
					m.addObject("eat2", eat2);
					m.addObject("food", food);
					m.addObject("Date", Date);		
					m.addObject("ment", ment);
					m.addObject("hit", hit);
					return m;
				}
			}
		return null;
		
	}
	

}
