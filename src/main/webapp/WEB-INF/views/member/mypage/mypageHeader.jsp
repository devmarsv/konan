<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<div class="card bg-info text-white shadow" style="width: 200px;">
		<div class="card-body" style="text-align: center;">
			<h1 style="font-family: 나눔스퀘어; font-size: 23pt;">
				<a href="myInfo.do">내 정보</a>
			</h1>
		</div>
	</div>
	<br>
	<br>


	<div style="margin: auto; text-align: center;">

		<a href="alterInfo.do" class="btn btn-success btn-icon-split"> <span
			class="icon text-white-50"> <i class="fas fa-check"></i>
		</span> <span class="text">&nbsp; &nbsp; 개인정보 수정 &nbsp; &nbsp;</span>
		</a> <a href="myBoard.do?page=1" class="btn btn-info btn-icon-split"
			style="margin-left: 20px;"> <span class="icon text-white-50">
				<i class="fas fa-info-circle"></i>
		</span> <span class="text">&nbsp; &nbsp; 내 게시글 &nbsp; &nbsp;</span>
		</a> <a href="myConnection.do" class="btn btn-warning btn-icon-split"
			style="margin-left: 20px;"> <span class="icon text-white-50">
				<i class="fas fa-exclamation-triangle"></i>
		</span> <span class="text">&nbsp; &nbsp; 접속기록 &nbsp; &nbsp;</span>
		</a> <a href="myReply.do" class="btn btn-info btn-icon-split"
			style="margin-left: 20px;"> <span class="icon text-white-50">
				<i class="fas fa-info-circle"></i>
		</span> <span class="text">&nbsp; &nbsp; 댓글 &nbsp; &nbsp;</span>
		</a>

	</div>
	<br>
	<br>
</body>
</html>