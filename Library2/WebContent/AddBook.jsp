<%@page import="com.catp.lms.util.LmsUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.catp.lms.dao.AddBookDao" %>
    <%@page import="com.catp.lms.vo.LmsBookBean" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery-1.9.1.js"></script>
  <script src="jquery-ui.js"></script>
  <link rel="stylesheet" href="jquery-ui.min.css" />
  <script>
  $(function() {
	  $( "#p" ).datepicker({changeMonth: true,
	        changeYear: true, yearRange: '1900:+0',dateFormat :'dd/mm/yy',maxDate:0
	        });
  });
  </script>  

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddBook</title>
<script type="text/javascript">
<%@include file="javaScript/addBookjs.js"%>
</script>     
      
      
</head>

<title>AddBook</title>


<link rel="stylesheet" type="text/css" href="css/MyStyle.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyle2.css" />


 <body  background="images/backimp.jpg"> 
 <%ArrayList catgry=AddBookDao.bookdetails(); %>
 
   <form name="addbookform" action="addbook" method="get" onSubmit="return validate();"> 
<h1 align="center"> Add Book</h1>


<table align="center" width= 100%, height=10%>


 <td align=" left"> 
<input type="button"  value="Home" onclick="location.href='Home.jsp'" >
<td><td align="right"><input type="button"  value="LogOut" onclick="location.href='Login.jsp'" >
</td> 





</table>

<table align="center" width=50%,height=50%>
 
 
 <tr>
 <td>Book Title :</td><td><input type="text" name="booktitle" onBlur="return validateTitle();"/></td>
 <td><p id="btitle"></p></td>
 </tr>
 
<tr>
<td>Category:</td><td>
<select name="category" onBlur="return validateCategory();">
<option value="0" selected>--select--</option>
<%for(int i=0;i<catgry.size();i++){ %>
<option ><%=catgry.get(i) %></option>
<%} %>
</select></td>
<td><p id="categ"></p></td>
 </tr> 
 
 
 <tr>
 <td>Author:</td><td><input type="text" name="author" onBlur="return validateAuthor();"/></td>
 <td><p id="Author"></p></td>
 </tr>

 <tr>
 <td><p id="pub"></p></td>
 </tr>
 
 <tr>
 <td>Publish Date:</td><td><input type="text" id="p" name="publishdate" onBlur="return validatePublishdate();"/></td>
  <td><p id="pubdate"></p></td>
 </tr>
 
 
 <tr>
 <td>Book Edition:</td><td><input type="text" name="bookedition" onBlur="return validateBookedition();"/></td>
<td> <p id="bedition"></p></td>
 </tr>

 
 <tr>
 <td>Price:</td><td><input type="text" id="price" name="price" onBlur="return validatePrice();"/></td>
<td><p id="netprice"></p></td>
 </tr>
 

<tr><td align="center"><input type="submit" value="ADD">
 <td align="left" ><input type="Reset" value="Reset"></td></tr>
 </table>
</form>
</body>
</html>
