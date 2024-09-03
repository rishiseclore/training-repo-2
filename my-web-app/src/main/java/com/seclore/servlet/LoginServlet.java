package com.seclore.servlet;



import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seclore.services.DatabaseLoginService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String captcha=request.getParameter("captcha");
		
		HttpSession session=request.getSession();
		String originalcaptcha=(String) session.getAttribute("captcha");
		DatabaseLoginService loginService=new DatabaseLoginService();
		int isValid =loginService.isValidUser(uname,pwd);
		if( isValid==1) {
			if (captcha.equals(originalcaptcha)) {
				
				String remember=request.getParameter("remember");
				if("y".equals(remember)) {
					String data=uname+":"+pwd;
					String encodedData=Base64.getEncoder().encodeToString(data.getBytes());
					
					Cookie c1= new Cookie("logindata",encodedData);
					c1.setMaxAge(60*60);
					response.addCookie(c1);
					
				}
				response.sendRedirect("welcome.html");
			}
			else {
				response.sendRedirect("login.html?error=2");
			}
			

		}
		else if( isValid==2)   {
			response.sendRedirect("login.html?error=3");
		}
	}



}
