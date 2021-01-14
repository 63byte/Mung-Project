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
           
    	}catch (Exception e) {
    		e.printStackTrace();
   }
  }

	/** 회원가입용 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception{
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
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	
	/** 로그인용 DAO
	 * @param conn
	 * @param member
	 * @return loginMember
	 * @throws Exception
	 */
	public Member loginMember(Connection conn, Member member) throws Exception{
		Member loginMember = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember = new Member(rset.getInt(1),
									rset.getString(2),
									rset.getString(3),
									rset.getString(4),
									rset.getString(5), 
									rset.getString(6), 
									rset.getString(7));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginMember;
	}

}
