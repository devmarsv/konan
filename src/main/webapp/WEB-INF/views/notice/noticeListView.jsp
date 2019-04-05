<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/notice.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<style type="text/css">
	input::-webkit-input-placeholder { color: #ddd; }
		  
</style>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../common/header.jsp"/> 
<div id="notice" class="wrap">
        <h2>공지사항</h2>
        <table class="nview">
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
            <tr>
                <td>게시번호</td>
                <td>작성자</td>
                <td><a href="ndetail.do">제목</a></td>
                <td>등록일</td>
                <td>조회</td>
            </tr>
            
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="ndetail.do">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr>
                
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr> 
                
                        <tr>
                <td>게시번호</td>
                <td>작성자</td>
                <td><a href="#">제목</a></td>
                <td>등록일</td>
                <td>조회</td>
            </tr>
            
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr>
                
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr>
                
            <tr>
                <td>게시번호</td>
                <td>작성자</td>
                <td><a href="#">제목</a></td>
                <td>등록일</td>
                <td>조회</td>
            </tr>
            
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr>
                
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr> 
                
                        <tr>
                <td>게시번호</td>
                <td>작성자</td>
                <td><a href="#">제목</a></td>
                <td>등록일</td>
                <td>조회</td>
            </tr>
            
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr>
                
            <tr>
            <td>게시번호</td>
            <td>작성자</td>
            <td><a href="#">제목</a></td>
            <td>등록일</td>
            <td>조회</td>
            </tr>                
            </tbody>    
        </table>
<div id="write_btn" class="wrap">
	<ul>
		<li class="page"><nav aria-label="Page navigation example">
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
	</li>
		<li class="wrbtn"><a href="bform.do">글쓰기</a></li>
	</ul>
</div>

<div class="search">
<form action="#" method="get" align="center" id="setRows">
  <div class="box">
    <select id="cgno">
      <option value="">전체</option>
      <option value="">제목</option>
      <option value="">내용</option>
    </select>
    <input type="text" name="bar" id="search_bar" placeholder="내용"/>
    <input type="submit" name="search" id="search_btn" vlaue="검색"/>
  </div>
</form>
</div>
<div id="clear"></div>
<br><br><br>
<c:import url="../common/footer.jsp"/>
</body>
</html>