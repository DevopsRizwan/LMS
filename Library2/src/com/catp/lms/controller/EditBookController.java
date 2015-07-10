
package com.catp.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import com.catp.lms.dao.EditBookDao;
import com.catp.lms.dao.AddBookDao;

import com.catp.lms.bo.EditBookBO;
import com.catp.lms.vo.LmsEditBookBean;

/**
 * Servlet implementation class EditBookController
 */
public class EditBookController extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try
		{
			
			System.out.println("edit controller page ++++++++++++++++++++++++++++++++++++++++++++++");
			LmsEditBookBean edit = new LmsEditBookBean();
	   	    edit.setAccountNo(request.getParameter("accountnumber"));
	       boolean b=EditBookBO.editbo(edit);
	     
	     if (b)
	     {    
	    	
	    	 /*1creating session object to get the session 
	    	   2geting values from bean
	    	   3setting the attribute to get on jsp */
	    	 
	    	 HttpSession hs=request.getSession();
	    	 
	    	 String bookid=edit.getAccountNo();
	    	 hs.setAttribute("bookid",bookid);
	    	 
	    	 
	    	 String title=edit.getBooktitle();
	    	 hs.setAttribute("title",title);
	    	 
	    	 String category=edit.getBookCategory();
	    	 hs.setAttribute("category",category);
	    	 
	    	  String author=edit.getBookAuthor();
	    	  hs.setAttribute("authorname",author);
	    	 
	    	  String publication=edit.getPublication();
	    	 hs.setAttribute("publication",publication);
	    	 
	    	 String publishdate=edit.getPublishDate();
	    	 hs.setAttribute("publishdate", publishdate);
	    	 
	    	 String bookedition=edit.getBookEdition();
	    	 hs.setAttribute("bookedition",bookedition);
	    	 
	    	 String price=edit.getPrice();
	    	 hs.setAttribute("price",price);
	    	 
	    	 
			         
	     response.sendRedirect("UpdateBookDetails.jsp"); //logged-in page
	    	 
	     }
		        
	     else 

	     {
	    	 String str=edit.getStr();
	    	 request.setAttribute("error", str);
	    	 RequestDispatcher rd=request.getRequestDispatcher("EditBook.jsp");
	    	 rd.include(request, response);
	     }
	
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





