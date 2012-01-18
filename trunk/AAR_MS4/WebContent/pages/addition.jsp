<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addition</title>
</head>
<body>

	
	<form action="Sum" method="post" onsubmit="return validateFormWelcome()">
	<table align="center" id="container">
	
	<% String label = "";
	String number = "";
	String numbers =(String)session.getAttribute("numbers"); 
	double res = (Double)session.getAttribute("resultat"); 
	if (numbers == null || numbers.isEmpty()){
		number = "A number please ? ";
	}else {label = "+ "; number = numbers + "<br/>___________<br/>&nbsp;= "+res;}
	%>

	<tr>
		<td></td><td><%=number %></td>
	</tr>
	<tr>
	<td><%=label %></td><td><input type="text" id="number" name="number"></td><td><label id="lbCheckLogin" style="color: red;"></label></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="Sum"></td>
	</tr>
	</table>  
	</form>

</body>
</html>