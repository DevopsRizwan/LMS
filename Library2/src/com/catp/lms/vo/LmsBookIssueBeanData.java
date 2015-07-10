package com.catp.lms.vo;

public class LmsBookIssueBeanData {
	private String BookId;
	private String MemberId;
	private String IssueDate;
	private String BookName;
	private String ReturnDate;
	private String BookStatus;
	private String error;
	

	public String getBookId() {
		return BookId;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	public String getBookStatus() {
		return BookStatus;
	}

	public void setBookStatus(String bookStatus) {
		BookStatus = bookStatus;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public void setBookId(String bookId) {
		this.BookId = bookId;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		this.MemberId = memberId;
	}

	public String getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(String issueDate) {
		this.IssueDate = issueDate;
	}

	public String getBookName() {
		return BookName;
	}
}
