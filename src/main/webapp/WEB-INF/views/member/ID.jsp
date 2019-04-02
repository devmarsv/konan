<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>ID</title>
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/id.css">
</head>

<body>
    <form class="box" action="index.html" method="post">
        <img src="/konan/resources/image/iconfinder_Lock_red_1891028.png" style="height: 100px;">
        <h3>로그인에 문제가 있나요?</h3>
        <h5>사용자 이름 또는 이메일을 입력하면 다시 계정에 로그인할 수 있는 링크를 보내드립니다.</h5>
        <input type="text" name="" placeholder="이메일 주소">
        <input type="submit" name="" value="로그인 링크 전송">
        <hr>
        <font style="color: white;">게정이 있으신가요?</font> <a href="login.do">로그인</a>
    </form>
</body>

</html>