<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sales Insert</title>
<link rel="styleSheet" href="${pageContext.request.contextPath }/css/style.css">
</head>
<script type="text/javascript">

	var sell_price;
	var amount;
	
	function init () {
		sell_price = document.getElementById('sell_price').value;
		amount = document.getElementById('amount').value;
		document.form.bprice.value = sell_price;
		change();
	}
	
	function add () {
		hm = document.form.amount;
		price = document.form.price;
		hm.value ++ ;
	
		price.value = parseInt(hm.value) * sell_price;
	}
	
	function del () {
		hm = document.form.amount;
		price = document.form.price;
			if (hm.value > 1) {
				hm.value -- ;
				price.value = parseInt(hm.value) * sell_price;
			}
	}
	
	function change () {
		hm = document.form.amount;
		price = document.form.price;
	
			if (hm.value < 0) {
				hm.value = 0;
			}
		price.value = parseInt(hm.value) * sell_price;
	}  

</script>
<body onload="init();">

<%@ include file="header.jsp" %>

<main>
	<div class="wrapper">
	
		<fieldset style="width : 1000px; height : 400px; overflow : auto;">
			<legend>매출 현황</legend>
			<table style="border : 1px solid black; width : 900px; margin : 10px auto;">
				<tr>
					<th>판매일</th>
					<th>상품명</th>
					<th>판매 수량</th>
					<th>판매 가격</th>
					<th>구매자</th>
				</tr>
				<c:forEach var="p" items="${list}">
					<tr>
						<td><fmt:formatDate value="${p.time }" pattern="yyyy-MM-dd HH:mm:ss"/>
						<td>${p.name }</td>
						<td>${p.amount }</td>
						<td>${p.price } 원</td>
						<td>${empty p.buyer ? "비회원" : p.buyer}</td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
		
	
	

		<h2>추가 매출 등록</h2>
		<form name="form" method="post">
			
			<p>
				상품 선택 : 
				<strong>${plist.name }</strong> 
			</p>
			<p>
				남은 수량 : ${plist.amount }
			</p>
			
			<p>
				상품수량 : 
				<input type=hidden id="sell_price" name="bprice" value="${plist.price }">
				<input type="number" id="amount" name="amount" value="1" size="3" onchange="change();" max="${plist.amount }">
				<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();">
			</p>
			<!-- 상품 가격 불러와서 수량별 계산 -->
			<p>상품가격 :  <input type="text" name="price" size="11" max="${plist.amount * plist.price }" readonly></p>
			<p>날짜 : <strong>현재시각을 기준으로 작성됨</strong></p>
			<p>구매자 : <input type="text" name="buyer"></p>
			<input type="hidden" name="result" value="1">
			<p><input type="submit" value="등록"></p>
		</form>
	</div>
</main>

</body>
</html>