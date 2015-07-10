

<%@page import="com.catp.lms.controller.MemRegController"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MemberRegistration</title>
 <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/ui-lightness/jquery-ui.css" rel="stylesheet" type="text/css"/>   
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>   
      <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>   
      <script src="jquery-1.9.1.js"></script>
  <script src="jquery-ui.js"></script>
  <link rel="stylesheet" href="jquery-ui.min.css" />
  <script>
  $(function() {
	  $( "#p" ).datepicker({changeMonth: true,
	        changeYear: true, yearRange: '1900:+0',dateFormat :'dd-mm-yy',maxDate:0
	        });
  });
  </script> 
  <script>
  <%@include file="javaScript/Validation.js"%>
  </script>
<script>
	function myFunction() {
		location.reload();
	}
</script>

</head>
<link rel="stylesheet" type="text/css" href="css/MyStyle.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyle2.css" />


 <body  background="images/backimp.jpg"> 
	<%if(null!=request.getAttribute("errormessage"))
	{
	 ArrayList<String> err=(ArrayList<String>)request.getAttribute("errormessage");
	 for(int i=0;i<err.size();i++) 
	 {%>
	 <%=err.get(i) %>`
	 <%} %>
	<% }%>


<form name="memform" action="memreg" method="get">




<h1 align="center"> Member Registration</h1>
<table align="center" width= 100%, height=10%>
<tr>
 <td align="left"> 
<input type="button"  value="Home" onclick="location.href='Home.jsp'" >
</td>
<td align="right"><input type="button"  value="LogOut" onclick="location.href='Login.jsp'" >
</td>
</tr> 
</table>
<table align="center" width=50%,height=50%>
 <tr>
 <tr>
 <td>Name:</td><td><input type="text" name="Name" onblur="return validateName();"/></td>
 <td><p id="nam"></p></td>
  </tr>
  
 <tr>
 <td>Email Address:</td><td><input type="text" name="Email" onblur="return validateMailid();"/></td>
  <td><p id="eml"></p></td>
  </tr>  
  
  
   <tr>
 <td>DOB:</td><td><input type="text" id="p" name="DOB" onblur="return validateDOB();"/></td>
  <td><p id="date"></p></td>
  </tr>
  
  
   <tr>
 	<td> Mobile No :</td>
 	<td><input type="text" name="MobileNo" onblur="return validatemobnum();"/></td>
   <td><p id="num"></p></td>
  </tr>
  
   <tr>


<td>Membership Mode :</td><td><select name="Mode" onblur="return validatemode();">
 <option value="--Select--">Select</option>
 <option value="Annualy">Annually</option>
 <option value="HalfYearly">HalfYearly</option>
	<option value="Quarterly">Quarterly</option>
</select>
 <td><p id="mode"></p></td>


 </tr>
 <tr>
  <td>Type Of Book:</td><td>
  <select name="Type" onblur="return validateType();">
 <option value="--Select--">Select</option>
  <option value="Adult">Adult</option>
  <option value="Children">Children</option>
  </select>
 <!--   <option value="dotnet">dotnet</option> -->
  <td><p id="type"></p></td>
  
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
<tr></tr>
<tr></tr>
<tr></tr>
 
<tr></tr>
<tr></tr>
<tr></tr>
<tr align="center">
<td ><button type="submit">Register</button></td>
<td ><button type="reset" onclick="myFunction()">Reset</button></td>
</tr>
</table>
</form>
</body>
</html>