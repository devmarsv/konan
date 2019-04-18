<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="./boardError.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Write your victimized</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<style>
.container {
	width: 1200px;
}

.pull-right, .pull-left {
	float: right;
	margin-right: 5px;
	border-radius: 3px;
	background-color: #87CEEB;
	padding: 5px 10px;
	border: none;
	color: #fff;
	text-align: center;
	font-size: 15px;
	display: inline-block;
	cursor: pointer;
}

th, td {
	background: #fff;
}

h2 {
	text-align: left;
}
</style>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
</head>
<body>
	<c:import url="../common/header.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<hr style="clear: both;">
		<h2 align="center">게시글 등록 페이지</h2>
		<form action="/konan/binsert" method="post"
			enctype="multipart/form-data">
			<table class="table table-bordered">
				<thead>
				<caption>
					<h2>글쓰기</h2>
				</caption>
				</thead>
				<tbody>
					<from action="write-ok.jsp" method="post"
						encType="multiplart/form-data">
					<tr>
						<td>제목</td>
						<td><input type="text" placeholder="제목을 입력하세요." name="btitle"
							class="form-con trol" /></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" readonly name="bwriter"
							value="${loginMember.getUserid()}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea cols="50" rows="20" placeholder="내용을 입력하세요."
								name="bcontent" class="from-control" /></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="upfile"></td>

						<td><input type="button" value="파일선택" class="pull-left" /> <br>
							<br> <input type="text" placeholder="파일을 선택하세요. "
							name="filename" class="form-control"> </input></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="등록"
							onclick="sendData()" class="pull-right" /> <input type="button"
							value="목록" class="pull-right" onclick="location.href='board.do'" />
						</td>
					</tr>
					</form>
				</tbody>
			</table>
		</form>
	</div>
	<br>
	<br>
	<br>
	<c:import url="../common/footer.jsp" />
</body>
</html>