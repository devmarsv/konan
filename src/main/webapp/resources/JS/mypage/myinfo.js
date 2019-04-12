/**
 * 
 */

$(function () {
    var userid = $('#userid').val();

    $.ajax({
        async: true,
        type: 'POST',
        data: userid,
        url: "findBoard.do",
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            if (data.length == 0) {
                $('#boardBody').html("<tr><td colspan=6>작성하신 게시글이 없습니다.</td></tr>");
            } else {
                data.forEach(function (element) {
                    var date = new Date(element.board_date);
                    $('#boardBody').html($('#boardBody').html() + "<tr role='row' class='even'><td class='sorting_1'>" + element.board_num + "</td> <td colspan=3> <a href='#'>" + element.board_title + "</a> </td> <td>" + date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate() + "</td> <td>" + element.board_readcount + "</td></tr>");
                })
            }
        },
        error: function () {
            console.log("error");
        }
    });


    $.ajax({
        async: true,
        type: 'POST',
        data: userid,
        url: "findReply.do",
        dataType: "json",
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            if (data.length == 0) {
                $('#replyBody').html("<tr><td colspan=6>작성하신 댓글이 없습니다.</td></tr>");
            } else {
                data.forEach(function (element) {
                    var date = new Date(element.board_reply_date);
                    var content = element.board_reply_content;
                    if (content.length > 27) {
                        content = content.substring(0, 27).concat("...");
                    }
                    $('#replyBody').html($('#replyBody').html() + "<tr role='row' class='even'><td class='sorting_1'>" + element.board_reply_num + "</td> <td class='reply_content' colspan='2' style=''>" + content + "</td> <td style='border-left: hidden; text-align: right;'><a href='#'>원문 보기 ▶</a> &nbsp; &nbsp;</td> <td>" + date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate() + "</td></tr>");
                })
            }
        },
        error: function () {
            console.log("error");
        }
    });

});