package com.dy.empSys.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidateServlet")
@SuppressWarnings("serial")
public class ValidateServlet extends HttpServlet{ 
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	ServletContext context = req.getServletContext();
    	String encoding = context.getInitParameter("encoding");
    	
    	req.setCharacterEncoding(encoding);
    	resp.setContentType("text/html;charset="+encoding);
    	
    	String str="ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnopqrstuvwxyz23456789";
    	
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<4;i++) {
    		sb.append(str.charAt(getRandoms(str.length())));
    	}
    	req.getSession().setAttribute("validate",sb.toString());
    	
    	//设置宽高
    	int width=100;
    	int height=60;
    	int rgb = BufferedImage.TYPE_INT_RGB;
    	//创建图片
    	BufferedImage image=new BufferedImage(width, height, rgb);
    	
    	Graphics g = image.getGraphics();
    	
    	g.setFont(new Font("楷体", Font.BOLD, 25));
    	
    	for(int i=0;i<5;i++) {
    		g.setColor(new Color(getRandoms(256), getRandoms(256), getRandoms(256)));
    		
    		g.drawLine(getRandoms(100), getRandoms(60), getRandoms(50)+50, getRandoms(20)+30);
    	}
    	
    	g.drawString(sb.toString(), getRandoms(20), getRandoms(20)+20);
    	//通知响应头以图片的方式解释
    	resp.setContentType("image/jepg");
    	//设置响应头控制浏览器不要缓存
    	resp.setDateHeader("exprise", -1);
    	resp.setHeader("Cache-Control", "no-cache");
    	resp.setHeader("Pragma", "nocache");
    	
    	ImageIO.write(image, "jpg", resp.getOutputStream());
    }
       
       
	private int getRandoms(int r) {
        return new Random().nextInt(r);
    }
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doGet(req, resp);
    }
       
}
