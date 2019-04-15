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
<script type="text/javascript" src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		getCommentList();
	});
	<!-- 댓글등록하기(Ajax) -->
	$(function(){
		$("#comm_btn").on("click", function(){
			   $.ajax({
				  url : "adminFreeReplyInsert.do",
				  type: "post",
				  data:$("#commform").serialize(),
				  dataType:"json",
				  success : function(data){
					  if(data.result==1){
						  getCommentList();
						  $("#comment").val("");
					  }else{
						  alert("전송실패");
					  }
				  },
				  error : function(request, status, error){
				  }
			 });
		});
	});
<!--댓글 불러오기(Ajax)-->
function getCommentList(){
	$.ajax({
		   url : "adminFreeReplyList.do",
		   type: "post",
		   data:$("#commform").serialize(),
		   dataType:"json",
		   success : function(data){
			
			   var html = "";
			   var cCnt = data.length;
			   
			   if(data.length > 0){
				   html += "<table style='border-bottom: 0.5px solid #e2e2e2; width:1100px;'>";
				   html += "<tr class='comm_line'>";
				   html += "<th class='user'>작성자</th>";
				   html += "<th class='date'>등록날짜</th>";
				   html += "<th class='con'>내용</th>";
				   html += "</tr>";
				   for(var i=0; i<data.length; i++){
					   html += "<tr class='comm_line'>";
					   html += "<td class='user'>"+data[i].writer+"</td>";
					   html += "<td class='date'>"+data[i].date+"</td>";
					   html += "<td class='con'>"+data[i].comment+"</td>";
				   }
				   html += "</table>";
			   }else {
				   html += "<table>";
				   html += "<tr class='comm_line'>";
				   html += "<td class='user'>등록된 댓글이 없습니다.</td>";
				   html += "</tr>";
				   html += " </tr></table><hr style='border: 0.5px solid #e2e2e2; width:1100px;'>"; 
				   
			   }
			   
			   $("#cCnt").html(cCnt);
			   $("#commentList").html(html);
			   
		 },
		 error:function(request,status,error){
			 alert(request);			 
			 alert(status);			 
			 alert(error);			 
		 }
	});

}  
</script>
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../../common/header.jsp"/>
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
                <td colspan="3"><a href="adminFreeDown.do?filename=${board.board_original_filename}">${board.board_original_filename}</a></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3" style="text-align: justify;">${board.board_content}</td>
            </tr>
        </table>
        <div id="blist" class="wrap">
            <div class="blist_btn">
                <a href="adminFreeList.do">목록</a>
            </div>
        </div>

   <!--내용-->
 </div>  
<!--댓글-->
<div id="com_box" class="wrap">
   <div class="comm" >
        <form id="commform" name="boardReply" class="cform">
        	<input type="hidden" name="board_num" value="${board_num}"/>
          <br><h4 style="text-align: left;">댓글</h4><span id="cCnt"></span><br>
           <ul>
            <li><textarea cols="140" rows="3" placeholder="댓글을 입력하세요. " id="comment" name="content" style="text-align: left;"></textarea></li>
            <li><a href="#" id ="comm_btn" class="comm_btn">댓글등록</a></li>
            </ul>
        </form>
   </div>
   <hr style="border: 0.5px solid #e2e2e2;">
   
   <div class="comm_con" id="commentList">
       <%-- <table>
           <tr>
               <td class="user">${BoardReply.uderid}</td>
               <td class="date">${BoardReply.board_reply_date}</td>
           </tr>
           <tr>
               <td class="con">${BoardReply.board_reply_content}</td>
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
       <hr style="border: 0.5px solid #e2e2e2; width:1100px;"> --%>
   </div>
   
   

   
   
   
   
   <div class="paging">   
	 <nav aria-label="Page navigation example">
	  <ul class="pagination pagination-sm justify-content-center">
	    <li class="page-item">
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

<c:import url="../../common/footer.jsp"/>
</body>
</html>