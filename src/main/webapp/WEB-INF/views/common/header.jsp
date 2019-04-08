<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/header.css">
<link href="/konan/resources/CSS/sb-admin-2.min.css" rel="stylesheet">
<script src="/konan/resources/JS/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script src="/konan/resources/JS/menu.js" defer="defer"
	type="text/javascript"></script>
<style type="text/css">
.nav li a {
	font-family: 나눔스퀘어;
	font-size: 11pt;
	color: #fff;
	text-decoration: none;
}

.nav li .submenu li a:hover {
	background: none;
}

.nav .home a:hover {
	background: #A1A1A1;
}
</style>
</head>

<body>
	<header class="all">
		<div id="header_logo" class="wrap">
			<div class="logo">
				<a href="#"><img src="/konan/resources/img/logo2.png"></a>
			</div>
			<nav>
				<ul class="nav">
					<li style="width: 100px;"><a href="search.do">검색</a></li>
					<li><a href="victim.do">피해등록</a></li>
					<li class="home"><a href="main.do">홈</a>
						<ul class="submenu">
							<li><a href="notice.do">공지사항</a></li>
							<li><a href="#">피해사례현황</a></li>
							<li><a href="board.do">자유게시판</a></li>
						</ul>
					</li>
					<c:choose>
						<c:when test="${empty loginMember}">
							<li><a href="login.do">로그인</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="myInfo.do">마이페이지</a>
							<li><a href="logout.do">로그아웃</a>
						</c:otherwise>
					</c:choose>
					<li><a href="#"><img src="/konan/resources/img/search.png">오늘사기예방<span
							style="color: red">#</span>수</a></li>
				</ul>
			</nav>
		</div>
		<div class="clear"></div>
	</header>
</body>

</html>