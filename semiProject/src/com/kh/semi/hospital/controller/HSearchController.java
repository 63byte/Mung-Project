package com.kh.semi.hospital.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.hospital.model.service.HSearchService;
import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.PageInfo;


@WebServlet("/hospital/search")
public class HSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchValue = request.getParameter("sv");
		String cp = request.getParameter("cp");
		
		try {
			HSearchService service = new HSearchService();
			
			Map<String,Object> map  = new HashMap<String,Object>();
			
			map.put("searchValue", searchValue);
			map.put("currentPage", cp);
			
			// 페이징 처리를 위한 데이터를 계산하고 저장하는객체 PageInfo 얻어오기
			PageInfo pInfo = service.getPageInfo(map);
			
			// 검색 게시글 목록 조회
			List<Hospital> hList = service.searchHospitalList(map,pInfo);
			
		}catch(Exception e) {
			
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
