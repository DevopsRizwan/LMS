<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.catp.lms.dao.IssueBookDao" %>
<%@ page import="com.catp.lms.controller.IssueBookController" %>

<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"> 
</script>
<script>
<%@include file="js/IssueValidation.js"%>
</script>


<script>
$(document).ready(function(){
	$('#bookSearch').click(function(){
		$("#tab1").find("tr:gt(0)").remove();
		
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookIssue</title>
</head>



<link rel="stylesheet" type="text/css" href="css/MyStyle.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyle2.css" />


 <body  background="images/backimp.jpg"> 


<form name="form" action="IssueBookController" method="get">

<h1 align="center"> Book Issue</h1>
<h2 class="error_message"> 
				<%
					if (null != request.getAttribute("errorMessage")) 
					{
                
						out.println(request.getAttribute("errorMessage"));
					}
				%>
			</h2>

<table align="center" width= 100%, height=10%>
 <td align="left"> 
<input type="button"  value="Home" onclick="location.href='Home.jsp'" >
<td align=  "right"><input type="button"  value="LogOut" onclick="location.href='Login.jsp'" >
</td> 
</table>
<table align="center" width=50%,height=50%>
 <tr>
 <tr>
<tr>
<td>Book Act No :</td><td><input type="text" name="Book_Act_No" onblur="return validateBookActNo()"/></td>
<td><p id="ActNo"></p></td>
</tr>
<tr>
<td>Member ID:</td><td><input type="text" name="MemberID" onblur="return validateMemberId()"/></td>
<td><p id="memberId"></p></td>
 </tr>
<tr>
 <td>Issue Date:</td><td><input type="Date" name="IssueDate"/></td>
 </tr>
  
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
<tr><td> <td align="center"><input type="submit" value="ISSUE"></td></tr>



<tr><td> <h1 align="center"> Get Book Account</h1>
<tr></tr>
<tr></tr>
<tr>
<td>Book Name :</td><td><input type="text" name="BookName"  onblur="return validateBookName()"></td>
<td><p id="bookname"></p></td>
 
</tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
  <tr></tr>
<tr><td align="center"><input type="submit" value="SEARCH" id="search"></td>
</tr>
</table>

<table align="center"  id="tab1" border="1" bgcolor="white" style="border: green; border-width: 2px; 
 style="" >
                <tr align="center">
                                <td><b>Book_Act_no</b></td>
                                <td><b>Book_Name</b></td>
                                
                                </tr>
                                               <% if(null!= request.getAttribute("success_message"))
                                                {
                                  for(int i=0;i<IssueBookDao.l1.size();i++)
                                	  
                                                {%>
                                <tr>
                                <td ><%=IssueBookDao.l1.get(i)%> </td>
                                <td><%=IssueBookDao.l2.get(i)%> </td>
                               
                
                                
                                <%} }%> 
                                
                                 </table> 
                                <!--  <br>
                                <table align="center"><input type="submit" value="Schedule"></table>


 -->

</form>





</body>
</html>