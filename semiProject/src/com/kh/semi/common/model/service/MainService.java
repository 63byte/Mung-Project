package com.kh.semi.common.model.service;


import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.common.model.dao.MainDAO;
import com.kh.semi.room.model.vo.Room;

public class MainService {

	private MainDAO dao = new MainDAO();
	
	
	/** 메인  인기 숙소 조회 Service
	 * @return room
	 * @throws Exception
	 */
	public List<Room> roomList() throws Exception {
		Connection conn = getConnection();
		
		List<Room> roomList = dao.roomList(conn);
		
		close(conn);
		
		return roomList;
	}

}
