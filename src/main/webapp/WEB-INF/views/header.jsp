<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />

<script type="text/javascript">

	function logout () {
		var con_test = confirm("로그아웃 하시겠습니까?");
		if(con_test == true){
			location.href = '${cp}/logout'
		}
	}
	

</script>

<header>

	<div class="header-wrapper">
		<div>
			<p><button onclick="location.href = '${cp}'">HOME</button></p>
			<c:if test="${not empty login }">
				<p><button onclick="logout();">LOGOUT</button></p>
			</c:if>
		</div>
	
		<div class="product">
			<p>상품 관리</p>
			<ul>
				<li><a href="${cp}/product">상품 관리</a></li>
				<li><a href="${cp}/product/insert">상품 등록</a></li>	<!-- 상품 이름, 수량, 가격 -->
			</ul>
		</div>
		
		<div class="sales">
			<p>매출 관리</p>
			<ul>
				<li><a href="${cp}/sales">매출 관리</a></li>	<!-- 총 판매금액 종류, 수량 확인 -->	
			</ul>
		</div>
		
		<div class="user">
			<p>회원 관리</p>
			<ul>
				<li><a href="${cp}/user">회원 확인</a></li>	<!-- 전체 회원 조회, 삭제  -->
				<li><a href="${cp}/user/insert">회원 등록</a></li>	<!-- 이름, 전화번호, 스탬프개수-->
			</ul>
		</div>
	
	</div>
</header>