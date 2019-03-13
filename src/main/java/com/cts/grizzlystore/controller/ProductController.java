package com.cts.grizzlystore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlystore.bean.Product;
import com.cts.grizzlystore.service.ProductService;

@Controller
public class ProductController {
	 @Autowired
	  private ProductService productService; 

	@RequestMapping(value="adminAddProduct.html", method=RequestMethod.GET)
	public String getProductPage()
	{
		return "adminAddProduct";
	}
	

	@RequestMapping(value="updateProduct.html", method=RequestMethod.GET)
	public String getUpdatePage()
	{
		return "updateProduct";
	}
	
	@RequestMapping(value="deleteProduct.html", method=RequestMethod.GET)
	public String getDeletePage()
	{
		return "deleteProduct";
	}
	
	@RequestMapping(value="adminListProduct.html", method=RequestMethod.GET)
	public String getListPage(Model model, HttpSession httpSession)
	{
		// model.addAttribute("product", new Product());
		 httpSession.setAttribute("products", productService.getAllProducts());
		 return "adminListProduct";
	}
	
	
	@RequestMapping(value="adminAddProduct.html", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product product) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if("success".equals(productService.addProduct(product)))
			modelAndView.setViewName("adminListProduct");
		else
			modelAndView.setViewName("adminAddProduct");
		
	return modelAndView;
	}
	
	@RequestMapping(value="updateProduct.html", method=RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute Product product) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if("success".equals(productService.updateProduct(product)))
			System.out.println("updated product");
			modelAndView.setViewName("admin");
	
	return modelAndView;
	}
	
	@RequestMapping(value="deleteProduct.html", method=RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute Product product) 
	{
		ModelAndView modelAndView = new ModelAndView();
		
			modelAndView.setViewName("admin");
		return modelAndView;
	}
	
	
}
	