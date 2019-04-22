<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KONAN</title>

<link href="/konan/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<link href="/konan/resources/CSS/sb-admin-2.min.css" rel="stylesheet">

</head>
<body>
	<c:if test="${empty sessionScope.loginMember}">
		<c:redirect url="../../index.jsp" />
	</c:if>

	<c:import url="../common/header.jsp"></c:import>

	<br>
	<br>
	<div style="text-align: center; width: 80%; margin: auto;">

		<c:if test="${count > 0}">
			<img src="/konan/resources/image/main_warning.png"
				style="height: 200px; width: 200px; margin: auto;">
			<br>
			<font
				style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 28pt; font-weight: bolder;">
				<font
				style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 28pt; font-weight: bolder; color: red;">${value}</font>에
				대한 피해사례 결과 입니다.
			</font>
		</c:if>

		<c:if test="${count <= 0}">
			<img src="/konan/resources/image/main_safe.png"
				style="height: 200px; width: 200px; margin: auto;">
			<br>
			<font
				style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 28pt; font-weight: bolder;">
				<font
				style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 28pt; font-weight: bolder; color: black;">${value}</font>에
				대해 등록된 피해사례가 없습니다.
			</font>
		</c:if>

	</div>

	<br>
	<br>

	<div
		style="width: 80%; height: 90px; background: red; padding: 15px; padding-left: 50px; margin: 5px; margin: auto;">
		<div style="display: inline-block; height: 25px;">
			<font style="color: white;"><b>피해를 당한 경우, 즉시 피해사례를 등록해주세요.<br>
					용의자 추적 정보 등 피해자를 위한 정보가 제공됩니다.
			</b> </font> <a href="victim.do" class="btn btn-danger btn-icon-split btn-lg"
				style="position: relative; left: 55%; bottom: 18px;"> <span
				class="icon text-white-50"> <i
					class="fas fa-exclamation-triangle"></i>
			</span> <span class="text">피해사례 등록하기</span>
			</a>
		</div>
	</div>

	<br>
	<br>
	<c:if test="${count > 0}">
		<div style="text-align: center; margin: auto;">
			<div class="card mb-4 py-3 border-bottom-danger"
				style="width: 39%; height: 150px; background: aliceblue; float: left; margin-left: 10%;">
				<div class="card-body">
					<font style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 13pt;">등록된
						피해 정보</font><br> <font
						style="font-family: 돋움, 굴림체; font-size: 30pt; font-weight: bolder;"><font
						style="color: red;">${count}</font>건</font>
				</div>
			</div>

			<div class="card mb-4 py-3 border-bottom-warning"
				style="width: 39%; height: 150px; background: aliceblue; margin-right: 10%;">
				<div class="card-body">
					<font style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 13pt;">최근
						신고 날짜</font><br> <font
						style="font-family: 돋움, 굴림체; font-size: 30pt; font-weight: bolder; color: red;">${list[0].report_date}</font>
				</div>
			</div>
		</div>
		<br>

		<div style="width: 80%; margin: auto;">
			<font
				style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 28pt; font-weight: bolder;">
				피해사례 목록 </font> <font
				style="font-family: 나눔스퀘어라운드, 굴림체; font-size: 14pt; font-weight: bolder;">
				(최근 ${size}건) </font> <br> <br>
			<table class="table table-bordered dataTable" id="dataTable"
				width="100%" cellspacing="0" role="grid"
				aria-describedby="dataTable_info"
				style="width: 100%; background: white; text-align: center;">
				<thead>
					<tr role="row">
						<th class="sorting_asc" tabindex="0" aria-controls="dataTable"
							rowspan="1" colspan="1" aria-sort="ascending"
							aria-label="Name: activate to sort column descending"
							style="width: 30px;">이름</th>
						<th class="sorting" tabindex="0" aria-controls="dataTable"
							rowspan="1" colspan="1"
							aria-label="Office: activate to sort column ascending"
							style="width: 50px;">계좌번호</th>
						<th class="sorting" tabindex="0" aria-controls="dataTable"
							rowspan="1" colspan="1"
							aria-label="Age: activate to sort column ascending"
							style="width: 40px;">연락처</th>
						<th class="sorting" tabindex="0" aria-controls="dataTable"
							rowspan="1" colspan="1"
							aria-label="Age: activate to sort column ascending"
							style="width: 40px;">신고 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="suspect">
						<tr role="row" class="odd">
							<td class="sorting_1">
							
								<c:if test="${!empty suspect.suspect_name}">
									${suspect.suspect_name}
								</c:if>
								
								<c:if test="${empty suspect.suspect_name}">
									<c:set var="nameBreak" value="true" />
									<c:forEach var="name" items="${list}">
										<c:if test="${!empty name.suspect_name and nameBreak}">
											${name.suspect_name}
											<c:set var="nameBreak" value="false" />
										</c:if>
									</c:forEach>
								</c:if>
								
							</td>
							<td>
							
								<c:if test="${!empty suspect.suspect_account}">
									${suspect.suspect_bank} ${suspect.suspect_account}
								</c:if>
								
								<c:if test="${empty suspect.suspect_account}">
									<c:set var="nameBreak" value="true" />
									<c:forEach var="name" items="${list}">
										<c:if test="${!empty name.suspect_account and nameBreak}">
											${name.suspect_bank} ${name.suspect_account}
											<c:set var="nameBreak" value="false" />
										</c:if>
									</c:forEach>
								</c:if>
							
							</td>
							<td>
								<c:if test="${!empty suspect.suspect_phone}">
									${fn:substring(suspect.suspect_phone, 0, 3)}-${fn:substring(suspect.suspect_phone, 3, 7)}-${fn:substring(suspect.suspect_phone, 7, -1)}
								</c:if>
								
								<c:if test="${empty suspect.suspect_phone}">
									<c:set var="nameBreak" value="true" />
									<c:forEach var="name" items="${list}">
										<c:if test="${!empty name.suspect_phone and nameBreak}">
											${fn:substring(name.suspect_phone, 0, 3)}-${fn:substring(name.suspect_phone, 3, 7)}-${fn:substring(name.suspect_phone, 7, -1)}
											<c:set var="nameBreak" value="false" />
										</c:if>
									</c:forEach>
								</c:if>
								
							</td>
							<td>${suspect.report_date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<br>
	<c:import url="../common/footer.jsp"></c:import>
</body>
</html>