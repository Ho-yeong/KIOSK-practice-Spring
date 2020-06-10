<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales Insert</title>
<link rel="styleSheet"
	href="${pageContext.request.contextPath }/css/style.css">
</head>
<script type="text/javascript">
	function doOpenCheck(chk) {
		var obj = document.getElementsByName("cancel");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != chk) {
				obj[i].checked = false;
			}
		}
	}
	
</script>

<body>

	<%@ include file="header.jsp"%>


	<main>
		<div class="wrapper">
			<form method="post">
				<fieldset style="width: 1000px; height: 400px; overflow: auto;">
					<legend>매출 현황</legend>
					<table
						style="border: 1px solid black; width: 900px; margin: 10px auto; border-collapse : collapse;">
						<tr>
							<th></th>
							<th>결제처리</th>
							<th>판매일</th>
							<th>상품명</th>
							<th>판매 수량</th>
							<th>판매 가격</th>
							<th>구매자</th>
						</tr>
						<c:forEach var="p" items="${list}">
							<tr style="border-bottom : 1px solid #c6c6c6; height: 35px;">
								<c:if test="${fn:trim(p.result) eq '정상처리'}">
									<td><input type="checkbox" name="cancel" value='${p.time}'
										onclick="doOpenCheck(this)"></td>
								</c:if>
								<c:if test="${fn:trim(p.result) ne '정상처리'}">
									<td></td>
								</c:if>
								<td>
									<c:if test="${p.result eq '정상처리'}">
										<span style="border-bottom : 1px solid blue;">${p.result}</span>
									</c:if>
									<c:if test="${p.result ne '정상처리'}">
										<span style="border-bottom : 1px solid red;">${p.result}</span>
									</c:if>
								</td>
								<td><fmt:formatDate value="${p.time }"
										pattern="yyyy-MM-dd HH:mm:ss" />
								<td>${p.name }</td>
								<td>${p.amount }</td>
								<td><fmt:formatNumber value="${p.price}" pattern="###,###,###" />원</td>
								<td>${empty p.buyer or '0' ? "비회원" : p.buyer}</td>
							</tr>
						</c:forEach>
					</table>

					<div class="total" style="border: 1px solid black; padding : 10px; position : absolute; top : 58%; left: 55%; display: flex; flex-direction: column; align-items: end;">
						<span>총 매출 : <fmt:formatNumber value="${total}" pattern="###,###,###" /> 원 </span> 
						<span style="border-bottom: 1px solid #c6c6c6; margin-bottom : 5px;">총 취소 : 
							<fmt:formatNumber value="${cancel}" pattern="###,###,###" /> 원
						</span> 
						<span>총 결제 : <fmt:formatNumber value="${total - cancel}" pattern="###,###,###" /> 원</span>
					</div>
				</fieldset>
				<input type="submit" value="결제 취소">
			</form>



			<h2>추가 매출 등록</h2>
			<form action="${cp }/sales/insert">
				<!-- 등록된 상품 목록 불러오기 -->
				<p>
					상품 선택 : <select name="name" required style="width: 200px; height : 30px; font-size : 16px;">
						<c:forEach var="p" items="${plist }">
							<option>${p.name }</option>
						</c:forEach>
					</select>
				</p>

				<p>
					<button>다음</button>
				</p>

			</form>
		</div>
	</main>

</body>
</html>