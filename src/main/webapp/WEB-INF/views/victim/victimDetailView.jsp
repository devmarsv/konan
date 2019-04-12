<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="boardError.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetailView</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<hr style="clear: both;">
	<br>
	<table align="center" cellpadding="10" cellspacing="0" border="1"
		width="500">
		<tr align="center" valign="middle">
			<th colspan="2">${victim.getBoard_num() }번글상세보기</th>
		</tr>
		<tr>
			<td height="15" width="100">제 목</td>
			<td>${victim.getBoard_title() }</td>
		</tr>
		<tr>
			<td>내 용</td>
			<td>${victim.getBoard_content }</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
			<c:if test="${empty victim.getOriginal_filepath }">
			첨부파일 없음
			</c:if><c:if test="${!empty victim.getOriginal_filepath }">
			<a
				href="/konan/bfdown?ofile=${victim.getOriginal_filepath }&rfile=${victim.getRename_filepath }">
					${victim.getOriginal_filepath }</a>
			</c:if>
			</td>
		</tr>
		<tr align="center" valign="middle">
			<td colspan="2">
			<c:if test="${!empty loginMember }">
			</c:if><c:if test="${loginMember.getUserid() eq victim.getBoard_writer() }">
			<a
				href="/konan/bupview?bnum=${victim.getBoard_num() }%>&page=${currentPage}">
					[수정페이지로 이동] </a> &nbsp;&nbsp; <a
				href="/konan/bdelete?bnum=${victim.getBoard_num() }"> [글삭제] </a>
				&nbsp;&nbsp; </c:if>
				<a href="/konan/vlist?page=${currentPage}">[목록]</a>
			</td>
		</tr>
	</table>
	<br>
	<c:import url="footer.jsp"></c:import>
</body>
</html>





