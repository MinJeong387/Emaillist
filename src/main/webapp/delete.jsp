<%@page import="learnbyteaching.emaillist.dao.EmailListDaoImpl"%>
<%@page import="learnbyteaching.emaillist.dao.EmailListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ServletContext context = getServletContext();
String dbUser = context.getInitParameter("dbUser");
String dbPass = context.getInitParameter("dbPass");

// 폼 데이터 받아오기
String no = request.getParameter("no");

EmailListDao dao = new EmailListDaoImpl(dbUser, dbPass);
dao.delete(Long.valueOf(no));

// Redirect (3xx)
response.sendRedirect("index.jsp");
%>