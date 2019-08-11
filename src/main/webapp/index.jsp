<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>teste</title>
</head>
<body>

<h1>horas : <%= new SimpleDateFormat("hh:mm:ss").format(new Date())  %></h1>
<%
	
	out.println("a");
	int dia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
	int mes = Integer.parseInt((new SimpleDateFormat("M")).format(new Date()));
	int ano = Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date()));
	
	if(mes==8){
		out.println("teste");
	}
	 
	
%>
<br>
<%= new Date()%>
</body>
</html>