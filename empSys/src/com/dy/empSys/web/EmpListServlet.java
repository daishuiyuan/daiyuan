package com.dy.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.empSys.Service.IempSysService;
import com.dy.empSys.Service.imple.EmpSysService;
import com.dy.empSys.bean.Emp;

@WebServlet("/EmpListServlet")
@SuppressWarnings("serial")
public class EmpListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取全局参数配置
				ServletContext context = req.getServletContext();
				String encoding = context.getInitParameter("encoding");

				// 设置请求编码格式
				req.setCharacterEncoding(encoding);
				// 设置响应格式
				resp.setContentType("text/html;charset=" + encoding);
				
				//通过service获取所有员工信息
				IempSysService service=new EmpSysService();
				List<Emp> emps = service.findAll();
				
				//把所有员工信息存入到请求域中
				req.setAttribute("emps", emps);
				
				//请求转发
			    req.getRequestDispatcher("/empList.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
