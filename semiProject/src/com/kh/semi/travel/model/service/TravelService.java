package com.kh.semi.travel.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.PageInfo;
import com.kh.semi.travel.model.dao.TravelDAO;
import com.kh.semi.travel.model.vo.Travel;

public class TravelService {
	
	private TravelDAO dao = new TravelDAO();

	/** 페이징 처리를 위한 값 계산 Service
	 * @param cp
	 * @return PageInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception {
		Connection conn = getConnection();
		
		// cp가 null일 경우 1, 아니면 cp를 얻어옴.
		int currentPage = cp == null? 1: Integer.parseInt(cp);
		
		// DB에서 전체 게시글 수를 조회하여 반환받기
		int listCount = dao.getListCount(conn);
		
		close(conn);
		
		return new PageInfo(currentPage, listCount);
	}

	/** 여행 지역정보 목록 조회 Service 
	 * @param pInfo
	 * @return tList
	 * @throws Exception
	 */
	public List<Travel> selectTravelList(PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		List<Travel> tList = dao.selectTravelList(conn, pInfo);
		
		close(conn);
		return tList;
	}

	/** 지역정보 글 상세 조회 Service 
	 * @param travelNo
	 * @return
	 * @throws Exception
	 */
	public Travel selectTravel(int travelNo) throws Exception {
		// 1) 커넥션 얻어오기
		Connection conn = getConnection();
		
		// 2) DAO 수행 후 결과 반환
		Travel travel = dao.selectTravel(conn, travelNo);
		System.out.println(travel);
		// 3) 공지사항 조회 성공 시 조회수 증가
		if( travel != null) {
			int result = dao.increaseReadCount(conn, travelNo);
			
			// 트랜잭션 처리
			if(result > 0) {
				commit(conn);
				
				// 이미 조회된 notice에서 readCount 값을 1 증가
				travel.setTravelReadCount( travel.getTravelReadCount() + 1 );
			} else {
				rollback(conn);
			}
		}
		// 4) 커넥션 반환
		close(conn);
		
		return travel;
	}

}
