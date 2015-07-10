package com.catp.lms.dao;


import java.sql.*;

import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsBookIssueBeanData;

public class IssueBookDao {
	
	
	static ArrayList<String> errormessage=null;
	static Connection con1=null;
	static Statement st1=null;
	static Statement st2=null;
	static PreparedStatement ps=null;
	static ResultSet rs=null;
	public static ArrayList<String> l1=null;
	public static ArrayList<String> l2=null;
	public static boolean book_details(LmsBookIssueBeanData Issue){
		 String bookname=Issue.getBookName();
		 System.out.println(  "got the"+bookname);
		 try
		{
			 l1=new ArrayList<String>();
			 l2=new ArrayList<String>();
			
			con1=LmsUtil.getConnection();
			
			st1=con1.createStatement();
			String str="select BookId, BookTitle from LMS_ADDBOOK where BookTitle LIKE '%"+bookname+"%' ";
			rs=st1.executeQuery(str);	
			while(rs.next())
			{
				l1.add(rs.getString("BookId"));
				l2.add(rs.getString("BookTitle"));
			}
			System.out.println(l1);
			System.out.println(l2);
			
		}
		catch(SQLException E)
		{

			return false;
		}
		finally 
		{
			if (rs != null) {
		    try {
		          rs.close();
		       } 
		    catch (Exception e) {}
		          rs = null;
		       }
		    if (st1!= null) {
			try {
			          st1.close();
			  } 
			catch (Exception e) {}
			          st1 = null;
			       }
		    if (con1 != null) {
		       try {
		          con1.close();
		       } catch (Exception e) {
		       }
		       con1 = null;
		    }
		}
		return true;
}
public static boolean IssueDao(LmsBookIssueBeanData Issue){
	//Establishing the connection
	con1=LmsUtil.getConnection();
	//Declaring the variables
	ArrayList<String> id=new ArrayList<String>(); 
	ArrayList<String> error=new ArrayList<String>();
	String bookid=Issue.getBookId();
	String Memberid=Issue.getMemberId();
	String IssueDate=Issue.getIssueDate();
	String ReturnDate=Issue.getReturnDate();
	String Bookstatus=Issue.getBookStatus();
	String issueid="";
	String returnday=null;
	String err=null;
	Date d,rdt;
	int count=0,flag=0;
	boolean b=false;
	//Calculating the return date based on issue date
	try
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			d= sdf.parse(IssueDate);
			System.out.println(d);
			Calendar cal=Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, 7);
			rdt= cal.getTime();
			System.out.println(rdt);
			returnday=sdf.format(rdt);
			
		}
		catch(Exception  e)
		{
			
		}
		//Checking the book availability
		st1=con1.createStatement();
		String Query1="select  bookid from lms_addbook lm  where bookid  not in (select bookid from lms_bookissue b where lm.bookid=b.bookid)"; 
		rs=st1.executeQuery(Query1);
		while(rs.next())
		{
			id.add(rs.getString(1));
		}
		st2=con1.createStatement();
		String Query2="select bookid from lms_bookissue where bookStatus='Available";
		rs=st2.executeQuery(Query2);
		while(rs.next())
		{
			id.add(Query2);
		}
		for(int i=0;i<id.size();i++)
		{
			if(bookid.equals(id.get(i)))
			{
				flag=1;
				break;
			}
			else
			{
				error.add("Book is not available and cannot be issued");
				
			}
			
			
		}
				
		//Counting the number of books issued to the member
	if(flag==1)
	{
		st1=con1.createStatement();
		String countquery="select count(Member_id)Member_id  from lms_bookissue where Member_id='"+Memberid+"' and  bookStatus='NotAvailable' group by Member_id";
		rs=st1.executeQuery(countquery);
		while(rs.next())
		{
			count=rs.getInt(1);
			System.out.println(count);
		}
		if(count>3)
		{
			error.add("BookIssue limit is exccceeded");
			errormessage.addAll(error);
					
		}
		else
		{
			//Generating the bookissueid
			st1=con1.createStatement();
			String str="select concat('BKIS',lms_bookissueid.nextval) from dual";
			rs=st1.executeQuery(str);
			while(rs.next())
			{
				issueid=rs.getString(1);
				System.out.println(issueid);
			}
				
				
			//Inserting the values into the database
			String str1="Insert into lms_bookissue values(?,?,?,?,?,?)";
			ps=con1.prepareStatement(str1);
			ps.setString(1, issueid);
			ps.setString(2, bookid);
			ps.setString(3, Memberid);
			ps.setString(4, IssueDate);
			ps.setString(5, returnday);
			ps.setString(6, "null");
			int n=ps.executeUpdate();
			System.out.println(n);
				
				
			//Updating the bookstatus after Issuing the book
			if(n==1)
			{
			st1=con1.createStatement();
			String updatequery="update lms_bookissue set bookstatus='NotAvailable' where bookid='"+bookid+"'";
			rs=st1.executeQuery(updatequery);
					
			}
	
		}
	
		
		
	}
	return true;
	}
	catch(SQLException e)
	{
		return false;
	}
	
			
}



}