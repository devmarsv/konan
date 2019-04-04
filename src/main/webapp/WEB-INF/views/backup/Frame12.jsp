<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>부트스트랩 101 템플릿</title>
<link href="/konan/resources/CSS/bootstrap.min.css" rel="stylesheet">
<script src="/konan/resources/JS/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script src="/konan/resources/JS/menu.js" defer="defer"
	type="text/javascript"></script>
	
</head>


<body>
	<c:import url="common/header.jsp"></c:import>
	<h1>MY PAGE</h1>
	<br>
	<a href="#"><button type="button" class="btn btn-primary" style="margin-left: 20px; width: 120px;">개인정보 수정</button></a>
	<a href="#"><button type="button" class="btn btn-primary" style="margin-left: 20px; width: 100px;">내 게시글</button></a>
	<a href="#"><button type="button" class="btn btn-primary" style="margin-left: 20px; width: 100px;">접속기록</button></a>
	<a href="#"><button type="button" class="btn btn-primary" style="margin-left: 20px; width: 100px;">댓글</button></a>
	<br><br>
	<div class="jumbotron" style="width: 70%;">
        <h3>개인정보 수정</h3>
        <img src="/konan/resources/img/logo.png" style="">
    </div>
	
	<c:import url="common/footer.jsp"></c:import>
</body>
</html>