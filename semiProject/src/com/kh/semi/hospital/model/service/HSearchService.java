package com.kh.semi.hospital.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.semi.hospital.model.dao.HSearchDAO;
import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.PageInfo;

public class HSearchService {

	private HSearchDAO dao = new HSearchDAO();
	
	
	
	/** 검색 내용이 포함된 페이징 처리 정보 생성 Service
	 * @param map
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		
		String searchValue = (String)map.get("searchValue");
		// 얻어온 파라미터 cp가 null이면 1, 아니면 int형으로 파싱
		map.put("currentPage", (map.get("currentPage")==null)? 1: Integer.parseInt((String)map.get("currentPage")));
		
		// SQL (병원 이름 검색)
		String condition = "HOSP_NM LIKE '%' || '" + searchValue + " '|| '%' "; 
		
		// SQL 조건문을 map에 추가
		map.put("condition", condition);
		
		// DB에서 조건을 만족하는 게시글의 수를 조회하기
		int listCount = dao.getListCount(conn, condition);
		
		close(conn);
		
		return new PageInfo((int)map.get("currentPage"), listCount);
	}



	
	
	/** 검색 게시글 목록 리스트 조회 Service
	 * @param map
	 * @param pInfo
	 * @return hList
	 * @throws Exception
	 */
	public List<Hospital> searchHospitalList(Map<String, Object> map, PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		String searchValue = (String)map.get("searchValue");
		
		String condition = "HOSP_NM LIKE '%' || '" + searchValue + " '|| '%' "; 
		
		List<Hospital> hList = dao.searchHospitalList(conn, pInfo, condition);
		
		
		return null;
	}

}
