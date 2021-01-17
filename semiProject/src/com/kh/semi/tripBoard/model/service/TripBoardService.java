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



	/** 게시글 상세조회 Service
	 * @param boardNo
	 * @return 
	 * @throws Exception
	 */
	public TripBoard selectBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		TripBoard board = dao.selectBoard(conn, boardNo);
		
		if(board != null) {
			int result = dao.increaseReadCount(conn, boardNo);
			
			if(result > 0) {		
				commit(conn);
				
				board.setReadCount(board.getReadCount() + 1);
				
			}
			else {
				rollback(conn);
			}
			
		}
		
		close(conn);
		
		return board;
	}

}
