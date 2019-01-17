package com.dy.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dy.empSys.Service.IempSysService;
import com.dy.empSys.Service.imple.EmpSysService;
import com.dy.empSys.bean.Emp;

@WebServlet("/LoginServlet")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取上下文
	    ServletContext context = req.getServletContext();
	    //获取全局参数
	    String encoding = context.getInitParameter("encoding");
	    //设置请求编码格式
	    req.setCharacterEncoding(encoding);
	    //设置响应编码格式
	    resp.setContentType("text/html;charset="+encoding);
	    //获取请求参数
	    String name=req.getParameter("name");
	    String password=req.getParameter("password");
	  
	    //调用Service中的方法进行登录
	    IempSysService service=new EmpSysService();
	    Emp emp=service.findEmpByNameAndPassword(name, password);
	    
	    //获取请求中的验证码
	    String validate = req.getParameter("validate");
	    //获取session中的验证码
	    String validate_in_session=(String)req.getSession().getAttribute("validate");
	    if (!validate_in_session.equals(validate)) {
			req.setAttribute("validate_error", "验证码有误，请重新输入");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
			return;
		}
	    
	    
	    if (emp!=null) {
			//把登陆的用户存入到session中，表示开启一段会话
	    	HttpSession session = req.getSession();
	    	session.setAttribute("emp", emp);
	    	
	    	//格式化时间日期
	    	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	    	String lastTime=sdf.format(new Date());
	    	
	    	//获取请求中的cookie
	    	Cookie[] cookies = req.getCookies();
	    	if (cookies!=null) {
				for (Cookie cookie : cookies) {
					if ("lastTime".equals(cookie.getName())&&cookie.getValue()!=null) {
						req.getRequestDispatcher("/index.jsp").include(req, resp);
				        req.setAttribute("lastTime", cookie.getValue());
				        Cookie cookie2=new Cookie("lastTime", lastTime);
				        cookie2.setPath("/");
				        cookie2.setMaxAge(60*60*24*30);
						resp.addCookie(cookie2);
						return;
					}else {
						Cookie cookie3=new Cookie("lastTime", lastTime);
						cookie3.setPath("/");
				        cookie3.setMaxAge(60*60*24*30);
				        req.setAttribute("lastTime", lastTime);
				        resp.addCookie(cookie3);
						req.getRequestDispatcher("/index.jsp").forward(req, resp);
						return;
					}
				}
			}else {
				Cookie cookie4=new Cookie("lastTime", lastTime);
				cookie4.setPath("/");
				cookie4.setMaxAge(60*60*24*30);
				resp.addCookie(cookie4);
				req.setAttribute("lastTime", lastTime);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				return;
			}
	    	
	    	resp.getWriter().write("登录成功,3s后回到主页");
	    	
	    	resp.setHeader("refresh","3;URL="+context.getContextPath()+"/index.jsp");
	    	return ;
	    	
		}else {
			//请求转发，把错误信息发送到前端页面
			req.setAttribute("error_msg", "账号或密码有误,请检查后登录");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return ;
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
