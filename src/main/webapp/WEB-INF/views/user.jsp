<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Insert</title>
<link rel="styleSheet"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<body>

	<%@ include file="header.jsp"%>
	<main>
		<div class="wrapper">
			<form method="post">
				<fieldset style="width: 1000px; height: 600px; overflow: auto;">
					<legend>회원 현황</legend>
					<table
						style="border: 1px solid black; width: 900px; margin: 10px auto;">
						<tr>
							<th></th>
							<th>No.</th>
							<th>이름</th>
							<th>연락처</th>
							<th>쿠폰</th>
							<th>가입일</th>
						</tr>
						<c:forEach var="p" items="${list}">
							<tr>
								<td><input type="checkbox" name="usernum"
									value="${p.usernum }"></td>
								<td>${p.usernum }</td>
								<td>${p.name }</td>
								<td>${p.pnum }</td>
								<td>${p.stamp }</td>
								<td><fmt:formatDate value="${p.registdate }"
										pattern="yyyy-MM-dd" />
							</tr>
						</c:forEach>
					</table>
				</fieldset>
					<div>
						<button>회원 삭제하기</button>
					</div>
			</form>
		</div>
	</main>
</body>
</html>