<%@page import="java.text.MessageFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Date"%>
<%@page import="services.StringExtender" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Home Page</h1>
	Hello
	<%=StringExtender.CreateName(System.getenv("USERNAME"))%>. Today is
	<%=new Date()%>
</body>
</html>