/*package com.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.wsp.member.model.service.MemberService;
import com.kh.wsp.member.model.vo.Member;

@WebServlet("/member/myPageUpdateNormal.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 닉네임
		String memberNickName = request.getParameter("nickName");

		// 이메일
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String memberEmail = email1 + "@" + email2; // 이메일을 '@' 구분자로 하여 하나로 합치기
		
		// 이메일 인증번호
		// ??????????
		
		// 전화번호
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String memberPhone = phone1 + "-" + phone2 + "-" + phone3; // 전화번호를 '-' 구분자로 하여 하나로 합치기

		// 성별
		String memberGender = request.getParameter("gender");
		
		
		// Session에 있는 로그인 정보를 얻어옴. -> 회원번호 사용
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");

		// 얻어온 수정 정보와 회원 번호를 하나의 Member 객체에 저장
		Member member = new Member();
		member.setMemberNo(loginMember.getMemberNo());
		member.setNickName(memberNickName);
		member.setEmail(memberEmail);
		member.setMemberPhone(memberPhone);
		member.setgender(memberGender);

		try {
			// 비즈니스 로직 수행 후 결과 반환
			int result = new MemberService().updateMember(member);

			String swalIcon = null;
			String swalTitle = null;
			String swalText = null;

			// 수정 성공 시
			if (result > 0) {
				swalIcon = "success";
				swalTitle = "회원 정보 수정 성공";
				swalText = "회원 정보가 수정되었습니다.";

				// DB 데이터가 갱신된 경우 Session에 있는 회원 정보도 갱신되어야 한다.

				// 기존 로그인 정보에서 id를 얻어와 갱신에 사용된 member 객체에 저장
				member.setMemberId(loginMember.getMemberId());
				member.setMemberName(loginMember.getMemberName());
				member.setMemberGrade(loginMember.getMemberGrade());
				// -> member 객체가 갱신된 회원 정보를 모두 갖게됨
		
				// Session에 있는 loginMember 정보를 member로 갱신
				session.setAttribute("loginMember", member);

			} else {
				swalIcon = "error";
				swalTitle = "회원 정보 수정 실패";
				swalText = "고객 센터에 문의 바랍니다.";
			}

			session.setAttribute("swalIcon", swalIcon);
			session.setAttribute("swalTitle", swalTitle);
			session.setAttribute("swalText", swalText);

			// 수정 완료 후 다시 내 정보 페이지로 재요청
			response.sendRedirect("myPageUpdateNormal.do");

		} catch (Exception e) {

		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}*/
