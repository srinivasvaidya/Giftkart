<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<form action="/LeaveMS/applyleave" method="post">
<br><br>
Hello ${user.username}<br><br>

<a href="http://localhost:8080/LeaveMS/approveemployee">Approve Employees Registration</a>
<br>
<a href="http://localhost:8080/LeaveMS/approveempleaves">Approve Employees Leaves</a>

<div align="center" >
Apply leave:<br><br>
from: &nbsp; 
<input type="date" name="from" value=""><br>
to: &nbsp;
<input type="date" name="to" value=""><br>
leave type: &nbsp;
<select name="leavetype">
<option>paid leave</option>
<option>sick leave</option>
</select><br><br>
<input type="submit" value="apply leave">
</div>
</form>
</body>
</html>