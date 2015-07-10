package com.catp.lms.vo;

public class LmsMemRegBean {
private	String name;
private	String emailaddress;
private	String mobileno;
private	String membershipmode;
private	String typeofbook;
private String dob;
private String fees;
public String getFees() {
	return fees;
}
public void setFees(String fee) {
	this.fees = fee;
}
public boolean valid;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailaddress() {
	return emailaddress;
}
public void setEmailaddress(String emailaddress) {
	this.emailaddress = emailaddress;
}
public String getMobileno() {
	return mobileno;
}
public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
public String getMembershipmode() {
	return membershipmode;
}
public void setMembershipmode(String membershipmode) {
	this.membershipmode = membershipmode;
}
public String getTypeofbook() {
	return typeofbook;
}
public void setTypeofbook(String typeofbook) {
	this.typeofbook = typeofbook;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}


public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
} 


}
