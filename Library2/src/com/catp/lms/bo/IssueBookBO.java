
package com.catp.lms.bo;

import java.util.*;import java.text.*;

import com.catp.lms.dao.IssueBookDao;
import com.catp.lms.vo.LmsBookIssueBeanData;

public class IssueBookBO {
	
	public static boolean IssueBO(LmsBookIssueBeanData issue)
	
	{
		//Declaring the variables
		boolean b=false;
		boolean id=false;
		int flag=0;
		String bookid=issue.getBookId();
		//validating the bookid
		if(!bookid.startsWith("BK-"))
		{
			flag=1;
		}
		else
		{
			for(int i=3;i<bookid.length();i++)
			{
				if(Character.isDigit(bookid.charAt(i)))
				{
					flag=2;
				}
			}
		}
		
		if(flag==0)
		{
			//method for dao class
			id=IssueBookDao.IssueDao(issue);
			
		}
		if(id)
		{
			b=true;
		}
		return b;
	
	
	
	

	
}}