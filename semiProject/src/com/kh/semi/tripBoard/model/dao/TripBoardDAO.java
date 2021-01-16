package com.kh.semi.tripBoard.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.tripBoard.model.vo.PageInfo;
import com.kh.semi.tripBoard.model.vo.TripBoard;

public class TripBoardDAO {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	private Properties prop = null;
	
	
	public TripBoardDAO() {
		String fileName = TripBoardDAO.class.getResource("/com/kh/semi/sql/tripboard/tripBoard-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName)); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	

	/** 전체 게시글 수 반환 DAO
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception{
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
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


	/** 전체 게시글 목록 조회 Service
	 * @param conn
	 * @param pInfo
	 * @return
	 * @throws Exception
	 */
	public List<TripBoard> selectBoardList(Connection conn, PageInfo pInfo) throws Exception{
		List<TripBoard> tList = null;
		
		String query = prop.getProperty("selectBoardList");
		
		
		try {
		int startRow = (pInfo.getCurrentPage() -1) * pInfo.getLimit() + 1;
		int endRow = startRow + pInfo.getLimit() -1 ;
		
		pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		
		rset = pstmt.executeQuery();
		
		tList = new ArrayList<TripBoard>();
		
		while(rset.next()) {
			TripBoard tripBoard = new TripBoard(rset.getInt("TRIP_BOARD_NO"),
									rset.getString("TRIP_BOARD_TITLE"),
									rset.getString("MEM_ID"),
									rset.getInt("TRIP_READ_COUNT"),
									rset.getTimestamp("TRIP_BOARD_DT"));
			tList.add(tripBoard);
			
			}
		
		}finally {
			close(rset);
			close(pstmt);
		}
	
	return tList;
		
		
	}
	
	
	
	

}
