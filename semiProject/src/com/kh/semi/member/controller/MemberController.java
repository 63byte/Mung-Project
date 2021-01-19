package com.kh.semi.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		String contextPath = request.getContextPath();

		String command = uri.substring((contextPath + "/member").length());

		// 컨트롤러 내에서 공용으로 사용할 변수 미리 선언
		String path = null; // forward 또는 redirect 경로를 저장할 변수
		RequestDispatcher view = null; // 요청 위임 객체

		String swalIcon = null;
		String swalTitle = null;
		String swalText = null;

		String errorMsg = null; // 에러 메세지 전달용 변수

		try {

			MemberService service = new MemberService();

			// ------- 일반회원가입 or 업체회원가입 선택해주는 jsp로 위임 ------
			if (command.equals("/signUpForm.do")) {
				errorMsg = "회원가입 선택 과정에서 문제 발생";

				path = "/WEB-INF/views/member/chooseSignUp.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}

			// ------- 일반 회원가입Form jsp로 위임
			else if (command.equals("/nomalSignUpForm.do")) {
				errorMsg = "회원가입 과정에서 문제 발생";

				path = "/WEB-INF/views/member/nomalSignUpForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			// ------- 업체 회원가입Form jsp로 위임
			else if (command.equals("/companySignUpForm.do")) {
				errorMsg = "회원가입 과정에서 문제 발생";

				path = "/WEB-INF/views/member/companySignUpForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			// --------- 회원가입 처리 servlcet
			else if (command.equals("/signUp.do")) {
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

				if (result > 0) {
					swalIcon = "success";
					swalTitle = "회원가입 성공";
					swalText = memberNickName + "님의 회원가입을 환영합니다.";
				} else {
					swalIcon = "error";
					swalTitle = "회원가입 실패";
					swalText = "문제가 지속될 경우 고객센터로 문의 바랍니다.";
				}

				HttpSession session = request.getSession();

				session.setAttribute("swalIcon", swalIcon);
				session.setAttribute("swalTitle", swalTitle);
				session.setAttribute("swalText", swalText);

				// 회원가입 진행 후 메인 페이지로 이동 (메인 화면 재요청)
				response.sendRedirect(request.getContextPath());

			}

			// ------- 아이디 중복검사 ajax --------------
			else if (command.equals("/idDupCheck.do")) {
				String userId = request.getParameter("userId");

				int result = service.idDupCheck(userId);

				response.getWriter().print(result);

			}

			// -------- 로그인 jsp로 위임
			else if (command.equals("/loginForm.do")) {
				path = "/WEB-INF/views/member/loginForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			// -------- 로그인용 servlet---------------------------------
			else if (command.equals("/login.do")) {
				String memberId = request.getParameter("userId");
				String memberPwd = request.getParameter("userPw");
				String save = request.getParameter("saveId");

				Member member = new Member();
				member.setMemberId(memberId);
				member.setMemberPwd(memberPwd);

				Member loginMember = service.loginMember(member);

				HttpSession session = request.getSession();

				if (loginMember != null) {

					session.setMaxInactiveInterval(60 * 30);

					session.setAttribute("loginMember", loginMember);

					Cookie cookie = new Cookie("saveId", memberId);

					if (save != null) {
						cookie.setMaxAge(60 * 60 * 24 * 7);
					} else {
						cookie.setMaxAge(0);
					}

					cookie.setPath(request.getContextPath());

					response.addCookie(cookie);

				} else {
					session.setAttribute("swalIcon", "error");
					session.setAttribute("swalTitle", "로그인 실패");
					session.setAttribute("swalText", "아이디 또는 비밀번호를 확인해주세요.");

				}

				response.sendRedirect(request.getContextPath());

			}
			// -------------------로그아웃 servlet--------------------------
			else if (command.equals("/logout.do")) {
				request.getSession().invalidate();

				response.sendRedirect(request.getContextPath());
			}

			// ------------------ 업체 로그인 요청 위임 Servlet --------------
			else if (command.equals("/companySignUp.do")) {

				path = "/WEB-INF/views/member/companySignUpForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}

			// ----------------- id, pw 찾기 ------------------------------
			else if (command.equals("/findIdForm.do")) {

				path = "/WEB-INF/views/member/findIdForm.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}
			
			
			// ------------------ id 찾기 인증번호 발송 Controller -----------------------
			else if(command.equals("/CheckMail")) {
				
				  final String user   = "pjh87973158@gmail.com";
				  final String password  = "pjh1218714";

				  String to = request.getParameter("mail");
				  String mTitle = "[뭉개뭉개] 아이디 찾기 인증.";
				  
				  Map<String, Object> map = new HashMap<>();
				  Random random = new Random();
				  String key = "";
				  
				  for (int i = 0; i < 3; i++) {
						int index = random.nextInt(25) + 65; // A~Z까지 랜덤 알파벳 생성
						key += (char) index;
					}
					int numIndex = random.nextInt(8999) + 1000; // 4자리 정수를 생성
					key += numIndex;
				  
				  
				  // Get the session object
				  Properties props = new Properties();
				  props.put("mail.smtp.host", "smtp.gmail.com");
				  props.put("mail.smtp.port", 465);
				  props.put("mail.smtp.auth", "true");
				  props.put("mail.smtp.ssl.enable", "true");
				  props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

				  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				   protected PasswordAuthentication getPasswordAuthentication() {
				    return new PasswordAuthentication(user, password);
				   }
				  });

				  // Compose the message
				  
				   MimeMessage message = new MimeMessage(session);
				   message.setFrom(new InternetAddress(user));
				   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				   // Subject
				   message.setSubject(mTitle);
				   
				   // Text
				   message.setText("뭉개뭉개에서 보내드리는 아이디 찾기용 인증 번호 : " + key);

				   // send the message
				   Transport.send(message);
				   
				   map.put("key", key);
				   response.getWriter().print(map);

			}
			
			// ------------- 아이디 찾기 결과, Form 전환 Controller ------------------
			else if(command.equals("/findIdResultForm.do")) {
				errorMsg = "아이디 찾기중 오류 발생";
				
				String nickName = request.getParameter("userName");
				String email = request.getParameter("mail");
				
				Member member = new Member();
				member.setMemberNickName(nickName);
				member.setEmail(email);
				
				Member findMember = service.findIdResult(member);
				
				if(findMember != null) {
					path = "/WEB-INF/views/member/findIdResultForm.jsp";
					
					request.setAttribute("findMember", findMember);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
				}else {
					request.getSession().setAttribute("swalIcon", "error");
					request.getSession().setAttribute("swalTitle", "아이디찾기 실패");
					response.sendRedirect(request.getHeader("referer"));
				}
				
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
