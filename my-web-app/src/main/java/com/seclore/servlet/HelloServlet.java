package com.seclore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

public class HelloServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Init called.........");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sCtx=getServletContext();
		
		System.out.println("Do get called");
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Welcome to serlets</h1>");
		out.write("<h2>Aaj ki tarikh" + LocalDate.now() + "</h2>");
		out.write("<h2>info" + sCtx + "</h2>");
		out.write("</body></html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Destroy called......");
	}
}
