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
<br><br><br>
 <h2 class="main_search" style="text-align:center; height:100px;">사기피해사례검색</h2><br><br>
   <div class="search-box" style="text-align:center; height:300px;">
    <input class="search-txt" style="width:400px; height:50px;" type="text" name="" placeholder="연락처 또는 계좌번호로 검색">
    <a class="search-btn" href="#">
      <img src="/konan/resources/img/search.png">
    </a> 
    </div>      
<c:import url="common/footer.jsp"/>
</body>

</html>