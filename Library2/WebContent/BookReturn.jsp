<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookReturn</title>
</head>


<link rel="stylesheet" type="text/css" href="css/MyStyle.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyle2.css" />


 <body  background="images/backimp.jpg"> 
<form>





<h1 align="center"> Book Return</h1>




<table align="center" width= 100%, height=10%>
 <tr><td align=" left"> 
 
<input type="button"  value="Home" onclick="location.href='Home.jsp'" >
<td><td align="right"><input type="button"  value="LogOut" onclick="location.href='Login.jsp'" >
</td>
</tr> 
</table>
<table align="center" width=50%,height=50%>
 <tr>

 <tr>
 <td>Book Account No:</td><td><input type="number" name="MemberID"/></td>
 </tr>




<tr>
<td>Return Status :</td><td> <select>
  <option value="Available">Return</option>
  <option value="Not Available">Lost</option>
  
</select></td>

 </tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr><td><td><input type="submit" value="RETURN"></td></tr>
</table>
</body>
</html>