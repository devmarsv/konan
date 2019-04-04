<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

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
<style type="text/css">
#myinfo span {
	font-size: 12pt;
}

#myinfo input[readonly] {
	background-color: #f7f1e3;
}

select {
	text-align-last: center;
}

.reply_content {
	text-align: left;
}
</style>
</head>


<body>
	<c:import url="../common/header.jsp"></c:import>
	<br>
	<br>
	<div class="card bg-info text-white shadow" style="width: 200px;">
		<div class="card-body">
			<h1 style="font-family: 나눔스퀘어; font-size: 23pt;"><a href="myInfo.do" style="display: inline-block; padding: 15px;">내 정보</a></h1>
		</div>
	</div>
	<br>
	<br>


	<div style="margin: auto; text-align: center;">
		<a href="alterInfo.do" class="btn btn-success btn-icon-split"> <span
			class="icon text-white-50"> <i class="fas fa-check"></i>
		</span> <span class="text">&nbsp; &nbsp; 개인정보 수정 &nbsp; &nbsp;</span>
		</a> <a href="myBoard.do" class="btn btn-info btn-icon-split"
			style="margin-left: 20px;"> <span class="icon text-white-50">
				<i class="fas fa-info-circle"></i>
		</span> <span class="text">&nbsp; &nbsp; 내 게시글 &nbsp; &nbsp;</span>
		</a> <a href="myConnection.do" class="btn btn-warning btn-icon-split"
			style="margin-left: 20px;"> <span class="icon text-white-50">
				<i class="fas fa-exclamation-triangle"></i>
		</span> <span class="text">&nbsp; &nbsp; 접속기록 &nbsp; &nbsp;</span>
		</a> <a href="myReply.do" class="btn btn-info btn-icon-split"
			style="margin-left: 20px;"> <span class="icon text-white-50">
				<i class="fas fa-info-circle"></i>
		</span> <span class="text">&nbsp; &nbsp; 댓글 &nbsp; &nbsp;</span>
		</a>
	</div>
	<br>
	<br>

	<div class="row">
		<div class="col-lg-6" style="width: 80%;">
			<!-- Default Card Example -->
			<div class="card shadow mb-4"
				style="width: 80%; float: right; height: 280px;">
				<div class="card-header py-3" style="width: 100%;">
					<h2 class="m-0 font-weight-bold text-primary">프로필</h2>
				</div>
				<br>
				<div class="card-body" style="width: 100%">
					<img src="/konan/resources/img/logo.png"
						style="width: 150px; height: 150px; margin-left: 25px; float: left;">
					<br>
					<h2 style="position: absolute; left: 50%; top: 50%; float: left;">별명
						:</h2>
				</div>

				<a href="alterInfo.do"
					style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
					<button class="btn btn-success btn-icon-split btn-sm">
						<span class="icon text-white-50"> <i
							class="fas fa-arrow-right"></i>
						</span> <span class="text">수정하기</span>
					</button>
				</a> <br>
			</div>

			<!-- Basic Card Example -->
			<div class="card shadow mb-4"
				style="width: 80%; float: right; height: 280px;">
				<div class="card-header py-3" style="width: 100%">
					<h2 class="m-0 font-weight-bold text-primary">내 게시글</h2>
				</div>
				<div class="card-body" style="width: 100%;">
					<table class="table table-bordered dataTable" id="dataTable"
						width="100%" cellspacing="0" role="grid"
						aria-describedby="dataTable_info" style="width: 100%;">
						<thead>
							<tr role="row">
								<th class="sorting_asc" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1" aria-sort="ascending"
									aria-label="Name: activate to sort column descending"
									style="width: 60px;">번 호</th>
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="3"
									aria-label="Position: activate to sort column ascending"
									style="width: 63px;">제 목</th>
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Start date: activate to sort column ascending"
									style="width: 69px;">작성일</th>
								<th class="sorting" tabindex="0" aria-controls="dataTable"
									rowspan="1" colspan="1"
									aria-label="Salary: activate to sort column ascending"
									style="width: 67px;">조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr role="row" class="odd">
								<td class="sorting_1">1</td>
								<td colspan="3">Accountant</td>
								<td>2008/11/28</td>
								<td>$162,700</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">2</td>
								<td colspan="3">Accountant</td>
								<td>2009/10/09</td>
								<td>$1,200,000</td>
							</tr>
							<tr role="row" class="odd">
								<td class="sorting_1">3</td>
								<td colspan="3">Accountant</td>
								<td>2009/01/12</td>
								<td>$86,000</td>
							</tr>
							<tr role="row" class="even">
								<td class="sorting_1">123213123</td>
								<td colspan="3">Accountant</td>
								<td>2012/10/13</td>
								<td>$132,000</td>
							</tr>
						</tbody>
					</table>
				</div>
				<a href="myBoard.do"
					style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
					<button class="btn btn-success btn-icon-split btn-sm">
						<span class="icon text-white-50"> <i
							class="fas fa-arrow-right"></i>
						</span> <span class="text">확인하기</span>
					</button>
				</a> <br>
			</div>
		</div>

		<div class="col-lg-6">
			<!-- Dropdown Card Example -->
			<div class="card shadow mb-4"
				style="width: 80%; float: left; height: 280px;">
				<div class="card-header py-3" style="width: 100%">
					<h2 class="m-0 font-weight-bold text-primary">접속 기록</h2>
				</div>
				<div class="card-body" style="width: 100%;">
					<br>
					<h2
						style="position: absolute; top: 50%; float: left; margin-left: 10px;">최근
						접속 아이피 :</h2>
				</div>
				<a href="myConnection.do"
					style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
					<button class="btn btn-success btn-icon-split btn-sm">
						<span class="icon text-white-50"> <i
							class="fas fa-arrow-right"></i>
						</span> <span class="text">확인하기</span>
					</button>
				</a> <br>
			</div>

			<!-- Collapsable Card Example -->
			<div class="card shadow mb-4"
				style="width: 80%; float: left; height: 280px;">
				<div class="card-header py-3" style="width: 100%">
					<h2 class="m-0 font-weight-bold text-primary">내 댓글</h2>
				</div>
				<div class="card-body" style="width: 100%;">
					<table class="table table-bordered dataTable" id="dataTable"
									width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">
									<thead>
										<tr role="row">
											<th class="sorting_asc" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="Name: activate to sort column descending"
												style="width: 60px;">번 호</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="3"
												aria-label="Position: activate to sort column ascending"
												style="width: 63px;">내 용</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Salary: activate to sort column ascending"
												style="width: 67px;">날짜</th>
										</tr>
									</thead>
									<tbody>
										<tr role="row" class="odd">
											<td class="sorting_1">1</td>
											<td class="reply_content" colspan="2">저도 같은사람한테 당했어요..ㅠㅠ</td>
											<td style="border-left: hidden; text-align: right;"> <a href="#">원문 보기 ▶</a> &nbsp; &nbsp; </td>
											<td>2008/11/28</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">2</td>
											<td class="reply_content" colspan="2">사실 내가 친거임</td>
											<td style="border-left: hidden; text-align: right;"> <a href="#">원문 보기 ▶</a> &nbsp; &nbsp; </td>
											<td>2009/10/09</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">3</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"> <a href="#">원문 보기 ▶</a> &nbsp; &nbsp; </td>
											<td>2009/01/12</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">123213123</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"> <a href="#">원문 보기 ▶</a> &nbsp; &nbsp; </td>
											<td>2012/10/13</td>
										</tr>
									</tbody>
								</table>
				</div>
				<a href="myReply.do"
					style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
					<button class="btn btn-success btn-icon-split btn-sm">
						<span class="icon text-white-50"> <i
							class="fas fa-arrow-right"></i>
						</span> <span class="text">확인하기</span>
					</button>
				</a> <br>
			</div>
		</div>
	</div>

	<br>
	<br>

	<c:import url="../common/footer.jsp"></c:import>
</body>

</html>