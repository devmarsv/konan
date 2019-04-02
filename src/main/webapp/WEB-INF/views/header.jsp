<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>konan</title>
<style type="text/css">
	nav { float: left;  }
	nav ul li {
		float: left;
		display: block;
		width: 120px;
		height: 35px;
		background: orange;
		color: navy;
	}
	
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
<header>
<nav>
<ul>
	<li><a href="main.do">home</a></li>
	<li><a href="moveAOP.do">AOP란?</a></li>
	<li><a href="moveFileup.do">파일업로드 테스트</a></li>
	<li><a href="moveAjax.do">Ajax 테스트</a></li>
	<li><a href="testView.do">패스워드 암호화 테스트</a></li>
</ul>
</nav>
<c:if test="${empty loginUser }">
<table id="loginFrm">
<form action="login.do" method="post">
<tr><th><input type="text" name="userid"></th>
<th rowspan="2"><input type="submit" value="로그인"></th></tr>
<tr><th><input type="password" name="userpwd"></th></tr>
<tr><th colspan="2"><a>아이디/암호분실시</a>
&nbsp <a>회원가입</a></th></tr>
</form>
</table>
</c:if>
<c:if test="${!empty sessionScope.loginMember }">
<table>
<tr><th>${loginMember.username } 님</th>
<th><a href="logout.do">로그아웃</a></th><tr>
<c:url var="minfo" value="myinfo.do">
	<c:param name="userid" value="${loginMember.userid }" />
</c:url>
<tr><th><a href="${minfo }">내정보보기</a></th>
<th><a>공지글쓰기</a></th><tr>
<tr><th><a>메일확인</a></th>
<th><a>쪽지확인</a></th><tr>
</table>
</c:if>
</header>
</body>
</html>