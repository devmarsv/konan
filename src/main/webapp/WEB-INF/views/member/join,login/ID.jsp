<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Find ID</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/id.css">
<script type="text/javascript"
	src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
	
<script type="text/javascript">
    var emailcheck = false;

    function checkValidate() {
            var email = $('#email').val();
            
            if (email == null) {
                email = "";
            }
            $.ajax({
                async: true,
                type: 'POST',
                data: email,
                url: "pwdEmailCheck.do",
                dataType: "json",
                contentType: "application/json; charset=UTF-8",
                success: function (data) {
                    if (data.cnt == null) {
                    	$('#emailCheck').show();
                        $('#emailCheck').html("사용자를 찾을 수 없습니다<br><br>");
                    } else {
                    	$('#emailCheck').show();
                    	$('#emailCheck').html("감사합니다! 비밀번호 재설정 링크를 받을 메일을 확인하세요.<br><br>");
                    	$.ajax({
                            async: true,
                            type: 'POST',
                            data: email,
                            url: "sendMail.do",
                            dataType: "json",
                            contentType: "application/json; charset=UTF-8",
                            success: function (data) {
                            	
                            }
                        });
                    	
                    }
                }
            });
        return emailcheck;
    }
    </script>
</head>

<body>
	<form class="box" method="post" onsubmit="return checkValidate();">
		<img src="/konan/resources/image/iconfinder_Lock_red_1891028.png"
			style="height: 100px;">
		<h3>로그인에 문제가 있나요?</h3>
		<h5>사용자 아이디 또는 이메일을 입력하면 다시 계정에 로그인할 수 있는 링크를 보내드립니다.</h5>
		<input type="text" id="email" name="email" placeholder="아이디나 이메일 주소"> <input
			type="submit" name="" value="로그인 링크 전송">
		<font style="font-family: 나눔스퀘어라운드; font-size: 10pt; color: red;" id="emailCheck" hidden="hidden"></font>
		<hr>
		<font style="color: white;">게정이 있으신가요?</font> <a href="login.do">로그인</a>
	</form>
</body>

</html>