<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/movie.css">
		<script src="script/movie.js"></script>
	</head>
	
	<body>
		<div id="Wrap">
			<h2>정보 등록</h2>
			<form method="post" enctype="multipart/form-data" name="frm">
				<table style="margin-top:100px;">
					<tr>
						<th>제 목</th>
						<td><input type="text" name="title"></td>
					</tr>
					
					<tr>
						<th>가 격</th>
						<td><input type="text" name="price"></td>
					</tr>
					
					<tr>
						<th>감 독</th>
						<td><input type="text" name="director"></td>
					</tr>
					
					<tr>
						<th>배 우</th>
						<td><input type="text" name="actor"></td>
					</tr>
					
					<tr>
						<th>설 명</th>
						<td>
							<textarea cols="80" rows="10" name="synopsis">
							
							</textarea>
						</td>
					</tr>
					
					<tr>
						<th>사 진</th>
						<td><input type="file" name="poster"></td>
					</tr>
				</table>
				
				<div style="text-align:center">
					<input type="submit" value="등록" onclick="return MovieCheck()">
					<input type="reset" value="다시 작성">
					<input type="button" value="목록" onclick="location.href='movieList.do'">
				</div>
			</form>
		</div>
	</body>
</html>