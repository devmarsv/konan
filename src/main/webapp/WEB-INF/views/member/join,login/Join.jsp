<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/konan/resources/CSS/join.css">
    <style type="text/css">
    </style>
    <script type="text/javascript" src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/konan/resources/JS/join.js">
    </script>
</head>

<body>
    <form class="box" action="joinDo.do" method="post" onsubmit="return checkValidate();">
        <a href="main.do"><img src="/konan/resources/image/밝은 로그.png"></a>
        <h1>회원가입</h1>

        <img src="/konan/resources/image/normal.png" id="idcheck" style="width: 30px; height: 30px; float: right; margin-top: 5px;">
        <input type="text" id="id" name="userid" placeholder="아이디" required>

        <input type="text" name="username" placeholder="이름[닉네임]" required>

        <img src="/konan/resources/image/normal.png" id="pwcheck" style="width: 30px; height: 30px; float: right; margin-top: 15px;">
        <input type="password" id="pwd" name="userpwd" placeholder="비밀번호" required>

        <input type="text" name="phone" placeholder="핸드폰 번호" required>

        <img src="/konan/resources/image/normal.png" id="emailCheck" style="width: 30px; height: 30px; float: right; margin-top: 15px; ">
        <input type="email" id="email" name="email" placeholder="이메일 주소" required>

        <input type="submit" value="가입">
        <c:choose>
        	<c:when test="${empty message }">
        		<font style="color: red; font-size: 10pt; font-family: 나눔스퀘어라운드;" hidden="hidden" id="errorMsg">Test<br><br></font>
        	</c:when>
        	<c:otherwise>
        		<font style="color: red; font-size: 10pt; font-family: 나눔스퀘어라운드;" id="errorMsg"> ${message}<br><br></font>
        	</c:otherwise>
        </c:choose>
        <font style="color: white;">가입하면 KONAN의 약관, 데이터 정책 및 쿠키 정책에 동의하게 됩니다.</font>
        <hr>
        <font style="color: white;">게정이 있으신가요?</font> <a href="login.do">로그인</a>
    </form>
</body>

</html>