package com.kh.semi.room.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.room.model.dao.RoomDAO;
import com.kh.semi.room.model.vo.PageInfo;
import com.kh.semi.room.model.vo.Room;

public class RoomService {
	
	
	private RoomDAO dao = new RoomDAO();
	
	
	

	/** 페이징 처리를 위한 값 계산 Service
	 * @param cp
	 * @return	PageInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception {
		Connection conn = getConnection();
		
		// cp가 null일 경우 1, 아니면 cp를 얻어옴.
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
		
		// System.out.println(currentPage); 동물병원 화면 들어가자마자 1 출력 됨
		
		// DB에서 전체 게시글 수를 조회하여 반환받기
		int listCount = dao.getListCount(conn);
		
		close(conn);
		
		return new PageInfo(currentPage, listCount);
	}




	/** 숙소 목록 조회 Service
	 * @param pInfo
	 * @return rList
	 * @throws Exception
	 */
	public List<Room> selectRoomList(PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		List<Room> rList = dao.selectRoomList(conn,pInfo);
		
		close(conn);
		return rList;
	}




	/** 숙소 상세조회 Service
	 * @param roomNo
	 * @return	room
	 * @throws Exception
	 */
	public Room selectRoomList(int roomNo) throws Exception {
		Connection conn = getConnection();
		
		Room room = dao.selectRoomList(conn, roomNo);
		
		// 상세조회가 성공하면
		if(room!=null) {
			int result = dao.increaseReadCount(conn,roomNo);
			
			if(result>0) {
				commit(conn);
				room.setViewCount(room.getViewCount()+1);
			}
			else  rollback(conn);
		}
		
		close(conn);
		return room;
	}

}
