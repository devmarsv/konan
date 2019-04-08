var idcheck = false;
var pwdcheck = false;
var emailcheck = false;

$(function () {
    $('#id').blur(function () {
        var userid = $('#id').val();
        if (userid == null) {
            return;
        }
        $.ajax({
            async: true,
            type: 'POST',
            data: userid,
            url: "idcheck.do",
            dataType: "json",
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                if (!(6 <= userid.length && userid.length <= 12)) {
                    $('#errorMsg').show();
                    $('#errorMsg').html("아이디 길이가 요구조건에 만족하지 않습니다.<br>(아이디는 6글자 12자 이하로 허용됩니다.)<br><br>");
                    $('#idcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
                    $('#idcheck').attr("title", "아이디 요구조건이 만족되지 않습니다.");
                    return false;
                } else {
                    $('#errorMsg').hide();
                }

                for (var i in userid) {
                    var ch = userid.charAt(i);
                    if (!(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')
                        || ('0' <= ch && ch <= '9') || (ch == '#' || ch == '_'
                            || ch == '!' || ch == '*'))) {
                        $('#errorMsg').show();
                        $('#errorMsg').html("아이디가 요구조건에 만족하지 않습니다.<br>(아이디는 영어소문자, 대문자, 숫자, 기호문자(#,_,!,*)로 허용됩니다.)<br><br>");
                        $('#idcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
                        $('#idcheck').attr("title", "아이디 요구조건이 만족되지 않습니다.");
                        return false;
                    } else {
                        $('#errorMsg').hide();
                    }
                }

                if (data.cnt > 0) {
                    $('#idcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
                    $('#idcheck').attr("title", "중복되는 아이디입니다.");
                    return false;
                } else {
                    $('#idcheck').attr("src", "/konan/resources/image/iconfinder_success_1646004.png");
                    $('#idcheck').attr("title", "");
                    idcheck = true;
                }
            }
        });
    });

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

    $('#email').blur(function () {
        var email = $('#email').val();
        if (email == null) {
            email = "23";
        }
        $.ajax({
            async: true,
            type: 'POST',
            data: email,
            url: "emailCheck.do",
            dataType: "json",
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                for (var i in email) {
                    var ch = email.charAt(i);
                    var token;
                    if (ch == '@') {
                        token = '@';
                        break;
                    }
                }

                if (token != '@') {
                    $('#emailCheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
                    $('#emailCheck').attr("title", "이메일 형식에 맞지 않습니다.");
                    return false;
                }

                if (data.cnt > 0) {
                    $('#emailCheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
                    $('#emailCheck').attr("title", "중복되는 이메일입니다.");
                    return false;
                } else {
                    $('#emailCheck').attr("src", "/konan/resources/image/iconfinder_success_1646004.png");
                    $('#emailCheck').attr("title", "");
                    emailcheck = true;
                }
            }
        });
    });
});

function checkValidate() {
    return idcheck && pwdcheck && emailcheck;
}