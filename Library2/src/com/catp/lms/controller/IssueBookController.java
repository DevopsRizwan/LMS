package com.catp.lms.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.catp.lms.bo.IssueBookBO;
import com.catp.lms.dao.IssueBookDao;

import com.catp.lms.vo.LmsBookIssueBeanData;


/**
 * Servlet implementation class IssueBookController
 */
public class IssueBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		try
		{
			LmsBookIssueBeanData Issue=new LmsBookIssueBeanData();
			
			Issue.setBookId(request.getParameter("Book_Act_No"));
			Issue.setMemberId(request.getParameter("MemberID"));
			Issue.setIssueDate(request.getParameter("IssueDate"));
			Issue.setBookName(request.getParameter("BookName"));
			System.out.println(request.getParameter("BookName"));
			boolean b=IssueBookBO.IssueBO(Issue);
			int n=123;
			String st=Integer.toString(n);
			response.getWriter().write(st);
			/*String bukid=Boolean.toString(b);
			response.getWriter().write(bukid);*/
			
			
		    if(b)
		    {
		    	 ArrayList<String> bookid=new ArrayList<String>();
		    	 ArrayList<String> booktitle=new ArrayList<String>();
		    	 bookid=IssueBookDao.l1;
		    	 booktitle=IssueBookDao.l2;
		    	 request.setAttribute("bookid",bookid);
		    	 request.setAttribute("booktitle", booktitle);
		    	 request.setAttribute("success_message", "success");
		    	 String message=Issue.getError();
		    	 request.setAttribute("message", message);
		    	 RequestDispatcher dis=request.getRequestDispatcher("BookIssue.jsp");
		    	 dis.include(request, response);
		    }
		    else
		    {
		    	ArrayList<String> error=new ArrayList<String>();
		    	request.setAttribute("eror", error);
		    	RequestDispatcher rd=request.getRequestDispatcher("BookIssue.jsp");
		    	rd.include(request, response);
		    	
		    }
		  
			  
			
		   
		   
		    
		    	
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		     
	
	
	}
}