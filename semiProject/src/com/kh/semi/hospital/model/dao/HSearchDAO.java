package com.kh.semi.hospital.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.PageInfo;

public class HSearchDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;

	
	
	/** 조건을 만족하는 게시글 수 조회 DAO
	 * @param conn
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, String condition) throws Exception {
		int listCount =0;
		
		String query = "SELECT COUNT(*) FROM V_HOSP WHERE HOSP_DEL_FL = 'N' AND " + condition;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}


	




	/** 검색된 동물병원 목록 조회 
	 * @param conn
	 * @param condition
	 * @param pInfo
	 * @returnh hList
	 * @throws Exception
	 */
	public List<Hospital> searchHospitalList(Connection conn, String condition, PageInfo pInfo) throws Exception {
		
		List<Hospital> hList=null;
		String query = "SELECT HOSP_NO, HOSP_NM, LOCATION2, PHONE, OPENING_TIME, CLOSING_TIME FROM" + 
	            "    (SELECT ROWNUM RNUM , H.*" + 
	            "    FROM" + 
	            "        (SELECT * FROM HOSPITAL " + 
	            "        WHERE " + condition +
	            "        AND HOSP_DEL_FL = 'N' ORDER BY HOSP_NO DESC) H )" + 
	            "WHERE RNUM BETWEEN ? AND ?";
		
		
		try {
			
			// SQL 구문 조건절에 대입할 변수 생성 (매 페이지 시작번호 1,7,13... , 매 페이지 끝 번호 6,12,19... )
			int startRow = (pInfo.getCurrentPage()-1) * pInfo.getLimit()+1;
			int endRow = startRow + pInfo.getLimit()-1;
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			hList = new ArrayList<Hospital>();
			
			while(rset.next()) {
				Hospital hospital = new Hospital(rset.getInt("HOSP_NO"), 
						rset.getString("HOSP_NM"), rset.getString("LOCATION2"), 
						rset.getString("PHONE"), rset.getString("OPENING_TIME"), 
								rset.getString("CLOSING_TIME"));
				
				hList.add(hospital);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return hList;
	}


}