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

	/**
	 * 비밀번호 변경 Service
	 * 
	 * @param loginMember
	 * @param newPw1
	 * @param newPw2
	 * @return
	 * @throws Exception
	 */
	public int updatePw(Member loginMember, String newPwd) throws Exception {
		Connection conn = getConnection();

		int result = dao.checkCurrentPw(conn, loginMember);

		if (result > 0) {
			loginMember.setMemberPwd(newPwd);

			result = dao.updatePwd(conn, loginMember);

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} else { // 현재 비밀번호 불일치
			result = -1;
		}

		close(conn);

		return result;
	}

	/**
	 * 회원 탈퇴 (탈퇴 여부 변경) Service
	 * 
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int withdrawal(Member loginMember) throws Exception {
		Connection conn = getConnection();

		int result = dao.checkCurrentPw(conn, loginMember); // 재활용

		if (result > 0) {

			result = dao.withdrawal(conn, loginMember.getMemberNo());

			if (result > 0)
				commit(conn);
			else
				rollback(conn);

		} else {
			// 현재 비밀번호가 일치하지 않을 경우 -1 반환
			result = -1;
		}

		close(conn);

		return result;
	}

}
