package com.kh.semi.room.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.room.model.vo.PageInfo;
import com.kh.semi.room.model.vo.Room;

public class RSearchDAO {
	
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
		
		String query = "SELECT COUNT(*) FROM ROOM WHERE ROOM_DEL_FL = 'N' AND " + condition;
		
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


	


	/** 검색된 숙소 목록 조회
	 * @param conn
	 * @param condition
	 * @param pInfo
	 * @return	rList
	 * @throws Exception
	 */
	public List<Room> searchRoomList(Connection conn, String condition, PageInfo pInfo) throws Exception {
		List<Room> rList=null;
		String query = "SELECT ROOM_NO, ROOM_NAME, LOCATION2 FROM" + 
	            "    (SELECT ROWNUM RNUM , R.*" + 
	            "    FROM" + 
	            "        (SELECT * FROM ROOM " + 
	            "        WHERE " + condition +
	            "        AND ROOM_DEL_FL = 'N' ORDER BY ROOM_NO DESC) R )" + 
	            "WHERE RNUM BETWEEN ? AND ?";
		
		
		try {
			
			// SQL 구문 조건절에 대입할 변수 생성 (매 페이지 시작번호 1,7,13... , 매 페이지 끝 번호 6,12,19... )
			int startRow = (pInfo.getCurrentPage()-1) * pInfo.getLimit()+1;
			int endRow = startRow + pInfo.getLimit()-1;
			
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Room>();
			
			while(rset.next()) {
				Room room = new Room(rset.getInt("ROOM_NO"), 
						rset.getString("ROOM_NAME"), rset.getString("LOCATION2"));
				
				rList.add(room);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}

}
