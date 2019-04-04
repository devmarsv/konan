<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/form.css">
</head>

<body class="bg-dark">
    <div>
        <form class="box" action="index.html" method="post">
            <a href="main.do"><img src="${pageContext.request.contextPath}/resources/image/밝은 로그.png"></a>
            <h1>로그인</h1>
            <input type="text" name="" placeholder="ID">
            <input type="password" name="" placeholder="Password">
            <input type="submit" name="" value="로그인">
            <a id="join" href="join.do">회원가입</a><br><br>
            <a id="lost" href="id.do">비밀번호를 잃어버렸나요?</a>
        </form>
    </div>
</body>
</html>