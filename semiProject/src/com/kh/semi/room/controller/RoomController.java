package com.kh.semi.room.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.hospital.model.service.HospitalService;
import com.kh.semi.room.model.service.RoomService;


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
			
			// 숙소 목록 조회**************************************
			if(command.equals("/list")) {
				
				errorMsg = "숙소 목록 조회 중 오류 발생";
				
				path = "/WEB-INF/views/room/roomList.jsp";
				
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
