package com.catp.lms.dao;
import  java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;
import java.text.*;

import com.catp.lms.controller.ReturnBook;
import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsReturnBeanData;

public class ReturnBookDAO
{
	static Connection connect=null;
	static Statement st=null;
	static PreparedStatement pst=null;
	static ResultSet rst;
public static String s1="";

	public static boolean returndao(LmsReturnBeanData retr)
	{
		//String s1=null;
		String s2=null;
		int flag2=0;
		boolean b=false;
		connect=LmsUtil.getConnection();
		try {
			String id=retr.getBook_id();
		
			st=connect.createStatement();
			String str="select Issue_Date,book_status from lms_bookissue where bookid='"+id+"'";
			System.out.println("issue_date");
			rst=st.executeQuery(str);
			//boolean c=rst.next();
			while(rst.next())
			{
			  
			  s1=rst.getString("issue_date");
			  s2=rst.getString("book_status");
			  if(s2.equals("available"))
				{
				   flag2=1;
				   
				}
				if(s2.equals("unavailable"))
				{
				   flag2=0;
				}
				
				if(flag2==0)
				{
				   b=true;
				   
				}
				if(flag2==1)
				{
				   b=false;
				}
			}	

		}
				
				
			catch (SQLException e) {
				
			}
			
			
			return b;
	}
			
			public static  int calculatefine()
			{
				int fine=0; 
			 
  try {
	  
	  
				  Date today=new Date();
				  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				  Date issue1=sdf.parse(s1);
				  Calendar cal= Calendar.getInstance();
				  cal.setTime(issue1);
				 double issueday=cal.getTimeInMillis();
				  cal.setTime(today);
				  double today1=cal.getTimeInMillis();
				  double nod=(today1-issueday)/(1000*3600*24);
				  
				  int totaldays=(int)nod-7;
				
				 if(totaldays>7&&totaldays<14)
				  {
					  fine=10;
				  }
				 else if(totaldays>=14&&totaldays<30)
				 {
					 fine=100;
				 }
				 else if(totaldays>=30)
				 {
					 fine=250;
				 }
				 else
				 {
					 
				 }
				 
				  System.out.println(totaldays);
			} catch (Exception e) {
				// TODO: handle exception
			}
			 
	return fine;
			}
	
			
public static boolean validity(LmsReturnBeanData retr)
{
	
String bk=retr.getBook_id();
	System.out.println("123");
	int count=0,flag=0,m=0;
	boolean k=false;
	for(int i=0;i<bk.length();i++)
	{
		if(Character.isAlphabetic(bk.charAt(i))||Character.isDigit(bk.charAt(i)))
		{
			count++;
		}
	}
	if(bk.startsWith("BK"))
	{
		System.out.println("1");
		flag=1;
	}
	
	if(flag!=1 || count!=bk.length())
	{
		System.out.println("haiiiiii");
		m=1;
	}
	System.out.println(count);
	System.out.println(flag);
	System.out.println(m);
	if(m==1)
	{
		
		k=true;
		
		
	}
	return k;
}
public static boolean update(LmsReturnBeanData retr)
{
	//String s1=null;
	String s2=null;
	int flag2=0;
	int a;
	boolean b=false;
	connect=LmsUtil.getConnection();
	try {
		String id=retr.getBook_id();
	    String status=retr.getReturn_status();
	    
		st=connect.createStatement();
		if(status.equals("Lost"))
		{
			String str1="delete from lms_bookissue where bookid='"+id+"' ";
			 a=st.executeUpdate(str1);
		}
		else
		{
		String str="update lms_bookissue set book_status='available' where bookid='"+id+"'";
		//System.out.println("issue_date");
		   a=st.executeUpdate(str);
		}
		System.out.println(a+"w");
	}
	catch
	(Exception e) {
		// TODO: handle exception
	}
	return b;
}
}


