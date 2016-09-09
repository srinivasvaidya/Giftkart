<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login page</title>
</head>
<body>
Admin Login Page
<br><br>
<form name="loginForm" action="<c:url value='login'/>" method='POST'>
User ID:  
<input type="text" name="username" value="110"><br>
Password:
<input type="password" name="password" value="admin"><br>
<input type="submit" value="login" >

  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
<br><br>
</form>
</body>
</html>