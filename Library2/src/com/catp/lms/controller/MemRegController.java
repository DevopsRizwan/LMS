package com.catp.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.catp.lms.dao.AddBookDao;
import com.catp.lms.dao.MemRegDao;

import com.catp.lms.bo.*;
import com.catp.lms.vo.LmsMemRegBean;

/**
 * Servlet implementation class for Servlet: MemRegController
 *
 */
 public class MemRegController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public MemRegController() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
 try{
		LmsMemRegBean member=new LmsMemRegBean();
		member.setName(request.getParameter("Name"));
		member.setDob(request.getParameter("DOB"));
		member.setEmailaddress(request.getParameter("Email"));
		member.setMembershipmode(request.getParameter("Mode"));
		member.setMobileno(request.getParameter("MobileNo"));
		member.setTypeofbook(request.getParameter("Type"));
		  String   email=member.getEmailaddress();
		  String   type=member.getTypeofbook();
		  String   mobile=member.getMobileno();
		  String   dob=member.getDob();
		  String   mode=member.getMembershipmode();
		  String   name=member.getName();
		 // "System.out.println" prints in the console; Normally used to trace the process
		
		  System.out.println("mem name is " +name );
		  System.out.println("mem email is " +email ); 
		  System.out.println("mem type" + type); 
		  System.out.println("mem ph " + mobile); 
		  System.out.println("mem dob is " + dob); 
		  System.out.println("mem mode is " + mode);
				
		
		
		
 boolean b= MemberRegBO.RegBO(member);
	     
	    if(b)
	     {
	    	String memid=member.getMembershipmode();
	    	String memfee=member.getFees();
	    	request.setAttribute("memid", memid);
	    	request.setAttribute("memfee", memfee);
	    	RequestDispatcher rd=request.getRequestDispatcher("Registrationsuccess.jsp");
	    	rd.forward(request, response); 
	              		
	     }
		        
	     else 
	     {
	    	 
	    	 
	    	 request.setAttribute("errormessage", MemberRegBO.error);
	    	 RequestDispatcher rd=request.getRequestDispatcher("MemberRegistration.jsp");
	    	 rd.include(request, response);
	    
	    	 
	     }
	} 
			
			
	catch (Throwable theException) 	    
	{
	     System.out.println(theException); 
	}
	       }
		}

 
 
 
 
	