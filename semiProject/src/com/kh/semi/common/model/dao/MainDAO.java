package com.kh.semi.common.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.room.model.vo.Room;

public class MainDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = null;
	
	

	/** 인기 숙소 조회 DAO
	 * @param conn
	 * @return roomList
	 * @throws Exception
	 */
	public List<Room> roomList(Connection conn) throws Exception{
		List<Room> roomList = null;
		String query =  "SELECT * FROM ROOM\r\n" + 
				"JOIN ROOM_IMG USING (ROOM_NO)\r\n" + 
				"WHERE ROOM_NO\r\n" + 
				"IN (SELECT ROOM_NO FROM  \r\n" + 
				"	(SELECT ROWNUM RNUM, R.* FROM \r\n" + 
				"		(SELECT ROOM_NO FROM ROOM\r\n" + 
				"		WHERE ROOM_DEL_FL='N'\r\n" + 
				"		 ORDER BY VIEW_COUNT DESC)R)\r\n" + 
				"WHERE RNUM BETWEEN 1 AND 3 )\r\n" + 
				"AND FILE_LEVEL =0\r\n" + 
				"ORDER BY VIEW_COUNT DESC;";
				
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			roomList = new ArrayList<Room>();
			
			while(rset.next()) {
				Room room = new Room();
				
			}
			
		}finally {
			close(rset);
			close(stmt);
			
		}
				
		return roomList;
	}

}
