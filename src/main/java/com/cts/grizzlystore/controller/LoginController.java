package com.cts.grizzlystore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.grizzlystore.bean.User;
import com.cts.grizzlystore.service.CategoryService;
import com.cts.grizzlystore.service.ProductService;
import com.cts.grizzlystore.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService loginService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="index.html", method=RequestMethod.GET)
	public String getLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="logout.html")
	public String getLogoutPage(HttpSession httpSession){
		httpSession.removeAttribute("user");
		httpSession.invalidate();
		return "index";
	}
	
	@RequestMapping(value="index.html", method=RequestMethod.POST)
	public ModelAndView validateUser(@ModelAttribute User login, HttpSession httpSession) 
	{
		ModelAndView modelAndView = new ModelAndView();
		User user = loginService.authenticateUser(login);
	if(user !=null)// checking if user is authentic 
	{
		if((loginService.getUserStatus(user))<3)//Checking if user is deactivated 
		{
			if(loginService.getUserType(user).equals("A")){
				user.setUserStatus(0);
				loginService.resetStatus(user);
				httpSession.setAttribute("user", user);
				httpSession.setAttribute("products", productService.getAllProducts());
				modelAndView.setViewName("adminListProduct");
				return modelAndView;
			}
			else
			{
				user.setUserStatus(0);
				loginService.resetStatus(user);
				System.out.println(user);
				httpSession.setAttribute("user", user);
				httpSession.setAttribute("products", productService.getAllProducts());
				modelAndView.setViewName("vendorListProduct");
				modelAndView.addObject("user", user);
				return modelAndView;
			}
		}
		else
		{
			
			modelAndView.setViewName("deactivatedAccount");
			return modelAndView;
		}
	
	}
	
	else
	{
		//increasing the number of attempts on invalid credentials 
		user = loginService.checkUser(login.getUserId());
		if(user !=null){
			user.setUserStatus(user.getUserStatus()+1);
			loginService.inceraseAttempt(user);
			}
		modelAndView.setViewName("index");	
		return modelAndView;
	}

	
	}
	
}
