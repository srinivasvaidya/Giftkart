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
<form action="">
Registered User Details are:
<br><br>

<table border="1" cellpadding="10" align="center" bordercolor="blue">
<tr>
   <th>User ID</th>
   <th>User Name</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Email</th>
   <th>House Number</th>
   <th>Street Name</th>
   <th>City</th>
   <th>State</th>
   <th>Pin code</th>
   <th>Account Number</th>
   <th>Balance</th>
</tr>
<c:forEach var="user" items="${userList}">
<tr>
<td><c:out value="${user.userId}"></c:out></td>
<td><c:out value="${user.username}"></c:out></td>
<td><c:out value="${user.firstname}"></c:out></td>
<td><c:out value="${user.lastname}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.address.houseNumber}"></c:out></td>
<td><c:out value="${user.address.streetname}"></c:out></td>
<td><c:out value="${user.address.city}"></c:out></td>
<td><c:out value="${user.address.state}"></c:out></td>
<td><c:out value="${user.address.pincode}"></c:out></td>
<td><c:out value="${user.account.accountNumber}"></c:out></td>
<td><c:out value="${user.account.balance}"></c:out></td>
</tr>
</c:forEach>
</table>

</form>
</body>
</html>