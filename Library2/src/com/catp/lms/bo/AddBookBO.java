
package com.catp.lms.bo;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import com.catp.lms.controller.*;
import com.catp.lms.dao.AddBookDao;

import com.catp.lms.vo.LmsBookBean;
public class AddBookBO {
	public static ArrayList<String> error;
	public static boolean AddbookBo(LmsBookBean book)
	{
		AddBookDao.AddBook(book);
		boolean b=false;
		String title=book.getBooktitle();
		String author=book.getBookAuthor();
		String Publication=book.getPublication();
		String publishdate=book.getPublishDate();
		String edition=book.getBookEdition();
		String price=book.getPrice();
		int t=0,ath=0,pb=0,pd=0,ed=0,p=0,flag=0;
		error=new ArrayList<String>(); 
				//BookTitle validation
		if(!Character.isLetter(title.charAt(0))&&title.charAt(0)==' ')
		{
			t=1;
		}
		else
		{
			for(int i=0;i<title.length();i++)
			{
				if(!Character.isLetter(title.charAt(i))&&title.charAt(i)!=' ')
				{
					t=1;
					break;
				}
			}
		}
		if(t==1)
		{
			String s="Enter a valid BookTitle";
			error.add(s);
		}
		//author validation
		if(!Character.isLetter(author.charAt(0))&&author.charAt(0)==' ')
		{
			ath=1;
		}
		else
		{
			for(int i=0;i<author.length();i++)
			{
				if(!Character.isLetter(author.charAt(i))&&author.charAt(i)!=' ')
				{
					ath=1;
					break;
				}
			}
		}
		if(ath==1)
		{
			String s="Author name should contain only characters and spaces";
			error.add(s);
		}
		//Publication validation
		if(!Character.isLetter(author.charAt(0))&&author.charAt(0)==' ')
		{
			pb=1;
		}
		else
		{
			for(int i=0;i<Publication.length();i++)
			{
				if(!Character.isLetter(Publication.charAt(i))&&Publication.charAt(i)!=' ')
				{
					pb=1;
					break;
				}
			}
		}
		if(pb==1)
		{
			String s=" Publication should contain only characters and spaces";
			error.add(s);
		}
		//publishDate validation
		Pattern pat= Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		Matcher match=pat.matcher(publishdate);
		if(!match.matches())
		{
			pd=1;
		}
		else
		{
			try
			{
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date d=sdf.parse(publishdate);
			Date d1=new Date();
			if(!d.before(d1))
			{
				pd=2;
			}
			}
			catch(Exception e)
			{
				
			}
		}
		if(pd==1)
		{
			String s="Enter a Valid Date";
			error.add(s);
		}
		if(pd==2)
		{
			String s="Date should be less than current date";
			error.add(s);
		}
	if(t==0&&ath==0&&pb==0&&pd==0)
	{
		//AddBookDao.AddBook(book);
		b=true;
	}
		
	return b;

}
}