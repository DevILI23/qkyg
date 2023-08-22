<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html");

	session.setAttribute("previousUrl", request.getRequestURL().toString());
	
	boolean isLogout = true;
	try {
		isLogout = (Boolean)session.getAttribute("isLogout");
	} catch (Exception e) {
		String url = "/group5/signinpage/signin.jsp";
		String script = "<script>location.href='" + url + "';</script>";
		out.println(script);
	}
	
	if(!isLogout) {
			RequestDispatcher rd = request.getRequestDispatcher("/ControllerHelp?command=contactUsForm");
			rd.forward(request, response);
	}
%>
