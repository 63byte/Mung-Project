package com.kh.semi.room.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.room.model.service.RoomService;
import com.kh.semi.room.model.vo.PageInfo;
import com.kh.semi.room.model.vo.Room;


@WebServlet("/room/*")
public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); //전체 요청 주소
				
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath+"/room").length());
		
		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체
		
		// sweet alert 메세지 전달하는 용도
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		String errorMsg = null;
		
		
		try {
			RoomService service = new RoomService();
			
			// 현재 페이지를 얻어와 커리스트링으로 사용할 것.
			// 쿼리스트링은 서버측에서 파라미터로 인식된다.
			String cp = request.getParameter("cp");
			// CurrentPage 사용 이유
			// 1) 페이징 처리 시 계산에 필요한 값이기 때문
			// 2) 효율적인 UI/UX를 제공하기 위해서 사용한다(상세조회/북마크...)
		    // 처음엔 얻어 올 값이 없어서 null 이 된다.
			
			
			
			// 숙소 목록 조회**************************************
			if(command.equals("/list")) {
				
				errorMsg = "숙소 목록 조회 중 오류 발생";
				
				
				// 1) 페이징 처리를 위한 값 계산 Service호출
				PageInfo pInfo = service.getPageInfo(cp);
				
				// 2) 숙소 목록 조회 비즈니스 로직 수행
				List<Room> rList = service.selectRoomList(pInfo);
				
				
				
				// ************* 썸네일추가 *************

				path = "/WEB-INF/views/room/roomList.jsp";
				request.setAttribute("rList", rList);
				request.setAttribute("pInfo", pInfo);
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			
			
			// 숙소 등록 화면 전환 **************************************
			else if(command.contentEquals("/insertForm")) {
				path = "/WEB-INF/views/room/roomInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
		}catch(Exception e) {
			
		}
		
		
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
