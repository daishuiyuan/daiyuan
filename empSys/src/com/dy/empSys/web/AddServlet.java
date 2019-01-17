package com.dy.empSys.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.empSys.Service.IempSysService;
import com.dy.empSys.Service.imple.EmpSysService;
import com.dy.empSys.bean.Emp;

@WebServlet("/AddServlet")
@SuppressWarnings("serial")
public class AddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数配置
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");

		// 设置请求编码格式
		req.setCharacterEncoding(encoding);
		// 设置响应格式
		resp.setContentType("text/html;charset=" + encoding);
		
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
		
		Emp emp=new Emp();
		emp.setName(name);
		emp.setPassword(password);
		emp.setGender(gender);
		emp.setAge(age);
		emp.setHiredate(hiredate);
		emp.setSalary(salary);
		emp.setPhone(phone);
		emp.setEmail(email);
		
		IempSysService service=new EmpSysService();
		service.AddEmp(emp);
		
		resp.sendRedirect(context.getContextPath()+"/empList.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
