<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String str="Welcome to jsp"; %>
<h1><%= str %></h1>
<h2>Aaj ka samay <%=LocalTime.now()%></h2>
<%
for (int i=1;i<11;i++){
%>
	<div><p>2 * <%= i %> = <%= 2*i %></p></div>
<%
} 
%>

<% String agent =  request.getHeader("user-agent"); %>
<h1>you are currently using <%= agent %>></h1>

<%
response.addHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Cache-Control", "pre-check=0, post-check=0");
response.setDateHeader("Expires", 0);
%>

</body>
</html>