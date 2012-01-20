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
	res = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	if(list!=null && list.size()>0)
	res += list.get(0).getNum1();
	
	for (int i = 0; i < list.size(); i++) {
		res += "<br>+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+list.get(i).getNum2();
		res += "<hr width = \"60\" noshade=\"noshade\" align =\"left\" />";
		res+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		if(i+1 < list.size() - 1)
			res += list.get(i+1).getNum1();
		else res += (list.get(i).getNum1()+list.get(i).getNum2());				
	}

	return res;
}%>
<%
String str = request.getParameter("id");
List<Calcul> list = new ArrayList<Calcul>();
if(str !=null && !str.isEmpty()){
	int id= Integer.parseInt(str);
	DAOCalcul dao = new DAOCalcul();
	list = dao.getCalculById(id);
}%>
<html>
<head>
<script type="text/javascript" src="jquery-1.4.1.js"></script>
<script type="text/javascript">
function isNumeric(){
    var RE = /^-{0,1}\d*\.{0,1}\d+$/;
    if(!RE.test($("#number").val())){
    	$("#lbNumber").text("Only number!!");
    	return false;
    }
    return true;
}
	
function clonePage(){
	var newWindow = window.open(document.location.href);
}
</script>
<title>Infinite sum</title>
</head>
<body>
<font size="4" color="green">Enter a number please!</font>
<form action="Sum?id=<%=str%>" method="post" onsubmit="return isNumeric()">
<table>
	<tr>
		<td></td>
		<td><input type="text" name="number" id="number"/></td><td><label id="lbNumber" style="color: red;"></label></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="SUM" /></td>
	</tr>
</table>
</form>

<hr/>
<input type="button" value="CLONE PAGE" onclick="clonePage()">
<hr/>
<b>Previous operation(s) :</b><br>
<%=listToString(list) %>
</body>
</html>
