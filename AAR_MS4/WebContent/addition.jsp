<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.DAOCalcul"%>
    <%@ page import="domain.Calcul"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%! 
public String listToString(List<Calcul> list) {

	String res = "";
	res = "&nbsp;&nbsp;&nbsp;";
	
	for (int i = 0; i < list.size(); i++) {
		res += list.get(i).getNum1();
		res += "<br> + "+list.get(i).getNum2();
		res += "<hr width = \"70\" noshade=\"noshade\" />";
		res+="<br> =";
		if(i+1 < list.size() - 1)
			res += "<br/>+ " + list.get(i+1).getNum1();
		else res += "<br/>+ " + (list.get(i).getNum1()+list.get(i).getNum2());
			
				
	}

	return res;
}%>
<%
String str = request.getParameter("id");
List<Calcul> list = new ArrayList<Calcul>();
if(str !=null && !str.isEmpty()){
int id= Integer.parseInt(str);
DAOCalcul dao = new DAOCalcul();
list = dao.getCalculById(id,request.getSession().getId());}
%>
<html>
<head>
<title>Infinite sum</title>
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

<hr/>

<b>Previous operation(s) :</b><br>
<%=listToString(list) %>

</body>


</html>
