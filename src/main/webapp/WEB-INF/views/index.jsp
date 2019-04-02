<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Page Title</title>
  <title>Untitled Document</title>
  <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/style.css">
   <script src="/konan/resources/JS/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="/konan/resources/JS/menu.js" defer="defer" type="text/javascript"></script>
</head>

<body>
  <c:import url="common/header.jsp"></c:import>
  <div id="notice" class="wrap">
    <h2>공지사항</h2>
    <table align="center" border="1" cellspacing="0" width="1000">
      <th width="100">게시번호</th>
      <th width="200">작성자</th>
      <th>제목</th>
      <th width="100">등록일</th>
      <th width="100">조회</th>

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
    </table>
    <div id="write_btn" class="wrap">
      <a href="#">글쓰기</a>
    </div>
  </div>
  <div id="clear"></div>

  <div id="search" class="wrap">
    <form action="#" method="get" align="center" id="setRows">
      <div class="box">
        <select id="cgno">
          <option value="">전체</option>
          <option value="">제목</option>
          <option value="">내용</option>
        </select>
        <input type="text" name="bar" id="search_bar" placeholder="내용" />
        <input type="submit" name="search" id="search_btn" vlaue="검색" />
      </div>
    </form>
  </div>
  <div id="clear"></div>
  <c:import url="common/footer.jsp"></c:import>
</body>

</html>