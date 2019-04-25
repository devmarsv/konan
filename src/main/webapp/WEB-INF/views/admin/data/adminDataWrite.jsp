<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>konan</title>

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
	font-size: 15px;
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

th {
	width: 200px;
}

h2 {
	text-align: left;
}

input::-webkit-input-placeholder {
	font-size: 14px;
	color: #e2e2e2;
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
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
		<h2>데이터 크기 설정</h2>
		<br>
		<table class="table table-bordered">
			<tbody>
				<form action="adminSuspectData.do" method="post"
					enctype="multipart/form-data">
					<tr>
						<th>출처</th>
						<td><select name="board_category">
								<option value="중고나라" selected>중고나라</option>
								<option value="더치트">더치트</option>
						</select></td>
					</tr>
					<tr>    
						<th>크기</th>   <!-- 1 page 50 -->
						<td><input type="number" min="50" max="50000" step="50" placeholder="추출할 데이터 양 - 50 단위"
							name="totalData" class="form-control" required/></td>
					</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="등록"
						class="pull-right" /> <input type="button" value="목록"
						class="pull-right" onclick="location.href='main.do'" /></td>
				</tr>
				</form>
			</tbody>
		</table>
	</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:import url="../../common/footer.jsp" />
</body>
</html>

