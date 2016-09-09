<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>
</head>
<body>
<form action="/GiftKart/register" method="post">
<table>
<tr>
<td>User ID: </td>
<td><input type="text" name="userId" size="20" value=101></td>
</tr>
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
<td>House No: </td>
<td><input type="text" name="address.houseNumber" size="20" value="102"></td>
</tr>
<tr>
<td>Street Name: </td>
<td><input type="text" name="address.streetname" size="20" value="puppalaguda"></td>
</tr>
<tr>
<td>City: </td>
<td><input type="text" name="address.city" size="20" value="Hyderbad"></td>
</tr>
<tr>
<td>State: </td>
<td><input type="text" name="address.state" size="20" value="Telangana"></td>
</tr>
<tr>
<td>Pincode: </td>
<td><input type="text" name="address.pincode" size="20" value="560019"></td>
</tr>
<tr>
<td><input type="submit" value="Register">
</tr>
</table>

</form>
</body>
</html>