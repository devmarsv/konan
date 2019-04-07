<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/notice.css">
</head>
<body>
<c:import url="../common/header.jsp"/>
<br><br><br>
<div id="ndetail" class="wrap">
    <h2>공지사항</h2>
     <table class="ndecon">
            <tr>
                <th scope="col">제목</th>
                <td colspan="3">제목</td>    
            </tr>
            <tr>
                <th scope="col">작성자</th>
                <td colspan="3">작성자</td>
            </tr>
            <tr >
                <th>등록일</th>
                <td>등록일</td>
                <th>조회수</th>
                <td>0</td>
            </tr>
            <tr>
                <th>파일첨부</th>
                <td colspan="3">파일파일</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3" style="text-align: justify;">내용내용내용내용내용내용
                내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용
                </td>
            </tr>
        </table>
        <div id="nlist" class="wrap">
            <div class="nlist_btn">
                <a href="notice.do">목록</a>
            </div>
        </div>

   <!--내용-->
 </div>  

<br><br><br><br><br>

<c:import url="../common/footer.jsp"/>
</body>
</html>