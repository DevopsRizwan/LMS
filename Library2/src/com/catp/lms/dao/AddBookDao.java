
package com.catp.lms.dao;
import java.text.*;
import java.util.*;
import java.net.HttpRetryException;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.catp.lms.util.LmsUtil;
import org.omg.CORBA.Request;

import com.catp.lms.vo.LmsBookBean;
import com.catp.lms.vo.LmsUserBean;
public class AddBookDao 	
{
   static Connection currentCon = null;
 

   public static void AddBook(LmsBookBean book) {

    //preparing some objects for connection 
    Statement stmt = null;    
    PreparedStatement ps=null;
    ResultSet rs=null;
    String booktitle=book.getBooktitle();  
	String bookCategory=book.getBookCategory(); 
	String bookAuthor=book.getBookAuthor();  
    String	publication=book.getPublication();  
    String	publishDate=book.getPublishDate();  
    String bookEdition=book.getBookEdition();  
	String price=book.getPrice();
	int id;
	String s1="";
    
 // "System.out.println" prints in the console; Normally used to trace the process
 System.out.println("Book booktitle is " + booktitle);          
 System.out.println("Book bookCategory is " + bookCategory); 
 System.out.println("Book bookAuthor is " + bookAuthor); 
 System.out.println("Book publication is " + publication); 
 System.out.println("Book publishDate is " + publishDate); 
 System.out.println("Book bookEdition is " + bookEdition); 
 System.out.println("Book bookPrice is " + price); 
try 
 {
    
    currentCon = LmsUtil.getConnection();
    stmt=currentCon.createStatement();
    String st="select concat('BK-',lms_bukid.nextval) from dual";
    rs=stmt.executeQuery(st);
    /*if(rs.next())
    {
    	System.out.println(rs.getString(1));
    }*/
    String searchQuery ="INSERT INTO LMS_AddBook values (?,?,?,?,?,?,?,?)"; 
    ps=currentCon.prepareStatement(searchQuery);
    
    while(rs.next())
    {
    ps.setString(1, rs.getString(1));
    s1=rs.getString(1);
    }
    ps.setString(2, booktitle);
    ps.setString(3, bookCategory);
    ps.setString(4, bookAuthor);
    ps.setString(5, publication);
    ps.setString(6, publishDate);
    ps.setString(7, bookEdition);
    ps.setString(8, price);
    int n=ps.executeUpdate();
    System.out.println(n);
    book.setValid(true);
      
 }
 catch (SQLException e) 
 {
    System.out.println(" An Exception has occurred! " + e);
    
 } 
	    
 //some exception handling
 finally 
 {
    if (ps != null) {
       try {
          ps.close();
       } catch (Exception e) {}
          ps = null;
       }
	
    if (currentCon != null) {
       try {
          currentCon.close();
       } catch (Exception e) {
       }

       currentCon = null;
    }
    
 }
 book.setstr(s1);
}	
 //DropDown Category Method  
   public static ArrayList bookdetails()
   {
	   ArrayList a1=new ArrayList();
	   ResultSet rs=null;
	   Statement st=null;
	   try
	   {
		  
	   currentCon=LmsUtil.getConnection();
	  
	   String str1="select * from lms_BookCategory";
	   st=currentCon.createStatement();
	   rs=st.executeQuery(str1);
	   
	   while(rs.next())
	   {
		   
		   a1.add(rs.getString(1));
		   
	  }
	   System.out.println("values displayed");
	   }
	   catch(SQLException e)
	   {
		   
	   }
	   finally 
	   {
		   try
		   {
			   if(rs!=null)
			   {
				  rs.close(); 
			   }
			   if(st!=null)
			   {
				   st.close();
			   }
			   if(currentCon!=null)
			   {
				   currentCon.close();
			   }

	         currentCon = null;
	      }
		   catch(Exception e)
		   {
			   
		   }
	   }
	 
	   return a1;
   }
}  
   /*public static String price()
   {
	  System.out.println("entered method");
	  Statement st=null;
	  ResultSet rs=null;
	  String str="";
	  ArrayList a1=new ArrayList();
	  ArrayList<String> a2=new ArrayList<String>();
	 
	  
	  
	  System.out.println("before query");
	  try
	  {
		  currentCon=LmsUtil.getConnection();
		  st=currentCon.createStatement();
		  String str1="select category from lms_bookdetails";
		  rs=st.executeQuery(str1);
		  while(rs.next())
		  {
			  a1.add(rs.getString(1));
		  }
		  System.out.println("executed query 1");
		  System.out.println(a1);
		  String str3="select discount from lms_bookdetails";
		  rs=st.executeQuery(str3);
		  while(rs.next())
		  {
			 a2.add(rs.getString(1)); 
		  }
		  System.out.println("executed query 2");
		  System.out.println(a2);

			  for(int i=0;i<a1.size();i++)
		  {
			  System.out.println("query3");
			  if(a1.get(i).equals(cat))
			  {
				  System.out.println("query3 entered");
				 String val=a2.get(i);
				 System.out.println(val);
				 float n=Integer.parseInt(val);
				 System.out.println(n);
				  String str2="select case when category='Fiction' and price<=300 then (price-(price*0.1))" +
			  		"when category='Fiction' and price>300 then (price-(price*0.2))end price from LMS_AddBook ";
				  System.out.println("inside try block");
				  rs=st.executeQuery(str2);
				  while(rs.next())
				  {
					  str=rs.getString(1);
					  System.out.println(str);
				  
				  }
			  }
		  
		  System.out.println("query executed");
	 }
	  catch(SQLException e)
	  {
		  
	  }
	  catch(NumberFormatException e)
	  {
		  
	  }
	  finally 
	   {
		   try
		   {
			   if(rs!=null)
			   {
				  rs.close(); 
			   }
			   if(st!=null)
			   {
				   st.close();
			   }
			   if(currentCon!=null)
			   {
				   currentCon.close();
			   }

	         currentCon = null;
	      }
		   catch(Exception e)
		   {
			   
		   }
		   
	   }
	  
	  HttpSession session=null;
	 session.setAttribute("pri",str);
	 return str;
	  
	  
	  
	  
   }*/
