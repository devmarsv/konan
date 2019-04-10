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

	<c:if test="${empty sessionScope.loginMember}">
		<c:redirect url="/index.jsp" />
	</c:if>
	<c:import url="../../common/header.jsp"></c:import>
	<c:import url="mypageHeader.jsp"></c:import>

	<form action="">
		<div class="card shadow mb-4" style="width: 70%; height: 550px;">
			<div class="card-header py-3" style="width: 100%;">
				<h2 style="font-family: 나눔고딕; color: olive; margin-top: 5px;">
					<b>댓글</b>
				</h2>
			</div>
			<div class="card-body" style="width: 80%;">
				<div class="table-responsive" style="overflow: hidden;">
					<div id="dataTable_wrapper"
						class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12 col-md-6" style="width: 200px;">
								<div class="dataTables_length" id="dataTable_length"
									style="width: 300px; text-align: left;">
									<label style="font-size: 15px;"> View : &nbsp;</label> <select
										name="dataTable_length" aria-controls="dataTable"
										class="custom-select custom-select-sm form-control form-control-sm"
										style="width: 50px; height: 25px;"><option value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option></select>

								</div>
							</div>
							<div class="col-sm-12 col-md-6">
								<div id="dataTable_filter" class="dataTables_filter"
									style="width: 300px; text-align: right; float: right;">
									<label style="font-size: 16px;">검색: &nbsp; </label><input
										type="search" class="form-control form-control-sm"
										placeholder="" aria-controls="dataTable"
										style="width: 150px; float: right; height: 25px;">
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-12">
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
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2008/11/28</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">2</td>
											<td class="reply_content" colspan="2">사실 내가 친거임</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2009/10/09</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">3</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2009/01/12</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">123213123</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2012/10/13</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">123123</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2011/06/07</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">56546456</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2012/12/02</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">87978978</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2011/05/03</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">687768678</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2011/12/12</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">123123</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2011/12/06</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">13123</td>
											<td colspan="2" class="reply_content">댓글 내용입니다.</td>
											<td style="border-left: hidden; text-align: right;"><a
												href="#">원문 보기 ▶</a> &nbsp; &nbsp;</td>
											<td>2012/03/29</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status"
									aria-live="polite">Showing 1 to 10 of 57 entries</div>
							</div>
							<div class="col-sm-12 col-md-7">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTable_paginate">
									<ul class="pagination">
										<li class="paginate_button page-item previous disabled"
											id="dataTable_previous"><a href="#"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">Previous</a></li>
										<li class="paginate_button page-item active"><a href="#"
											aria-controls="dataTable" data-dt-idx="1" tabindex="0"
											class="page-link">1</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="2" tabindex="0"
											class="page-link">2</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="3" tabindex="0"
											class="page-link">3</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="4" tabindex="0"
											class="page-link">4</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="5" tabindex="0"
											class="page-link">5</a></li>
										<li class="paginate_button page-item "><a href="#"
											aria-controls="dataTable" data-dt-idx="6" tabindex="0"
											class="page-link">6</a></li>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="#" aria-controls="dataTable" data-dt-idx="7"
											tabindex="0" class="page-link">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<br>
	<br>

	<c:import url="../../common/footer.jsp"></c:import>
</body>

</html>