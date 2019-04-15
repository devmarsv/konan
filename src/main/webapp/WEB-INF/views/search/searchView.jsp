<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/search.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../common/header.jsp"/>
<br><br><br><br>
 <div id="search_box" class="wrap">
  <form action="search.do" method="get" align="center">
   <table class="search_bar">
       <tr>
           <th>거래구분</th>
           <td><select id="cg" name="cg">
              <option value="전체" <c:if test='${cg=="전체"}'>selected</c:if>>전체</option>
              <option value="직거래" <c:if test='${cg=="직거래"}'>selected</c:if>>직거래</option>
              <option value="게임·비실물" <c:if test='${cg=="게임·비실물"}'>selected</c:if>>게임·비실물</option>
              </select>
           </td>
           <td rowspan="2">
           <input type="submit" name="search" id="search_btn" vlaue="검색"/></td>
        </tr>
        <tr>
            <th>피해사례 검색</th>
            <td><input type="text" name="bar" id="search_bar" value="${bar}" placeholder="내용"/></td>
        </tr>
      </table>
</form>
</div>

<div id="clear"></div>


<div id="search" class="wrap">
        <table class="sview">
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
            <c:choose>
            	<c:when test="${fn:length(searchList) > 0 }">
            		<c:forEach items="${searchList}" var="notice" varStatus="status">
            <tr>
                <td>${search.board_num}</td>
                <td>${search.board_writer}</td>
                <td><a href="sdetail.do?board_num=${board.board_num}">${search.board_title}</a></td>
                <td>${search.board_date}</td>
                <td>${search.board_readcount}</td>
            </tr>
            </c:forEach>
            </c:when>
            <c:otherwise>
            	<td colspan="5">조회된 결과가 없습니다.</td>
            </c:otherwise>
            </c:choose>
            </tbody>    
        </table>
</div>

<br>


<div id="write_btn" class="wrap">
	<ul>
		<li class="page"><nav aria-label="Page navigation example">
			  <ul class="pagination pagination-sm justify-content-center">
			    <li class="page-item">
			    <c:url var="first" value="search.do">
			    	<c:param name="page" value="1"/>
			    </c:url>
			      <a class="page-link" href="${first}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			        <span class="sr-only">Previous</span>
			      </a>
		    </li>
		    
		    <c:forEach var="p" begin="${startPage}" end="${endPage}" step="1">
		    		<c:url var="move" value="search.do">
		    			<c:param name="page" value="${p}"/>
		    		</c:url>
		    		<c:if test="${p eq currentPage}">
		    			<li class="page-item active"><a class="page-link" href="#">${p}<span class="sr-only">(current)</span></a></li>
		    		</c:if>
		    		<c:if test="${p ne currentPage}">
		    			<li class="page-item"><a class="page-link" href="${move}">${p}</a></li>
		    		</c:if>
		    	</c:forEach>
		   
		    <li class="page-item">
		    <c:url var="last" value="search.do">
		    	<c:param name="page" value="${maxPage}"/>
		    </c:url>
		      <a class="page-link" href="#{last}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		        <span class="sr-only">Next</span>
		      </a>
		    </li>
		    
		  </ul>
		</nav>
	</li>
	</ul>
</div>
  
<br><br><br>
<c:import url="../common/footer.jsp"/>
</body>
</html>