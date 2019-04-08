<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Page Title</title>
    <link rel="stylesheet" type="text/css" media="screen" href="/konan/resources/CSS/join.css">
    <script type="text/javascript" src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$('#id').focusout(function(){
                $('#idcheck').show();
                var userid = $('#id').val();
                console.log(userid);
                $.ajax({
                    async: true,
                    type: 'POST',
                    data: userid,
                    url: "idcheck.do",
                    dataType: "json",
                    contentType: "application/json; charset=UTF-8",
                    success: function(data){
                        
                    }
                });
            });
    	});
    </script>
</head>

<body>
    <form class="box" action="joinDo.do" method="post">
        <a href="main.do"><img src="/konan/resources/image/밝은 로그.png"></a>
        <h1>회원가입</h1>
        <img src="/konan/resources/image/iconfinder_Lock_red_1891028.png" id="idcheck" hidden="hidden" style="width: 30px; height: 30px; float: right; margin-top: 5px;">
        <input type="text" id="id" name="userid" placeholder="아이디">
        <img src="/konan/resources/image/iconfinder_Lock_red_1891028.png" hidden="" style="width: 30px; height: 30px; float: right; margin-top: 5px;">
        <input type="text" name="username" placeholder="이름[닉네임]">
        <input type="password" name="userpwd" placeholder="비밀번호">
        <input type="text" name="phone" placeholder="핸드폰 번호">
        <input type="text" name="email" placeholder="이메일 주소">
        <input type="submit" value="가입">
        <font style="color: white;">가입하면 KONAN의 약관, 데이터 정책 및 쿠키 정책에 동의하게 됩니다.</font>
        <hr>
        <font style="color: white;">게정이 있으신가요?</font> <a href="login.do">로그인</a>
    </form>
</body>

</html>