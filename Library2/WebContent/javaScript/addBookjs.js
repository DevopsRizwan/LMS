
function validate()
	{
		var title=document.forms["addbookform"]["booktitle"].value;
		var author=document.forms["addbookform"]["author"].value;
		var publication=document.forms["addbookform"]["publication"].value;
		var publishdate=document.forms["addbookform"]["publishdate"].value;
		var bookedition=document.forms["addbookform"]["bookedition"].value;
		var price=document.forms["addbookform"]["price"].value;
		
	if(title==null || title==""){
		document.getElementById("btitle").innerHTML="Title field  cannot be left blank";
		return false;
	}
	if(author==null || author==""){
		document.getElementById("Author").innerHTML="Author field  cannot be left blank";
		return false;
	}
	if(publication==null || publication==""){
		document.getElementById("pub").innerHTML="Publication field  cannot be left blank";
		return false;
	}
	if(publishdate==null || publishdate==""){
		document.getElementById("pubdate").innerHTML="Publishdate field  cannot be left blank";
		return false;
	}
	if(bookedition==null || bookedition==""){
		document.getElementById("bedition").innerHTML="Bookedition field  cannot be left blank";
		return false;
	}
	if(price==null || price==""){
		document.getElementById("netprice").innerHTML="Price field  cannot be left blank";
		return false;
	}
}
function validateTitle(){
	var title=document.forms["addbookform"]["booktitle"].value;
	if(title==null || title==""){
		document.getElementById("btitle").innerHTML="Title field  cannot be left blank";
		return false;
	}
	else{
		var letters =/^[A-Za-z ]+$/; 
		if(title.match(letters)) 
		{ 
			document.getElementById("btitle").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("btitle").innerHTML="Please provide proper title";
			return false; 
		} 
	}
}

function validateAuthor(){
	var auth=document.forms["addbookform"]["author"].value;
	if(auth==null || auth==""){
		document.getElementById("Author").innerHTML="Author  cannot be left blank";
		return false;
	}
	else{
		var letters = /^[A-Za-z ]+$/; 
		if(auth.match(letters)) 
		{ 
			document.getElementById("Author").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("Author").innerHTML="Please provide proper author";
			return false; 
		} 
	}
}
function validatePublication(){
	var publication=document.forms["addbookform"]["publication"].value;
	if(publication==null || publication==""){
		document.getElementById("pub").innerHTML="Publication field  cannot be left blank";
		return false;
	}
	else{
		var letters = /^[A-Za-z ]+$/; 
		if(publication.match(letters)) 
		{ 
			document.getElementById("pub").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("pub").innerHTML="Please provide proper publication";
			return false; 
		} 
	}
}
function validatePublishdate(){
	var pubdate=document.forms["addbookform"]["publishdate"].value;
	if(pubdate==null || pubdate==""){
		document.getElementById("pubdate").innerHTML="publishadate field  cannot be left blank";
		return false;
	}
	else{
			document.getElementById("pubdate").innerHTML=""; 
			return true; 
		} 
}

function validateBookedition(){
	var bookedi=document.forms["addbookform"]["bookedition"].value;
	if(bookedi==null || bookedi==""){
		document.getElementById("bedition").innerHTML="Bookedition  field  cannot be left blank";
		return false;
	}
	else if(bookedi>0) 
		{ 
			document.getElementById("bedition").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("bedition").innerHTML="Please provide proper edition";
			return false; 
		} 
	}

function validatePrice(){
	var price=document.forms["addbookform"]["price"].value;
	if(price==null || price==""){
		document.getElementById("netprice").innerHTML="Price field  cannot be left blank";
		return false;
	}
	else if(price>=0) 
		{ 
			document.getElementById("netprice").innerHTML=""; 
			return true; 
		} 
		else 
		{ 
			document.getElementById("netprice").innerHTML="Please provide proper price";
			return false; 
		} 
}	
	
