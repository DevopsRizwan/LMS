package com.catp.lms.controller;
import com.catp.lms.vo.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.lms.bo.ReturnBookBO;
import com.catp.lms.dao.ReturnBookDAO;
import com.catp.lms.vo.LmsReturnBeanData;

/**
 * Servlet implementation class ReturnBook
 */
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBook() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			ReturnBookDAO rb=new ReturnBookDAO();
		 LmsReturnBeanData retr=new LmsReturnBeanData();
		 retr.setReturn_status(request.getParameter("return_status"));
		 retr.setBook_id(request.getParameter("MemberID"));
		 
		 boolean b=ReturnBookBO.returnbo(retr);
		
		boolean c=ReturnBookDAO.validity(retr);
		  if(b==true)
		  {
			int fine=ReturnBookDAO.calculatefine();
			if(fine>0)
			{
				System.out.println(fine);
				request.setAttribute("Message", fine);
				RequestDispatcher rd=request.getRequestDispatcher("/BookReturn.jsp");
				 rd.forward(request,response);
			}
			else
			{
				ReturnBookDAO.update(retr);
			RequestDispatcher rd=request.getRequestDispatcher("/returnbooksuccess.jsp");
			 rd.forward(request,response);
			
			} 
 
		  }
		  else if(c==false)
		  {
			  System.out.println("kdfsj");
			  request.setAttribute("errorMessage", "Book is not issued cannot be returned");
				RequestDispatcher rd=request.getRequestDispatcher("/BookReturn.jsp");
				 rd.forward(request,response);
		  }
		  
		  else
		  {
			  request.setAttribute("errorMessage", "The Entered id is not correct");
              RequestDispatcher rd=request.getRequestDispatcher("/BookReturn.jsp");  
              rd.include(request, response);
 
		  }
		 
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
