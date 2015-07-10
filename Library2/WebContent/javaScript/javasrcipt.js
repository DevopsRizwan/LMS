
	function validate()
	{
		var name=document.forms["frm1"]["userName"].value;
		var name2=document.forms["frm1"]["userPassword"].value;
		
		if((name==null || name=="")||(name2==null || name2==""))
			{
			
			
		if(name==null || name=="")
			{
				document.getElementById("user_name").innerHTML="UserName should not be left Blank";
			
				
			}
		
	 if(name2==null || name2=="")
			{
				document.getElementById("pwd").innerHTML="Password should not be left blank";
				
			}
		return false;
			}
		else
			{
	
		return true;
		
		
	}
	}
	function myFunction() {
	    location.reload();
	}
