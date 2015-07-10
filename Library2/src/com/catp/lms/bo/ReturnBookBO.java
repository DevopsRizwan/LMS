package com.catp.lms.bo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.catp.lms.dao.ReturnBookDAO;
import com.catp.lms.util.LmsUtil;
import com.catp.lms.vo.LmsReturnBeanData;

public class ReturnBookBO {
	
public static boolean returnbo(LmsReturnBeanData retr){
	
	
	boolean k=false;
	
	/*String bk=retr.getBook_id();
	
	int count=0,flag=0,m=0;
	for(int i=0;i<bk.length();i++)
	{
		if(Character.isAlphabetic(bk.charAt(i))||Character.isDigit(bk.charAt(i)))
		{
			count++;
		}
	}
	if(bk.startsWith("BK"))
	{
		flag=1;
	}
	
	if(flag!=1&&count!=bk.length())
	{
		m=1;
	}
	
	if(m==0)
	{
		k=true;
		
		
	}*/
	
	
		
	boolean b=ReturnBookDAO.returndao(retr);
	int flag=0;
	
	if(b==true)
	{
		flag=1;
	}
	if(b==false)
	{
		flag=0;
	}
	
	if(flag==1)
	{
	  k=true;
	  System.out.println("valid");
	}
	if(flag==0)
	{
		k=false;
		System.out.println("not valid");
	}
	
	return k;
	
	

	
		
	

}

}
