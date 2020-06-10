<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Insert</title>
<link rel="styleSheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main>
	<div class="wrapper">
		<h2>회원 등록</h2>
		<form method="post">
			<p>회원명 : <input name="name" required></p>
			<p>전화번호 : <input name="pnum" min="13" maxlength="13" required onkeyup="inputPhoneNumber(this)"></p>
			<p><input type="submit" value="등록"></p>
		</form>
	</div>
</main>

</body>

<script>
function inputPhoneNumber(obj) {



    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";



    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}
</script>
</html>