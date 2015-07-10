package com.catp.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.catp.lms.dao.AddBookDao;
import com.catp.lms.dao.EditBookDao;
import com.catp.lms.dao.UBookDao;
import com.catp.lms.vo.LmsEditBookBean;

/**
 * Servlet implementation class EditBookController
 */
public class UBookController extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try
		{
			
			System.out.println("ubookcontroleer+++++++++++++++++++++");
			LmsEditBookBean ubook = new LmsEditBookBean();
			 
			//edit.setAccountNo(request.getParameter("accountnumber"));
			 ubook.setAccountNo(request.getParameter("bookid"));
			 ubook.setBooktitle(request.getParameter("title"));
			 ubook.setBookCategory(request.getParameter("category"));
			 ubook.setBookAuthor(request.getParameter("author"));	     
		     ubook.setPublication(request.getParameter("publication"));
		     ubook.setPublishDate(request.getParameter("publishdate"));
		     ubook.setBookEdition(request.getParameter("edition"));
		     ubook.setPrice(request.getParameter("price"));
		    String bookid=ubook.getAccountNo();
		    System.out.println("bookid frm bean is"+ bookid);
		    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        ubook=UBookDao.UBook(ubook);
	     
	     if (ubook.isValid())
	     {    
	    	
	    
	    	 
	    	 
			         
	     response.sendRedirect("updatesuccess.jsp"); //logged-in page
	    	 
	     }
		        
	     else 
	    	 response.sendRedirect("InvalidLogin.jsp"); //error page 
	
	}
			
	catch (Throwable theException) 	    
	{
	     System.out.println(theException); 
	}
	       }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
