package com.catp.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;    
import org.apache.log4j.Logger;

import com.catp.lms.controller.EditBookController;
import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsEditBookBean;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class UBookDao
{
	   static Connection currentCon = null;
	   static ResultSet rs=null;
	   //static PreparedStatement ps=null;
	   private static Logger logger=Logger.getLogger(UBookDao.class);

	   public static LmsEditBookBean UBook(LmsEditBookBean ubook) {

	    //preparing some objects for connection 
	   Statement stmt = null;    
	    //String accountno=edit.getAccountNo();  
    	 String id=ubook.getAccountNo();
    	 String title=ubook.getBooktitle();
    	 String category=ubook.getBookCategory();
    	 String author=ubook.getBookAuthor();
    	 String publication=ubook.getPublication();
    	 String publishdate=ubook.getPublishDate();
    	 String bookedition=ubook.getBookEdition();
    	 String price=ubook.getPrice();
    	 
	    System.out.println("BOOKID%%%%%%%%%%%%%%%%%"+id);
	    
	    
	    
		
	    System.out.println("^%%%%%%%%%%%%%%%");
	 // "System.out.println" prints in the console; Normally used to trace the process

	    System.out.println(id);          
	 logger.info("account nu logger=" + id);

	                      /*create table LMS_ADDBOOK
(
Bookid varchar(12),
BookTitle varchar(50),
Category varchar(30),
Author varchar(50),
Publication varchar(50),
PublishDate varchar(20),
BookEdition varchar(10),
Price number
);*///
	 /*update room_info set 
	 no_of_rooms_avail='" + avail_rooms + "' 
		 where room_type='" + d2 + "'";*/
	// String searchQuery="select * from LMS_ADDBOOK where BOOKID='"+accountno+"'";
String searchQuery = "UPDATE LMS_ADDBOOK SET  BOOKTITLE='" + title + "' ,CATEGORY='" + category + "' ,AUTHOR='" +author + "',  PUBLICATION='" + publication + "', PUBLISHDATE=' " + publishdate + "' , BOOKEDITION='" +bookedition + "',PRICE='" + price + "' WHERE BOOKID='"+id+"'";
	//String searchQuery="UPDATE LMS_ADDBOOK SET BOOKTITLE='"+title+"' where BOOKID='"+id+"'";  	    
	  	     
	 
	 System.out.println("Query: "+searchQuery);
		    
	 try 
	 {
       
		      
		currentCon = LmsUtil.getConnection();
		stmt=currentCon.createStatement();
       // stmt.executeUpdate(searchQuery);
         System.out.println("before rs");
	      rs = stmt.executeQuery(searchQuery);
	      System.out.println("resultset :: "+rs.getRow());
	      boolean more = rs.next();   
	      
	      if (!more) 
	      {
	         System.out.println("Sorry, " +
	         		"book acountno not valid");
	         ubook.setValid(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      { 
                     /*printing the logs*/	         
		    logger.info("the value of boookid::"+id);
		    logger.info("The value of BookTitle is :: "+title);
		    logger.info("The value of category is :: "+category);
		    logger.info("The value of Author is :: "+author);
		    logger.info("The value of publication is :: "+publication);
		    logger.info("The value of publis Date is :: "+publishdate);
		    logger.info("The value of bookedition is :: "+bookedition);
		    logger.info("The value of price is :: "+price);
		    
		  
	             
                /*now set valid as true*/           
            
	        ubook.setValid(true);
	      
	   } 

	    
	 }
	 catch (Exception ex) 
	 {
	    System.out.println(" An Exception has occurred! " + ex);
	    logger.error("");
	    ex.printStackTrace();
	 } 
		    
	 //some exception handling
	 finally 
	 {
	    if (stmt != null) {
	       try {
	         stmt.close();
	       } catch (Exception e) {}
	          stmt= null;
	       }
		
	    if (currentCon != null) {
	       try {
	          currentCon.close();
	       } catch (Exception e) {
	       }

	       currentCon = null;
	    }
	 }
	return ubook;
		
	}	
	}


