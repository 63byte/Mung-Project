package com.kh.semi.CSCenter.model.vo;

import java.sql.Timestamp;

public class Notice {

	private int notice_no;
	private String notice_title;
	private String notice_content;
	private Timestamp create_dt;
	private int notice_readCount;
	
	private char notice_delFl;
	private int mem_no;
	
	public Notice() {
	}

	public Notice(int notice_no, String notice_title, String notice_content, Timestamp create_dt, int notice_readCount,
			char notice_delFl, int mem_no) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.create_dt = create_dt;
		this.notice_readCount = notice_readCount;
		this.notice_delFl = notice_delFl;
		this.mem_no = mem_no;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Timestamp getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(Timestamp create_dt) {
		this.create_dt = create_dt;
	}

	public int getNotice_readCount() {
		return notice_readCount;
	}

	public void setNotice_readCount(int notice_readCount) {
		this.notice_readCount = notice_readCount;
	}

	public char getNotice_delFl() {
		return notice_delFl;
	}

	public void setNotice_delFl(char notice_delFl) {
		this.notice_delFl = notice_delFl;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", create_dt=" + create_dt + ", notice_readCount=" + notice_readCount
				+ ", notice_delFl=" + notice_delFl + ", mem_no=" + mem_no + "]";
	}

	
}
