<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>PW Change</title>

<link rel="stylesheet" type="text/css" media="screen"
	href="/konan/resources/CSS/join.css">
<style type="text/css">
.box input[type="text"], .box input[type="password"], .box input[type="email"]
	{
	border: 0;
	background: none;
	display: block;
	margin: 10px 40px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 10px 5px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
}
</style>

<script type="text/javascript"
	src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function () {
		
	    $('#pwd').blur(function () {
	        var userpwd = $('#pwd').val();
	        if (!(6 <= userpwd.length && userpwd.length <= 12)) {
	            $('#errorMsg').show();
	            $('#errorMsg').html("비밀번호 길이가 요구조건에 만족하지 않습니다.<br>(비밀번호는 6글자 12자 이하로 허용됩니다.)<br><br>");
	            $('#pwcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
	            $('#pwcheck').attr("title", "비밀번호 요구조건이 만족되지 않습니다.");
	            return false;
	        } else {
	            $('#errorMsg').hide();
	        }

	        for (var i in userpwd) {
	            var ch = userpwd.charAt(i);
	            if (!(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')
	                || ('0' <= ch && ch <= '9') || (ch == '!' || ch == '@'
	                    || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*'))) {
	                $('#errorMsg').show();
	                $('#errorMsg').html("비밀번호가 요구조건에 만족하지 않습니다.<br>(비밀번호는 영어소문자, 대문자, 숫자, 기호문자(#,!,*,@,&,^,%,$)로 허용됩니다.)<br><br>");
	                $('#pwcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
	                $('#pwcheck').attr("title", "비밀번호 요구조건이 만족되지 않습니다.");
	                return false;
	            } else {
	                $('#pwcheck').attr("src", "/konan/resources/image/iconfinder_success_1646004.png");
	                $('#errorMsg').hide();
	                pwdcheck = true;
	            }
	        }
	    });
	    
	});
	</script>
</head>
<body class="bg-dark">
	<div>
		<form class="box" action="changePwd.do" method="post">
			<a href="main.do"><img
				src="${pageContext.request.contextPath}/resources/image/밝은 로그.png"></a>
			<h1>패스워드 변경</h1>
			<input type="text" name="userid" value="${userid}"
				readonly="readonly"> <img
				src="/konan/resources/image/normal.png" id="pwcheck"
				style="width: 30px; height: 30px; float: right; margin-top: 15px;">
			<input type="password" id="pwd" name="userpwd" placeholder="비밀번호"
				required> <input type="submit" value="수정하기">
			<c:choose>
				<c:when test="${empty message }">
					<font style="color: red; font-size: 10pt; font-family: 나눔스퀘어라운드;"
						hidden="hidden" id="errorMsg">Test<br> <br></font>
				</c:when>
				<c:otherwise>
					<font style="color: red; font-size: 10pt; font-family: 나눔스퀘어라운드;"
						id="errorMsg"> ${message}<br> <br></font>
				</c:otherwise>
			</c:choose>
		</form>
	</div>
</body>
</html>