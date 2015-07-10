
package com.catp.lms.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.catp.lms.dao.AddBookDao;
import com.catp.lms.dao.LoginDao;

import com.catp.lms.bo.AddBookBO;
import com.catp.lms.vo.LmsBookBean;

/**
 * Servlet implementation class for Servlet: LoginController
 *
 */

public class AddBookController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
				           throws ServletException, java.io.IOException {

	try
	{	    
		LmsBookBean book = new LmsBookBean();
	     book.setBookEdition(request.getParameter("bookedition"));
	     book.setBookAuthor(request.getParameter("author"));
	     book.setBookCategory(request.getParameter("category"));
	     book.setBooktitle(request.getParameter("booktitle"));
	     book.setPrice(request.getParameter("bookprice"));
	     book.setPublication(request.getParameter("publication"));
	     book.setPublishDate(request.getParameter("publishdate"));
	     book.setPrice(request.getParameter("price"));
	     
	    Boolean b=AddBookBO.AddbookBo(book);
	    System.out.println("next method");
	    if (b)
	     {
		      System.out.println("true");
		      HttpSession session=request.getSession();
		      String s4=book.getstr();
		      session.setAttribute("msg", s4);
		      RequestDispatcher rd=request.getRequestDispatcher("addsuccess.jsp");
		      rd.forward(request, response);
	    	
	    	 
	     }
		        
	     else 
	     {
	    	 ArrayList<String> a1=new ArrayList<String>();
	    	 a1=AddBookBO.error;
	    	 request.setAttribute("error", a1);
	    	 RequestDispatcher rd=request.getRequestDispatcher("AddBook.jsp"); 
	    	 rd.include(request, response);//error page 
	     }
	    	
	} 
			
			
	catch (Throwable theException) 	    
	{
	     System.out.println(theException); 
	}
	}
}