package com.kh.semi.CSCenter.model.vo;

import java.sql.Timestamp;

public class Faq {

	private int faqNo;
	private String faqTitle;
	private String faqContent;
	private Timestamp faqCreateDt;
	private String faqFl;
	private int faqReadCount;
	private int memNo;
	private String memId;
	public Faq() {
		
	}
	
	
	public Faq(int faqNo, String faqTitle, Timestamp faqCreateDt, int faqReadCount, int memNo) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqCreateDt = faqCreateDt;
		this.faqReadCount = faqReadCount;
		this.memNo = memNo;
	}


	public Faq(int faqNo, String faqTitle, String faqContent, Timestamp faqCreateDt, String faqFl, int faqReadCount,
			int memNo, String memId) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqCreateDt = faqCreateDt;
		this.faqFl = faqFl;
		this.faqReadCount = faqReadCount;
		this.memNo = memNo;
		this.memId = memId;
	}


	public int getFaqNo() {
		return faqNo;
	}


	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}


	public String getFaqTitle() {
		return faqTitle;
	}


	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}


	public String getFaqContent() {
		return faqContent;
	}


	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}


	public Timestamp getFaqCreateDt() {
		return faqCreateDt;
	}


	public void setFaqCreateDt(Timestamp faqCreateDt) {
		this.faqCreateDt = faqCreateDt;
	}


	public String getFaqFl() {
		return faqFl;
	}


	public void setFaqFl(String faqFl) {
		this.faqFl = faqFl;
	}


	public int getFaqReadCount() {
		return faqReadCount;
	}


	public void setFaqReadCount(int faqReadCount) {
		this.faqReadCount = faqReadCount;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", faqCreateDt="
				+ faqCreateDt + ", faqFl=" + faqFl + ", faqReadCount=" + faqReadCount + ", memNo=" + memNo + ", memId="
				+ memId + "]";
	}
  
	

}
