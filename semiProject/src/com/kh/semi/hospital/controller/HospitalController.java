package com.kh.semi.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.hospital.model.service.HospitalService;
import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.Image;
import com.kh.semi.hospital.model.vo.PageInfo;

@WebServlet("/hospital/*")
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); //전체 요청 주소
		
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath+"/hospital").length());
		
		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체
		
		// sweet alert 메세지 전달하는 용도
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		String errorMsg = null;
		
		try {
			HospitalService service = new HospitalService();
			
			// 현재 페이지를 얻어와 커리스트링으로 사용할 것.
			// 쿼리스트링은 서버측에서 파라미터로 인식된다.
			String cp = request.getParameter("cp");
			// CurrentPage 사용 이유
			// 1) 페이징 처리 시 계산에 필요한 값이기 때문
			// 2) 효율적인 UI/UX를 제공하기 위해서 사용한다(상세조회/북마크...)
		    // 처음엔 얻어 올 값이 없어서 null 이 된다.
			
			
			
			// 동물병원 목록 조회**************************************
			if(command.equals("/list")) {
				
				errorMsg = "동물병원 목록 조회 중 오류 발생";
								
				
				// 1) 페이징 처리를 위한 값 계산 Service호출
				PageInfo pInfo = service.getPageInfo(cp);
				
				
				// 2) 동물병원 목록 조회 비즈니스 로직 수행
				List<Hospital> hList = service.selectHospitalList(pInfo);
				// pInfo를 가져가는 이유 = 
				// pInfo에 담겨져있는 currentPage와 limit를 이용해 현재 페이지에 맞는 게시글 목록을 조회하기 위해
				
				
				
				
				// 썸네일 추가
				
//				if(hList!=null) {
//					
//					// 조회된 동물병원이 있다면 썸네일이 있는지 확인해보고 있으면 출력한다.
//					List<Image> iList = service.selectThumbnailList(pInfo);
//					
//					if(!iList.isEmpty()) {
//						request.setAttribute("iList", iList);
//					}
//				}
				
				
				path = "/WEB-INF/views/hospital/hospitalList.jsp";
				
				request.setAttribute("hList", hList);
				request.setAttribute("pInfo", pInfo);
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			
			
			
			// 동물병원 상세조회 Controller ******************************
			else if(command.contentEquals("/view")) {
				errorMsg = "게시글 상세 조회 과정에서 오류 발생";
				
				int hospitalNo = Integer.parseInt(request.getParameter("hospitalNo"));
				
				// 상세조회 비즈니스 로직 수행 후 결과 반환받기
				Hospital hospital = service.selectHospital(hospitalNo);
				
				if(hospital!=null) { // 상세조회 성공 시
					
					// 해당 게시글에 포함된 이미지 파일 목록 조회 서비스 호출
															
					
					path ="/WEB-INF/views/hospital/hospitalView.jsp";
					request.setAttribute("hospital", hospital);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}else {
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "동물병원 상세 조회 실패");
					response.sendRedirect("list");
				}
				
				
				
			}
			
			
			
			
			
			
			
			
			
			// 동물병원 등록 화면 전환 **************************************
				else if(command.contentEquals("/insertForm")) {
					path = "/WEB-INF/views/hospital/hospitalInsert.jsp";
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}
			
			
			// 동물병원 등록 **************************************
				else if(command.contentEquals("insert")) {
					errorMsg ="동물병원 등록 과정에서 오류 발생";
					
					// 1. MultipartRequest 객체 생성하기
					// 1-1. 전송 파일 용량 지정(byte단위)
					int maxSize = 20* 1024 * 1024; // 20MB
					
				}
	
			
		}catch(Exception e) {
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			
			// 에러 메세지를 request객체에 담는다
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		}
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
