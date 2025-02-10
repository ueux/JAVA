<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css" />
</head>
<body>
	<div class="container">
		<h1>Page Title</h1>
		<h3>Enter your Title here</h3>
		<%@ include file="menu.jsp"%>
	</div>
	<form action="<%=application.getContextPath()%>/third" method="post">
		<input name="message" type="text" placeholder="Enter your name here"/>
		<button>Submit</button>
	</form>
	<script src="<%=application.getContextPath()%>/js/script.js"></script>
</body>
</html>