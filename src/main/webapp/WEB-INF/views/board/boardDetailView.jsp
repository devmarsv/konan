<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/board.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<style type="text/css">

li a{text-decoration: none !important;}
#comm_btn {
	margin-top:1px;
	padding: 20px;
	border-radius: 8px;
	background: #87CEEB;
	
}

#comm_btn:hover {
	background: #007bff;
}

.write_btn {
	padding:10px;
	font-size:15px;
	border-radius: 20px;
	color:blue;
	float: right;
	margin:3px;
}

</style>
<script type="text/javascript"
	src="/konan/resources/JS/jquery-3.3.1.min.js"></script>
<script type="text/javascript">


	$(document).ready(function(){
		getCommentList();
	});
	/*
 var bDisplay = true;
	function doDisplay(){
	    var con = document.getElementById("comm_box");
	    if(con.style.display=='none'){
	        con.style.display = 'block';
	    }else{
	        con.style.display = 'none';
	    }
	}
	
	$(function(){
		$('#comm_btn').on("click", function(){
			if($(this).html() == '더보기'){
				$(this).html('접기');
			}
			else{
				$(this).html('더보기');
			}
		});
	}); */
	
	<!-- 댓글등록하기(Ajax) -->
	$(function(){
		$("#comm_btn").on("click", function(){
			   $.ajax({
				  url : "addBreply.do",
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
			   url : "breplyList.do",
			   type: "post",
			   data:$("#commform").serialize(),
			   dataType:"json",
			   success : function(data){
				
				   var html = "";
				   var cCnt = data.length;
				   var userid = "${loginMember.userid}";
				   
				   if(data.length > 0){
					   html += "<table style='border-bottom: 0.5px solid #e2e2e2; width:1100px;'>";
					   html += "<tr class='comm_line'>";
					   html += "<th class='user'>작성자</th>";
					   html += "<th class='con'>내용</th>";
					   html += "<th class='date'>등록날짜</th>";
					   html += "</tr style='border: 0.5px solid #e2e2e2; width:1100px;'>";
					   for(var i=0; i<data.length; i++){
						   html += "<tr class='comm_line'>";
						   html += "<td class='user'>"+data[i].writer+"</td>";
						   html += "<td class='con'>"+data[i].comment+"</td>";
						   html += "<td class='date'>"+data[i].date+"</td>";
						   html += "<td>";
						   if(userid == data[i].writer)
						   	html += "<a href='deleteBreply.do?br_num="+data[i].br_num+"&board_num="+${board_num}+"'>삭제</a>";
						   html += "</td></tr>";
					   }
					   html += "</table>";
					   
				   }else {
					   html += "<table>";
					   html += "<tr class='comm_line'>";
					   html += "<td class='user'>등록된 댓글이 없습니다.</td>";
					   html += "</tr>";
					   html += " </tr></table>"; 
					   
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<body>
	<c:import url="../common/header.jsp" />
	<br>
	<br>
	<br>
	<div id="bdetail" class="wrap">
		<h2>자유게시판</h2>
		<c:if test="${loginMember.userid eq board.board_writer}">
			<a class="write_btn" href="bdelete.do?board_num=${board.board_num}">게시글 삭제</a>
			<span class="write_btn">|</span>
			<a class="write_btn" href="bupdateView.do?board_num=${board.board_num}">게시글 수정</a>
		</c:if>
		<table class="bdecon">
			<tr>
				<th scope="col">제목</th>
				<td colspan="3">${board.board_title}</td>
			</tr>
			<tr>
				<th scope="col">작성자</th>
				<td colspan="3">${board.board_writer}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td>${board.board_date}</td>
				<th>조회수</th>
				<td>${board.board_readcount}</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<c:choose>
					<c:when test="${empty board.board_original_filename}">
						<td colspan="3"><img src="/konan/resources/image/nonfile.png"> 첨부파일이 없습니다.</td>
					</c:when>
					<c:otherwise>
						<td colspan="3"><img src="/konan/resources/image/file.jpg">
							<a href="bdown.do?filename=${board.board_original_filename}">${board.board_original_filename}</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" style="text-align: justify;">${board.board_content}</td>
			</tr>
		</table>
		<div id="blist" class="wrap">
			<div class="blist_btn">
				<a href="board.do" style="color:#fff;">목록</a>
			</div>
		</div>

		<!--내용-->
	</div>
	<!--댓글-->
	<div id="com_box" class="wrap">
		<div class="comm">
			<form id="commform" name="boardReply" class="cform">
				<input type="hidden" name="board_num" value="${board_num}" /> <br>
				<h4 style="text-align: left;">
					댓글 <span id="cCnt"></span>
				</h4>
				<br>
				<ul id="comm_box">

					<c:choose>
						<c:when test="${!empty loginMember}">
							<li><textarea cols="130" rows="3" placeholder="댓글을 입력하세요. "
									id="comment" name="content" style="text-align: left; width:950px;""></textarea></li>
							<li id="comm_btn"><a href="#" style="color:#fff;">댓글등록</a></li>
						</c:when>
						<c:otherwise>
							<li><textarea cols="130" rows="3"
									placeholder="로그인 을 하셔야 댓글을 등록하실수 있습니다. " id="comment"
									name="content" style="text-align: left; width:950px;"></textarea></li>
							<li id="comm_btn"><a href="login.do" style="color:#fff;">댓글등록</a></li>
						</c:otherwise>
					</c:choose>
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


		<!-- <a href="javascript:doDisplay();" id="comm_btn"
			style="text-align: center">더보기</a><br /> -->
		<br />
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:import url="../common/footer.jsp" />
</body>
</html>