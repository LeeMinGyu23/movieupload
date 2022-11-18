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
			<h2>리스트</h2>
			<table>
				<tr>
					<td colspan="6" style="text-align:right">
						<a href="movieWrite.do">정보등록</a>
					</td>
				</tr>	
				<tr>
					<th>제목</th>
					<th>감독</th>
					<th>배우</th>
					<th>가격</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				
				<c:forEach var="movie" items="${movieList}">
					<tr>
						<td>${movie.title}</td>
						<td>${movie.director}</td>
						<td>${movie.actor}</td>
						<td>${movie.price}</td>
						<td><a href="movieUpdate.do?code=${movie.code}">정보 수정</a></td>
						<td><a href="movieDelete.do?code=${movie.code}">정보 삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>