<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/movie.css">
	</head>
	
	<body>
		<div id="Wrap">
			<h2>정보 삭제</h2>
			<form method="post" enctype="multipart/form-data" name="frm">
			
			<input type="hidden" name="code" value="${movie.code}"/>
			
			<table>
				<tr>
					<td style="width:300px;">
						<c:choose>
							<c:when test="${empty movie.poster}">
								<img src="upload/noimage.gif" style="width:200px">
							</c:when>
							
							<c:otherwise>
								<img src="upload/${movie.poster}" style="width:200px">
							</c:otherwise>
						</c:choose>
					</td>
					
					<td>
						<table style="margin-top:100px;">
							<tr>
								<th>제 목</th>
								<td>${movie.title}</td>
							</tr>
							
							<tr>
								<th>가 격</th>
								<td>${movie.price }</td>
							</tr>
							
							<tr>
								<th>감 독</th>
								<td>${movie.director}</td>
							</tr>
							
							<tr>
								<th>배 우</th>
								<td>${movie.actor}</td>
							</tr>
							
							<tr>
								<th style="width:100px;">설 명</th>
								<td style="height:200px; width:800px">
										${movie.synopsis}
								</td>
							</tr>
							
						</table>
					</td>
				</tr>
			</table>
			
			<div style="text-align:center">
				<input type="submit" value="삭제">
				<input type="button" value="목록" onclick="location.href='movieList.do'">
			</div>
				
			</form>
		</div>
	</body>
</html>