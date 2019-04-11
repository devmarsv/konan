<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/board.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../common/header.jsp"/>
<br><br><br>
<div id="bdetail" class="wrap">
    <h2>자유게시판</h2>
     <table class="bdecon">
            <tr>
                <th scope="col">제목</th>
                <td colspan="3">${board.board_title}</td>    
            </tr>
            <tr>
                <th scope="col">작성자</th>
                <td colspan="3">${board.board_writer}</td>
            </tr>
            <tr >
                <th>등록일</th>
                <td>${board.board_date}</td>
                <th>조회수</th>
                <td>${board.board_readcount}</td>
            </tr>
            <tr>
                <th>파일첨부</th>
                <td colspan="3"><a href="bdown.do?filename=${board.board_original_filename}">${board.board_original_filename}</a></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3" style="text-align: justify;">${board.board_content}</td>
            </tr>
        </table>
        <div id="blist" class="wrap">
            <div class="blist_btn">
                <a href="board.do">목록</a>
            </div>
        </div>

   <!--내용-->
 </div>  
<!--댓글-->
<div id="com_box" class="wrap">
   <div class="comm" >
        <form action="" name="" class="cform">
          <br><h4 style="text-align: left;">댓글</h4><br>
           <ul>
            <li><textarea cols="140" rows="4" placeholder="댓글을 입력하세요. " name="content" style="text-align: left;"></textarea></li>
            <li><input type="submit" name="comm" class="comm_btn" vlaue="댓글등록"/></li>
            </ul>
        </form>
   </div>
   <hr style="border: 0.5px solid #e2e2e2;">
   <div class="comm_con">
       <table>
           <tr>
               <td class="user">작성자</td>
               <td class="date">등록날짜</td>
           </tr>
           <tr>
               <td class="con">내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용</td>
           </tr>
       </table>
       <hr style="border: 0.5px solid #e2e2e2; width:1100px;">
       <table>
           <tr class="comm_line">
               <td class="user">작성자</td>
               <td class="date">등록날짜</td>
           </tr>
           <tr>
               <td class="con">내용</td>
           </tr>
       </table>
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