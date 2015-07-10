package com.catp.lms.bo;

import java.text.SimpleDateFormat;

import java.util.*;

import com.catp.lms.dao.AddBookDao;
import com.catp.lms.dao.MemRegDao;
import com.catp.lms.vo.LmsMemRegBean;

import java.util.regex.*;

import com.catp.lms.dao.MemRegDao;
public class MemberRegBO {
	public static ArrayList<String> error;
	
	/**
	 * Reg bo.
	 *
	 * @param member the member reg
	 * @return true, if successful
	 */
	public static boolean RegBO(LmsMemRegBean member )
	{	//	boolean b = MemberRegDao.RegDao(MemberReg);
		boolean k=true;
		//boolean b=MemRegDao.MemReg(member);

		String name =member.getName();
		String email=member.getEmailaddress();
		String dob=member.getDob();
		String mnub=member.getMobileno();
		String mode=member.getMembershipmode();
		String tob=member.getTypeofbook();

		int t=0,ct=0,dt=0,m=0,vdob=0,ag=0,ty=0;
		ArrayList<String> errormessage=new ArrayList<String>();


		if(!Character.isLetter(name.charAt(0))&&name.charAt(0)==' ')
		{
			t=1;
		}
		else
		{
			for(int i=0;i<name.length();i++)
			{
				if(!Character.isLetter(name.charAt(i))&&name.charAt(i)!=' ')
				{
					t=1;
					break;
				}
			}
		}
		if(t==1)
		{
			String s="Enter a valid Name";
			errormessage.add(s);
		}


				 Pattern dateFrmtPtrn =
			Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");
		Matcher mtch = dateFrmtPtrn.matcher(dob);      
		if(!mtch.matches())
		{
			dt=1;

		}
		if(dt==1)
		{
			String s="Enter a Valid Date";
			errormessage.add(s);

		}
		


		//MOBILE NO.
		if(mnub.length()==10)
		{
			for(int i=0;i<10;i++)
			{   
				if(Character.isDigit(mnub.charAt(i)))		 
				{
					ct++;
				}
			} 
		}	 
		if(ct!=10)
		{
			String s1="Enter a Valid Mobile number";
			errormessage.add(s1);

		}


		// Membership Mode
		{
			if(!mode.equals("Annually")&&!mode.equals("HalfYearly")&&!mode.equals("Yearly")&&!mode.equals("Quarterly"))  
			{
				m=1;
			}	
			if(m==1)
			{
				String s2="Select an option";
				errormessage.add(s2);
			}	
		} 		  	

		// Type of book

		// Date of birth validation.

		String dobb=member.getDob();
		if(dobb!="")
		{
			vdob=1;

		}
		else
		{
			errormessage.add("Date of birth can not be left blank.");


		}
		if(vdob==1)
		{
			int age;
			try
			{
				Date dtt=new Date();
				SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");

				Date dob1=sd.parse(dobb);
				Calendar c=Calendar.getInstance();

				c.setTime(dob1);
				long d1=c.getTimeInMillis();

				c.setTime(dtt);
				long d2=c.getTimeInMillis();
				//System.out.println(d1);
				//System.out.println(d2);
				//output1=(d1-d2);
				int age1=Math.abs((int)( (d1-d2) / (1000*3600*24) ) );
				age=age1/365;
				System.out.println(age);
				if(age>=0 && age<=14)
				{
					ag=1;


				}
				else if(age>14)
				{

					ag=2;
				}
			}               
			catch(Exception ee)
			{

			}
			if(ag==1)
			{
				if(!tob.equals("Children"))
				{
					ty=1;
				}
			}

			if(ag==2)
			{
				if(!tob.equals("Adult"))
				{
					ty=2;
				}
			}

			if(ty==1||ty==2)
			{
				String s3="Choose the correct type of book";
				errormessage.add(s3);

			}
			
			
		}


		if(t==0&&dt==0&&ct==0&&ty==0&&m==0)
	{
		boolean b=MemRegDao.MemReg(member);
			if(b)
			{
				k=true;
		} 
	}
	else		{
			error=new ArrayList<String>();
			error.addAll(errormessage);
	}
		
		return k;   
	}
	
} 









