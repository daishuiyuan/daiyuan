<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="WEB-INF/css/css/bootstrap.css" />
		<style type="text/css">
			body{
				background:url(img/qiongmei2.jpg) no-repeat center top;
				background-size: 100%;
			}
			#d1{
			position: relative;	
	        margin-top: 10%;
	        margsin-left: 10%;
           } 
           #d2{
           	position: relative;
           	margin-left: 40%;
           }
		</style>
		<script type="text/javascript">
		 function changeImage(){
			 var vali=document.getElementById("validate");
			 vali.src="${pageContext.request.contextPath}/ValidateServlet?date="+new Date();
			 
		 }
		</script>
		
	</head>
	<body>
		<div id="d1" >
		<form action="${pageContext.request.contextPath }/LoginServlet" method="get" class="form-horizontal" role="form">
		<div class="form-group">
		<label for="name" class="col-sm-2 control-label">用户名:</label>
	         <div class="col-sm-5">
		      <input class="form-control" type="text"  name="name" placeholder="用户名" maxlength="20">
		      <span id="nameSpan"></span>
		     </div>
		</div>	
		<div class="form-group">
	    <label class="col-sm-2 control-label">密&emsp;码:</label>
	      <div class="col-sm-5">
		   <input class="form-control" type="password" name="password" maxlength="20"/>	
		   </div>
		   <br>
		    ${requestScope.error_msg }
		   <br>
		</div>
		<br>
		验证码：<input type="text" name="validate"/>
		<img id="validate" alt="验证码" src="${pageContext.request.contextPath }/ValidateServlet" onclik="changeImage()" style="cursor:pointer">
		<br>
		<font color="red">${requestScope.validate_error }</font>
		<br>
		<div id="d2">
		<input class="btn btn-default" type="button" value="注册" onclick=""/>
		&emsp;&emsp;
		<input class="btn btn-default" type="submit" value="登录" />
		</div>
		</form>
		</div>
	   
	</body>
</html>
