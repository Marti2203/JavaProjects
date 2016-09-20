<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page: DO NOT PANIC</title>
</head>
<body>
	<h1>ERROR PLEASE DO NOT PANIC</h1>
	<br> Servlet name is
	<%=request.getAttribute("javax.servlet.error.servlet_name")%><br>
	Request URI is
	<%=request.getAttribute("javax.servlet.error.request_uri")%><br>
	Error message is
	<%=request.getAttribute("javax.servlet.error.message")%><br>
	Status code is
	<%=request.getAttribute("javax.servlet.error.status_code")%><br>
	<%=request.getAttribute("javax.servlet.error.exception")==null ? "" 
			: "Exception is"
				+request.getAttribute("javax.servlet.error.exception")
				+" and the stack trace has been written to LatesException.txt" %>
	<br>
</body>
</html>