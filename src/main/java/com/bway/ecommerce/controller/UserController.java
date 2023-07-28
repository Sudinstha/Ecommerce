package com.bway.ecommerce.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bway.ecommerce.model.User;
import com.bway.ecommerce.service.UserService;





@Controller
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model){
	
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = userService.login(user.getEmail(),user.getPassword());

		if(usr != null) {
			
			return "admin";
		}
		
		model.addAttribute("message","user not found");
		return "login";
		}
	
	
	@GetMapping("/register")
	public String getregister() {
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute User user, Model model){
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.register(user);

		
		return"login";
		}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "login";
	}
	
	
}
