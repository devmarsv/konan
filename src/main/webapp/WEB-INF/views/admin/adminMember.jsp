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
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>


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
	
	
	
	</script>
	
	
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>
<c:import url="../common/header.jsp"/>




 
<div id="notice" class="wrap">
        <h2>회원검색</h2>
        

<div id="allDiv" align="center">
	<form action="msearch.do" method="post">
		<input type="hidden" name="search" value="all">
			 
		
		<select id="cgno" onchange="getval(this);">
      <option name="checkl" value="전체">전체</option>
      <option name="checkl" value="이름">이름</option>
      <option name="checkl" value="아이디">아이디</option>
    </select>
		<input type="search" name="keyword" placeholder="전체">
		<input type="submit" value="검색">
	</form>
</div>
<div id="nameDiv" align="center">
	<form action="msearch.do" method="post">
		<input type="hidden" name="search" value="name">
		 
		<select id="cgno" onchange="getval(this);">
      <option name="checkl" value="전체">전체</option>
      <option name="checkl" value="이름">이름</option>
      <option name="checkl" value="아이디">아이디</option>
    </select>	
    
		<input type="search" name="keyword" placeholder="이름">
		<input type="submit" value="검색">
	</form>
</div>
<div id="idDiv" align="center">
	<form action="msearch.do" method="post">
		<input type="hidden" name="search" value="id">
		<select id="cgno" onchange="getval(this);">
      <option name="checkl" value="전체">전체</option>
      <option name="checkl" value="이름">이름</option>
      <option name="checkl" value="아이디">아이디</option>
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
           <tr align="center"> 
              <td>${status.count}</td>
              <td>
              <a href="#">${member.userid }</a>
              </td>
              <td>${member.username }</td>
              <td>${member.phone }</td>
               <td>${member.state }</td>
                <td>수정</td>
                 <td>탈퇴</td>
               
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
	</li>
		
	</ul>
</div>


<div id="clear"></div>
<br><br><br><br><br>

<c:import url="../common/footer.jsp"/>
</body>
</html>