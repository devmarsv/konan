<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/search.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
	
<style type="text/css">
a {
	text-decoration: none !important;
}

.red{
	color:red;
}
</style>	
	
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<body>
	<c:import url="../common/header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<div id="search_box" class="wrap">
		<form action="search.do" method="get" align="center">
			<table class="search_bar">
				<tr>
					<th>거래구분</th>
					<td><select id="cg" name="cg" style="width:400px; height:30px;">
							<option value="" <c:if test='${empty cg}'>selected</c:if>>전체</option>
							<option value="직거래" <c:if test='${cg=="직거래"}'>selected</c:if>>직거래</option>
							<option value="게임·비실물"
								<c:if test='${cg=="게임·비실물"}'>selected</c:if>>게임·비실물</option>
					</select></td>
					<td rowspan="2"><input type="submit" name="search"
						id="search_btn" value="검색" /></td>
				</tr>
				<tr>
					<th>피해사례 검색</th>
					<td><input type="text" name="bar" id="search_bar"
						value="${bar}" placeholder="제목/내용/은행명/계좌번호/핸드폰번호 검색" style="height:30px;"/></td>
				</tr>
			</table>
		</form>
	</div>

	<div id="clear"></div>


	<div id="search" class="wrap">
		<table class="sview">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="*">
				<col width="250">
				<col width="150">
				<col width="150">
			</colgroup>
			<thead>
				<tr>
					<th scope="row">게시번호</th>
					<th scope="row">용의자이름</th>
					<th scope="row">용의자 계좌번호</th>
					<th scope="row">용의자 연락처</th>
					<th scope="row">등록일</th>
					<th scope="row">내용</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${fn:length(suspectlist) > 0 }">
						<c:forEach items="${suspectlist}" var="suspect" varStatus="status">
							<tr>
								<td>${suspect.suspect_no}</td>
								
								<c:if test="${!empty suspect.suspect_name}">
								<td><strong class="red">${suspect.suspect_name}</strong></td></c:if>
								<c:if test="${empty suspect.suspect_name}">
								<td><strong class="red">--</strong></td></c:if>
								
								<td>
								<c:if test="${!empty suspect.suspect_bank}">
								<strong class="red">(${suspect.suspect_bank})</strong></c:if> 
								<c:if test="${!empty suspect.suspect_account}"><strong class="red">${suspect.suspect_account}</strong>
								</c:if>
								
								<c:if test="${empty suspect.suspect_bank}">
								<strong class="red">-</strong></c:if><c:if test="${empty suspect.suspect_account}"><strong class="red">-</strong>
								</c:if>
								</td>
								
								<c:if test="${!empty suspect.suspect_phone}">
								<td><strong class="red">${suspect.suspect_phone}</strong></td></c:if>
								<c:if test="${empty suspect.suspect_phone}">
								<td><strong class="red">--</strong></td></c:if>
								
								
								<td>${suspect.report_date}</td>
								<td><a href="sdetail.do?suspect_no=${suspect.suspect_no}">자세히보기 ></a></td>
								
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td colspan="5">조회된 결과가 없습니다.</td>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>


<%-- <div id="search" class="wrap">
		<table class="sview">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="150">
				<col width="*">
				<col width="150">
				<col width="150">
			</colgroup>
			<thead>
				<tr>
					<th scope="row">게시번호</th>
					<th scope="row">거래구분</th>
					<th scope="row">작성자</th>
					<th scope="row">제목</th>
					<th scope="row">등록일</th>
					<th scope="row">조회</th>
				</tr>
			</thead>

			<tbody>
				<c:choose>
					<c:when test="${fn:length(searchList) > 0 }">
						<c:forEach items="${searchList}" var="search" varStatus="status">
							<tr>
								<td>${search.board_num}</td>
								<td>${search.board_category}</td>
								<td>${search.board_writer}</td>
								<td><a href="sdetail.do?board_num=${search.board_num}">${search.board_title}</a></td>
								<td>${search.board_date}</td>
								<td>${search.board_readcount}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td colspan="5">조회된 결과가 없습니다.</td>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div> --%>
	<br>


	<div id="write_btn" class="wrap">
		<ul>
			<li class="page"><nav aria-label="Page navigation example">
					<ul class="pagination pagination-sm justify-content-center">
						<c:choose>
							<c:when test="${currentPage eq 1}">
								<li class="page-item disabled"><a class="page-link"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="search.do?page=${currentPage-1}&cg=${cg}&bar=${bar}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
								</a></li>
							</c:otherwise>
						</c:choose>

						<c:if test="${currentMin eq 1 && currentMax eq 0}">
							<li class="page-item active"><a class="page-link">1<span
									class="sr-only">(current)</span></a></li>
						</c:if>

						<c:forEach var="p" begin="${currentMin}" end="${currentMax}">
							<c:if test="${currentPage eq p}">
								<li class="page-item active"><a class="page-link" href="#">${p}<span
										class="sr-only">(current)</span></a></li>
							</c:if>
							<c:if test="${currentPage ne p}">
								<li class="page-item"><a class="page-link"
									href="search.do?page=${p}&cg=${cg}&bar=${bar}">${p}</a></li>
							</c:if>
						</c:forEach>

						<!-- 다음 -->
						<c:choose>
							<c:when test="${currentPage < maxPage}">
								<li class="page-item"><a class="page-link"
									href="search.do?page=${currentPage+1}&cg=${cg}&bar=${bar}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item disabled"><a class="page-link"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
	</div>

	<br><br>
	<br><br>
	<br><br>
	<c:import url="../common/footer.jsp" />
</body>
</html>