<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Page</title>
</head>
<body>
<form action="/GiftKart/products/add" method="post">
Add New Product
<br><br>
<%-- <c:set var="categoryList" value="${categoryList}" /> --%>
Product Name: 
<input type="text" name="prodname"><br>
Product price: 
<input type="text" name="price"><br>
Product colour: 
<input type="text" name="colour"><br>
Category: 
<select name="category.catagoryname" >
  <c:forEach items="${categoryList}" var="category">
    <option value="${category.catagoryname}">
        ${category.catagoryname}
    </option>
    <c:set var="category.categoryid" value="${category.categoryid}" />
  </c:forEach>
</select>
<br>
<input type="submit" value="submit">

<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
</form>

</body>
</html>