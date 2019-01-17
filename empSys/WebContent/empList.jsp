<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    
   
</script>
</head>
<body>
   <table border="1" width="700" cellspacing="0">
		
		<thead>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>年龄</th>
				<th>入职日期</th>
				<th>薪资</th>
				<th>电话</th>
				<th>邮箱</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
	
		<c:forEach items="${requestScope.emps }" var="e">
			<tr>
				<td>${e.id }</td>
				<td>${e.name }</td>
				<td>${e.password }</td>
				<td>${e.gender }</td>
				<td>${e.age }</td>
				<td>${e.hiredate }</td>
				<td>${e.salary }</td>
				<td>${e.phone }</td>
				<td>${e.email }</td>
				<td><a href="${pageContext.request.contextPath }/UpdateServlet?id=${e.id }&name=${e.name}&password=${e.password }&gender=${e.gender }
				&age=${e.age }&hiredate=${e.hiredate }&salary=${e.salary }&phone=${e.phone }&email=${e.email } ">修改</a></td>
				
				<td><a href="${pageContext.request.contextPath }/DeleteServlet?id=${e.id }">删除</a></td>
			</tr>
		</c:forEach>
	
	</table>


</body>
</html>