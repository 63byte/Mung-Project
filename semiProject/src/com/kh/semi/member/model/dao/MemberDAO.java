package com.kh.semi.member.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.kh.semi.member.model.vo.Member;

public class MemberDAO {

//  DAO에서 자주 사용되는 JDBC 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = null;

	public MemberDAO() {
//    외부에 저장된 XML 파일로부터 SQL 을 얻어온다. -> 유지보수성 향상
		try {
			String filePath = MemberDAO.class.getResource("/com/kh/semi/sql/member-query.xml").getPath();

			prop = new Properties();
//     k , y 가 둘다 string 자료형
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 회원가입용 DAO
	 * 
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		int result = 0;

		String query = prop.getProperty("signUp");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberNickName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getGender());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);

		}

		return result;
	}

	/**
	 * 로그인용 DAO
	 * 
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception {
		Member loginMember = null;

		String query = prop.getProperty("loginMember");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());

			rset = pstmt.executeQuery();

			if (rset.next()) {
				loginMember = new Member(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7));
			}

		} finally {
			close(rset);
			close(pstmt);
		}

		return loginMember;
	}

	/**
	 * 아이디 중복검사용 DAO
	 * 
	 * @param conn
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String userId) throws Exception {
		int result = 0;

		String query = prop.getProperty("idDupCheck");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}

		} finally {
			close(rset);
			close(pstmt);

		}

		return result;

	}

	/**
	 * 내 정보 수정 DAO
	 * 
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member member) throws Exception {
		int result = 0;

		String query = prop.getProperty("updateMember");

		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getMemberNickName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getMemberNo());

			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 현재 비밀번호 검사 DAO
	 * 
	 * @param conn
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */

	/*
	 * public int checkCurrentPw(Connection conn, Member loginMember) throws
	 * Exception {
	 * 
	 * int result = 0;
	 * 
	 * String query = prop.getProperty("checkCurrentPw");
	 * 
	 * try { pstmt = conn.prepareStatement(query);
	 * 
	 * pstmt.setInt(1, loginMember.getMemberNo()); pstmt.setString(2,
	 * loginMember.getMemberPwd());
	 * 
	 * rset = pstmt.executeQuery();
	 * 
	 * if(rset.next()) { result = rset.getInt(1); //조회 결과가 있을 경우 Member 객체에 조회 내용을
	 * 저장 }
	 * 
	 * } finally { close(rset); close(pstmt); }
	 * 
	 * return result; }
	 */

	/**
	 * 비밀번호 변경 DAO
	 * 
	 * @param conn
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */

	/*
	 * public int updatePw(Connection conn, Member loginMember) throws Exception{
	 * 
	 * int result = 0; String query = prop.getProperty("updatePw");
	 * 
	 * try { pstmt = conn.prepareStatement(query); pstmt.setString(1,
	 * loginMember.getMemberPwd()); pstmt.setInt(2, loginMember.getMemberNo());
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * 
	 * } finally { close(pstmt); }
	 * 
	 * return result; }
	 */
}
