<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/board.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<style type="text/css">
	input::-webkit-input-placeholder { color: #ddd; }
	.bview tr td a{
 			color:#22518A;
    		text-decoration: none;
    	} 
</style>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../common/header.jsp"/> 
<div id="board" class="wrap">
        <h2>자유게시판</h2>
        <table class="bview">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="*">
                <col width="150">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <th scope="row">게시번호</th>
                <th scope="row">작성자</th>
                <th scope="row">제목</th>
                <th scope="row">등록일</th>
                <th scope="row">조회</th> 
            </tr>
            </thead>
            
            <tbody>
			<c:forEach items="${boardList}" var="board" varStatus="status">
            <tr>
                <td>${board.board_num}</td>
                <td>${board.board_writer}</td>
                <td><a href="bdetail.do?board_num=${board.board_num}">${board.board_title}</a></td>
                <td>${board.board_date}</td>
                <td>${board.board_readcount}</td>
            </tr>
            </c:forEach>
            </tbody>    
        </table>
</div>
<div id="clear"></div> 

 
<div id="write_btn" class="wrap">
	<ul>
		<li class="page"><nav aria-label="Page navigation example">
			  <ul class="pagination pagination-sm justify-content-center">
			    <li class="page-item">
			    <!-- 맨처음 -->
			    <c:url var="first" value="board.do">
			    	<c:param name="page" value="1"/>
			    </c:url>
			      <a class="page-link" href="${first}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			        <span class="sr-only">Previous</span>
			      </a>
		   
		    <c:forEach var="p" begin="${startPage}" end="${endPage}" step="1">
		    	<c:url var="move" value="board.do">
		    		<c:param name="page" value="${p}"/>
		    	</c:url>
		    	<c:if test="${p == currentPage}">
				    <li class="page-item active"><a class="page-link" href="#">${p}<span class="sr-only">(current)</span></a></li>
		    	</c:if>
		    	<c:if test="${p != currentPage}">
				    <li class="page-item"><a class="page-link" href="${move}">${p}</a></li>
		    	</c:if>
		    </c:forEach>	
		    
		    
		    <!-- 맨끝 -->
		    <li class="page-item">
		    <c:url var="next" value="board.do">
		    	<c:param name="last" value="${maxPage}"/>
		    </c:url>
		      <a class="page-link" href="${last}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		        <span class="sr-only">Next</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</li>
		<li class="wrbtn"><a href="bform.do">글쓰기</a></li>
	</ul>
</div>

<div id="clear"></div>

<div id="search" class="wrap">
<form action="board.do" method="get" align="center" id="setRows">
  <div class="box">
    <select id="cg" name="cg">
      <option value="all" <c:if test='${cg == "all"}'>selected</c:if>>전체</option>
      <option value="title"<c:if test='${cg == "title"}'>selected</c:if>>제목</option>
      <option value="content"<c:if test='${cg == "content"}'>selected</c:if>>내용</option>
    </select>
    <input type="text" name="bar" id="search_bar" placeholder="내용" value="${bar}" />
    <input type="submit" name="search" id="search_btn" vlaue="검색"/>
  </div>
</form>
</div>
<div id="clear"></div>
<br><br><br><br>
<c:import url="../common/footer.jsp"/>
</body>
</html>