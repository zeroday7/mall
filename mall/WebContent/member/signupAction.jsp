<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dao.*" %>
<%@ page import = "vo.*" %>
<%
	// 로그인 중임에도 이 파일을 접근했을때 ....
	if(session.getAttribute("loginMemberEmail") != null) {
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return;
	}
	
	request.setCharacterEncoding("utf-8");
	String memberEmail = request.getParameter("memberEmail");
	String memberPw = request.getParameter("memberPw");
	String memberName = request.getParameter("memberName");
	
	// 사용가능한 이메일 인지...
	MemberDao memberDao = new MemberDao();
	Member member = memberDao.selectMemberEmailCk(memberEmail); // 가입 이메일 체크 메서드 호출
	if(member != null) {
		System.out.println("이미 사용중인 이메일 입니다");
		response.sendRedirect(request.getContextPath()+"/member/signup.jsp");
		return;
	}
	
	Member paramMember = new Member();
	paramMember.memberEamil = memberEmail;
	paramMember.memberPw = memberPw;
	paramMember.memberName = memberName;
	memberDao.insertMember(paramMember); // 회원가입 메서드 호출
	
	response.sendRedirect(request.getContextPath()+"/member/login.jsp");
%>