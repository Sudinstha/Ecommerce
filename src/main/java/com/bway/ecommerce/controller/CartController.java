package com.bway.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bway.ecommerce.global.GlobalData;
import com.bway.ecommerce.model.Product;
import com.bway.ecommerce.service.ProductService;

@Controller
public class CartController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable Long id) {
		
		GlobalData.cart.add(productService.getProductById(id));
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String cartGet(Model model, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);	
		return "cart";
	}
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	@GetMapping("/checkout")
	public String checkout(Model model, HttpSession session) {
		if(session.getAttribute("validuser") == null) {
			return "login";
		}  
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}
}
