package com.kh.semi.travel.model.vo;

public class travelAttachment {
	private int travelImgNo; // 지역정보 이미지 번호
	private String travelImgPath; // 지역정보 이미지 경로
	private String travelImgName; // 지역정보 이미지 이름
	private int travelImgLevel; // 지역정보 이미지 레벨
	private int travelNo; // 게시글 번호
	
	public travelAttachment() { }

	
	
	
	@Override
	public String toString() {
		return "travelAttachment [travelImgNo=" + travelImgNo + ", travelImgPath=" + travelImgPath + ", travelImgName="
				+ travelImgName + ", travelImgLevel=" + travelImgLevel + ", travelNo=" + travelNo + "]";
	}

	public travelAttachment(int travelImgNo, String travelImgPath, String travelImgName, int travelImgLevel,
			int travelNo) {
		super();
		this.travelImgNo = travelImgNo;
		this.travelImgPath = travelImgPath;
		this.travelImgName = travelImgName;
		this.travelImgLevel = travelImgLevel;
		this.travelNo = travelNo;
	}


	public int getTravelImgNo() {
		return travelImgNo;
	}

	public void setTravelImgNo(int travelImgNo) {
		this.travelImgNo = travelImgNo;
	}

	public String getTravelImgPath() {
		return travelImgPath;
	}

	public void setTravelImgPath(String travelImgPath) {
		this.travelImgPath = travelImgPath;
	}

	public String getTravelImgName() {
		return travelImgName;
	}

	public void setTravelImgName(String travelImgName) {
		this.travelImgName = travelImgName;
	}

	public int getTravelImgLevel() {
		return travelImgLevel;
	}

	public void setTravelImgLevel(int travelImgLevel) {
		this.travelImgLevel = travelImgLevel;
	}

	public int getTravelNo() {
		return travelNo;
	}

	public void setTravelNo(int travelNo) {
		this.travelNo = travelNo;
	}
	
	
}
