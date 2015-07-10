package com.catp.lms.util;
import java.sql.*;
import java.util.*;


public class LmsUtil{

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
    	  System.out.println("------Connection Creation started-----");
    	  //String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name
    	 String url= "jdbc:oracle:thin:@localhost:1521:xe";
    	 
        // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
         
         try
         {            	
            con = DriverManager.getConnection(url,"SYSTEM","password-1"); 
             								
        System.out.println("------Connection Created SuccessFully-----"+con.toString());
              
         }
         
         catch (SQLException ex) 
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}

