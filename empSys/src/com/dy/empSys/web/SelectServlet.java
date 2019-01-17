package com.dy.empSys.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectServlet")
@SuppressWarnings("serial")
public class SelectServlet extends HttpServlet{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//获取上下文
    	ServletContext context = req.getServletContext();
    	//获取全局参数
    	String encoding = context.getInitParameter("encoding");
    	
    	//设置请求和响应编码
    	req.setCharacterEncoding(encoding);
    	resp.setContentType("text/html;charset="+encoding);
    	
    	String id = req.getParameter("id");
    	String name = req.getParameter("name");
    	
    	
    	
    }
       
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }
}
