
package com.catp.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;    
import java.util.ArrayList;

import com.catp.lms.controller.EditBookController;
import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsEditBookBean;

import java.io.IOException;
import org.apache.catalina.*;
import org.apache.log4j.Logger;

public class EditBookDao
{
	static Connection currentCon = null;
	static ResultSet rs=null;
	static Statement stmt = null;
	static ArrayList<String> id=null;
	private static Logger logger=Logger.getLogger(EditBookDao.class);
	static String str=null;

	public static boolean EditBook(LmsEditBookBean edit) {
		String accountno=edit.getAccountNo();
		boolean k=false;
		int flag=0;
		try
		{

			id=new ArrayList<String>();
			stmt=currentCon.createStatement();
			String searchQuery="select bookid from lms_addbook";
			rs=stmt.executeQuery(searchQuery);
			while(rs.next())
			{
				id.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{

		}
		for(int i=0;i<id.size();i++)
		{
			if(accountno.equals(id.get(i)))
			{
				flag=1;
				break;
			}
			else
			{
				str="Bookid does not exists";
			}
			edit.setStr(str);
			
		}
		if(flag==1)
		{

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			// "System.out.println" prints in the console; Normally used to trace the process

			System.out.println("Book account number is " + accountno);          
			logger.info("account nu logger=" + accountno);


			String searchQuery="select * from LMS_ADDBOOK where BOOKID='"+accountno+"'";


			System.out.println("Query: "+searchQuery);

			try 
			{


				currentCon = LmsUtil.getConnection();
				stmt=currentCon.createStatement();
				System.out.println("before rs");
				rs = stmt.executeQuery(searchQuery);
				System.out.println("resultset :: "+rs.getRow());
				boolean more = rs.next();   
				if (!more) 
				{
					System.out.println("Sorry, " +
					"book acountno not valid");
					edit.setValid(false);
				} 

				//if user exists set the isValid variable to true
				else if (more) 
				{ 
					String bookid=rs.getString("BOOKID");
					String booktitle = rs.getString("BOOKTITLE");
					String category=rs.getString("CATEGORY");
					String author = rs.getString("AUTHOR");
					String publication=rs.getString("PUBLICATION");
					String publishdate = rs.getString("PUBLISHDATE");
					String bookedition = rs.getString("BOOKEDITION");
					String price = rs.getString("PRICE");
					/*printing the logs*/	         
					logger.info("the value of boookid::"+bookid);
					logger.info("The value of BookTitle is :: "+booktitle);
					logger.info("The value of category is :: "+category);
					logger.info("The value of Author is :: "+author);
					logger.info("The value of publication is :: "+publication);
					logger.info("The value of publis Date is :: "+publishdate);
					logger.info("The value of bookedition is :: "+bookedition);
					logger.info("The value of price is :: "+price);
					/*setting values in bean*/
					edit.setAccountNo(bookid); 
					edit.setBooktitle(booktitle);
					edit.setBookCategory(category);
					edit.setBookAuthor(author);
					edit.setPublication(publication);
					edit.setPublishDate(publishdate);
					edit.setBookEdition(bookedition);
					edit.setPrice(price);


					/*now set valid as true*/           

					edit.setValid(true);
					k=true;
				} 

			}
			catch (Exception ex) 
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

		}
		return k;
	}
}

