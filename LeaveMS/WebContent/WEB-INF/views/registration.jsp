<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
</head>
<body>

<form action="/LeaveMS/register" method="post">
<div align="center">User Registration Form:<br><br></div>
<table align="center" >
<tr>
<td>User Name: </td>
<td><input type="text" name="username" size="20" value="srinivas"></td>
</tr>
<tr>
<td>Password: </td>
<td><input type="password" name="password" size="20" value="vaidya"></td>
</tr>
<tr>
<td>First Name: </td>
<td><input type="text" name="firstname" size="20" value="srinivas"></td>
</tr>
<tr>
<td>Last Name: </td>
<td><input type="text" name="lastname" size="20" value="vaidya"></td>
</tr>
<tr>
<td>Email: </td>
<td><input type="text" name="email" size="20" value="srinivasvaidya999@gmail.com"></td>
</tr>
<tr>
<td>User Type: </td>
<td>
<select name="usertype">
<option>Employee</option>
<option>HR</option>
</select><br><br>
</td>
</tr>
<tr>
<td><input type="submit" value="Register">
</tr>
</table>

</form>
</body>
</html>