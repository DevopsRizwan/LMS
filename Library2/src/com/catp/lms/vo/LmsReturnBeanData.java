package com.catp.lms.vo;

public class LmsReturnBeanData {
	private String book_id;
	private String return_status;
	private String returned_date;
	private String range_code;

	public LmsReturnBeanData() {
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getReturn_status() {
		return return_status;
	}

	public void setReturn_status(String return_status) {
		this.return_status = return_status;
	}

	public String getReturned_date() {
		return returned_date;
	}

	public void setReturned_date(String returned_date) {
		this.returned_date = returned_date;
	}

	public String getRange_code() {
		return range_code;
	}

	public void setRange_code(String range_code) {
		this.range_code = range_code;
	}

	
}