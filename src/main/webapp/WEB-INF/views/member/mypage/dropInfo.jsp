<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이 페이지</title>
<link href="/konan/resources/CSS/bootstrap.min.css" rel="stylesheet">
<script src="/konan/resources/JS/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script src="/konan/resources/JS/menu.js" defer="defer"
	type="text/javascript"></script>

<!-- 123 -->
<link href="/konan/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/konan/resources/CSS/sb-admin-2.min.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="/konan/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="/konan/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/konan/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/konan/resources/JS/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/konan/resources/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="/konan/resources/JS/demo/chart-area-demo.js"></script>
<script src="/konan/resources/JS/demo/chart-pie-demo.js"></script>


<script src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
<style type="text/css">
#myinfo span {
	font-size: 12pt;
}

#myinfo input[readonly] {
	background-color: #f7f1e3;
}

input {
	text-align: center;
}
</style>

</head>

<body>
	<c:if test="${empty sessionScope.loginMember}">
		<c:redirect url="/index.jsp" />
	</c:if>

	<c:import url="../../common/header.jsp"></c:import>
	<c:import url="mypageHeader.jsp"></c:import>

	<form action="dropInfo.do" method="post" onsubmit="return pwdcheck();">
		<div class="card shadow mb-4" style="width: 70%; height: 450px;">
			<div class="card-header py-3" style="width: 100%;">
				<h2 style="font-family: 나눔고딕; color: olive; margin-top: 5px;">
					<b>회원 탈퇴</b>
				</h2>
			</div>
			<br> <br> <br>
			<div class="card-body" id="myinfo"
				style="text-align: center; width: 650px;">
				<br><br>
				<h2>비밀번호 재확인</h2><br>
				<font>안전한 사용을 위해 비밀번호를 다시 한 번 입력해주세요.</font>
				<div style="width: 390px; margin-top: 30px;">
					<span class="text" style="text-align: left;">아이디 </span> <input
						type="text" class="form-control form-control-user" name="userid"
						readonly="readonly" value="${sessionScope.loginMember.userid}" id="userid"
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 40px;">
				</div>
				<br>
				<div style="width: 390px;">
					<span class="text" style="text-align: left;">비밀번호 </span> <span
						style="float: right;">
					</span> <input type="password" class="form-control form-control-user"
						value="" required id="pwd" name="userpwd"
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 40px;">
						<br>
				</div>
				<br><br><br>
				<button class="btn btn-success btn-icon-split btn-sm"
					style="float: right; margin-right: 20px; margin-top: 15px;">
					<span class="icon text-white-50"> <i
						class="fas fa-arrow-right"></i>
					</span> <span class="text">탈퇴하기</span>
				</button>
			</div>
		</div>


	</form>
	<br>
	<br>

	<c:import url="../../common/footer.jsp"></c:import>
</body>

</html>