package com.kh.semi.mypage.vo;

import java.sql.Timestamp;

public class fBoardInquiry {
	private int fBoardNo;
	private String fBoardTitle;
	private Timestamp fBoardCreateDate;
	private int fReadCount;
	private String fBoardDeleteFl;
	private int memberNo;
	
	public fBoardInquiry() {}

	public fBoardInquiry(int fBoardNo, String fBoardTitle, Timestamp fBoardCreateDate, int fReadCount,
			String fBoardDeleteFl, int memberNo) {
		super();
		this.fBoardNo = fBoardNo;
		this.fBoardTitle = fBoardTitle;
		this.fBoardCreateDate = fBoardCreateDate;
		this.fReadCount = fReadCount;
		this.fBoardDeleteFl = fBoardDeleteFl;
		this.memberNo = memberNo;
	}

	public int getfBoardNo() {
		return fBoardNo;
	}

	public void setfBoardNo(int fBoardNo) {
		this.fBoardNo = fBoardNo;
	}

	public String getfBoardTitle() {
		return fBoardTitle;
	}

	public void setfBoardTitle(String fBoardTitle) {
		this.fBoardTitle = fBoardTitle;
	}

	public Timestamp getfBoardCreateDate() {
		return fBoardCreateDate;
	}

	public void setfBoardCreateDate(Timestamp fBoardCreateDate) {
		this.fBoardCreateDate = fBoardCreateDate;
	}

	public int getfReadCount() {
		return fReadCount;
	}

	public void setfReadCount(int fReadCount) {
		this.fReadCount = fReadCount;
	}

	public String getfBoardDeleteFl() {
		return fBoardDeleteFl;
	}

	public void setfBoardDeleteFl(String fBoardDeleteFl) {
		this.fBoardDeleteFl = fBoardDeleteFl;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "fBoardInquiry [fBoardNo=" + fBoardNo + ", fBoardTitle=" + fBoardTitle + ", fBoardCreateDate="
				+ fBoardCreateDate + ", fReadCount=" + fReadCount + ", fBoardDeleteFl=" + fBoardDeleteFl + ", memberNo="
				+ memberNo + "]";
	}
	
	
	
}
