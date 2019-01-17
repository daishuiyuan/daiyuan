<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>嘻嘻嘻管理系统</h1>
     <br>
    <c:if test="${sessonScope.emp==null }">
	<a href="/empSys/register.jsp">注册</a>
	<a href="/empSys/login.jsp">登录</a>
	</c:if>
	
	<c:if test="${sessionScope.emp!=null }">
	<a href="${pageContext.request.contextPath }/EmpListServlet">员工列表</a>
	<a href="${pageContext.request.contextPath }/LogoutServlet">安全退出</a>
	<a href="${pageContext.request.contextPath }/Select.jsp">查询员工</a>
	<div>上次登陆时间:${requestScope.lastTime }</div>
	</c:if>
</body>
</html>