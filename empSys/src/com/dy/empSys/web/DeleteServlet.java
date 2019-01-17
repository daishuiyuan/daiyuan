package com.dy.empSys.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dy.empSys.Service.IempSysService;
import com.dy.empSys.Service.imple.EmpSysService;

@WebServlet("/DeleteServlet")
@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet{
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	    // 获取全局参数配置
			ServletContext context = req.getServletContext();
			String encoding = context.getInitParameter("encoding");

			// 设置请求编码格式
			req.setCharacterEncoding(encoding);
			// 设置响应格式
			resp.setContentType("text/html;charset=" + encoding);
			
			String sid= req.getParameter("id");
			int id= Integer.parseInt(sid);
			
		    IempSysService service=new EmpSysService();
		    service.DeleteEmp(id);
	        
		    resp.sendRedirect(context.getContextPath()+"/empList.jsp");
    }
      
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }
}
