package net.webplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list/*")
public class ListController {

	
	@RequestMapping(value="menu_list")
	public void menu_list() {
		
	}

	
	@RequestMapping(value="top_list")
	public void top_list() {
		
	}
	
}
