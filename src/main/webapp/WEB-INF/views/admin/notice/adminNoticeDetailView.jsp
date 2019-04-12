<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/notice.css">
</head>
<body>
	<c:import url="../../common/header.jsp" />
	<br>
	<br>
	<br>
	<div id="ndetail" class="wrap">
		<h2>공지사항</h2>
		<table class="ndecon">
			<tr>
				<th scope="col">제목</th>
				<td colspan="3">${notice.noticetitle}</td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td colspan="3">${notice.noticewriter}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${notice.noticedate}</td>
				<th>조회수</th>
				<td>${notice.noticereadcount}</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<c:if test="${empty notice.original_filepath}">
					<td colspan="3">첨부파일이 없습니다.</td>
				</c:if>
				<td colspan="3"><a
					href="ndown.do?filename=${notice.original_filepath}">${notice.original_filepath}</a></td>
				<!-- 첨부파일이 1개이상일경우 -->

			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: justify;">${notice.noticecontent}</td>
			</tr>
		</table>
		<div id="nlist" class="wrap">
			<div class="nlist_btn">
				<a href="noticeboard.do">목록</a>
			</div>
		</div>
		<!--내용-->
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>

	<c:import url="../../common/footer.jsp" />
</body>
</html>