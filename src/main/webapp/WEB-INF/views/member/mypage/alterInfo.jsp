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
<script type="text/javascript"
	src="/konan/resources/JS/mypage/alterInfo.js"></script>

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

	<form action="alterInfoDo.do" method="post"
		onsubmit="return checkInvalidate()&&fileCheck(this.form);" enctype="multipart/form-data">
		<div class="card shadow mb-4" style="width: 70%; height: 450px;">
			<div class="card-header py-3" style="width: 100%;">
				<h2 style="font-family: 나눔고딕; color: olive; margin-top: 5px;">
					<b>개인정보 수정</b>
				</h2>
			</div>
			<br> <br> <br>
			<div class="card-body" id="myinfo"
				style="text-align: center; width: 650px;">
				<div
					style="border: 1px solid black; float: left; margin-left: 10px; margin-right: 20px; width: 200px; height: 200px;">
					<br> <img
						src="/konan/resources/profileImage/${sessionScope.loginMember.userid}.png?time="
						onerror="this.src='/konan/resources/image/iconfinder_ic_no_sim_48px_3669320.png'"
						style="width: 150px; height: 150px;" id="profileImage"><br>

					<button type="button" class="btn btn-danger btn-icon-split"
						style="float: right; margin-top: 10px; margin-right: 5px; display: table-cell; vertical-align: bottom;"
						onclick="deleteImage();">&nbsp; 삭제 &nbsp;</button>

					<button type="button" class="btn btn-success btn-icon-split"
						style="float: right; margin-top: 10px; margin-right: 5px;"
						onclick="imageUpload();">&nbsp; 등록 &nbsp;</button>

					<input type="file" id="uploadFile" name="image" hidden="">
					<input type="text" id="delete" name="delete" value="" hidden="">

				</div>

				<div style="width: 390px; float: right;">
					<span class="text" style="text-align: left;">아이디 </span> <input
						type="text" class="form-control form-control-user" name="userid"
						readonly="readonly" value="${sessionScope.loginMember.userid}"
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 40px;">
				</div>
				<br> <br> <br>

				<div style="width: 390px; float: right;">
					<span class="text" style="text-align: left;">비밀번호 </span> <span
						style="float: right;"> <img
						src="/konan/resources/image/normal-white.png" id="pwcheck"
						style="height: 23px; width: 23px;">
					</span> <input type="password" class="form-control form-control-user"
						value="" required id="pwd" name="userpwd"
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 17px;">
				</div>
				<br> <br> <br>

				<div style="width: 390px; float: right;">
					<span class="text" style="">비밀번호 확인 </span> <span
						style="float: right;"> <img
						src="/konan/resources/image/normal-white.png" id="pwcheck2"
						style="height: 23px; width: 23px;">
					</span> <input type="password" class="form-control form-control-user"
						value="" required id="pwd2"
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 17px;">
				</div>
				<br> <br> <br>

				<div style="width: 390px; float: right;">
					<span class="text">이 름[닉네임] </span> <input type="text"
						class="form-control form-control-user" readonly="readonly"
						value="${sessionScope.loginMember.username}" name="username"
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 40px;">
				</div>
				<br> <br> <br>

				<div style="width: 390px; float: right;">
					<span class="text">휴 대 전 화 </span> <input type="text"
						class="form-control form-control-user" value="" name="phone"
						required
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 40px;">
				</div>
				<br> <br> <br>

				<div style="width: 390px; float: right;">
					<span class="text" style="">이 메 일 </span> <input type="text"
						class="form-control form-control-user"
						value="${sessionScope.loginMember.email }" name="email" readonly
						style="size: 10px; width: 200px; height: 25px; float: right; margin-right: 40px;">
				</div>
				<br> <br> <br>

				<button class="btn btn-success btn-icon-split btn-sm"
					style="float: right; margin-right: 20px; margin-top: 15px;">
					<span class="icon text-white-50"> <i
						class="fas fa-arrow-right"></i>
					</span> <span class="text">수정하기</span>
				</button>
			</div>
		</div>


	</form>
	<br>
	<br>

	<c:import url="../../common/footer.jsp"></c:import>
</body>

</html>