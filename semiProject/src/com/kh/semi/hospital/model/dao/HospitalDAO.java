package com.kh.semi.hospital.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.PageInfo;

public class HospitalDAO {
	
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = null;
	
	public HospitalDAO() {
		String fileName = HospitalDAO.class.getResource("/com/kh/semi/sql/hospital/hospital-query.xml").getPath();
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream(fileName));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/** 전체 동물병원 수 반환 DAO
	 * @param conn
	 * @return listCount
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




	/** 동물병원 목록 조회 DAO
	 * @param conn
	 * @param pInfo
	 * @return
	 * @throws Exception
	 */
	public List<Hospital> selectHospitalList(Connection conn, PageInfo pInfo) throws Exception {
		List<Hospital> hList = null;
		String query = prop.getProperty("selectHospitalList");
		
		try {
			// SQL 구문 조건절에 대입할 변수 생성
			int startRow = (pInfo.getCurrentPage()-1) * pInfo.getLimit()+1;
			int endRow = startRow + pInfo.getLimit()-1;
			// 7개의 글 중에서 1페이지에 해당하는 글을 가져옴 : 7~2번째의 글만 가져오게 됨.
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,  endRow);
			
			rset = pstmt.executeQuery();
			
			hList = new ArrayList<Hospital>();
			
			while(rset.next()) {
				Hospital hospital = new Hospital(rset.getString("HOSP_NM"), 
						rset.getString("LOCATION2"), rset.getString("PHONE"), 
						rset.getString("OPENING_TIME"), rset.getString("CLOSING_TIME"));
				hList.add(hospital);		
			}
			
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return hList;
	}



	/** 동물병원 상세조회 Service
	 * @param conn
	 * @param hospitalNo
	 * @return hospital
	 * @throws Exception
	 */
	public Hospital selectHospital(Connection conn, int hospitalNo) throws Exception {
		Hospital hospital = null;
		
		String query = prop.getProperty("selectHospital");
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, hospitalNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				hospital = new Hospital();
				hospital.setHospNm(rset.getString("HOSP_NM"));
				hospital.setLocation2(rset.getString("LOCATION2"));
				hospital.setPhone(rset.getString("PHONE"));
				hospital.setOpeningTime(rset.getString("OPENING_TIME"));
				hospital.setClosingTime(rset.getString("CLOSING_TIME"));
				hospital.setHospInfo(rset.getString("HOSP_INFO"));
				hospital.setViewCount(rset.getInt("VIEW_COUNT"));
				hospital.setWifi(rset.getString("WIFI"));
				hospital.setParking(rset.getString("PARKING"));
				hospital.setAppointment(rset.getString("APPOINTMENT"));
				hospital.setFullTime(rset.getString("FULL_TIME"));
				
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return hospital;
	}

	

	

	/** 조회 수 증가 DAO
	 * @param conn
	 * @param hospitalNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int hospitalNo)throws Exception {
		int result =0;
		
		String query = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, hospitalNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
