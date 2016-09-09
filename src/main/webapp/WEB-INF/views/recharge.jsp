<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recharge User Account</title>
</head>
<body>
<form action="/GiftKart/user/recharge" method="post">
Recharge User Account:
<br><br>
<div align="center">
Userid:
<input type="text" name="userId" value="101"><br>
Recharge Points:
<input type="text" name="account.balance" value="10"><br><br>

<input type="submit" value="submit">

</div>
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
</form>
</body>
</html>