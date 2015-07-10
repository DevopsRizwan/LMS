 



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>HomePage</title>
 
<link rel="stylesheet" type="text/css" href="css/MyStyle.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyle2.css" />



<body background="images/backimp.jpg">


<form name="editbook" action="editpage" method="get">
<table align="center" width= 100%, height=10%>
 
<td align=" left">
<input type="button"  value="Home" onclick="location.href='Home.jsp'" >
 
<td><td align="right"><input type="button"  value="LogOut" onclick="location.href='Login.jsp'" >
</td>
</table>
<table align="center" width=50%,height=50%>
 <tr>
<td>Account No.:</td><td><input type="number" name="accountnumber"/></td>
</tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
<td align="center"><input type="button"  value="Search" onclick="location.href='UpdateBookDetails.jsp'" >
</tr>
</table>
</form>
</body>
</html>