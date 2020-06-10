<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link rel="styleSheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main>
	<div class="wrapper">
		<h1> ${msg }</h1>
		<button onclick="history.go(-1)">뒤로 가기</button>
	</div>
</main>


</body>
</html>
