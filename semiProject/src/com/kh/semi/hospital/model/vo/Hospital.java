package com.kh.semi.hospital.model.vo;

public class Hospital {
	private int hospNo;
	private String hospNm;
	private String location;
	private String location2;
	private String phone;
	private String openingTime;
	private String closinTime;
	private String hospInfo;
	private int viewCount;
	private int like;
	private char hospDelFl;
	private int memNo;
	
	public Hospital() {}
	
	
//	조회화면 용 생성자
	public Hospital(String hospNm, String location2, String phone, String openingTime, String closinTime) {
		super();
		this.hospNm = hospNm;
		this.location2 = location2;
		this.phone = phone;
		this.openingTime = openingTime;
		this.closinTime = closinTime;
	}
	

	
//	전체 매개변수 생성자
	public Hospital(int hospNo, String hospNm, String location, String location2, String phone, String openingTime,
			String closinTime, String hospInfo, int viewCount, int like, char hospDelFl, int memNo) {
		super();
		this.hospNo = hospNo;
		this.hospNm = hospNm;
		this.location = location;
		this.location2 = location2;
		this.phone = phone;
		this.openingTime = openingTime;
		this.closinTime = closinTime;
		this.hospInfo = hospInfo;
		this.viewCount = viewCount;
		this.like = like;
		this.hospDelFl = hospDelFl;
		this.memNo = memNo;
	}





	public int getHospNo() {
		return hospNo;
	}


	public void setHospNo(int hospNo) {
		this.hospNo = hospNo;
	}


	public String getHospNm() {
		return hospNm;
	}


	public void setHospNm(String hospNm) {
		this.hospNm = hospNm;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getLocation2() {
		return location2;
	}


	public void setLocation2(String location2) {
		this.location2 = location2;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getOpeningTime() {
		return openingTime;
	}


	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}


	public String getClosinTime() {
		return closinTime;
	}


	public void setClosinTime(String closinTime) {
		this.closinTime = closinTime;
	}


	public String getHospInfo() {
		return hospInfo;
	}


	public void setHospInfo(String hospInfo) {
		this.hospInfo = hospInfo;
	}


	public int getViewCount() {
		return viewCount;
	}


	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}


	public int getLike() {
		return like;
	}


	public void setLike(int like) {
		this.like = like;
	}


	public char getHospDelFl() {
		return hospDelFl;
	}


	public void setHospDelFl(char hospDelFl) {
		this.hospDelFl = hospDelFl;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	@Override
	public String toString() {
		return "Hospital [hospNo=" + hospNo + ", hospNm=" + hospNm + ", location=" + location + ", location2="
				+ location2 + ", phone=" + phone + ", openingTime=" + openingTime + ", closinTime=" + closinTime
				+ ", hospInfo=" + hospInfo + ", viewCount=" + viewCount + ", like=" + like + ", hospDelFl=" + hospDelFl
				+ ", memNo=" + memNo + "]";
	}
	
	
}
