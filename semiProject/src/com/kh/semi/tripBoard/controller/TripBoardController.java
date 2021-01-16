
package com.kh.semi.tripBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
			if(command.equals("/tripList.do")) {
				
				path = "/WEB-INF/views/tripBoard/tripBoardList.jsp";
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
