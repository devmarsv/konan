<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="./boardError.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardWriteForm</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<hr style="clear: both;">
	<h2 align="center">게시글 등록 페이지</h2>
	<form action="/konan/binsert" method="post"
		enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" readonly name="bwriter"
					value="${loginMember.getUserid()}"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="upfile"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="7" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="등록하기"> &nbsp; <a href="/konan/vlist?page=1">목록으로</a></td>
			</tr>
		</table>
	</form>
	<hr>
	<c:import url="footer.jsp"></c:import>
</body>
</html>