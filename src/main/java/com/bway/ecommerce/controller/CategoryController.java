package com.bway.ecommerce.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.ecommerce.model.Category;
import com.bway.ecommerce.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	@GetMapping("/add")
	public String getCategory(HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		} 
		return "categoryadd";
	}
	@PostMapping("/add")
	public String postCategory(HttpSession session ,@ModelAttribute Category cat) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		} 
		catService.addCategory(cat);
		return "categoryadd";
	}
	@GetMapping("/list")
	public String catList(Model model, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		} 
		model.addAttribute("catList", catService.getAllCats());
		return "categorylist";
	}
	
	@GetMapping("/edit")
	public String edit(HttpSession session,@RequestParam long id, Model model){
		if(session.getAttribute("validuser") == null) {
			return "login";
		} 
		model.addAttribute("catObject", catService.getCatById(id));
		return "categoryedit";
	}
	@GetMapping("/delete")
	public String delete(HttpSession session, @RequestParam long id) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		} 
		catService.deleteCat(id);
		return "redirect:/category/list";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Category cat, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		catService.updateCat(cat);
		 return "redirect:/category/list";
	}
	
	
}
