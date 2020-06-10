<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h2>상품 등록</h2>
		<form method="POST">
			<p>상품명 : <input name="name" required></p>
			<p>상품수량 : <input name="amount" required></p>
			<p>상품가격 (원) : <input name="price" onkeyup="inputNumberFormat(this)" required></p>
			<p><input type="submit" value="등록"></p>
		</form>
	</div>
</main>


</body>

<script>
    function inputNumberFormat(obj) {
    obj.value = comma(uncomma(obj.value));
}

function comma(str) {
    str = String(str);
    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
    str = String(str);
    return str.replace(/[^\d]+/g, '');
}
</script>


</html>