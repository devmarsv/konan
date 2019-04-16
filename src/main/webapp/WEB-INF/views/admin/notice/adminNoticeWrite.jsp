<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Write something else you want</title>

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
<script type="text/javascript"
	src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/konan/resources/JS/join.js">

</script>
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
<body>
	<c:import url="../../common/header.jsp" />
	<br>
	<br>
	<br>
	<div class="container">
		<h2>글쓰기</h2>
		<table class="table table-bordered">
			<thead>
			<caption></caption>
			</thead>
			<tbody>
				<form action="adminNoticeWrite.do" method="post" enctype="multipart/form-data">
					<tr>
						<th>제목</th>
						<td><input type="text" placeholder="제목을 입력하세요." name="title"
							class="form-control" /></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text"name="writer" class="form-control" 
						value="admin" readonly /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea cols="50" rows="20" placeholder="내용을 입력하세요. "
								name="content" class="form-control"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" value="파일선택" name="upfile"
							class="pull-left" /> <br> <br> </td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록"
							 class="pull-right" /> <input type="button"
							value="목록" class="pull-right" onclick="location.href='adminNoticeList.do'" /></td>
					</tr>
				</form>
			</tbody>
		</table>
	</div>
	</div>
	<br>
	<br>
	<br>
	<c:import url="../../common/footer.jsp" />
</body>
</html>

