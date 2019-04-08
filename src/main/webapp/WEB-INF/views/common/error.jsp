<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <script src="/konan/resources/JS/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="/konan/resources/JS/menu.js" defer="defer" type="text/javascript"></script>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/konan/resources/CSS/sb-admin-2.min.css" rel="stylesheet">
    
</head>

<body>
    <div class="container-fluid">
          <!-- 404 Error Text -->
          <div class="text-center">
            <div class="error mx-auto" data-text="404">404</div>
            <p class="lead text-gray-800 mb-5">Page Not Found</p>
            <p class="text-gray-500 mb-0">It looks like you found a glitch in the matrix...</p>
            <a href="main.do">← Back to Dashboard</a>
          </div>
   </div>
</body>

</html>