package net.webplate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.webplate.service.FoodService;
import net.webplate.service.LikeService;
import net.webplate.service.MemberService;
import net.webplate.vo.FoodVO;
import net.webplate.vo.LikeVO;

@Controller
public class LikeController {
	
	@Autowired
	private LikeService likeService;

	
	
	  @ResponseBody
	  @RequestMapping(value="/like", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
		public String like(int boardno, HttpSession session ,HttpServletRequest request,HttpServletResponse response ){
		boardno=Integer.parseInt(request.getParameter("boardno"));
	    
		JSONObject obj = new JSONObject();
	    String mno=(String)session.getAttribute("Sid");
	    
	    System.out.println(boardno); 
	    System.out.println(mno); 
	    
	    ArrayList<String> msgs = new ArrayList<String>();
	    HashMap <String, Object> hashMap = new HashMap<String, Object>();
	    hashMap.put("boardno", boardno);
	    hashMap.put("mno", mno);
	    
	    if(likeService.firstcheck(hashMap)==0) {
	    	likeService.create(hashMap);
	    }
	    
	    LikeVO likeVO = likeService.read(hashMap);
	    
	    
	    
	    int like_state = 0;
	    like_state = likeVO.getLike_state();
	   
	    
	    if(like_state == 0) {
	    	msgs.add("좋아요");
	    	likeService.like_check(hashMap);
	    	like_state++;
	    } else {
	    	msgs.add("좋아요 취소");
	    	likeService.like_check_cancel(hashMap);
	    	like_state--;
	    }
	    
	    obj.put("boardno", boardno);
	    obj.put("like_check", like_state);
	    obj.put("msg", msgs);


	    return obj.toJSONString();
	  }

	
	
}