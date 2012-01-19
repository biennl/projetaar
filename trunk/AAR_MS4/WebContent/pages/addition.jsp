<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.DAOCalcul"%>
    <%@ page import="domain.Calcul"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% String str = request.getParameter("id");
List<Calcul> list = new ArrayList<Calcul>();
if(str !=null && !str.isEmpty()){
int id= Integer.parseInt(str);
DAOCalcul dao = new DAOCalcul();
list = dao.getCalculById(id,request.getSession().getId());}

%>
<html>
<head>
<title>c:url CoreJstl Tag</title>
</head>
<body>
<font size="4" color="green">Enter a number please!</font>
<form action="Sum" method="post">
<table>
	<tr>
		<td>Enter id:</td>
		<td><input type="text" name="name" /></td>
	</tr>
	</table>
<input type="submit" value="submit" /></form>


</body>
</html>