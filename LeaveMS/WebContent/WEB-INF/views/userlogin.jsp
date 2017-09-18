<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="/js/userlogin.js" />"></script>
<script src="<c:url value="/js/main.css" />"></script>
<title>Login page</title>
</head>
<body>
<h3>Leave Management System</h3>
<br><br>
<form action="/LeaveMS/userlogin" method="post" >
<br>
<br>
<p align="center">
User name:  
<input type="text" name="userId" value="101"><br>
Password:
<input type="password" name="password" value="vaidya"><br>
<input type="submit" value="login" >
<br><br>
<a href="/LeaveMS/adminlogin">Admin Login</a>
<br><br>
<a href="/LeaveMS/register">Register User</a>
</p>
 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>

</body>
</html>