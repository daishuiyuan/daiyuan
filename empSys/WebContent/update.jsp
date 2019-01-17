<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <form action="${pageContext.request.contextPath }/UpdateInfoServlet" method="post">
                      姓名:<input id="name" name="name" type="text" placeholder="${requestScope.name }"/>
         <br>             
                      密码:<input id="password" name="password" type="password" placeholder="${requestScope.password }"/>
         <br>
                      性别 :
      <c:if test="${requestScope.gender}==男">               
             男:<input id="m" name="gender" type="radio" value="男" check="checked"/>
             女:<input id="fm" name="gender" type="radio" value="女"/>  
        </c:if> 
        <c:if test="${requestScope.gender}==女">               
             男:<input id="m" name="gender" type="radio" value="男" />
             女:<input id="fm" name="gender" type="radio" value="女" check="checked"/>  
        </c:if>                 
         <br>             
                      年龄:<input id="age" name="age" type="text" placeholder="${requestScope.age }"/>
         <br>
                      入职日期:<input id="hiredate" name="hiredate" type="date" placeholder="${requestScope.date }"/>  
         <br>
                      薪资:<input id="salary" name="salary" type="text" placeholder="${requestScope.salary }"/>
         <br>
                     电话:<input id="phone" name="phone" type="text" placeholder="${requestScope.phone }"/>
         <br>
                     电子邮箱:<input id="email" name="email" type="text" placeholder="${requestScope.email }"/>
         <br>                                       
        <input type="submit" value="注册"/>                                                               
       </form>
</body>
</html>