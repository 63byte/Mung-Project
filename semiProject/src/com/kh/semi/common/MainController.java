package com.kh.semi.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.common.model.service.MainService;
import com.kh.semi.room.model.vo.Room;


@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		try {
		
			MainService service = new MainService();
			
			List<Room> roomList = service.roomList();
			
			
			
			request.setAttribute("room",roomList);
			
			
			path = "/index.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request,response);
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
