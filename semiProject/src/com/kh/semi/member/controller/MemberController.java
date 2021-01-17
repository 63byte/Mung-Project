package com.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();	
		
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath+"/member").length() );
		
		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null;  // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체
		
		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;
		
		String errorMsg = null;	// 에러 메세지 전달용 변수
		
		try {
			
			MemberService service = new MemberService();
			
			// ------- 일반회원가입 or 업체회원가입 선택해주는 jsp로 위임 ------
			if(command.equals("/signUpForm.do")) {
				errorMsg = "회원가입 선택 과정에서 문제 발생";
				
				path = "/WEB-INF/views/member/chooseSignUp.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			// ------- 일반 회원가입Form  jsp로 위임
			else if(command.equals("/nomalSignUpForm.do")) {
				errorMsg = "회원가입 과정에서 문제 발생";
				
				path = "/WEB-INF/views/member/nomalSignUpForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// ------- 업체 회원가입Form  jsp로 위임
			else if(command.equals("/companySignUpForm.do")) {
				errorMsg = "회원가입 과정에서 문제 발생";
				
				path = "/WEB-INF/views/member/companySignUpForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			
			// --------- 회원가입 처리 servlcet
			else if(command.equals("/signUp.do")) {
				errorMsg = "회원가입 과정에서 문제 발생";
				
				String memberId = request.getParameter("userId");
				String memberPwd = request.getParameter("pwd1");
				String memberNickName = request.getParameter("userName");
				
				String e1 = request.getParameter("email1");
				String e2 = request.getParameter("email2");
				String email = e1 + "@" + e2;
				
				String phone1 = request.getParameter("phone1");
				String phone2 = request.getParameter("phone2");
				String phone3 = request.getParameter("phone3");

				String phone = phone1 + "-" + phone2 + "-" + phone3;
				
				String gender = request.getParameter("gender");
				
				Member member = new Member(memberId, memberPwd, memberNickName, email, phone, gender);
				
				
				
					int result = service.signUp(member);
					
					if(result > 0) {
						swalIcon = "success";
						swalTitle = "회원가입 성공";
						swalText = memberNickName + "님의 회원가입을 환영합니다.";
					}else {
						swalIcon = "error";
						swalTitle = "회원가입 실패";
						swalText =  "문제가 지속될 경우 고객센터로 문의 바랍니다.";
					}
					
					HttpSession session = request.getSession();
					
					session.setAttribute("swalIcon", swalIcon);
					session.setAttribute("swalTitle", swalTitle);
					session.setAttribute("swalText", swalText);
					
					// 회원가입 진행 후 메인 페이지로 이동 (메인 화면 재요청)
					response.sendRedirect(request.getContextPath());
					
				
			}
			
			// ------- 아이디 중복검사 ajax --------------
				else if(command.equals("/idDupCheck.do")) {
					String userId = request.getParameter("userId");

					int result = service.idDupCheck(userId);
					
					response.getWriter().print(result);
					
				}
			
			// -------- 로그인 jsp로 위임
			else if(command.equals("/loginForm.do")) {
				path = "/WEB-INF/views/member/loginForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// -------- 로그인용 servlet---------------------------------
			else if(command.equals("/login.do")) {
				String memberId = request.getParameter("userId");
				String memberPwd = request.getParameter("userPw");
				String save = request.getParameter("saveId");
				
				Member member = new Member();
				member.setMemberId(memberId);
				member.setMemberPwd(memberPwd);
				
				
					Member loginMember = service.loginMember(member);
					
					
					HttpSession session = request.getSession();
					
					if(loginMember != null) {
						
						session.setMaxInactiveInterval(60*30);
						
						session.setAttribute("loginMember", loginMember);
						
						Cookie cookie = new Cookie("saveId", memberId);
						
						if(save != null) {
							cookie.setMaxAge(60 * 60 * 24 * 7);
						}else {
							cookie.setMaxAge(0);
						}
						
						cookie.setPath(request.getContextPath());
						
						response.addCookie(cookie);
						
					}else {
						session.setAttribute("swalIcon", "error");
						session.setAttribute("swalTitle", "로그인 실패");
						session.setAttribute("swalText", "아이디 또는 비밀번호를 확인해주세요.");
						
					}
					
					response.sendRedirect(request.getContextPath());
				
			}
			// -------------------로그아웃 servlet--------------------------
			else if(command.equals("/logout.do")) {
				request.getSession().invalidate();
				
				response.sendRedirect(request.getContextPath());
			}
			
			// ------------------ 업체 로그인 요청 위임 Servlet --------------
			else if(command.equals("/companySignUp.do")) {
				
				path = "/WEB-INF/views/member/companySignUpForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// ----------------- id, pw 찾기 ------------------------------
			else if(command.equals("/findIdForm.do")) {
				
				path = "/WEB-INF/views/member/findIdForm.jsp";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
