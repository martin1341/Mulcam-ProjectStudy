<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
<title>어디갈까?</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<!-- CSS, JavaScript -->
<link href="<%=request.getContextPath()%>/resources/css/board/articlewrite.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/board/articlewrite.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<section id="articlewrite">
		<div id="articlewrite-wrap">
			<form action="write" method="post" enctype="multipart/form-data">
				<input type="text" id="articleTitleForm" name="articleTitle" placeholder="제목을 입력해주세요.">
				<div id="articleImageUpload">대표 이미지 추가: <input type="file" id="articleImageForm" name="uploadImage"></div>
				<textarea id="articleContentForm" name="articleContent" placeholder="내용을 입력해주세요."></textarea>
				<input type="submit" id="writebtn" class="articlewritebtn" value="등록">
				<input type="button" id="cancelbtn" class="articlewritebtn" value="취소" onclick="location.href='/board'">
				<input type="hidden" name="articleAuthor" value="${ sessionScope.session_id }">
			</form>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>