package com.catp.lms.dao;
import java.text.*;
import java.util.*;
import java.sql.*;
import org.apache.log4j.Logger;

import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsUserBean;

public class LoginDao 	
{
   static Connection currentCon = null;
   static ResultSet rs = null; 
   private static Logger logger=Logger.getLogger(LoginDao.class);
   
   public static LmsUserBean login(LmsUserBean bean) {
	 
     


	   
      Statement stmt = null;    
	
      String username = bean.getUsername();    
      String password = bean.getPassword();   
      //SELECT USERNAME,PASSWORD FROM LMS_USER
     // String searchQuery ="select * from LMS_USERS where USERNAME='"+ username+ "' AND PASSWORD='"+ password+ "'";
      String searchQuery ="SELECT USERNAME,PASSWORD FROM LMS_USER"; 
	    
   // "System.out.println" prints in the console; Normally used to trace the process
   //System.out.println("Your user name is " + username);          
   //System.out.println("Your password is " + password);
      
    logger.info("the logger info is " + username);
    System.out.println("Your user name is " + username); 
   System.out.println("Query: "+searchQuery);
	    
   try 
   {
      
      currentCon = LmsUtil.getConnection();
      stmt=currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);
      System.out.println("resultset :: "+rs.getRow() );
      boolean more = rs.next();
	       
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
         bean.setValid(false);
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         String userName = rs.getString("USERNAME");
         String passWord = rs.getString("PASSWORD");
	     	
         System.out.println("Welcome " + userName);
         if(userName.equals(username)&&passWord.equals(password))
         {
         
         bean.setValid(true);
      }
   } 
   }

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
      ex.printStackTrace();
   } 
	    
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (Exception e) {}
            rs = null;
         }
	
      if (stmt != null) {
         try {
            stmt.close();
         } catch (Exception e) {}
            stmt = null;
         }
	
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (Exception e) {
         }

         currentCon = null;
      }
   }

return bean;
	
   }	
}
