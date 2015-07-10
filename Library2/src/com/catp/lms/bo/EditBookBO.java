package com.catp.lms.bo;
import com.catp.lms.dao.EditBookDao;

import com.catp.lms.vo.LmsEditBookBean;

public class EditBookBO {
	public static boolean editbo(LmsEditBookBean edit){
		//Declaring the variables
		boolean b=false;
		int flag=0;
		String id=edit.getAccountNo();
		if(id.startsWith("BK-"))
		{
			flag=1;
		}
		else
		{
			for(int i=0;i<id.length();i++)
			{
				if(!Character.isDigit(id.charAt(i)))
				{
					flag=2;
				}
			}
		}
		if(flag==0)
		{
			boolean k=EditBookDao.EditBook(edit);
			if(k)
			{
				b=true;
			}
		}
		return b;
		
	}
	

}