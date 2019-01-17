<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <form action="${pageContext.request.contextPath }/AddServlet" method="get">
                      姓名:<input id="name" name="name" type="text"/>
         <br>             
                      密码:<input id="password" name="password" type="password"/>
         <br>
                      性别 :
             男:<input id="m" name="gender" type="radio" value="男"/>
             女:<input id="fm" name="gender" type="radio" value="女"/>         
         <br>             
                      年龄:<input id="age" name="age" type="text"/>
         <br>
                      入职日期:<input id="hiredate" name="hiredate" type="date"/>  
         <br>
                      薪资:<input id="salary" name="salary" type="text"/>
         <br>
                     电话:<input id="phone" name="phone" type="text"/>
         <br>
                     电子邮箱:<input id="email" name="email" type="text"/>
         <br>                                       
        <input type="submit" value="注册"/>                                                               
       </form>
</body>
</html>