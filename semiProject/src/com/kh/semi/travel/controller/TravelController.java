package com.kh.semi.travel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.hospital.model.vo.Hospital;
import com.kh.semi.hospital.model.vo.PageInfo;
import com.kh.semi.travel.model.service.TravelService;
import com.kh.semi.travel.model.vo.Travel;

@WebServlet("/travel/*")
public class TravelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI(); // 요청 들어오는 주소 /travel/
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/travel").length());

		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체

		String swalIcon = null; // sweet alert로 메세지 전달하는 용도
		String swalTitle = null;
		String swalText = null;
		String errorMsg = null; // 에러 메세지 전달용 변수

		try {
			TravelService service = new TravelService();
			
			String cp = request.getParameter("cp");
			
			// 지역정보 리스트 조회 Controller **************************************************
			if (command.equals("/localList.do")) {
				errorMsg = "지역정보 리스트 조회 중 오류 발생.";
				
				// 1) 페이징 처리를 위한 값 계산 Service호출
				PageInfo pInfo = service.getPageInfo(cp);
				
				// 2) 게시글 목록 조회 비즈니스 로직 수행
				List<Travel> tList = service.selectTravelList(pInfo);
				// pInfo를 가져가는 이유 = 
				// pInfo에 담겨져있는 currentPage와 limit를 이용해 현재 페이지에 맞는 게시글 목록을 조회하기 위해
				
				
				// 썸네일 추가
				
				
				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/travel/localInfo/localList.jsp";

				request.setAttribute("tList", tList);
				request.setAttribute("pInfo", pInfo);				
				
				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 지역정보 글 상세 조회 Controller **************************************************
			if (command.equals("/localView.do")) {
				errorMsg = "지역정보 글 상세 조회 중 오류 발생.";
				
				// 쿼리스트링으로 전달된 공지사항 번호를 int형으로 파싱(자료형을 바꿈)하여 저장
				int travelNo = Integer.parseInt(request.getParameter("no") );				
				
				// 상세조회 비즈니스 로직 수행 결과 반환
				Travel travel = service.selectTravel(travelNo);
				
				// 조회 결과에 따른 view 연결 처리
				if(travel != null) { // 조회 성공
					path = "/WEB-INF/views/travel/localInfo/localView.jsp";
					request.setAttribute("travel", travel);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				} else { // 조회 실패 했을 때
					HttpSession session = request.getSession();
					session.setAttribute("swalIcon", "error");
					session.setAttribute("swalTitle", "지역정보글 상세 조회 실패");
					response.sendRedirect(request.getHeader("referer"));
				}
			}

			// 지역정보 글쓰기 Controller **************************************************
			if (command.equals("/localInsert.do")) {
				errorMsg = "지역정보 글쓰기 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/travel/localInfo/localInsert.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			
			// ***********************************************************************
			// 관광지 리스트 Controller **************************************************
			if (command.equals("/sightsList.do")) {
				errorMsg = "관광지 리스트 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/travel/sights/sightsList.jsp";

				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 관광지 글쓰기 Controller **************************************************
			if (command.equals("/sightsInsert.do")) {
				errorMsg = "관광지 글쓰기 중 오류 발생.";
				
				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/travel/sights/sightsInsert.jsp";
				
				// 요청 위임 객체 생성 후 위임 진행
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
