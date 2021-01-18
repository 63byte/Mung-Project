package com.kh.semi.member.model.vo;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	// private String memberName; 멤버네임 추가해야 할 것 같아요잉 T^T
	private String memberNickName;
	private String email;
	private String phone;
	private String gender;
	private String signDt;
	private String scsnFl;
	private String memberAdmin;
	
	
	
	public Member() {}



	public Member(int memberNo, String memberId, String memberPwd, String memberNickName, String email, String phone,
			String gender, String signDt, String scsnFl, String memberAdmin) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNickName = memberNickName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.signDt = signDt;
		this.scsnFl = scsnFl;
		this.memberAdmin = memberAdmin;
	}
	
	


	// 회원가입용 생성자
	public Member(String memberId, String memberPwd, String memberNickName, String email, String phone, String gender) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNickName = memberNickName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
	}
	
	



	public Member(int memberNo, String memberId, String memberNickName, String email, String phone, String gender,
			String memberAdmin) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberNickName = memberNickName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.memberAdmin = memberAdmin;
	}



	public int getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	public String getMemberNickName() {
		return memberNickName;
	}



	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getSignDt() {
		return signDt;
	}



	public void setSignDt(String signDt) {
		this.signDt = signDt;
	}



	public String getScsnFl() {
		return scsnFl;
	}



	public void setScsnFl(String scsnFl) {
		this.scsnFl = scsnFl;
	}



	public String getMemberAdmin() {
		return memberAdmin;
	}



	public void setMemberAdmin(String memberAdmin) {
		this.memberAdmin = memberAdmin;
	}



	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberNickName=" + memberNickName + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", signDt=" + signDt + ", scsnFl=" + scsnFl + ", memberAdmin=" + memberAdmin + "]";
	}
	
	
}
