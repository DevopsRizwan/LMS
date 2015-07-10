
function validateName(){
    var Name=document.forms["memform"]["Name"].value;
    if(Name==null || Name==""){
          document.getElementById("nam").innerHTML="Name field  cannot be left blank";
          return false;
    }
    else{
          var letters = /^[A-Za-z ]+$/; 
          if(Name.match(letters)) 
          { 
                document.getElementById("nam").innerHTML=""; 
                return true; 
          } 
          else 
          { 
                document.getElementById("nam").innerHTML="Please provide proper username";
                return false; 
          } 
        }
} 
function validateMailid(){
		var mailid=document.forms["memform"]["Email"].value;
		if(mailid==null || mailid==""){
			document.getElementById("eml").innerHTML="E-Mailid field  cannot be left blank";
			return false;
			}
		else{
			var regEx =/^([-+.'\w+])+[@](\w+)+[.](\w+)$/;
			if(mailid.match(regEx)) 
			{ 
				document.getElementById("eml").innerHTML=""; 
					return true; 
			} 
			else 
			{ 
				document.getElementById("eml").innerHTML="Please provide proper E-mailid";
				return false; 
			} 
		}
	}

    
function validatemobnum(){
    
    var  mnum=document.forms["memform"]["MobileNo"].value;
    if( mnum==null ||  mnum==""){
    document.getElementById("num").innerHTML=" field  cannot be left blank";
    return false;
    } 
    else{
		var regEx =/^[0-9]{10}$/;
		if(mnum.match(regEx)) 
		{ 
			document.getElementById("num").innerHTML=""; 
				return true; 
		} 
		else 
		{ 
			document.getElementById("num").innerHTML="Please provide proper mobile no";
			return false; 
		} 
	}
    }

function validatemode(){
   { 
    var mmode=document.forms["memform"]["Mode"].value;
    if(Name==null || Name==""){
    document.getElementById("mode").innerHTML="Mode field  cannot be left blank";
    return false;
    } 
   } 

function validateType(){
	var tob=document.forms["memform"]["Type"].value;
    if(tob==null || tob==""){
    document.getElementById("type").innerHTML="Type field  cannot be left blank";
    return false;
   
    }}
    
  }
    


