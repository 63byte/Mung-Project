package com.kh.semi.CSCenter.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.CSCenter.model.vo.PageInfo;
import com.kh.semi.CSCenter.model.vo.NoticeAttachment;
import com.kh.semi.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/notice/*")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();	
		
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath+"/notice").length() );
		
		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null;  // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		
		String errorMsg = null;	// 에러 메세지 전달용 변수
	
		try {
			
			// notice 리스트페이지 이동
			if(command.equals("/notice.do")) {
				errorMsg = "페이지 이동 중 오류발생";
				
				
				
				path = "/WEB-INF/views/notice/NoticeCenter.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			// notice 상세페이지 이동

			else if(command.equals("/noticeView.do")) {
				
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/notice/NoticeCenterView.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
		
			// notice 글쓰기폼 이동
			else if(command.equals("/noticeForm.do")){
				
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/notice/NoticeCenterInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
			}
			
			// notice 수정폼 이동
			else if(command.equals("/noticeUpdateForm.do")){
				
				errorMsg = "페이지 이동 중 오류발생";
				path = "/WEB-INF/views/notice/NoticeCenterUpdate.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			// notice 글쓰거 서버 요청
			else if(command.equals("/noticeInsert.do")) {
				
				
				errorMsg = "공지사항 삽입 과정에서 오류 발생";
				
				int maxSize = 20 * 1024 * 1024; // 20MB = 20 * 1024KB == 20* 1024 * 1024Byte

				String root = request.getSession().getServletContext().getRealPath("/");

				String filePath = root + "resources/image/csCenter";

				
				MultipartRequest multiRequest
				= new MultipartRequest(request,filePath, maxSize,"UTF-8",new MyFileRenamePolicy());
				
				
				List<NoticeAttachment> fList = new ArrayList<NoticeAttachment>();

				Enumeration<String> files = multiRequest.getFileNames();

				while(files.hasMoreElements()) { // 다음 요소가 있다면

				
					String name = files.nextElement(); // img0
	
					if(multiRequest.getFilesystemName(name) != null){
						
						//  Attachment 객체에 파일 정보 저장
						NoticeAttachment temp = new NoticeAttachment();
						
						temp.setNotifileName(multiRequest.getFilesystemName(name));
						temp.setNotifilePath(filePath);
						
						
						// name 속성에 따라 fileLevel 지정
						int fileLevel = 0;
						switch(name) {
						case "img0"  : fileLevel = 0; break;
						case "img1"  : fileLevel = 1; break;
						case "img2"  : fileLevel = 2; break;
						case "img3"  : fileLevel = 3; break;
						}
						
						temp.setNotiFileLevel(fileLevel);
						
						// fList에추가
						fList.add(temp);
					}
					
					
				}
				System.out.println(fList);
			}
			
		
			
			
			
			
			
			
			
			
			
			
			
			
		} catch(Exception e) {
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
