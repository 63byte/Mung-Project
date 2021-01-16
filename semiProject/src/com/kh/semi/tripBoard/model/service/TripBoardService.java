package com.kh.semi.tripBoard.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.tripBoard.model.dao.TripBoardDAO;
import com.kh.semi.tripBoard.model.vo.PageInfo;
import com.kh.semi.tripBoard.model.vo.TripBoard;

public class TripBoardService {
	
	TripBoardDAO dao = new TripBoardDAO();

	
	
	/** 페이징 처리를 위한 현재 페이지값 얻어오는 Service
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception{
		Connection conn = getConnection();
		
		int currentPage = cp == null ? 1 : Integer.parseInt(cp);
		
		int listCount = dao.getListCount(conn);
		
		close(conn);
		
		return new PageInfo(currentPage, listCount);
		
	}



	/** 전체 게시글 목록 조회 Service
	 * @param pInfo
	 * @return
	 * @throws Exception
	 */
	public List<TripBoard> selectBoardList(PageInfo pInfo) throws Exception{
		Connection conn = getConnection();
		
		List<TripBoard> tList = dao.selectBoardList(conn, pInfo);
		
		close(conn);
		
		return tList;
	}

}
