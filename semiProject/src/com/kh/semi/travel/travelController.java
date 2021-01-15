package com.kh.semi.travel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel/*")
public class travelController extends HttpServlet {
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
//			NoticeService service = new NoticeService();

			// 지역정보 Controller **************************************************
			if (command.equals("/localInfo.do")) {
				errorMsg = "공지사항 목록 조회 중 오류 발생.";

				// 요청을 위임할 경로 jsp 경로 지정
				path = "/WEB-INF/views/travel/localInfo/localInfo.jsp";

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
