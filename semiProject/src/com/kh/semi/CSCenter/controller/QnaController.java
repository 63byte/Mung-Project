package com.kh.semi.CSCenter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/qna/*")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String uri = request.getRequestURI();	
		
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath+"/qna").length() );
		
		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null;  // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		
		String errorMsg = null;	// 에러 메세지 전달용 변수
	
		
		try {
			
			
			// Q&A 리스트 페이지 이동
			if(command.equals("/qna.do")) {
			
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/qna/QnaCenter.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			
			}
			
			
			// Q&A   상세 페이지 이동
			else if(command.equals("/qnaView.do")) {
			
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/qna/QnaView.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			
			}
			
			// Q&A 글쓰기 이동
			else if(command.equals("/qnaForm.do")) {
			
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/qna/QnaInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			
			}		
			
			// Q&A  질문 수정 이동
			else if(command.equals("/qnaUpdate.do")) {
			
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/qna/QnaUpdate.jsp";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
