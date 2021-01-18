package com.kh.semi.tripBoard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.common.MyFileRenamePolicy;
import com.kh.semi.freeBoard.model.vo.Attachment;
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.tripBoard.model.service.TripBoardService;
import com.kh.semi.tripBoard.model.vo.PageInfo;
import com.kh.semi.tripBoard.model.vo.TripBoard;
import com.oreilly.servlet.MultipartRequest;


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
				
				if(tList != null) {
					// 썸네일 이미지 목록 조회 서비스 호출
					List<Attachment> trList = service.selectThumbnailList(pInfo);
					
					// 썸네일 이미지 목록이 비어있지 않은 경우
					if(!trList.isEmpty()) {
						request.setAttribute("trList", trList);
					}
				}
				
				
				
				path = "/WEB-INF/views/tripBoard/tripBoardList.jsp";
				
				request.setAttribute("tList", tList);
				request.setAttribute("pInfo", pInfo);
				
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// -------------- 여행 후기 게시글 상세조회 Controller -----------------------
			else if(command.equals("/tripView.do")) {
				errorMsg = "게시글 상세 조회 과정에서 오류 발생";
				
				int boardNo = Integer.parseInt(request.getParameter("no"));
				
				TripBoard board = service.selectBoard(boardNo);
				
				if(board != null) {
					
					List<Attachment> trList = service.selectBoardFiles(boardNo);
					
					if(!trList.isEmpty()) {	// 해당 게시글 이미지 정보가 DA에 있을 경우
						request.setAttribute("trList", trList);
					}
					path = "/WEB-INF/views/tripBoard/tripView.jsp";
					request.setAttribute("board", board);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
					// ----------------파일 등록 추가해줘야 됨-------------------------------------

				}else {
					
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "게시글 상세조회 실패");
					response.sendRedirect("tripList.do?cp=1");
				}
			}
			
			// -------------------------게시글 작성 화면 전환 Controller ----------------------------
			else if(command.equals("/insertForm.do")) {
				errorMsg = "게시글 작성 화면 이동 중 문제 발생";
				
				path = "/WEB-INF/views/tripBoard/tripBoardInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			// ------------------------- 게시글 등록 Controller ------------------------------------
			else if(command.equals("/insert.do")) {
				errorMsg = "게시글 등록 과정에서 오류 발생";
				
				int maxSize = 20 * 1024 * 1024;
				
				String root = request.getSession().getServletContext().getRealPath("/");
				String filePath = root + "resources/uploadTripImages/";
				
				MultipartRequest multiRequest 
				= new MultipartRequest(request, filePath, maxSize,
						"UTF-8", new MyFileRenamePolicy());
				
				List<Attachment> trList = new ArrayList<Attachment>();
				
				Enumeration<String> files = multiRequest.getFileNames();
				
					while(files.hasMoreElements()) {
					
					String name = files.nextElement();
					
					if(multiRequest.getFilesystemName(name) != null) {
						
						// Attachment 객체에 파일 정보 저장
						Attachment temp = new Attachment();
						
						temp.setFileName(multiRequest.getFilesystemName(name));
						temp.setFilePath(filePath);
						
						// name 속성에 따라 fileLevel 지정
						int fileLevel = 0;
						switch(name) {
						case "img0" : fileLevel = 0; break;
						case "img1" : fileLevel = 1; break;
						case "img2" : fileLevel = 2; break;
						case "img3" : fileLevel = 3; break;
						case "img4" : fileLevel = 4; break;
						}
						
						temp.setFileLevel(fileLevel);
						
						trList.add(temp);
					}
					
				}
					
					String boardTitle = multiRequest.getParameter("boardTitle");
					String boardContent = multiRequest.getParameter("boardContent");
					
					Member loginMember = (Member)request.getSession().getAttribute("loginMember");
					int boardWriter = loginMember.getMemberNo();
					
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("trList", trList);
					map.put("boardTitle", boardTitle);
					map.put("boardContent", boardContent);
					map.put("boardWriter", boardWriter);
					
					int result = service.insertBoard(map);
					
					if(result > 0) {	// DB 삽입 성공 시 result에는 삽입한 글 번호가 저장되어 있다.
						swalIcon = "success";
						swalTitle = "게시글 등록 성공";
						path = "tripView.do?cp=1&no=" + result;
					}else {
						swalIcon = "error";
						swalTitle = "게시글 등록 실패";
						path = "tripList.do";	// 게시글 목록
					}
					
					request.getSession().setAttribute("swalIcon", swalIcon);
					request.getSession().setAttribute("swalTitle", swalTitle);
					response.sendRedirect(path);
				
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
