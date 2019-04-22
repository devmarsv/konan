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
</style>

<script src="/konan/resources/JS/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">

</script>

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
					<b>내 게시글</b>
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
									<label style="font-size: 15px; width: 50px;"></label>
								</div>
							</div>
							<div class="col-sm-12 col-md-6">
								<div id="dataTable_filter" class="dataTables_filter"
									style="width: 300px; text-align: right; float: right;">

								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-12">
								<table class="table table-bordered dataTable" id="dataTable"
									width="100%" cellspacing="0" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">
									<thead style="text-align: center;">
										<tr role="row">
											<th class="sorting_asc" tabindex="0"
												aria-controls="dataTable" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="Name: activate to sort column descending"
												style="width: 50px;">번 호</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1"
												aria-label="Position: activate to sort column ascending"
												style="width: 70px;">카테고리</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="2"
												aria-label="Position: activate to sort column ascending"
												style="width: 90px;">제 목</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Start date: activate to sort column ascending"
												style="width: 80px;">작성일</th>
											<th class="sorting" tabindex="0" aria-controls="dataTable"
												rowspan="1" colspan="1"
												aria-label="Salary: activate to sort column ascending"
												style="width: 50px;">조회수</th>
										</tr>
									</thead>
									<tbody id="boardBody" style="text-align: center;">
									
										<c:if test="${allCount eq 0}">
											<td colspan="6">작성하신 게시글이 없습니다.</td>
										</c:if>
									
										<c:forEach items="${board}" var="bo">
											<tr role="row" class="even">
												<td class="sorting_1">${bo.board_num}</td>
												<td>${bo.board_category}</td>
												<td colspan="2" style="text-align: left;">
													<c:if test="${bo.board_category eq '자유'}">
														<a href="bdetail.do?board_num=${bo.board_num}">${bo.board_content}</a>
													</c:if>
													<c:if test="${!(bo.board_category eq '자유')}">
														<a href="vdetail.do?boardnum=${bo.board_num}">${bo.board_content}</a>
													</c:if>
												</td>
												<td>${bo.board_date}</td>
												<td>${bo.board_readcount}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-5">
								<div class="dataTables_info" id="dataTable_info" role="status"
									aria-live="polite">

									<c:choose>
										<c:when test="${currentPage eq 0}">
											Showing ${allCount} to ${allCount} of ${allCount} entries
										</c:when>
										<c:when test="${currentPage == maxPage}">
											Showing ${currentPage*10-9} to ${allCount} of ${allCount} entries
										</c:when>
										<c:when test="${currentPage eq 1}">
											Showing ${currentPage} to ${currentPage*10} of ${allCount} entries
										</c:when>
										<c:when test="${currentPage ne 1 and currentPage != maxPage}">
											Showing ${currentPage*10-9} to ${currentPage*10} of ${allCount} entries
										</c:when>
									</c:choose>
								</div>
							</div>
							<div class="col-sm-12 col-md-7">
								<div class="dataTables_paginate paging_simple_numbers"
									id="dataTable_paginate">
									<ul class="pagination" style="float: right;">
										<c:choose>
											<c:when test="${currentPage eq 1 or currentPage eq 0}">
												<li class="paginate_button page-item previous"
													id="dataTable_previous"><a>Previous</a></li>
											</c:when>
											<c:otherwise>
												<li class="paginate_button page-item"
													id="dataTable_previous"><a
													href="myBoard.do?page=${currentPage-1}"
													aria-controls="dataTable" data-dt-idx="0" tabindex="0"
													class="page-link">Previous</a></li>
											</c:otherwise>
										</c:choose>

										<c:if test="${currentPage eq 0}">
											<li class="paginate_button page-item active"><a
												aria-controls="dataTable" data-dt-idx="1" tabindex="0"
												class="page-link"
												style="margin-left: 5px; margin-right: 5px;">1</a></li>
										</c:if>

										<c:forEach begin="${currentMin}" end="${currentMax}" var="num">
											<c:if test="${currentPage eq num}">
												<li class="paginate_button page-item active"><a
													aria-controls="dataTable" data-dt-idx="${num}" tabindex="0"
													class="page-link"
													style="margin-left: 5px; margin-right: 5px;">${num}</a></li>
											</c:if>
											<c:if test="${currentPage ne num}">
												<li class="paginate_button page-item"><a
													href="myBoard.do?page=${num}" aria-controls="dataTable"
													data-dt-idx="${num}" tabindex="0" class="page-link"
													style="margin-left: 5px; margin-right: 5px;">${num}</a></li>
											</c:if>
										</c:forEach>

										<c:choose>
											<c:when test="${currentPage < maxPage}">
												<li class="paginate_button page-item next"
													id="dataTable_next"><a
													href="myBoard.do?page=${currentPage+1}"
													aria-controls="dataTable" data-dt-idx="7" tabindex="0"
													class="page-link">Next</a></li>
											</c:when>
											<c:otherwise>
												<li class="paginate_button page-item next"
													id="dataTable_next"><a aria-controls="dataTable"
													data-dt-idx="7" tabindex="0" class="page-link">Next</a></li>
											</c:otherwise>
										</c:choose>
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