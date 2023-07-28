package com.bway.ecommerce.controller;



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
	public String getCategory() {
		return "categoryadd";
	}
	@PostMapping("/add")
	public String postCategory(@ModelAttribute Category cat) {
		catService.addCategory(cat);
		return "categoryadd";
	}
	@GetMapping("/list")
	public String catList(Model model) {
		model.addAttribute("catList", catService.getAllCats());
		return "categorylist";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam long id, Model model){
		model.addAttribute("catObject", catService.getCatById(id));
		return "categoryedit";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		catService.deleteCat(id);
		return "redirect:/category/list";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Category cat) {
		 catService.updateCat(cat);
		 return "redirect:/category/list";
	}
	
	@GetMapping("/table")
	public String getTable() {
		return "tables";
	}
}
