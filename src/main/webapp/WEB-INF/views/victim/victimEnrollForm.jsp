<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>konan</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

   <style>
    .container{width:1200px; font-size:15px;}
    .pull-right, .pull-left{
        float:right;
        margin-right: 5px;
        border-radius:3px;
        background-color: #87CEEB;
        padding: 5px 10px;
        border: none;
        color: #fff;
        text-align: center;
        font-size: 15px;
        display: inline-block;
        cursor: pointer;
    }
    th, td{background: #fff;}
    th{width:200px;}
    h2{text-align:left;}
    input::-webkit-input-placeholder {font-size:14px; color:#e2e2e2;}
</style> 

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="../common/header.jsp"/>
<br><br><br><br>
<br><br><br><br>
<div class="container">
<h2> 피해등록</h2><br> 
<table class="table table-bordered">
    <tbody>
        <form action="write_ok.jsp" method="post" encType="multiplart/form-data">

            <tr>
            <th>카테고리</th>
            <td>	
            	<select id="cgno">
              		<option value="">직거래</option>
              		<option value="">게임·비실물</option>
            	</select></td>
            </tr>
            
            <tr>
                <th>작성자 </th>
               		<td>${loginMember.getUserid()}</td>
            </tr>
            <tr>
                <th>피의자</th>
                <td><input type="text" placeholder="피의자 이름을 입력해주세요. " name="subject" class="form-control"/></td>
            </tr>
             <tr>
            	<th>은행명</th>
            	<td><input type="text" placeholder="은행명을 입력해주세요." name="subject" class="form-control"/></td>
            </tr>
            <tr>
                <th>계좌번호</th>
                <td><input type="text" placeholder="계좌번호 를 입력해주세요." name="subject" class="form-control"/></td>
            </tr>
            <tr>
                <th>핸드폰번호</th>
                <td><input type="text" placeholder="핸드폰번호 을 입력해주세요." name="subject" class="form-control"/></td>
            </tr>
            <tr>
                <th>첨부파일 </th>
              
                <td>
                <input type="button" value="파일선택" class="pull-left"/>
                <br><br>
                <input type="text" placeholder="파일을 선택하세요. " name="filename" class="form-control">
                
                </input>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="subject"  rows="20" cols="50" style="font-size: 14px;" placeholder="내용을 입력하세요." class="form-control"></textarea></td>
                <!-- <td><input type="text" placeholder="내용을 입력하세요. " name="subject" class="form-control"/></td> -->
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="취소" onclick="location.href='main.do'" class="pull-right"/>
                    <input type="button" value="등록" class="pull-right" onclick="location.href='victimboard.do'"/>
                </td>
            </tr>
        </form>
    </tbody>
</table>
</div>
</div>
<br><br><br><br>
<br><br><br><br>
<c:import url="../common/footer.jsp"/>
</body>
</html>

