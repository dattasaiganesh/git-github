package com.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res){
		
		String name=req.getParameter("name");
		System.out.println("name is" +name);
		String pass=req.getParameter("pass");
		System.out.println("pass is" +pass);
		
		if(pass.equals("ganesh") )
		{
			String message = "Welcome" +name;
			return new ModelAndView("loginpage","message",message);
		}
		else{
		return new ModelAndView("errorpage", "message", "Errorlogin");
		}
		
	}
	

}
