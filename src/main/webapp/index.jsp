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

</body>
</html>