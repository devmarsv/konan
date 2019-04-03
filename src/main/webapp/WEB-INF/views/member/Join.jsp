<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/join.css">
</head>

<body>
    <form class="box" action="index.html" method="post">
        <a href="main.do"><img src="/konan/resources/image/밝은 로그.png"></a>
        <h1>회원가입</h1>
        <input type="text" name="" placeholder="이메일 주소">
        <input type="text" name="" placeholder="성명">
        <input type="text" name="" placeholder="사용자 이름">
        <input type="password" name="" placeholder="비밀번호">
        <input type="submit" name="" value="가입">
        <font style="color: white;">가입하면 KONAN의 약관, 데이터 정책 및 쿠키 정책에 동의하게 됩니다.</font>
        <hr>
        <font style="color: white;">게정이 있으신가요?</font> <a href="login.do">로그인</a>
    </form>
</body>

</html>