<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="styleSheet"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>

	<%@ include file="header.jsp"%>

	<main>
		<div class="wrapper">
			<h1>현재 상품 현황</h1>

			<form method="post">
				<fieldset style="width: 1000px; height: 600px; overflow: auto;">
					<legend>회원 현황</legend>
					<table
						style="width: 900px; margin: 10px auto;">
						<tr style="border-bottom: 1px solid black;">
							<th></th>
							<th>상품명</th>
							<th>현재 수량</th>
							<th>상품 가격</th>
							<th>상품 등록일</th>
							<th></th>
						</tr>
						<c:forEach var="p" items="${list}">
							<tr>
								<td><input type="checkbox" name="name" value="${p.name }">
								</td>
								<td>${p.name }</td>
								<td>${p.amount }</td>
								<td><fmt:formatNumber value="${p.price}" pattern="###,###,###" />원</td>
								<td><fmt:formatDate value="${p.time }" pattern="yyyy-MM-dd" />
								<td><div class="updateBtn"
										onclick="location.href = '${cp}/product/update?name=${p.name}'">수정</div></td>
							</tr>
						</c:forEach>
					</table>
				</fieldset>
				<div>
					<button>제품 삭제하기</button>
				</div>
			</form>
		</div>
	</main>


</body>


</html>
