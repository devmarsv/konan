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
	href="${pageContext.request.contextPath}/resources/CSS/notice.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<style type="text/css">
input::-webkit-input-placeholder {
	color: #ddd;
}

.nview tr td a {
	color: #22518A;
	text-decoration: none;
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
	<div id="notice" class="wrap">
		<h2>공지사항</h2>
		<table class="nview">
			<colgroup>
				<col width="150">
				<col width="150">
				<col width="*">
				<col width="150">
				<col width="150">
			</colgroup>
			<thead>
				<tr>
					<th scope="row">게시번호</th>
					<th scope="row">작성자</th>
					<th scope="row">제목</th>
					<th scope="row">등록일</th>
					<th scope="row">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(noticeList) > 0}">
						<c:forEach items="${noticeList}" var="notice" varStatus="status">
							<tr>
								<td>${notice.noticeno}</td>
								<td>${notice.noticewriter}</td>
								<td><a href="ndetail.do?noticeno=${notice.noticeno}">${notice.noticetitle}</a>
									<c:if test="${!empty notice.original_filepath}">
										<img src="/konan/resources/image/file.jpg">
									</c:if></td>
								<td>${notice.noticedate}</td>
								<td>${notice.noticereadcount}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>

		<div id="write_btn" class="wrap">
			<ul>
				<li class="page">
					<nav aria-label="Page navigation example">
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
										href="notice.do?page=${currentPage-1}&cg=${cg}&bar=${bar}" aria-label="Previous">
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
										href="notice.do?page=${p}&cg=${cg}&bar=${bar}">${p}</a></li>
								</c:if>
							</c:forEach>


							<!-- 다음 -->
							<c:choose>
								<c:when test="${currentPage < maxPage}">
									<li class="page-item"><a class="page-link"
										href="notice.do?page=${currentPage+1}&cg=${cg}&bar=${bar}" aria-label="Next"> <span
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
					</nav>
				</li>

				<li class="wrbtn"><c:choose>
						<c:when test="${loginMember.userid == 'admin'}">
							<a href="nform.do">글쓰기</a>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose></li>

			</ul>
		</div>
		<br> <br>
		<div class="search">
			<form action="notice.do" method="get" align="center" id="setRows">
				<div class="box">
					<select id="cg" name="cg" style="height:36px;">
						<option value="all" <c:if test='${cg == "all"}'>selected</c:if>>전체</option>
						<option value="title"
							<c:if test='${cg == "title"}'>selected</c:if>>제목</option>
						<option value="content"
							<c:if test='${cg == "content"}'>selected</c:if>>내용</option>
					</select> <input type="text" name="bar" id="search_bar" placeholder="내용"
						value="${bar}" style="height:36px;"/> <input type="submit" name="search"
						id="search_btn" value="검색" />
				</div>
			</form>
		</div>
		<div id="clear"></div>
		<br> <br> <br> <br> <br>

		<c:import url="../common/footer.jsp" />
</body>
</html>