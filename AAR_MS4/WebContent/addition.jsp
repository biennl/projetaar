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
	int size = list.size();	
	if(list!=null && size>0)
	res += list.get(size - 1).getNum1();
	
	for (int i = size - 1; i >= 0; i--) {
		res += "<br>+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+list.get(i).getNum2();
		res += "<hr width = \"80\" noshade=\"noshade\" align =\"left\" />";
		res+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		if(i-1 > 0)
			res += list.get(i-1).getNum1();
		else res += (list.get(i).getNum1()+list.get(i).getNum2());				
	}

	return res;
}%>

<html>
<head>
<%
String str = request.getParameter("id");
int id = 0;
String idCalcul = (str==null)?"":str;
String lastID = (str == null ) ? "" : "?id="+str;
List<Calcul> list = new ArrayList<Calcul>();
String msg ="&nbsp;&nbsp;&nbsp;A number please !";
String jsMsg ="Sorry! this calculation does not existed!";
String plusSign = "";
DAOCalcul dao = new DAOCalcul();
int idMax = dao.getMaxId();
if(str !=null && !str.isEmpty()){
	id= Integer.parseInt(str);
	if(id<=idMax){
		list = dao.getCalculById(id);
		if(list.size()>0){
			msg ="&nbsp;&nbsp;&nbsp;&nbsp;"+ (list.get(0).getNum1()+list.get(0).getNum2());
			plusSign = "+";}
		else msg ="Sorry! this calculation is expired! Enter a number to start";
	}
// 	else
// 	{
%>
<script type="text/javascript">
function isValidLink(id){
	if(id > <%=idMax%> ){
		alert("<%=jsMsg%>");
		window.location="http://localhost:8080/AAR_MS4/";
	}
}
</script>
<%//}
}
%>
<script type="text/javascript" src="jquery-1.4.1.js"></script>
<script type="text/javascript">
function isNumeric(){
    var RE = /^-{0,1}\d*\d+$/;
    if(!RE.test($("#number").val())){
    	$("#lbNumber").text("Only integer!!");
    	return false;
    }
    return true;
}
	
function clonePage(){
	window.open(document.location.href);
}

function timer(){
	var aTimer = setTimeout('deleteHistory(<%=idCalcul%>)',10000);
}

function deleteHistory(param){
	$.get("Sum",{id:param});
}

function doPermalien(){
	$.get("Sum",{idPerm:<%=idCalcul%>});
}
</script>
<title>Infinite sum</title>
</head>
<body onload="timer();isValidLink(<%=id%>)">
<input type="button" value="PREV" onClick="history.back()">
<input type="button" value="NEXT" onClick="history.forward()">
<input type="button" value="CLONE" onclick="clonePage()">
<input type="button" value="PERMALIEN" onclick="doPermalien()">
<hr/><br>

<font size="4" color="green"><%=msg%></font>
<form action="Sum<%=lastID%>" method="post" onsubmit="return isNumeric()">
<table>
	<tr>
		<td></td>
		<td><%=plusSign%><input type="text" name="number" id="number"/></td><td><label id="lbNumber" style="color: red;"></label></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="SUM" /></td>
	</tr>
</table>
</form>

<hr/>
<b>Previous operation(s) :</b><br>
<%=listToString(list) %>
</body>
</html>
