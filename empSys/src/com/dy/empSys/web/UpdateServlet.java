package com.dy.empSys.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		
		req.setCharacterEncoding(encoding);
		resp.setContentType("text/html;charset="+encoding);
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String h= req.getParameter("hiredate");
	    Date hiredate = Date.valueOf(h);
		String s= req.getParameter("salary");
		double salary = Double.parseDouble(s);
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		req.setAttribute("name", name);
		req.setAttribute("password", password);
		req.setAttribute("gender", gender);
		req.setAttribute("age", age);
		req.setAttribute("hiredate", hiredate);
		req.setAttribute("salary", salary);
		req.setAttribute("phone", phone);
		req.setAttribute("email", email);
		
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
       
}
