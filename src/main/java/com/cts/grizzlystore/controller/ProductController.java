package com.cts.grizzlystore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlystore.bean.Category;
import com.cts.grizzlystore.bean.Product;
import com.cts.grizzlystore.service.CategoryService;
import com.cts.grizzlystore.service.ProductService;

@Controller
public class ProductController {
	 @Autowired
	  private ProductService productService; 
	 @Autowired
	 private CategoryService categoryService;

	 //fetching the category list before sending to addProductPage
	@RequestMapping(value="adminAddProduct.html", method=RequestMethod.GET)
	public String getProductPage(HttpSession httpSession)
	{
		List<Category> categoryList = categoryService.getCategory();
		httpSession.setAttribute("category", categoryList);
		return "adminAddProduct";
	}
	
	@RequestMapping(value="adminListProduct.html", method=RequestMethod.GET)
	public String getListPage(Model model, HttpSession httpSession)
	{
		// model.addAttribute("product", new Product());
		 httpSession.setAttribute("products", productService.getAllProducts());
		 return "adminListProduct";
	}
	
	
	@RequestMapping(value="adminAddProduct.html", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute Product product,HttpSession httpSession) 
	{
		ModelAndView modelAndView = new ModelAndView();
		if("success".equals(productService.addProduct(product)))
			{
			modelAndView.setViewName("adminListProduct");
			httpSession.setAttribute("products", productService.getAllProducts());
			}
		else
			modelAndView.setViewName("adminAddProduct");
		
	return modelAndView;
	}

	@RequestMapping(value="index.html")
	public String getIndexPage(){
		return "index";
	}
	
	@RequestMapping(value="sortByRating.html")
	public ModelAndView updateProduct(@RequestParam("order")String sorting , HttpSession httpSession) 
	{
		ModelAndView modelAndView = new ModelAndView();
		httpSession.setAttribute("products", productService.sortProductsByRating(sorting));
		
			modelAndView.setViewName("adminListProduct");
	
	return modelAndView;
	}
	
	@RequestMapping(value="adminDeleteProduct.html")
	public ModelAndView deleteProduct(@RequestParam("id")String id, HttpSession httpSession) 
	{
		ModelAndView modelAndView = new ModelAndView();
		
		if("success".equals(productService.deleteProduct(id)))
			{
			modelAndView.setViewName("adminListProduct");
			httpSession.setAttribute("products", productService.getAllProducts());
			}
			modelAndView.setViewName("adminListProduct");
		return modelAndView;
	}
	
	@RequestMapping(value="adminViewProduct.html")
	public ModelAndView getProductDetails(@RequestParam("id") String id) {
		Product product = productService.findProduct(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("adminViewProduct");
		return modelAndView;
	}
	
	@RequestMapping(value="showProductByCategory.html")
	public ModelAndView adminShowProductByCategory(@ModelAttribute Category category, HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		httpSession.setAttribute("products", productService.getProductByCategory(category.getName()));
		modelAndView.setViewName("adminListProduct");
		return modelAndView;
		
	}
	
	//vendor mapping
	@RequestMapping(value="vendorSortByRating.html")
	public ModelAndView getVendorSort(@RequestParam("order")String sorting,HttpSession httpSession){

		ModelAndView modelAndView = new ModelAndView();
		httpSession.setAttribute("products", productService.sortProductsByRating(sorting));
		
			modelAndView.setViewName("vendorListProduct");
	
			return modelAndView;
	}
	
	@RequestMapping(value="ProductByCategory.html")
	public ModelAndView vendorShowProductByCategory(@ModelAttribute Category category, HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		
		httpSession.setAttribute("products", productService.getProductByCategory(category.getName()));
		modelAndView.setViewName("vendorListProduct");
		return modelAndView;
		
	}
	
}
	