<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table align="center" border="1" cellpadding="2" cellspacing="2" style="border-collapse: collapse; width: 1400px;">    
<tbody>
<tr>
        <td colspan="2" height="30">
     <tiles:insertAttribute name="header" /></td>
</tr>
<tr>
        <td height="700" valign="top" width="250">
	<tiles:insertAttribute name="navigation" /></td>
        <td valign="top" width="2000">
	<tiles:insertAttribute name="body" /></td>
</tr>
<tr>
        <td colspan="2" height="30">
	<tiles:insertAttribute name="footer" /></td>
 </tr>
</tbody>
</table>
</body>
</html>
