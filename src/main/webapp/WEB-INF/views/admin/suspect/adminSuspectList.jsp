<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/CSS/notice.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<style type="text/css">
input::-webkit-input-placeholder {
	color: #ddd;
}

.nview tr td a {
	color: #22518A;
	text-decoration: none;
}
</style>
<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script> -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

	
</head>



<script type="text/javascript">

	
	// 회원 삭제 버튼
	function suspectDeleteCall(suspect_no){
		alert(suspect_no +'번 용의자를 삭제처리 하였습니다.');
		location.href = "adminSuspectDelete.do?suspect_no="+suspect_no;
	 
	}
   

	 //피의자 수정 버튼
    
	   function suspectUpdateCall(suspect_no, count){
		 
		$.ajax({
			url: "adminSuspectUpdateAjax.do",
			data: { suspect_no: suspect_no},
			dataType: "json",
			type: "post",
			success: function(jsonData){
			console.log("jsonData : " + jsonData);
			var ds='dd';
			var output = '';
			output += '<td>'+count+'</td>';
			output += "<td><form action='adminSuspectUpdate.do' method='post'>"+"<input type='hidden' name='suspect_no' value="+jsonData.suspect_no+"><input type='text' id='keywords' name='suspect_name' placeholder='"+decodeURIComponent(jsonData.suspect_name)+"'>"+"</input><input type='submit' value='ok' /></form></td>";
			output += "<td><form action='adminSuspectUpdate.do' method='post'>"+"<input type='hidden' name='suspect_no' value="+jsonData.suspect_no+"><input type='text' name='suspect_bank' placeholder='"+decodeURIComponent(jsonData.suspect_bank)+"'>"+"</input><input type='submit' value='ok' /></form></td>";    
			output += "<td><form action='adminSuspectUpdate.do' method='post'>"+"<input type='hidden' name='suspect_no' value="+jsonData.suspect_no+"><input type='text' name='suspect_account' placeholder='"+decodeURIComponent(jsonData.suspect_account.replace(/\+/g, " "))+"'>";    			
			output += "</input><input type='submit' value='ok' /></form></td><td><form action='adminSuspectUpdate.do' method='post'><input type='hidden' name='suspect_no' value="+jsonData.suspect_no+"><input type='text' name='suspect_phone' placeholder='" + decodeURIComponent(jsonData.suspect_phone) + "'></input></input><input type='submit' value='ok' /></form></td>";
			output += "<td><form action='adminSuspectUpdate.do' method='post'>"+"<input type='hidden' name='suspect_no' value="+jsonData.suspect_no+"><input type='text' name='report_date' placeholder='"+jsonData.report_date+"'>"+"</input><input type='submit' value='ok' /></form></td>";    
			output += "<td><form action='adminSuspectUpdate.do' method='post'><input type='hidden' name='suspect_no' value="+jsonData.suspect_no+"><input type='text' name='suspect_count' placeholder='"+jsonData.suspect_count+"'></input><input type='submit' value='ok' /></form></td>"; 
			//output += "<td><button onClick='"+"memberUpdateAccept("+'"'+$("#keywordsf").html()+'"' +")"+";' class='btn btn-info'>취소</button></td>";
			output += "<td><button class='btn btn-info' onclick='backPage();'>취소</button></td>";
			output += "<td><button type='button' class='btn btn-danger' onclick='suspectDeleteCall("+jsonData.suspect_no+")"+";'>삭제</button></td>";
			///onclick="memberDeleteCall('${member.userid}',${member.state })"
			

		    $("#idx"+count).html(output);
		     },
			error: function(request, status, errorData){
				console.log("error code : " + request.status
					+ "\nmessage : " + request.responseText
					+ "\nerror : " + errorData);
			}
		});
		
	}
   
	 
    // 수정 취소 버튼
    
    function backPage(){
   location.href= "adminSuspectList.do";
    }
	
	
    

    






</script>



<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
<body>
	<c:import url="../../common/header.jsp" />





	<div id="notice" class="wrap">
		<h2>피의자 관리</h2>
        
<div class="search">
<form action="adminSuspectList.do" method="get" align="center" id="setRows">
  <div class="box">
    <select id="cg" style="height:30px;" name="cg">
      <option value="all" <c:if test='${cg == "all"}'>selected</c:if>>전체</option>
      <option value="name" <c:if test='${cg == "name"}'>selected</c:if>>이름</option>
      <option value="phone" <c:if test='${cg == "phone"}'>selected</c:if>>전화번호</option>
      <option value="bank" <c:if test='${cg == "bank"}'>selected</c:if>>은행</option>
      <option value="account" <c:if test='${cg == "account"}'>selected</c:if>>계좌</option>
    </select>
    <input type="text" name="bar" id="search_bar" placeholder="내용" value="${bar}"/>
    <input type="submit" name="search" id="search_btn" value="검색"/>
  </div>
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
         
                <th scope="row">이름</th>
                <th scope="row">은행명</th>
                <th scope="row">계좌번호</th>
                <th scope="row">전화번호</th> 
                <th scope="row">신고날짜</th> 
                <th scope="row">누적횟수</th> 
                <th scope="row">수정</th> 
                <th scope="row">삭제</th> 
            </tr>
            </thead>
            
            <tbody>
   <c:choose>
      <c:when test="${fn:length(suspectList) > 0}">
         <c:forEach items="${suspectList }" var="suspect" varStatus="status">
           <tr align="center" id="idx${status.count}"> 
              <td>${suspect.suspect_no }</td>
              <td>${suspect.suspect_name }
              <a href="#"></a>
              </td>
              <td>${suspect.suspect_bank}</td>
              <td>${suspect.suspect_account }</td>
               <td>${suspect.suspect_phone }</td>
               
               <td>${suspect.report_date }</td>
                  <td>${suspect.suspect_count }</td>
                
                <td><button type="button" class="btn btn-primary"
										onclick="suspectUpdateCall('${suspect.suspect_no}',${status.count })">수정</button></td>
								<td><button type="button" class="btn btn-danger" onclick="suspectDeleteCall('${suspect.suspect_no}')">삭제</button></td>
                             
               
               
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
								<!--맨처음 --> <c:url var="first" value="adminSuspectList.do">
									<c:param name="page" value="1" />
								</c:url> <a class="page-link" href="${first}" aria-label="Previous">
									<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
							</a>
							</li>


							<c:forEach var="p" begin="${startPage}" end="${endPage}" step="1">
								<c:url var="move" value="adminSuspectList.do">
									<c:param name="page" value="${p}" />
								</c:url>
								<c:if test="${p eq currentPage}">
									<li class="page-item active"><a class="page-link" href="#">${p}<span
											class="sr-only">(current)</span></a></li>
								</c:if>
								<c:if test="${p ne currentPage}">
									<li class="page-item"><a class="page-link" href="${move}">${p}</a></li>
								</c:if>
							</c:forEach>


							<li class="page-item">
								<!--맨끝--> <c:url var="last" value="adminSuspectList.do">
									<c:param name="page" value="${maxPage}" />
								</c:url> <a class="page-link" href="${last}" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
							</a>
							</li>
						</ul>
					</nav></li>
			</ul>
		</div>

		</ul>
	</div>


	<div id="clear"></div>
	<br>
	<br>
	<br>
	<br>
	<br>

	<c:import url="../../common/footer.jsp" />
</body>
</html>