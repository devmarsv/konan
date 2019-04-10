/**
 * 
 */

var pwdcheck = false;
var pwdcheck2 = false;

$(function () {
    $("#pwd2").blur(function () {
        var pwd = $("#pwd").val();
        var pwd2 = $("#pwd2").val();
        if (pwdcheck == false) {
            $('#pwcheck2').attr("src", "/konan/resources/image/normal-white.png");
            return;
        }
        if (pwd != pwd2) {
            $('#pwcheck2').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
            $('#pwcheck2').attr("title", "비밀번호가 일치하지 않습니다.");
            pwdcheck2 = false;
        } else {
            $('#pwcheck2').attr("src", "/konan/resources/image/iconfinder_success_1646004.png");
            pwdcheck2 = true;
        }
    });

    $('#pwd').blur(function () {
        var userpwd = $('#pwd').val();
        var pwd2 = $("#pwd2").val();

        if (!(6 <= userpwd.length && userpwd.length <= 12)) {
            $('#pwcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
            $('#pwcheck').attr("title", "비밀번호 요구조건이 만족되지 않습니다.");
            pwdcheck = false;
            $('#pwcheck2').attr("src", "/konan/resources/image/normal-white.png");
            return;
        }

        for (var i in userpwd) {
            var ch = userpwd.charAt(i);
            if (!(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')
                || ('0' <= ch && ch <= '9') || (ch == '!' || ch == '@'
                    || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*'))) {
                $('#pwcheck').attr("src", "/konan/resources/image/iconfinder_error_1646012.png");
                $('#pwcheck').attr("title", "비밀번호 요구조건이 만족되지 않습니다.");
                $('#pwcheck2').attr("src", "/konan/resources/image/normal-white.png");
                pwdcheck = false;
                return;
            } else {
                $('#pwcheck').attr("src", "/konan/resources/image/iconfinder_success_1646004.png");
                pwdcheck = true;
            }
        }

        if (pwd != pwd2 || pwd2 == "") {
            $('#pwcheck2').attr("src", "/konan/resources/image/normal-white.png");
            pwdcheck2 = false;
        }
    });

    $('#uploadFile').on("change", function () {
        fileCheck(this);
    });

});

function checkInvalidate() {
    if (pwdcheck == false) {
        $('#pwd').select();
        return false;
    }
    if (pwdcheck2 == false) {
        $('#pwd2').select();
        return false;
    }
    return pwdcheck && pwdcheck2;
}



function fileCheck(fi) {
    if ($('#delete').val()) {
        return true;
    }

    var file = $("#uploadFile").val();

    if (file == null) {
        return false;
    }

    var fn = file.substring(file.lastIndexOf('.') + 1); //파일의 확장자를 구합니다.

    if (fn.toUpperCase() == "PNG" || fn.toUpperCase() == "JPEG"
        || fn.toUpperCase() == "JPG" || fn.toUpperCase() == "JPE"
        || fn.toUpperCase() == "GIF") {

        if (fi.files && fi.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#profileImage').attr('src', e.target.result);
            }
            reader.readAsDataURL(fi.files[0]);
        }

        return true;
    } else {
        alert("이미지파일만 업로드 가능합니다(PNG,JPEG,JPG,GIF,JPE)");
        return false;
    }
}


function imageUpload() {
    $('#uploadFile').click();
}

function deleteImage() {
    var date = new Date();
    $('#profileImage').attr(
        "src",
        "/konan/resources/image/iconfinder_ic_no_sim_48px_3669320.png?time="
        + date.getDate());
    $('#delete').val(true);
}


