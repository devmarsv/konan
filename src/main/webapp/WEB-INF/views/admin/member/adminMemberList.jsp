<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resources/CSS/notice.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<style type="text/css">
	input::-webkit-input-placeholder { color: #ddd; }
	.nview tr td a{
 			color:#22518A;
    		text-decoration: none;
    	}
		  
</style>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
</head>



<script type="text/javascript">
	$(function(){
	
		//showDiv();
	/* 	$("#allDiv").css("display", "block");
		$("#nameDiv").css("display", "none");
		$("#idDiv").css("display", "none");
		 */
		
		/* $("#cgno").change(function(){
			showDiv();
		});
		*/
	
		$("#allDiv").css("display", "block");
		$("#nameDiv").css("display", "none");
		$("#idDiv").css("display", "none");
		
	});
	 
	function getval(sel)
	{

	  if(sel.value == "전체")
		  {
		  
		  $("#allDiv").css("display", "block");
			$("#nameDiv").css("display", "none");
			$("#idDiv").css("display", "none");
		  }
	  
	  if(sel.value == "이름")
	  {
	  
		  $("#allDiv").css("display", "none");
			$("#nameDiv").css("display", "block");
			$("#idDiv").css("display", "none");
	  }
	  
	  if(sel.value == "아이디")
	  {
	  
		  $("#allDiv").css("display", "none");
			$("#nameDiv").css("display", "none");
			$("#idDiv").css("display", "block");
	  }
	}
	
function showDiv(val){
		
	if($("select option:selected").val()==val)
    {
		
		$("#allDiv").css("display", "block");
		$("#nameDiv").css("display", "none");
		$("#idDiv").css("display", "none");
     
		alert(3);
		}
	
	if($("select option:selected").val()==val)
		{
		
		$("#allDiv").css("display", "none");
		$("#nameDiv").css("display", "block");
		$("#idDiv").css("display", "none");
	
		alert(2);
		
		}
	if($("select option:selected").val()==val)
     {
		
		$("#allDiv").css("display", "none");
		$("#nameDiv").css("display", "none");
		$("#idDiv").css("display", "block");

		alert(1);
		}
	}
	
	
function memberDeleteCall(userid, state){
	alert(state);
	location.href = "adminMemberUpdateDelete.do?userid="+userid+"&state="+state;
 
}




function memberUpdateAccept(count)
{
	/* $.ajax({
		url: "test1.do",
		data: { userid: uid},
		dataType: "json",
		type: "post",
		success: function(jsonData){
			console.log("jsonData : " + jsonData);
		    	
               
	
	},
	error: function(request, status, errorData){
		console.log("error code : " + request.status
			+ "\nmessage : " + request.responseText
			+ "\nerror : " + errorData);
	}
 }); */
 
 alert($("#idx"+count).html());
}
function memberUpdateCall(count,uid){
  
	
	$.ajax({
		url: "test1.do",
		data: { userid: uid},
		dataType: "json",
		type: "post",
		success: function(jsonData){
			console.log("jsonData : " + jsonData);
		    	
		
			/* 
			<tr align="center" id="idx${status.count}"> 
            <td>${status.count}</td>
            <td>
            <a href="#">${member.userid }</a>
            </td>
            <td>${member.username }</td>
            <td>${member.phone }</td>
             <td>${member.state }</td>
              <td><button onclick="memberUpdateCall(${status.count}, '${member.userid }');">수정</button></td>
               <td><button onclick="memberDeleteCall('${member.userid}', ${member.state });">탈퇴</button></td>
             
         </tr>  
			 */
		
		
				$("#idx"+count).html("<td>"+count+"</td><td><a href='#'>"+jsonData.userid+"</a></td><td><form action='test3.do' method='post'><input type='text' id='keyword' name='keyword' placeholder='"+decodeURIComponent(jsonData.username)+"'></input></td><td><input type='text' name='keyword' placeholder='"+jsonData.phone+"'></input></td><td><input type='text' name='keyword' placeholder='"+jsonData.state+"'></input></td></form><td><button onclick='ds(3);' class='btn btn-info'>완료</button></td><td><button type='button' class='btn btn-warning' onclick='back();'>취소</button></td></form>");
			
			 
		
           //<td><button onclick="memberDeleteCall('${member.userid}', ${member.state });">탈퇴</button></td>");
			/* </td>
			"
			
			"id : " + jsonData.userid +
					"<br>이름 : " + 	decodeURIComponent(jsonData.username) +
					"<br>phone : " + 
					jsonData.phone
					+ "<br>이메일 : " + 
					jsonData.email) */
			
		},
		error: function(request, status, errorData){
			console.log("error code : " + request.status
				+ "\nmessage : " + request.responseText
				+ "\nerror : " + errorData);
		}
	});
	
}

function ds(df){
	alert(3);
//location.href= "adminm.do";
}
function back(){

location.href= "adminMemberList.do";
}
	</script>
	
	
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../../common/header.jsp"/>




 
<div id="notice" class="wrap">
        <h2>회원 관리</h2>
        

<div id="allDiv" align="center">
	<form action="adminMemberSearch.do" method="post">
		<input type="hidden" name="search" value="all">
			 
		
		<select id="cgno" onchange="getval(this);">
      <option name="checkl" value="전체" selected>전체</option>
      <option name="checkl" value="이름">이름</option>
      <option name="checkl" value="아이디">아이디</option>
    </select>
		<input type="search" name="keyword" placeholder="연관검색어">
		<input type="submit" value="검색">
	</form>
</div>
<div id="nameDiv" align="center">
	<form action="adminMemberSearch.do" method="post">
		<input type="hidden" name="search" value="name">
		 
		<select id="cgno" onchange="getval(this);">
      <option name="checkl" value="전체">전체</option>
      <option name="checkl" value="이름" selected>이름</option>
      <option name="checkl" value="아이디">아이디</option>
    </select>	
    
		<input type="search" name="keyword" placeholder="이름">
		<input type="submit" value="검색">
	</form>
</div>
<div id="idDiv" align="center">
	<form action="adminMemberSearch.do" method="post">
		<input type="hidden" name="search" value="id">
		<select id="cgno" onchange="getval(this);">
      <option name="checkl" value="전체">전체</option>
      <option name="checkl" value="이름">이름</option>
      <option name="checkl" value="아이디" selected>아이디</option>
    </select>	
	    <input type="search" name="keyword" placeholder="아이디">
		<input type="submit" value="검색">
	</form>
</div>        
       




        <table class="nview">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="*">
                <col width="150">
                <col width="150">
                <col width="150">
                <col width="150">
            </colgroup>
            <thead>
            <tr>
                <th scope="row">번호</th>
                <th scope="row">아이디</th>
                <th scope="row">이름</th>
                <th scope="row">전화번호</th>
                <th scope="row">상태</th> 
                <th scope="row">수정</th> 
                <th scope="row">탈퇴</th> 
            </tr>
            </thead>
            
            <tbody>
   <c:choose>
      <c:when test="${fn:length(list) > 0}">
         <c:forEach items="${list }" var="member" varStatus="status">
           <tr align="center" id="idx${status.count}"> 
              <td>${status.count}</td>
              <td>
              <a href="#">${member.userid }</a>
              </td>
              <td>${member.username }</td>
              <td>${member.phone }</td>
               <td>${member.state }</td>
                <td><button type="button" class="btn btn-primary" onclick="memberUpdateCall(${status.count}, '${member.userid }');">수정</button></td>
                 <td><button type="button" class="btn btn-danger" onclick="memberDeleteCall('${member.userid}', ${member.state });">탈퇴</button></td>
               
           </tr>  
         </c:forEach>
      </c:when>    
      <c:otherwise>
          <tr>
          <td colspan="4">조회된 결과가 없습니다.</td>
          </tr>
      </c:otherwise>
   
   </c:choose>
</tbody>
            
            
            
        </table>
<div id="write_btn" class="wrap">
	<ul>
		<li class="page"><nav aria-label="Page navigation example">
			  <ul class="pagination pagination-sm justify-content-center">
			     <li class="page-item">
				 <!--맨처음 -->
			     <c:url var="first" value="adminMemberList.do">
			     	<c:param name="page" value="1"/>
			     </c:url>
			      <a class="page-link" href="${first}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			       <span class="sr-only">Previous</span>
			      </a>
		    	</li>
		    	
		    	
		    	<c:forEach var="p" begin="${startPage}" end="${endPage}" step="1">
		    		<c:url var="move" value="adminMemberList.do">
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
		    <!--맨끝-->
		    <c:url var="last" value="adminMemberList.do">
		    	<c:param name="page" value="${maxPage}"/>
		    </c:url>
		      <a class="page-link" href="${last}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		        <span class="sr-only">Next</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</li>
	
		<%-- <li class="wrbtn"><a href="nform.do?userid='${loginMember.userid}'">글쓰기</a></li> --%>
	</ul>
</div>
		
	</ul>
</div>


<div id="clear"></div>
<br><br><br><br><br>

<c:import url="../../common/footer.jsp"/>
</body>
</html>