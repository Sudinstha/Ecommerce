package com.bway.ecommerce.controller;



import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String getIndex(Model model) {
		String[] imagesNames = new File("src/main/resource/static/images/banner").list();
		model.addAttribute("imgNameList",imagesNames);
		return "index";
	}
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin";
	}
}
