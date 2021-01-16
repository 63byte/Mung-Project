package com.kh.semi.tripBoard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.tripBoard.model.service.TripBoardService;
import com.kh.semi.tripBoard.model.vo.PageInfo;
import com.kh.semi.tripBoard.model.vo.TripBoard;


@WebServlet("/tripBoard/*")
public class TripBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring( (contextPath + "/tripBoard").length() );
		
		String path = null;
		
		RequestDispatcher view = null;
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		
		String errorMsg = null;
		
		try {
			TripBoardService service = new TripBoardService();
			
			String cp = request.getParameter("cp");
			
			if(command.equals("/tripList.do")) {
				errorMsg = "게시글 목록 조회 중 오류 발생";
				
				PageInfo pInfo = service.getPageInfo(cp);
				
				List<TripBoard> tList = service.selectBoardList(pInfo);
				
				path = "/WEB-INF/views/tripBoard/tripBoardList.jsp";
				
				request.setAttribute("tList", tList);
				request.setAttribute("pInfo", pInfo);
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("errorMsg", errorMsg);
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
