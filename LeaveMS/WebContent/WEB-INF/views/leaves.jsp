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
<div align="center">Employee applied leaves</div>
<form action="/LeaveMS/approveempleaves" method="post">
<br><br>

<table border="1" cellpadding="10" align="center" bordercolor="blue">
<tr>
   <th>User ID</th>
   <th>From</th>
   <th>To</th>
   <th>Leave count</th>
   <th>leave type</th>
   <th></th>
 </tr>
<c:forEach var="leave" items="${leaveslist}">
<tr>
<td><c:out value="${leave.userId}"></c:out></td>
<td><c:out value="${leave.from}"></c:out></td>
<td><c:out value="${leave.to}"></c:out></td>
<td><c:out value="${leave.leavecount}"></c:out></td>
<td><c:out value="${leave.leavetype}"></c:out></td>
<td><input type="checkbox" name="leaveId" id="${leave.leaveId}" value="${leave.leaveId}"></td>
</tr>
</c:forEach>
</table>
<br><br>
<div align="center"><input type="submit" value="approve" name="approve"></div>


</form>
</body>
</html>