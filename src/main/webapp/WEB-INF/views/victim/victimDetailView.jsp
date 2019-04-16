<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>victim Detail view</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/board.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
	<c:import url="../common/header.jsp"/>
<br><br><br>
<div id="vdetail" class="wrap">
    <h2>피해사례 현황</h2>
     <table align="center" cellpadding="10" cellspacing="0" border="1" width="500" class="bdecon">
            <tr align="center" valign="middle">
                <th colspan="2">${victim.getBoardnum }번 글 상세보기</th>
            </tr>
            <tr>
                <th scope="col">제목</th>
                <td colspan="3">${victim.getBoardtitle() }</td>    
            </tr>
            <tr>
                <th scope="col">작성자</th>
                <td colspan="3">${victim.getBoardwriter() }</td>
            </tr>
            <tr >
                <th>등록일</th>
                <td>${victim.getBoarddate() }</td>
                <th>조회수</th>
                <td>${victim.getBoardreadcount() }</td>
            </tr>
            <tr>
                <th>파일첨부</th>
                <c:if test="${empty victim.getOriginal_filepath }"> 첨부파일 없음</c:if>
                <c:if test="${!empty victim.getOriginal_filepath }">
                <td colspan="3"><a href="/konan/bfdown?ofile=${victim.getOriginal_filepath }&rfile=${victim.getRename_filepath">${victim.getOriginal_filepath }</a>
                </td>
                </c:if> 
            </tr>
            
            <tr>
                <th>내 용</th>
                <td colspan="3" style="text-align: justify;">${victim.getBoardcontent() }</td>
            </tr>
        </table>
        <div id="blist" class="wrap">
            <div class="vlist_btn">
                <a href="victimboard.do">목록</a>
            </div>
        </div>

  
 </div>  
   <div class="paging">   
     <nav aria-label="Page navigation example">
      <ul class="pagination pagination-sm justify-content-center">
        <li class="page-item disabled">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>
    </nav>
    </div>
</div>

<br><br><br><br><br>

<c:import url="../common/footer.jsp"/>
</body>
</html>



