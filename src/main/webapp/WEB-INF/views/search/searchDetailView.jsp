<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/search.css">
</head>
<body>
<c:import url="../common/header.jsp"/>
<br><br><br>
<div id="sdetail" class="wrap">
    <h2>검색상세페이지</h2>
     <table class="sdecon">
            <tr>
                <th scope="col">제목</th>
                <td colspan="3">${search.board_title}</td>    
            </tr>
            <tr>
                <th scope="col">작성자</th>
                <td colspan="3">${search.board_writer}</td>
            </tr>
            <tr >
                <th>등록일</th>
                <td>${search.board_date}</td>
                <th>조회수</th>
                <td>${search.board_readcount}</td>
            </tr>
            <tr>
                <th>파일첨부</th>
                <c:if test="${empty search.board_original_filename}">
                	<td colspan="2">첨부파일이 없습니다.</td>
                </c:if>
                <td colspan="2">
                <a href="sdown.do?filename=${search.board_original_filename}">${search.board_original_filename}</a></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3" style="text-align: justify;">
                ${search.board_content}
                </td>
         </tr>
        </table>
        <br><br>
        <h3>피의자정보</h3>
        <br>
        <table class="sdecon">
            <tr>
                <th>피의자</th>
                <td>${suspect.suspect_name}</td>
            </tr>
            <tr>
                <th>핸드폰번호</th>
                <td>${suspect.suspect_phone}</td>
            </tr>
            
            <tr>
                <th>계좌번호</th>
                <td>${suspect.suspect_account}</td>
            </tr>
        </table>
        <div id="slist" class="wrap">
            <div class="slist_btn">
                <a href="search.do">목록</a>
            </div>
        </div>

   <!--내용-->
 </div>
 <br><br><br>
 <c:import url="../common/footer.jsp"/>  
</body>
</html>