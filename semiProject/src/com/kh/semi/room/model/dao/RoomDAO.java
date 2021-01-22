package com.kh.semi.room.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.room.model.vo.PageInfo;
import com.kh.semi.room.model.vo.Room;



public class RoomDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = null;
	
	public RoomDAO() {
		String fileName = RoomDAO.class.getResource("/com/kh/semi/sql/room/room-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

	/** 전체 숙소 수 반환 DAO
	 * @param conn
	 * @return	listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception {
		int listCount =0;
		String query = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()){
				listCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}






	/** 숙소 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @return rList
	 * @throws Exception
	 */
	public List<Room> selectRoomList(Connection conn, PageInfo pInfo) throws Exception {
		List<Room> rList = null;
		String query = prop.getProperty("selectRoomList");
		
		try {
			// SQL 구문 조건절에 대입할 변수 생성
			int startRow = (pInfo.getCurrentPage()-1) * pInfo.getLimit()+1;
			int endRow = startRow + pInfo.getLimit()-1;
			// 7개의 글 중에서 1페이지에 해당하는 글을 가져옴 : 7~2번째의 글만 가져오게 됨.
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,  endRow);
			
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
