<%@page import="com.catp.lms.vo.LmsBookBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.catp.lms.dao.AddBookDao" %>
    <%@page import="com.catp.lms.vo.LmsBookBean" %>
    <%@page import="com.catp.lms.controller.AddBookController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<form>
<body>
<% 
HttpSession hs=request.getSession();
int fees=(Integer)hs.getAttribute("fees");
%>
<H1 align="center">

UPDATE SUCCESSFULLY
</H1>
<table>
<tr align="center">

<td align="center"><h2 align="center">Fees :</td><td><input type="text" name="fees" VALUE=<%=fees%>/></h2></td>

<tr>
</table>
</body>
</form>
</html>