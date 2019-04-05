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
<c:import url="common/header.jsp"/>
 <h2 class="main_search">사기피해사례검색</h2>
   <div class="search-box">
    <input class="search-txt" type="text" name="" placeholder="연락처 또는 계좌번호로 검색">
    <a class="search-btn" href="#">
      <img src="/konan/resources/img/search.png">
    </a> 
    </div>      
<c:import url="common/footer.jsp"/>
</body>

</html>