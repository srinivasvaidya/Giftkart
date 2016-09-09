<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<div id='tab1' class="tab_content" style="display: block; width: 100%">
            <h3>Display tag Pagination and Sorting Example</h3>
            <p>This is FIRST TABLE </p>
            <display:table name="orderList" pagesize="2"
                           export="true" sort="list" uid="one">
                <display:column property="orderId" title="orderId"
                                sortable="true" headerClass="sortable" />
                <display:column property="orderStatus" title="orderStatus"
                                sortable="true" headerClass="sortable" />
            </display:table>
  		</div>

Orders placed are:<br><br>
<table border="1" cellpadding="10">
<tr>
   <th>Order ID</th>
   <th>order starus</th>
   <th>Product Order Id</th>
   <th>product order starus</th>
   <th>product ID</th>
   <th>order Date</th>
</tr>
<c:forEach var="order" items="${orderList}">
<c:forEach var="prodorder" items="${order.productOrders}">
<tr>
<td><c:out value="${order.orderId}"></c:out></td>
<td><c:out value="${order.orderStatus}"></c:out></td>
<td><c:out value="${prodorder.productorderId}"></c:out></td>
<td><c:out value="${prodorder.prodorderStatus}"></c:out></td>
<td><c:out value="${prodorder.productid}"></c:out></td>
<td><c:out value="${prodorder.orderDate}"></c:out></td>
</tr>
</c:forEach>
</c:forEach>
</table>

</body>
</html>