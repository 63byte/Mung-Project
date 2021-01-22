package com.kh.semi.room.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kh.semi.room.model.vo.Attachment;
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






	/** 숙소 상세조회 Service
	 * @param conn
	 * @param roomNo
	 * @return room
	 * @throws Exception
	 */
	public Room selectRoom(Connection conn, int roomNo) throws Exception {
		Room room = null;
		String query = prop.getProperty("selectRoom");
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, roomNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				room = new Room();
				room.setRoomName(rset.getString("ROOM_NAME"));
				room.setLocation1(rset.getString("LOCATION1"));
				room.setLocation2(rset.getString("LOCATION2"));
				room.setPhone(rset.getString("PHONE"));
				room.setRoomInfo(rset.getString("ROOM_INFO"));
				room.setCheckin(rset.getString("CHECKIN"));
				room.setCheckout(rset.getString("CHECKOUT"));
				room.setFacility(rset.getString("FACILITY"));
				room.setDog(rset.getString("DOG"));
				room.setViewCount(rset.getInt("VIEW_COUNT"));
				
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return room;
	}






	/** 조회 수 증가 DAO
	 * @param conn
	 * @param roomNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int roomNo) throws Exception {
		int result =0;
		
		String query = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, roomNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}






	/** 숙소 다음번호 받아오기 Service
	 * @param conn
	 * @return insertNo
	 * @throws Exception
	 */
	public int selectNextNo(Connection conn) throws Exception {
		int insertNo = 0;
		String query = prop.getProperty("selectNextNo");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				insertNo = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return insertNo;
	}




	
	


	/** 숙소 등록 DAO
	 * @param conn
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int insertRoom(Connection conn, Map<String, Object> map) throws Exception {
		int result =0;
		
		String query = prop.getProperty("insertRoom");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (int)map.get("insertNo"));
			pstmt.setString(2, (String)map.get("roomName"));
			pstmt.setString(3, (String)map.get("location1"));
			pstmt.setString(4, (String)map.get("location2"));
			pstmt.setString(5, (String)map.get("phone"));
			pstmt.setString(6, (String)map.get("roomInfo"));
			pstmt.setString(7, (String)map.get("checkin"));
			pstmt.setString(8, (String)map.get("checkout"));
			pstmt.setString(9, (String)map.get("facility"));
			pstmt.setString(10, (String)map.get("dog"));
			pstmt.setInt(11, (int)map.get("memberNo"));
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}






	/**	파일 정보 등록 DAO
	 * @param conn
	 * @param at
	 * @return result
	 * @throws Exception
	 */
	public int insertAttachment(Connection conn, Attachment at) throws Exception {
		int result =0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, at.getFilePath());
			pstmt.setString(2, at.getFileName());
			pstmt.setInt(3, at.getFileLevel());
			pstmt.setInt(4, at.getRoomNo());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

}
