package com.catp.lms.dao;
import java.text.*;
import java.util.*;
import java.lang.reflect.Member;
import java.sql.*;

import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsMemRegBean;
public class MemRegDao 	
{
   static Connection currentCon = null;
   static Statement stmt = null;  
   static ResultSet rs=null;

   public static boolean MemReg(LmsMemRegBean member) {

    //preparing some objects for connection 
  
  int fees=0;
  String fee=null;
 
 
  
  String   name=member.getName();
 
  System.out.println("DAO FETCH NAMEE==="+name);
  String   email=member.getEmailaddress();
  String   type=member.getTypeofbook();
  String   mobile=member.getMobileno();
  String   dob=member.getDob();
  String   mode=member.getMembershipmode();
 // "System.out.println" prints in the console; Normally used to trace the process
 System.out.println("member name is " + name);          
 System.out.println("mem email is " + email); 
 System.out.println("mem type" + type); 
 System.out.println("mem ph " + mobile); 
 System.out.println("mem dob is " + dob); 
 System.out.println("mem mode is " + mode);  
 
 
  //String searchQuery ="INSERT INTO LMS_MEMBERS values ('"+name+"','"+email+"','"
    //                   +type+"',"+mobile+",'"+dob+"','"+mode+"')"; 
	    
 
 //System.out.println("Query: "+searchQuery);
	    
 try 
 {
   String memid="select concat('MI-',lms_memberid.nextval) from dual";
   String memberid=""; 
    currentCon = LmsUtil.getConnection();
    stmt=currentCon.createStatement();
   rs=stmt.executeQuery(memid);
   while(rs.next())
   {
    memberid=rs.getString(1);
   System.out.println(memberid);
   }
   member.setMembershipmode(memberid);
String searchQuery="INSERT INTO LMS_MEMBERS VALUES('"+memberid+"','"+name+"','"+dob+"','"+email+"','"+mobile+"','"+mode+"','"+type+"')";





   stmt=currentCon.createStatement();
  int hold=stmt.executeUpdate(searchQuery);
   
   
  
   
   if (hold==0) 
   {
      System.out.println("Sorry, " +
      		"not valid");
      member.setValid(false);
   } 
	        
   //if user exists set the isValid variable to true
   else if (hold>0) 
   { 
              /*printing the logs*/	         
 String mode1=member.getMembershipmode();
 String type1=member.getTypeofbook();
	// String type1=rs.getString("Type

 String getfees="select fees from lms_Membership_Masters where  Membership_Mode='"+ mode1+"' and Type_of_Book='"+ type1+"'";
 
 currentCon = LmsUtil.getConnection();
  stmt=currentCon.createStatement();
 rs=stmt.executeQuery(getfees);
 while(rs.next())
 {
 fees=rs.getInt("FEES");
 System.out.println(fees);
 
 
 
 }
 fee=Integer.toString(fees);
 member.setFees(fee);

 System.out.println(fees+"                  %%%%%%%%%%%%%%%%%%%");
 System.out.println(mode1+"khgllhvhvljhdfsaddddddddddddddddddddddddd");
System.out.println(type1+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
          
         /*now set valid as true*/           
     
    member.setValid(true);
   
} 
   
      
 }
 catch (SQLException ex) 
 {
    System.out.println(" An Exception has occurred! " + ex);
    ex.printStackTrace();
 } 
	    
 //some exception handling
 finally 
 {
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
return true;
	
}
   
   
   public static ArrayList<String> membermode()
   {
	   ArrayList<String> mode=new ArrayList<String>();
	   try
	   {
		   stmt=currentCon.createStatement();
		   String modeQuery="select  *  from lms_MemberShip_Mode";
		   rs=stmt.executeQuery(modeQuery);
		   while(rs.next())
		   {
			   mode.add(rs.getString(1));
		   }
		   System.out.println(mode);
		   
	   }
	   catch(SQLException e)
	   {
		   
	   }
	   return mode;
   }
   
   public static ArrayList<String> membertype()
   {
	   ArrayList<String> type=new ArrayList<String>();
	   try
	   {
		   stmt=currentCon.createStatement();
		   String typeQuery="select * from Lms_type_of_book";
		   rs=stmt.executeQuery(typeQuery);
		   while(rs.next())
		   {
			   type.add(rs.getString(1));
		   }
		   System.out.println(type);
		   return type;
	   }
	   catch(SQLException e)
	   {
		   
	   }
	   return type;
   }
}
