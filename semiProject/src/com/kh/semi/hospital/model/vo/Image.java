package com.kh.semi.hospital.model.vo;

public class Image {
	private int hospImgNo;
	private String hospImgPath;
	private String hospImgName;
	private int hospImgLevel;
	private int hospNo;
	
	public Image() {}

	public Image(int hospImgNo, String hospImgPath, String hospImgName, int hospImgLevel, int hospNo) {
		super();
		this.hospImgNo = hospImgNo;
		this.hospImgPath = hospImgPath;
		this.hospImgName = hospImgName;
		this.hospImgLevel = hospImgLevel;
		this.hospNo = hospNo;
	}

	public int getHospImgNo() {
		return hospImgNo;
	}

	public void setHospImgNo(int hospImgNo) {
		this.hospImgNo = hospImgNo;
	}

	public String getHospImgPath() {
		return hospImgPath;
	}

	public void setHospImgPath(String hospImgPath) {
		this.hospImgPath = hospImgPath;
	}

	public String getHospImgName() {
		return hospImgName;
	}

	public void setHospImgName(String hospImgName) {
		this.hospImgName = hospImgName;
	}

	public int getHospImgLevel() {
		return hospImgLevel;
	}

	public void setHospImgLevel(int hospImgLevel) {
		this.hospImgLevel = hospImgLevel;
	}

	public int getHospNo() {
		return hospNo;
	}

	public void setHospNo(int hospNo) {
		this.hospNo = hospNo;
	}

	@Override
	public String toString() {
		return "Image [hospImgNo=" + hospImgNo + ", hospImgPath=" + hospImgPath + ", hospImgName=" + hospImgName
				+ ", hospImgLevel=" + hospImgLevel + ", hospNo=" + hospNo + "]";
	}
	
	
	
	

}
