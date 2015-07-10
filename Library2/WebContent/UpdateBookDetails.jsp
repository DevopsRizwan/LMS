
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATEBook</title>
</head>



<link rel="stylesheet" type="text/css" href="css/MyStyle.css" />
<link rel="stylesheet" type="text/css" href="css/MyStyle2.css" />

 <form name="ubook" action="ubookpage" method="get">
 <body  background="images/backimp.jpg"> 



 <% HttpSession hs=request.getSession();
 String bookid=(String)hs.getAttribute("bookid");
 String  title=(String)hs.getAttribute("title");
 String category=(String)hs.getAttribute("category");
 String author=(String)hs.getAttribute("authorname");
 String publication=(String)hs.getAttribute("publication");
 String publishdate=(String)hs.getAttribute("publishdate");
 String bookedition=(String)hs.getAttribute("bookedition");
String price=(String)hs.getAttribute("price"); 
%>

<h1 align="center"> Update Book Details</h1>
<table align="center" width= 100%, height=10%>
<td align=" left"> 
<input type="button"  value="Home" onclick="location.href='Home.jsp'" >
<td><td align="right"><input type="button"  value="LogOut" onclick="location.href='Login.jsp'" >
</td> 
</table>
<table align="center" width=50%,height=50%>
<tr>
 <td>Book Act. No :</td>
 <!--
 <td><select>
  <option name="bookid" value="bid"><%=bookid %></option>
 
</select></td>-->
 <td><input type="text" name="bookid" value=<%=bookid %>> </td>
 </tr> 
  <tr>
 <td>Book Title :</td>
 <!-- <td><select>
  <option name="title" value="tit"><%=title %></option>
 
</select></td>-->

 <td><input type="text" name="title" value=<%=title %>> </td>

 </tr> 
 
 
 
 <tr>
 <td>Category :</td>
 <!-- <td><select>
  <option value="cat" name="category"> <%=category %>  </option>
 
</select></td>-->
 <td><input type="text" name="category" value=<%=category %>> </td>

 </tr> 
 <tr>
<td>Author : </td> <td><input type="text" name="author" value=<%=author %>> </td>
</tr>
 
 
 <tr>
 <td>Publication :</td><td><input type="text" name="publication"
     value=<%= publication %>></td>
 </tr>
  <tr>
 <td>Publish Date :</td><td><input type="text" name="publishDate"
    value=<%= publishdate %>></td>
 </tr>
 
 <tr>
 <td>Book Edition :</td>
 <td><input type="text" name="edition"   value=<%= bookedition %>></td>
 </tr>
 
 <tr>
 <td>Net Price :</td>
 
 <td><input type="text" name="price" value=<%= price %>  >  </td>
 
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
<td align="center"><button type="submit">UPDATE</button></tr> 
</table>

</body>
</form>
</html>