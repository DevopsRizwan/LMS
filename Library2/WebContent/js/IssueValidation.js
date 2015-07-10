
function validateBookActNo()
{
	var Name=document.forms["form"]["Book_Act_No"].value;
	if(Name==null || Name=="")
	{
		document.getElementById("ActNo").innerHTML="Name field  cannot be left blank";
		return false;
	}
	else
	{
		var letters =/^[BK]+[-]+\d+$/; 
		if(Name.match(letters)) 
		{ 
			document.getElementById("ActNo").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("ActNo").innerHTML="Please provide proper Book Account No";
			return false; 
		} 
	}

}
function validateMemberId()
{
	var id=document.forms["form"]["MemberID"].value;
	if(id=="" || id==null)
	{
		document.getElementById("memberId").innerHTML=" field  cannot be left blank";
		return false;
	}
	else
	{
		var letters =/^[MBR]+[-]+\d+$/; 
		if(id.match(letters)) 
		{ 
			document.getElementById("memberId").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("memberId").innerHTML="Please provide proper Member Id";
			return false; 
		} 
	}

}

function validateBookName()
{
	var letters =/^[A-Za-z ]+$/; 
	var id1=document.forms["form"]["BookName"].value;
	if(id1==null || id1=="")
	{
		document.getElementById("bookname").innerHTML=" field  cannot be left blank";
		return false;
	}
	else if(id1.match(letters)) 
	{ 
		document.getElementById("bookname").innerHTML=""; 
		return true; 
	} 
	else 
	{ 
		document.getElementById("bookname").innerHTML="Please provide proper Book Name";
		return false; 
	} 
}






