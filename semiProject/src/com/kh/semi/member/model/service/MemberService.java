package com.kh.semi.member.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.semi.member.model.dao.MemberDAO;
import com.kh.semi.member.model.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	/**
	 * 회원가입용 Service
	 * 
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {
		Connection conn = getConnection();

		int result = dao.signUp(conn, member);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	/**
	 * 로그인용 Service
	 * 
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception {
		Connection conn = getConnection();

		Member loginMember = dao.loginMember(conn, member);

		close(conn);
		return loginMember;
	}

	/**
	 * 아이디 중복 검사용 Service
	 * 
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String userId) throws Exception {

		Connection conn = getConnection();

		int result = dao.idDupCheck(conn, userId);

		close(conn);

		return result;
	}

	/**
	 * 내 정보 수정 Service
	 * 
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member member) throws Exception {
		Connection conn = getConnection();

		int result = dao.updateMember(conn, member);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	
	/** 비밀번호 변경 Service
	 * @param loginMember
	 * @param newPw1
	 * @param newPw2
	 * @return
	 * @throws Exception
	 */
	public int updatePw(Member loginMember, String newPwd) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.checkCurrentPw(conn, loginMember);
		
		if(result > 0) {
			loginMember.setMemberPwd(newPwd);
			
			result = dao.updatePwd(conn, loginMember);
			
			if(result > 0)		commit(conn);
			else				rollback(conn);
			
			
		}else {	// 현재 비밀번호 불일치
			result = -1;
		}
		
		close(conn);
		
		return result;
	}

	/**
	 * 비밀번호 변경 Service
	 * 
	 * @param loginMember
	 * @param newPw1
	 * @param newPw2
	 * @return result
	 * @throws Exception
	 */
	/*
	 * public int updatePw(Member loginMember, String newPw1, String newPw2) throws
	 * Exception {
	 * 
	 * Connection conn = getConnection();
	 * 
	 * // 1) 현재 비밀번호가 일치하는지 검사 int result = dao.checkCurrentPw(conn, loginMember);
	 * 
	 * // 2) 현재 비밀번호 일치 시 새 비밀번호로 수정 if(result > 0) { // 현재 비밀번호가 일치하는 경우
	 * 
	 * // loginMember 비밀번호 필드에 newPwd를 세팅하여 재활용 loginMember.setMemberPwd(newPw1);
	 * loginMember.setMemberPwd(newPw2);
	 * 
	 * result = dao.updatePw(conn, loginMember);
	 * 
	 * if(result > 0) commit(conn); else rollback(conn);
	 * 
	 * } else { // 현재 비밀번호 불일치 result = -1; }
	 * 
	 * close(conn);
	 * 
	 * return result; }
	 */

}
