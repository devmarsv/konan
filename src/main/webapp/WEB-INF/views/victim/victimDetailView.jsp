<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>victim Detail view</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/notice.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
	<c:import url="../common/header.jsp"/>
<br><br><br>
<div id="ndetail" class="wrap">
    <h2>피해사례 현황</h2>
    <table class="ndecon">
			<tr>
                <th scope="col">제목</th>
                <td colspan="3">${victim.board_title }</td>    
            </tr>
            <tr>
                <th scope="col">작성자</th>
                <td colspan="3">${victim.board_writer }</td>
            </tr>
            <tr >
                <th>등록일</th>
                <td>${victim.board_date }</td>
                <th>조회수</th>
                <td>${victim.board_readcount }</td>
            </tr>
            <tr>
               <th>파일첨부</th>
				<c:if test="${empty victim.board_original_filename}">
					<td colspan="2">첨부파일이 없습니다.</td>
				</c:if>
				<td colspan="2"><a
					href="vdown.do?filename=${victim.board_original_filename}">${victim.board_original_filename}</a></td>
				<!-- 첨부파일이 1개이상일경우 -->

			</tr>
			<tr>
              <th>내용</th>
				<td colspan="3" style="text-align: justify;">${victim.board_content}</td>
			</tr>
		</table>
		<div id="nlist" class="wrap">
			<div class="nlist_btn">
				<a href="victimboard.do">목록</a>
			</div>
		</div>
		<!--내용-->
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>

	<c:import url="../common/footer.jsp" />
</body>
</html>



