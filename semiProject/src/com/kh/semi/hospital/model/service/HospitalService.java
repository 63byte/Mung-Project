package com.kh.semi.hospital.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.hospital.model.dao.HospitalDAO;
import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.Image;
import com.kh.semi.hospital.model.vo.PageInfo;

public class HospitalService {
	
	
	private HospitalDAO dao = new HospitalDAO();
	
	

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

	
	



	/**	동물병원 목록 조회 Service
	 * @param pInfo
	 * @param location1 
	 * @return	hList
	 * @throws Exception
	 */
	public List<Hospital> selectHospitalList(PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
		
		List<Hospital> hList = dao.selectHospitalList(conn, pInfo);
		
		close(conn);
		return hList;
	}


	


	/** 동물병원 상세조회 Service
	 * @param hospitalNo
	 * @return hospital
	 * @throws Exception
	 */
	public Hospital selectHospital(int hospitalNo) throws Exception {
		Connection conn = getConnection();
		
		Hospital hospital = dao.selectHospital(conn, hospitalNo);
				
		// 상세조회가 성공하면
		if(hospital != null) {
			
			
//			조회 수 증가
			int result = dao.increaseReadCount(conn,hospitalNo);
			
			if(result>0) {
				commit(conn);
//				반환되는 병원 데이터에도 조회수를 1 추가해준다.
				hospital.setViewCount(hospital.getViewCount() +1);
			}
			else rollback(conn);
		}
		
		close(conn);
		return hospital;
	}





 
	/** 동물병원 상세조회 부대시설 목록 Service
	 * @param hospitalNo
	 * @return	facilityList
	 * @throws Exception
	 */
	public List<Hospital> selectFacility(int hospitalNo) throws Exception {
		Connection conn = getConnection();
		
		List<Hospital> facilityList = dao.selectFacility(conn, hospitalNo);
		
		close(conn);
		
		return facilityList;
	}










	

}
