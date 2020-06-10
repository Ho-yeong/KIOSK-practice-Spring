<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<link rel="styleSheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<script type="text/javascript">

	function test1() {
		
		const userid = document.getElementById('userid').value;
		const userpw = document.getElementById('userpw').value;
		
		var request = new XMLHttpRequest();
		request.open("POST", "${pageContext.request.contextPath}/?userid=" + userid + "&userpw=" + userpw);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				alert("로그인 성공!");
				const login = document.getElementById('login');
				login.style.display = 'none'
				
			} else {
				alert("로그인 실패");
			}
		}
		request.send();
		
	}
</script>
<body>

<%@ include file="header.jsp" %>

<main>
	<div class="wrapper">
		<h1> ITBANK KIOSK 점주님 환영합니다.</h1>
	</div>
</main>

<c:if test="${empty login}">
	<aside id="login" style="display : block;">
		<div class="loginForm">
			<div>ID : admin, PW : admin</div>
			<form method="post">
				<input type="text" name="userid" placeholder="ID" id="userid" required>
				<input type="password" name="userpw" placeholder="PW" id="userpw" required>
				<input type="button" value="LOG IN" onclick="test1()">
			</form>
		</div>
	</aside>
</c:if>

</body>
</html>
