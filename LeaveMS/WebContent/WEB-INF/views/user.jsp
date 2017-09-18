<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
</head>
<body>
<form action="/LeaveMS/approveuser" method="post">
Registered User Details are:
<br><br>

<table border="1" cellpadding="10" align="center" bordercolor="blue">
<tr>
   <th>User ID</th>
   <th>User Name</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Email</th>
   <th></th>
 </tr>
<c:forEach var="user" items="${userlist}">
<tr>
<td><c:out value="${user.userId}"></c:out></td>
<td><c:out value="${user.username}"></c:out></td>
<td><c:out value="${user.firstname}"></c:out></td>
<td><c:out value="${user.lastname}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><input type="checkbox" name="userId" id="${user.userId}" value="${user.userId}"></td>
</tr>
</c:forEach>
</table>
<br><br>
<div align="center"><input type="submit" value="approve" name="approve"></div>


</form>
</body>
</html>