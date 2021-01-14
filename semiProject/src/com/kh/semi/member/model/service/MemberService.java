package com.kh.semi.member.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.semi.member.model.dao.MemberDAO;
import com.kh.semi.member.model.vo.Member;

public class MemberService {
	private MemberDAO dao = new MemberDAO();

	
	
	
	/** 회원가입용 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		if(result > 0)		commit(conn);
		else				rollback(conn);
		
		close(conn);
		return result;
	}




	/** 로그인용 Service
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Member member) throws Exception{
		Connection conn = getConnection();
		
		Member loginMember = dao.loginMember(conn, member);
		
		close(conn);
		return loginMember;
	}

}
