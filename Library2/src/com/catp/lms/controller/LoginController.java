package com.catp.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.catp.lms.dao.LoginDao;
import com.catp.lms.vo.LmsUserBean;


/**
 * Servlet implementation class for Servlet: LoginController
 *
 */
public class LoginController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {

	try
	{	    
	     LmsUserBean user = new LmsUserBean();
	     user.setUserName(request.getParameter("userName"));
	     user.setPassword(request.getParameter("userPassword"));
	     user = LoginDao.login(user);
	     if (user.isValid())
	     {
		        
	          HttpSession session = request.getSession(true);	    
	          session.setAttribute("currentSessionUser",user); 
	          response.sendRedirect("Home.jsp");
	          //logged-in page      		
	     }
		        
	     else 
	    	 response.sendRedirect("InvalidLogin.jsp"); //error page 
	} 
			
			
	catch (Throwable theException) 	    
	{
	     System.out.println(theException); 
	}
	       }
		}
