<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="styleSheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main>
	<div class="wrapper">
		<h1> 현재 상품 현황 </h1>
		
		<form method="post">
			<table>
				<tr>
					<th>상품명</th>
					<th>현재 수량</th>
					<th>상품 가격</th>
					<th>상품 등록일</th>
				</tr>
				
					<tr>
						<td><strong>${p.name }</strong></td>
						<td><input type="text" name="amount" value="${p.amount }"></td>
						<td><input type="text" name="price" value="${p.price }"></td>
						<td><strong><fmt:formatDate value="${p.time }" pattern="yyyy-MM-dd"/></strong></td>
					</tr>
				
			</table>
			<div>
				<button onclick="location.href = '${cp}/product/update'">제품 수정</button>
			</div>
		</form>
	</div>
</main>


</body>


</html>
