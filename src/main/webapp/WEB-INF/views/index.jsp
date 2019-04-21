<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>KONAN</title>
<style>
.searchbar {
	margin-bottom: 250px;
	margin-top: auto;
	height: 80px;
	background-color: #376092;
	border-radius: 40px;
	padding: 10px;
}

.search_input {
	color: white;
	border: 0;
	outline: 0;
	background: none;
	width: 0;
	caret-color: transparent;
	line-height: 40px;
	transition: width 0.4s linear;
}

.searchbar>.search_input {
	padding: 30px 10px;
	width: 450px;
	caret-color: red;
	transition: width 0.4s linear;
}

.searchbar>.search_icon {
	background: white;
	color: #7D9BBE;
}

.search_icon {
	height: 50px;
	width: 50px;
	float: right;
	/* 	margin-top: 5px; */
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 50%;
	color: white;
}

a {
	text-decoration: none;
	!
	important
}

input::-webkit-input-placeholder {
	color: #fff;
}
</style>
<link rel="stylesheet" type="text/css" media="screen"
	href="/konan/resources/CSS/style.css">
<script src="/konan/resources/JS/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script src="/konan/resources/JS/menu.js" defer="defer"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script type="text/javascript"
	src="/konan/resources/JS/MainSearch/mainPage.js"></script>
</head>

<body>
	<c:import url="common/header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<h2 class="main_search"
		style="text-align: center; height: 100px; font-size: 35pt;">
		<b>사기피해사례 검색</b>
	</h2>
	
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="searchbar">

				<c:if test="${empty sessionScope.loginMember}">
					<input id="empty" class="search_input" type="text"
						placeholder="로그인 후 피해사례를 검색할 수 있습니다."
						style="margin-top : 7px; font-size: 15pt; font-family: 굴림체;">
					<a href="login.do" class="search_icon"><i class="fas fa-search"></i></a>
				</c:if>

				<c:if test="${!empty sessionScope.loginMember}">
					<form name="search" action="searchMain.do" method="post">
						<input class="search_input" type="text"
							placeholder="연락처 또는 계좌번호 등으로 검색해 보세요." name="number"
							style="margin-top: 7px; font-family: 굴림체; font-size: 15pt;">
						<a href="javascript:search.submit()" class="search_icon"><i class="fas fa-search"></i></a>
					</form>
				</c:if>

			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<c:import url="common/footer.jsp" />
</body>