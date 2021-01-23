package com.kh.semi.room.controller;

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
import com.kh.semi.member.model.vo.Member;
import com.kh.semi.room.model.service.RoomService;
import com.kh.semi.room.model.vo.Attachment;
import com.kh.semi.room.model.vo.PageInfo;
import com.kh.semi.room.model.vo.Room;
import com.oreilly.servlet.MultipartRequest;


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
			
			
			
			
			
			// 숙소 상세조회 Controller **********************************
			else if(command.equals("/view")) {
				errorMsg = "숙소 상세 조회 과정에서 오류 발생";
				
				int roomNo = Integer.parseInt(request.getParameter("roomNo"));
				
				// 상세조회 비즈니스 로직 수행 후 결과 반환받기
				Room room = service.selectRoom(roomNo);
				
				if(room!=null) {
					// 상세조회 성공 시 (파일목록)
					
					
					path ="/WEB-INF/views/room/roomView.jsp";
					request.setAttribute("room", room);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}else {
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "숙소 상세 조회 실패");
					response.sendRedirect("list");
				}
			}
			
			
			
			// 숙소 등록 화면 전환 **************************************
			else if(command.equals("/insertForm")) {
				path = "/WEB-INF/views/room/roomInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			
			// 숙소 등록 *********************************************
			else if(command.equals("/insert")) {
				errorMsg = "숙소 등록 과정에서 오류 발생";
				
				// form태그에서 encType이 multipart/form-data형식이면
				// 기존에 사용하던 request  객체로 파라미터를 얻어올 수 없다.
				
				// 1. MultipartRequest 객체 생성하기
				// 1-1. 전송 파일 용량 지정(byte단위)
				int maxSize = 20* 1024 * 1024; // 20MB
				
				// 1-2. 서버에 업로드된 파일을 저장할 경로 지정
				String root = request.getSession().getServletContext().getRealPath("/");
				
				String filePath = root + "resources/image/uploadRoomImages/";
				
				// 1-3. 파일명 변환을 위한 클래스 작성 (Attachment.java)
				
				// 1-4. MultipartRequest 객체 생성 (객체 생성과 동시에 파라미터로 넘어온 내용 중 파일이 서버에 바로 저장됨)
				MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
				
				// 2. 생성한 객체에서 파일 정보만을 얻어와 별도의 List에 모두 저장
				
				// 2-1. 파일 정보를 모두 저장할 List 객체 생성
				List<Attachment> fList= new ArrayList<Attachment>();
				
				// 2-2. 업로드된 파일의 name 모두 받기
				Enumeration<String> files = multiRequest.getFileNames();
				
				
				// 2-3. 얻어온 Enumeration 객체에 요소를 하나씩 반복 접근, 
				// 업로드된 파일 정보를 Attachment객체에 저장 후 iList에 추가
				
				while(files.hasMoreElements()) { //다음 요소가 있다면
					String name = files.nextElement(); //img0
					
					// 제출받은 file태그 요소 중 업로드된 파일이 있을 경우
					if(multiRequest.getFilesystemName(name)!=null) {
						// Attachment 객체에 파일 정보 저장
						Attachment temp = new Attachment();
						
						temp.setFileName(multiRequest.getFilesystemName(name));
						temp.setFilePath(filePath);
						

						// name 속성에 따라 fileLevel 지정
						int fileLevel =0;
						
						switch(name) {
						case "img0" : fileLevel =0; break;
						case "img1" : fileLevel =1; break;
						case "img2" : fileLevel =2; break;
						case "img3" : fileLevel =3; break;
						case "img4" : fileLevel =4; break;
						case "img5" : fileLevel =5; break;
						
						}
						temp.setFileLevel(fileLevel);
						
						// fList에 추가
						fList.add(temp);
					}
				}// end while
				
				// 3.파일정보를 제외한 게시글 정보를 얻어와 저장하기
				String checkin = multiRequest.getParameter("checkin");
				String checkout = multiRequest.getParameter("checkout");
				
				String[] facilityArr = multiRequest.getParameterValues("facility");
				String facility = null;
				if(facilityArr!=null) { // 숙소 시설 배열이 비어있지 않다면.
					facility= String.join(",", facilityArr);
				}
				
				
				String[] dogArr = multiRequest.getParameterValues("dog");
				String dog = null;
				if(dogArr!=null) { // 견종이 비어있지 않다면.
					dog= String.join(",", dogArr);
				}
				
				
				String roomInfo = multiRequest.getParameter("room_info");
				
				// 세션에서 로그인한 회원의 번호를 얻어옴
				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
				int memberNo = loginMember.getMemberNo();
				
				
				// 업체회원 정보 얻어오기
				Member comMember = service.selectComMember(memberNo);
				request.setAttribute("comMember", comMember);
				
				// 얻어온 변수들을 모두 저장할 Map  생성
				Map<String,Object> map = new HashMap<String,Object>();
				
				map.put("fList",fList);
				map.put("checkin", checkin);
				map.put("checkout", checkout);
				map.put("facility", facility);
				map.put("dog", dog);
				map.put("roomInfo", roomInfo);
				map.put("memberNo", memberNo);
				
				// 4. 게시글 등록 비즈니스 로직 수행 후 결과 반환받기
				int result = service.insertRoom(map);
				
				if(result>0) {// DB에 데이터 등록 성공하면 result에 병원번호가 저장되어 있다.
					swalIcon = "success";
					swalTitle = "숙소 등록 완료."
							+ "	관리자 확인 후 게시글이 등록됩니다.";
					path = "list";
					
					
				} else {
					swalIcon = "error";
					swalTitle ="등록 실패";
					path = "list";
				}
				
				request.getSession().setAttribute("swalIcon", swalIcon);
	        	request.getSession().setAttribute("swalTitle", swalTitle);
	        	 
	        	 response.sendRedirect(path);
				
				
				
			}
			
			// 동물병원 수정 화면 전환 Controller ************
			
			else if(command.equals("/updateForm")) {
				errorMsg ="숙소 수정 화면 불러오는 과정에서 오류 발생";
				
				int roomNo = Integer.parseInt(request.getParameter("roomNo"));
				Room room = service.updateView(roomNo);
				
				if(room!=null) {
					
					List<Attachment> fList = service.selectHospitalFiles(roomNo);
					
					if(!fList.isEmpty()) {
						request.setAttribute("fList", fList);
					}
					path = "/WEB-INF/views/room/roomUpdate.jsp";
					request.setAttribute("room", room);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}else {
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "숙소 수정 화면 전환에 실패했습니다.");
					response.sendRedirect(request.getHeader("referer"));
				}
			}
			
			// 숙소 수정하기 **********************************
			
			else if(command.equals("update")) {
				errorMsg = "숙소 수정 과정에서 오류 발생";
				
				// 1. MultipartRequest 객체 생성에 필요한 값 설정
	        	 int maxSize = 20 * 1024 * 1024; // 최대 크기 20MB
	        	 String root = request.getSession().getServletContext().getRealPath("/");
	        	 String filePath = root + "resources/image/uploadRoomImages/";
	        	 
	        	 // 2. MultipartRequest 객체 생성
	        	 // -> 생성과 동시에 전달받은 파일이 서버에 저장됨
	        	 MultipartRequest multiRequest = new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
	        	// 3.파일정보를 제외한 게시글 정보를 얻어와 저장하기
				String location1 = multiRequest.getParameter("location1");
				String roomName = multiRequest.getParameter("roomName");
				String phone1 = multiRequest.getParameter("phone1");
				String phone2 = multiRequest.getParameter("phone2");
				String phone3 = multiRequest.getParameter("phone2");
				String phone = phone1+"-" + phone2 + "-" + phone3; // 전화번호 합치기
				
				String location2 = multiRequest.getParameter("location2");
				String checkin = multiRequest.getParameter("checkin");
				String checkout = multiRequest.getParameter("checkout");
				
				String[] facilityArr = multiRequest.getParameterValues("facility");
				String facility = null;
				if(facilityArr!=null) { // 숙소 시설 배열이 비어있지 않다면.
					facility= String.join(",", facilityArr);
				}
				
				
				String[] dogArr = multiRequest.getParameterValues("dog");
				String dog = null;
				if(dogArr!=null) { // 견종이 비어있지 않다면.
					dog= String.join(",", dogArr);
				}
				
				
				String roomInfo = multiRequest.getParameter("room_info");
				
				int roomNo = Integer.parseInt(multiRequest.getParameter("roomNo"));
				
				// 4. 전달받은 파일 정보를 List에 저장
				List<Attachment> fList = new ArrayList<Attachment>();
				Enumeration<String> files = multiRequest.getFileNames();
				// input type="file"인 모든 요소의 name 속성 값을 반환받아 files에 저장
				
				
				while(files.hasMoreElements()) {
					// 현재 접근중인 name속성값읇 변수에 저장
					 String name = files.nextElement();
		        		
	        		 // 현재 name 속성이 일치하는 요소로 업로드된 파일이 있다면
	        		 if(multiRequest.getFilesystemName(name) != null) {
	        			 
        			 Attachment temp = new Attachment();
        			 
        			 // 변경된 파일 이름 temp에 저장
        			 temp.setFileName(multiRequest.getFilesystemName(name));
        			 
        			 // 지정한 파일 경로 tmep에 저장
        			 temp.setFilePath(filePath);
        			 
        			 // 해당 게시글 번호 temp에 저장
        			 temp.setRoomNo(roomNo);
        			 
        			 // 파일 레벨 temp에 저장
        			 switch(name) {
        			 case "img0" : temp.setFileLevel(0); break;
        			 case "img1" : temp.setFileLevel(1); break;
        			 case "img2" : temp.setFileLevel(2); break;
        			 case "img3" : temp.setFileLevel(3); break;
        			 case "img4" : temp.setFileLevel(4); break;
        			 case "img5" : temp.setFileLevel(5); break;
        			 }
        			 
        			 // temp를 fList에 추가
        			 fList.add(temp);
        			// 이미지를 변경한 부분들만 fList에 추가가 된다.
        		 }
					
				}
				
				
				
				
			}
			
			
			
			
			
			
			
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
