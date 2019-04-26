<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/search.css">
	
<style type="text/css">
a {
	text-decoration: none !important;
}
h5{
	color: #fff; 
	padding:10px; 
	background:#BC1717;
	border-radius: 10px; 
}

h4 img{
	width:10px;
	height:10px;
	margin-top:-10px;
}
</style>	
</head>
<body>
	<c:import url="../common/header.jsp" />
	<br>
	<br>
	<br>
	<div id="sdetail" class="wrap">
		
		<h2>검색상세페이지</h2>
		<table class="sdecon">
			<tr>
				<th scope="col">제목</th>
				<td colspan="3">${search.board_title}</td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td colspan="3">${search.board_writer}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${search.board_date}</td>
				<th>조회수</th>
				<td>${search.board_readcount}</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<c:choose>
					<c:when test="${empty search.board_original_filename}">
						<td colspan="3"><img src="/konan/resources/image/nonfile.png"> 첨부파일이 없습니다.</td>
					</c:when>
					<c:otherwise>
						<td colspan="3"><img src="/konan/resources/image/file.jpg">
							<a href=sdown.do?filename=${search.board_original_filename}">${search.board_original_filename}</a></td>
					</c:otherwise>
				</c:choose>	
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: justify;">
					${search.board_content}</td>
			</tr>
		</table>
		<br>
		<br>
		<h5>피의자NO.${suspect.suspect_no} 정보</h5>
		<table class="sdecon">
			<tr>
				<th>피의자</th>
				<td>
				<c:choose>
					<c:when test="${!empty suspect.suspect_name}">${suspect.suspect_name}</c:when>
					<c:otherwise><span style="color:#BCBCBC;">입력된 내용이 없습니다.</span></c:otherwise>
				</c:choose></td>
			</tr>
			<tr>
				<th>신고일</th>
				<td><c:choose>
					<c:when test="${!empty suspect.report_date}">${suspect.report_date}</c:when>
					<c:otherwise><span style="color:#BCBCBC;">입력된 내용이 없습니다.</span></c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>누적횟수</th>
				<td><c:choose>
					<c:when test="${!empty suspect.suspect_count}">${suspect.suspect_count}</c:when>
					<c:otherwise><span style="color:#BCBCBC;">입력된 내용이 없습니다.</span></c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<th>핸드폰번호</th>
				<td>${suspect.suspect_phone}</td>
			</tr>

			<tr>
				<th>계좌번호</th>
				<td><c:choose>
					<c:when test="${!empty suspect.suspect_bank}">(${suspect.suspect_bank})</c:when>
					<c:otherwise><span style="color:#BCBCBC;">입력된 내용이 없습니다.</span></c:otherwise>
				</c:choose>
				 ${suspect.suspect_account}</td>
			</tr>
		</table>
		<div id="slist" class="wrap">
			<div class="slist_btn">
				<a href="search.do" style="color:#fff;">목록</a>
			</div>
		</div>

		<!--내용-->
	</div>
	<br>
	<br>
	<br>
	<c:import url="../common/footer.jsp" />
</body>
</html>