<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>마이 페이지</title>
    <link href="/konan/resources/CSS/bootstrap.min.css" rel="stylesheet">
    <!-- 123 -->
    <link href="/konan/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/konan/resources/CSS/sb-admin-2.min.css" rel="stylesheet">

    <!-- Bootstrap core JavaScript-->
    <script src="/konan/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/konan/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/konan/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/konan/resources/JS/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <!-- <script src="/konan/resources/vendor/chart.js/Chart.min.js"></script> -->

    <!-- Page level custom scripts -->
    <!-- <script src="/konan/resources/JS/demo/chart-area-demo.js"></script> -->
    <!-- <script src="/konan/resources/JS/demo/chart-pie-demo.js"></script> -->
    <style type="text/css">
        #myinfo span {
            font-size: 12pt;
        }

        #myinfo input[readonly] {
            background-color: #f7f1e3;
        }

        select {
            text-align-last: center;
        }

        .reply_content {
            text-align: left;
        }
    </style>

    <script src="/konan/resources/JS/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="/konan/resources/JS/menu.js" defer="defer" type="text/javascript"></script>
    <script type="text/javascript">

        $(function () {
            var userid = "${sessionScope.loginMember.userid}";

            $.ajax({
                async: true,
                type: 'POST',
                data: userid,
                url: "findBoard.do",
                dataType: "json",
                contentType: "application/json; charset=UTF-8",
                success: function (data) {
                    if (data.length == 0) {
                        $('#boardBody').html("<tr><td colspan=5>작성하신 게시글이 없습니다.</td></tr>");
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
                            if(content.length > 27){
                                content = content.substring(0,27).concat("...");
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

    </script>

</head>


<body>
    <c:if test="${empty sessionScope.loginMember}">
        <c:redirect url="/index.jsp" />
    </c:if>

    <c:import url="../../common/header.jsp"></c:import>
    <c:import url="mypageHeader.jsp"></c:import>

    <div class="row">
        <div class="col-lg-6" style="width: 80%;">
            <!-- Default Card Example -->
            <div class="card shadow mb-4" style="width: 80%; float: right; height: 280px;">
                <div class="card-header py-3" style="width: 100%;">
                    <h2 class="m-0 font-weight-bold text-primary">프로필</h2>
                </div>
                <br>
                <div class="card-body" style="width: 100%">
                    <img src="/konan/resources/profileImage/${sessionScope.loginMember.userid}.png"
                        onerror="this.src='/konan/resources/image/iconfinder_ic_no_sim_48px_3669320.png'"
                        style="width: 150px; height: 150px; margin-left: 25px; float: left;">
                    <br>
                    <h2 style="position: absolute; left: 50%; top: 50%; float: left;">별명
                        : ${sessionScope.loginMember.username}</h2>
                </div>

                <a href="alterInfo.do" style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
                    <button class="btn btn-success btn-icon-split btn-sm">
                        <span class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
                        </span> <span class="text">수정하기</span>
                    </button>
                </a> <br>
            </div>

            <!-- Basic Card Example -->
            <div class="card shadow mb-4" style="width: 80%; float: right; height: 280px;">
                <div class="card-header py-3" style="width: 100%">
                    <h2 class="m-0 font-weight-bold text-primary">최근 내 게시글</h2>
                </div>
                <div class="card-body" style="width: 100%;">
                    <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0"
                        role="grid" aria-describedby="dataTable_info" style="width: 100%; text-align: center;">
                        <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-sort="ascending" aria-label="Name: activate to sort column descending"
                                    style="width: 60px;">번 호</th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="3"
                                    aria-label="Position: activate to sort column ascending" style="width: 63px;">제 목
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Start date: activate to sort column ascending" style="width: 69px;">작성일
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Salary: activate to sort column ascending" style="width: 67px;">조회수</th>
                            </tr>
                        </thead>
                        <tbody id="boardBody">

                        </tbody>
                    </table>
                </div>
                <a href="myBoard.do" style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
                    <button class="btn btn-success btn-icon-split btn-sm">
                        <span class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
                        </span> <span class="text">확인하기</span>
                    </button>
                </a> <br>
            </div>
        </div>

        <div class="col-lg-6">
            <!-- Dropdown Card Example -->
            <div class="card shadow mb-4" style="width: 80%; float: left; height: 280px;">
                <div class="card-header py-3" style="width: 100%">
                    <h2 class="m-0 font-weight-bold text-primary">접속 기록</h2>
                </div>
                <div class="card-body" style="width: 100%;">
                    <br>
                    <h2 style="position: absolute; top: 50%; float: left; margin-left: 10px;">최근
                        접속 아이피 :</h2>
                </div>
                <a href="myConnection.do" style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
                    <button class="btn btn-success btn-icon-split btn-sm">
                        <span class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
                        </span> <span class="text">확인하기</span>
                    </button>
                </a> <br>
            </div>

            <!-- Collapsable Card Example -->
            <div class="card shadow mb-4" style="width: 80%; float: left; height: 280px;">
                <div class="card-header py-3" style="width: 100%">
                    <h2 class="m-0 font-weight-bold text-primary">최근 내 댓글</h2>
                </div>
                <div class="card-body" style="width: 100%;">
                    <table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0"
                        role="grid" aria-describedby="dataTable_info" style="width: 100%; text-align: center;">
                        <thead>
                            <tr role="row">
                                <th class="sorting_asc" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-sort="ascending" aria-label="Name: activate to sort column descending"
                                    style="width: 60px;">번 호</th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="3"
                                    aria-label="Position: activate to sort column ascending" style="width: 63px;">내 용
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="dataTable" rowspan="1" colspan="1"
                                    aria-label="Salary: activate to sort column ascending" style="width: 67px;">날짜</th>
                            </tr>
                        </thead>
                        <tbody id="replyBody">

                        </tbody>
                    </table>
                </div>
                <a href="myReply.do" style="float: right; margin-left: 30px; margin-top: 5px; width: 70px;">
                    <button class="btn btn-success btn-icon-split btn-sm">
                        <span class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
                        </span> <span class="text">확인하기</span>
                    </button>
                </a> <br>
            </div>
        </div>
    </div>

    <br>
    <br>

    <c:import url="../../common/footer.jsp"></c:import>

</body>

</html>