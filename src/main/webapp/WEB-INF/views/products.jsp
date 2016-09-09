<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<form action="/GiftKart/kart" method="post">
Welcome page
<br><br>
Hello ${user.username}<br><br>

<c:if test="${sessionKartlist != null && sessionKartsize > 0}" >
Following Products are added to the kart:<br>
<c:forEach var="kartproduct" items="${sessionKartlist}">
<c:out value="${kartproduct}"></c:out><br>
</c:forEach> 
</c:if>
<br>

Products Available are:<br><br>
<table border="1" cellpadding="10">
<tr>
   <th>Product ID</th>
   <th>Product Name</th>
   <th>Category</th>
   <th>Price</th>
   <th>Colour</th>
   <th>Add to Kart</th>
</tr>
<c:forEach var="product" items="${productlist}">
<tr>
<td><c:out value="${product.productId}"></c:out></td>
<td><c:out value="${product.prodname}"></c:out></td>
<td><c:out value="${product.category.catagoryname}"></c:out></td>
<td><c:out value="${product.price}"></c:out></td>
<td><c:out value="${product.colour}"></c:out></td>
<td><input type="checkbox" name="productid" id="${product.productId}" value="${product.productId}"></td>
</tr>
</c:forEach>
</table>
<br><br>
<input type="submit" value="Add to kart" name="addtokart">
<input type="submit" value="Checkout" name="checkout">

 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>
</body>
</html>